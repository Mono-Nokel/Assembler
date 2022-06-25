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
package com.mononokel.assembler.switching;

import com.mononokel.assembler.alu.Condition;
import com.mononokel.assembler.gates.AND;
import com.mononokel.assembler.gates._32bitXOR;

public class _256Switch
{
   public boolean[] compute(byte address, boolean d)
   {
      boolean ret[] = new boolean[256];
      AND and = new AND();
      Condition condition = new Condition();
      _32bitXOR _32bitXOR = new _32bitXOR();
      
      for (int i = 0; i < 32; i++)
      {
         for (int j = 0; j < 256; j++)
         {
            ret[j] = and.compute(condition.compute(false, true, false, _32bitXOR.compute(j, (address & 0xFF))), d);
         }
      }
      
      return ret;
   }
}
