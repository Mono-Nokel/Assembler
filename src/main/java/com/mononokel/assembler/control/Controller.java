//   Copyright 2022 Josh Worthington
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
package com.mononokel.assembler.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.mononokel.assembler.control.enums.ControllerState;
import com.mononokel.assembler.control.interfaces.ControllerUpdateListener;
import com.mononokel.assembler.processor.Computer;
import com.mononokel.assembler.view.MemoryMapOut;
import com.mononokel.assembler.view.enums.Destination;
import com.mononokel.assembler.view.enums.Instruction;
import com.mononokel.assembler.view.enums.Jump;
import com.mononokel.assembler.view.model.ProgramTableModel;

public class Controller
{
   private Computer computer;
   private boolean useBreakPoints = false;
   private Boolean[] breakPoints;
   private Boolean paused = false;
   private Boolean stopped = true;
   private ExecutorService thread = (ExecutorService) Executors.newSingleThreadExecutor();
   private Future<?> threadFuture;
   private Set<ControllerUpdateListener> listeners = new HashSet<>();
   private MemoryMapOut memoryMapOut = new MemoryMapOut();
   
   public void addListenener(ControllerUpdateListener listener)
   {
      synchronized (listeners)
      {
         listeners.add(listener);
      }
   }
   
   public void loadProgram(List<Object[]> program)
   {
      computer = new Computer();
      breakPoints = program.stream().map(o -> (Boolean)o[ProgramTableModel.BREAK_POINT_COLUMN]).toArray(Boolean[]::new);
      Short[] programCodeObj = (Short[]) program.stream().map(o -> {
         short ret;
         
         if (o[ProgramTableModel.INSTRUCTION_COLUMN] instanceof Instruction)
         {
            int destCode = ((Destination)o[ProgramTableModel.DESTINATION_COLUMN]).getCode();
            int instructionCode = ((Instruction)o[ProgramTableModel.INSTRUCTION_COLUMN]).getCode();
            int jumpCode = ((Jump)o[ProgramTableModel.JUMP_COLUMN]).getCode();
            
            ret = (short) 0b1000000000000000;
            ret |= (short) (instructionCode << 6);
            ret |= (short) (destCode << 3);
            ret |= jumpCode;
         }
         else
         {
            String temp = ((String)o[ProgramTableModel.INSTRUCTION_COLUMN]);
            
            if (temp.indexOf('#') > 0)
            {
               temp = temp.substring(0, temp.indexOf('#'));
            }
            
            ret = (short)(int)Integer.valueOf(temp.trim());
         }
         
         return ret;
      }).toArray(Short[]::new);      
      short[] programCode = new short[programCodeObj.length];
      
      for (int i = 0; i < programCodeObj.length; i++)
      {
         programCode[i] = programCodeObj[i];
      }
      
      computer.loadProgram(programCode);
   }
   
   public boolean isStopped()
   {
      synchronized (stopped)
      {
         return stopped;  
      }
   }
   
   public boolean isPaused()
   {
      synchronized (paused)
      {
         return paused;  
      }
   }
   
   public void stop()
   {
      if (threadFuture != null)
      {
         threadFuture.cancel(true);
      }
      
      synchronized (stopped)
      {
         stopped = true;  
      }
      updateListeners(ControllerState.stopped);
   }
   
   public void run(boolean useBreakPoints)
   {
      this.useBreakPoints = useBreakPoints;
      
      synchronized (paused)
      {
         paused = false;
      }
      
      synchronized (stopped)
      {
         if (stopped)
         {
            stopped = false;
            threadFuture = thread.submit(this::compute);
         }
      }
      updateListeners(ControllerState.running);
   }
   
   public void step()
   {
      boolean localStopped = isStopped();
      boolean localPaused = isPaused();
      
      if (localPaused && !localStopped)
      {
         runComputer();
      }
   }
   
   public void pause()
   {
      synchronized (paused)
      {
         paused = true;
      }
      updateListeners(ControllerState.paused);
   }
   
   public int getA()
   {
      return computer.getRegisters()[0];
   }
   
   public int getD()
   {
      return computer.getRegisters()[1];
   }
   
   public int getAStar()
   {
      return computer.getRegisters()[2];
   }
   
   public int getProgramCounter()
   {
      return computer.getProgramCounter();
   }
   
   public int[] getRam()
   {
      return computer.getRAM();
   }
   
   private void compute()
   {
      boolean localStopped = false;
      boolean localPaused = false;
      
      while (!localStopped)
      {
         synchronized (paused)
         {
            localPaused = paused || (useBreakPoints && breakPoints[computer.getProgramCounter()]);
            
            if (localPaused)
            {
               paused = localPaused;
               updateListeners(ControllerState.paused);
            }
         }
         
         while (localPaused && !localStopped)
         {
            localPaused = isPaused();
            localStopped = isStopped();
            
            try
            {
               Thread.sleep(100);
            } catch (InterruptedException e)
            {
               Thread.currentThread().interrupt();
            }
         }
         
         localStopped = isStopped();         
         runComputer();
      }
      
      updateListeners(ControllerState.stopped);
   }

   private void runComputer()
   {
      boolean outputResult = false;
      
      synchronized (computer)
      {
         short outputInstruction = (short) ((short) 0b1000000000000000 | Destination.AStar.getCode() << 3);
         if ((computer.getCurrentInstruction() &  outputInstruction) == outputInstruction)
         {
            outputResult = true;
         }
         
         synchronized (stopped)
         {
            stopped = stopped || !computer.compute();
         }
         
         if (outputResult)
         {
            memoryMapOut.writeCharacter((char)computer.getRegisters()[2]);
         }
      }
   }
   
   private void updateListeners(ControllerState state)
   {
      synchronized (listeners)
      {
         listeners.stream().forEach(l -> l.update(state));
      }
   }
}
