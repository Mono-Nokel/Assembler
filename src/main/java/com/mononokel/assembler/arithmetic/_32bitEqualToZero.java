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

import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.gates.OR;

public class _32bitEqualToZero
{
   public boolean compute(int a)
   {
      OR or = new OR();
      Inverter inverter = new Inverter();
      int tempResults = 0;
      
      for (int i = 32; i > 2; i /= 2)
      {
         tempResults = orBits(a, i);
      }
      
      return inverter.compute(or.compute((tempResults & 2) != 0, (tempResults & 1) != 0));
   }
   
   private int orBits(int bits, int length)
   {
      OR or = new OR();
      int tempResults = 0;
      
      for (int i = 0; i < length; i+=2)
      {
         if (or.compute((bits & i) != 0, (bits & (i - 1)) != 0))
         {
            tempResults |= (1 << i/2);
         }
      }
      
      return tempResults;
   }
}
