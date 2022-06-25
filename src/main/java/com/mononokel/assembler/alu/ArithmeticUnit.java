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

import com.mononokel.assembler.arithmetic._32bitAdder;
import com.mononokel.assembler.arithmetic._32bitSubtractor;
import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.switching._32bitSelector;

public class ArithmeticUnit
{
   public int compute(boolean op1, boolean op0, int a, int b)
   {
      _32bitSelector _32bitSelector = new _32bitSelector();
      _32bitSubtractor _32bitSubtractor = new _32bitSubtractor();
      _32bitAdder _32bitAdder = new _32bitAdder();
      Inverter inverter = new Inverter();
      int selectedBValue = _32bitSelector.compute(op0,
            booleanToInt(inverter.compute(false)), b);
      
      return _32bitSelector.compute(op1,
            _32bitSubtractor.compute(a, selectedBValue),
            _32bitAdder.compute(a, selectedBValue, false));
   }
   
   private int booleanToInt(boolean a)
   {
      if (a)
      {
         return 1;
      }
      
      return 0;
   }
}
