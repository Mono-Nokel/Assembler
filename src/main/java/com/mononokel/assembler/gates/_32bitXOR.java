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
package com.mononokel.assembler.gates;

public class _32bitXOR implements _32bitGate
{
   public int compute(int a, int b)
   {
      int ret = 0;
      XOR xor = new XOR();
      
      for (int i = 0; i < 32; i++)
      {
         if (xor.compute((a & (1 << i)) != 0, (b & (1 << i)) != 0))
         {
            ret |= (1 << i);
         }
      }
      
      return ret;
   }
}
