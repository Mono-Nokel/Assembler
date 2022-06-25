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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _32bitSwitchTest
{
   @Test
   void testComputeA()
   {
      _32bitSwitch _32bitSwitch = new _32bitSwitch();
      int[] results = _32bitSwitch.compute(true, 0x55555555);
      
      assertEquals(0x55555555, results[0]);
      assertEquals(0, results[1]);
   }
   
   @Test
   void testComputeB()
   {
      _32bitSwitch _32bitSwitch = new _32bitSwitch();
      int[] results = _32bitSwitch.compute(false, 0x55555555);
      
      assertEquals(0, results[0]);
      assertEquals(0x55555555, results[1]);
   }
}
