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
import com.mononokel.assembler.gates._32bitInverter;

public class _32bitSubtractor
{
   public int compute(int a, int b)
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      _32bitInverter _32bitInverter = new _32bitInverter();
      Inverter inverter = new Inverter();
      
      return _32bitAdder.compute(a, _32bitInverter.compute(b), inverter.compute(false));
   }
}
