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

import com.mononokel.assembler.arithmetic._32bitEqualToZero;
import com.mononokel.assembler.arithmetic._32bitLessThanZero;
import com.mononokel.assembler.gates.AND;
import com.mononokel.assembler.gates.Inverter;
import com.mononokel.assembler.gates.NAND;

public class Condition
{
   public boolean compute(boolean lt, boolean eq, boolean gt, int a)
   {
      NAND nand = new NAND();
      Inverter inverter = new Inverter();
      _32bitEqualToZero _32bitEqualToZero = new _32bitEqualToZero();
      AND and = new AND();
      _32bitLessThanZero _32bitLessThanZero = new _32bitLessThanZero();
      
      return nand.compute(
            inverter.compute(
                  nand.compute(
                        nand.compute(lt, _32bitLessThanZero.compute(a)),
                        nand.compute(eq, _32bitEqualToZero.compute(a)))),
            nand.compute(
                  and.compute(
                        inverter.compute(_32bitLessThanZero.compute(a)),
                        inverter.compute(_32bitEqualToZero.compute(a))), gt));
   }
}
