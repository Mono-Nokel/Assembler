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

import com.mononokel.assembler.alu.ALU;
import com.mononokel.assembler.alu.Condition;
import com.mononokel.assembler.switching._32bitSelector;
import com.mononokel.assembler.util.Splitter;

public class ALUInstruction
{
   private ALU alu = new ALU();
   
   public ALUInstructionResult compute(short instruction, int a, int d, int aStar)
   {
      Condition condition = new Condition();
      _32bitSelector _32bitSelector = new _32bitSelector();
      ALUInstructionResult ret = new ALUInstructionResult();
      Splitter splitter = new Splitter();
      boolean[] instructions = splitter.compute(instruction);
      
      ret.r = alu.compute(instructions[10], instructions[9],
            instructions[8], instructions[7], instructions[6],
            d, _32bitSelector.compute(instructions[12], aStar, a));
      ret.a = instructions[5];
      ret.d = instructions[4];
      ret.aStar = instructions[3];
      ret.j = condition.compute(instructions[2], instructions[1], instructions[0], ret.r);
      
      return ret;
   }
}
