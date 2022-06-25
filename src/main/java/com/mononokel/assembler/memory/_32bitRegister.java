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

import com.mononokel.assembler.gates.AND;

public class _32bitRegister
{
   private _32bitLatch _32bitLatchA = new _32bitLatch();
   private _32bitLatch _32bitLatchB = new _32bitLatch();
   
   public int compute(boolean st, int d, boolean clock)
   {
      AND and = new AND();
      
      return _32bitLatchB.compute(clock,
            _32bitLatchA.compute(and.compute(st, clock), d));
   }
}
