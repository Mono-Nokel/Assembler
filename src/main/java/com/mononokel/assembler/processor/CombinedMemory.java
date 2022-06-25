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

import com.mononokel.assembler.memory.RAM;
import com.mononokel.assembler.memory._32bitRegister;

public class CombinedMemory
{
   private _32bitRegister a = new _32bitRegister();
   private _32bitRegister d = new _32bitRegister();
   private RAM ram = new RAM();
   
   public int[] compute(boolean a, boolean d, boolean aStar, int x, boolean clock)
   {
      int[] ret = new int[3];
      
      ret[0] = this.a.compute(a, x, clock);
      ret[1] = this.d.compute(d, x, clock);
      ret[2] = this.ram.compute((byte) ret[0], aStar, x, clock);
      
      return ret;
   }
   
   public int[] getRAMDump()
   {
      return ram.getRAMDump();
   }
}
