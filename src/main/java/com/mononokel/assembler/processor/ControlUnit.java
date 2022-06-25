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
import com.mononokel.assembler.switching._32bitSelector;
import com.mononokel.assembler.util.Bundler;
import com.mononokel.assembler.util.Splitter;

public class ControlUnit
{
   private ALUInstruction aluInstruction = new ALUInstruction();
   
   public ALUInstructionResult compute(short instruction, int a, int d, int aStar)
   {
      _32bitSelector _32bitSelector = new _32bitSelector();
      Bundler bundler = new Bundler();
      Splitter splitter = new Splitter();
      ALUInstructionResult ret = new ALUInstructionResult();
      boolean[] instructions = splitter.compute(instruction);
      ALUInstructionResult aluResult = aluInstruction.compute(instruction, a, d, aStar);
      Inverter inverter = new Inverter();
      int bundledALUResult = bundler.compute(new boolean[] {aluResult.j, aluResult.aStar, aluResult.d, aluResult.a});
      int bundledDataResult = bundler.compute(new boolean[] {false, false, false, inverter.compute(instructions[15])});
      boolean[] splitResults = splitter.compute(_32bitSelector.compute(instructions[15],
            bundledALUResult, bundledDataResult));
      
      ret.r = _32bitSelector.compute(instructions[15], aluResult.r, instruction);
      ret.a = splitResults[3];
      ret.d = splitResults[2];
      ret.aStar = splitResults[1];
      ret.j = splitResults[0];
      
      return ret;
   }
}
