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

import com.mononokel.assembler.switching._32bitSelector;

public class ALU
{
   public int compute(boolean u, boolean op1, boolean op0, boolean zx, boolean sw,
         int a, int b)
   {
      _32bitSelector _32bitSelector = new _32bitSelector();
      LogicUnit logicUnit = new LogicUnit();
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      int tempA = _32bitSelector.compute(zx, 0, _32bitSelector.compute(sw, b, a));
      int tempB = _32bitSelector.compute(sw, a, b);
      
      return _32bitSelector.compute(u, 
            arithmeticUnit.compute(op1, op0, tempA, tempB), 
            logicUnit.compute(op1, op0, tempA, tempB));
   }
}
