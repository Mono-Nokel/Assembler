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

import com.mononokel.assembler.arithmetic._32bitIncrementer;
import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.switching._32bitSelector;

public class Counter
{
   private _32bitRegister _32bitRegister = new _32bitRegister();
   private int previousOut = 0;
   
   public int compute(boolean st, int d, boolean clock)
   {
      _32bitIncrementer _32bitIncrementer = new _32bitIncrementer();
      _32bitSelector _32bitSelector = new _32bitSelector();
      Inverter inverter = new Inverter();
      
      previousOut = _32bitRegister.compute(inverter.compute(false), 
            _32bitSelector.compute(st, d, _32bitIncrementer.compute(previousOut)), clock);
      
      return previousOut;
   }
}
