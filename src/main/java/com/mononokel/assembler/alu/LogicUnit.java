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
package com.mononokel.assembler.alu;

import com.mononokel.assembler.gates._32bitAND;
import com.mononokel.assembler.gates._32bitInverter;
import com.mononokel.assembler.gates._32bitOR;
import com.mononokel.assembler.gates._32bitXOR;
import com.mononokel.assembler.switching._32bitSelector;

public class LogicUnit
{
   public int compute(boolean op1, boolean op0, int a, int b)
   {
      _32bitSelector _32bitSelector = new _32bitSelector();
      _32bitInverter _32bitInverter = new _32bitInverter();
      _32bitAND _32bitAND = new _32bitAND();
      _32bitOR _32bitOR = new _32bitOR();
      _32bitXOR _32bitXOR = new _32bitXOR();
      
      return _32bitSelector.compute(op1,
            _32bitSelector.compute(op0, _32bitInverter.compute(a), _32bitXOR.compute(a, b)),
            _32bitSelector.compute(op0, _32bitOR.compute(a, b), _32bitAND.compute(a, b)));
   }
}
