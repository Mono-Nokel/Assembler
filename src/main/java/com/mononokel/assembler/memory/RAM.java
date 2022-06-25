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
package com.mononokel.assembler.memory;

import java.util.Arrays;

import com.mononokel.assembler.switching._256Switch;
import com.mononokel.assembler.switching._256_32bitSelector;

public class RAM
{
   private _32bitRegister registers[] = new _32bitRegister[256];
   
   public RAM()
   {
      Arrays.setAll(registers, r -> new _32bitRegister());
   }
   
   public int compute(byte address, boolean store, int x, boolean clock)
   {
      _256Switch _256Switch = new _256Switch();
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      int registerResults[] = new int[256];
      
      boolean[] storeSwitch = _256Switch.compute(address, store);
      
      for (int i = 0; i < 256; i++)
      {
         registerResults[i] = registers[i].compute(storeSwitch[i], x, clock);
      }
      
      return _256_32bitSelector.compute(address, registerResults);
   }
   
   public int[] getRAMDump()
   {
      int[] ret = new int[256];
      
      for (int i = 0; i < 256; i++)
      {
         ret[i] = registers[i].compute(false, 0, true);
      }
      
      return ret;
   }
}
