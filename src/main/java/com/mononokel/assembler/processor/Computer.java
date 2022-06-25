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
package com.mononokel.assembler.processor;

import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.memory.Counter;

public class Computer
{
   private int[] registers = new int[3];
   private CombinedMemory combinedMemory = new CombinedMemory();
   private Counter counter = new Counter();
   private ControlUnit controlUnit = new ControlUnit();
   private short[] program = new short[0];
   private int programCounter = 0;
   
   public boolean compute()
   {
      if (programCounter < program.length)
      {
         Inverter inverter = new Inverter();
         ALUInstructionResult controlUnitResult = controlUnit.compute(program[programCounter],
               registers[0], registers[1], registers[2]);
         registers = combinedMemory.compute(controlUnitResult.a, controlUnitResult.d,
               controlUnitResult.aStar, controlUnitResult.r, inverter.compute(false));
         programCounter = counter.compute(controlUnitResult.j, registers[0], inverter.compute(false));         
         
         return true;
      }
      
      return false;
   }
   
   public void loadProgram(short[] instructionSet)
   {
      if (instructionSet != null)
      {
         program = instructionSet;
      }
   }
   
   public int[] getRegisters()
   {
      return registers;
   }
   
   public int[] getRAM()
   {
      return combinedMemory.getRAMDump();
   }
   
   public int getProgramCounter()
   {
      return programCounter;
   }
   
   public short getCurrentInstruction()
   {
      return program[getProgramCounter()];
   }
}
