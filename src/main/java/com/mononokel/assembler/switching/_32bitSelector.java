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

import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.gates.NAND;

public class _32bitSelector
{
   public int compute(boolean aOrB, int a, int b)
   {
      int ret = 0;
      NAND nand = new NAND();
      Inverter inverter = new Inverter();
      boolean inverseAORB = inverter.compute(aOrB);
      
      for (int i = 0; i < 32; i++)
      {
         if (nand.compute(nand.compute(aOrB, (a & (1 << i)) != 0), nand.compute(inverseAORB, (b & (1 << i)) != 0)))
         {
            ret |= (1 << i);
         }
      }
      
      return ret;
   }
}
