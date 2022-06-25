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

import com.mononokel.assembler.gates.AND;
import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.gates.NAND;

public class _32bitSwitch
{
   public int[] compute(boolean aORb, int d)
   {
      int ret[] = new int[2];
      AND and = new AND();
      Inverter inverter = new Inverter();
      NAND nand = new NAND();
      
      for (int i = 0; i < 32; i++)
      {
         boolean bit = (d & (1 << i)) != 0;
         
         if (inverter.compute(nand.compute(aORb, bit)))
         {
            ret[0] |= (1 << i);
         }
         
         if (and.compute(nand.compute(aORb, bit), bit))
         {
            ret[1] |= (1 << i);
         }
      }
      
      return ret;
   }
}