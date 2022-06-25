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
package com.mononokel.assembler.arithmetic;

import com.mononokel.assembler.gates.NAND;
import com.mononokel.assembler.gates.XOR;

public class FullAdder
{
   public int compute(boolean a, boolean b, boolean c)
   {
      int ret = 0;
      NAND nand = new NAND();
      XOR xor = new XOR();
      boolean bXORc = xor.compute(b, c);
      boolean aNANDbXORc = nand.compute(a, bXORc);
      
      if (nand.compute(aNANDbXORc, nand.compute(b, c)))
      {
         ret = 2;
      }
      
      if (nand.compute(nand.compute(a, aNANDbXORc), nand.compute(aNANDbXORc, bXORc)))
      {
         ret++;
      }
      
      return ret;
   }
}
