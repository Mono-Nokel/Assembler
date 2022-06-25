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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _32bitAdderTest
{
   @Test
   void testCompute5_7False()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(12, _32bitAdder.compute(5, 7, false));
   }
   
   @Test
   void testCompute5_7True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(13, _32bitAdder.compute(5, 7, true));
   }
   
   @Test
   void testCompute0_0True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(1, _32bitAdder.compute(0, 0, true));
   }
   
   @Test
   void testCompute0_0False()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(0, _32bitAdder.compute(0, 0, false));
   }
   
   @Test
   void testCompute0_1True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(2, _32bitAdder.compute(0, 1, true));
   }
   
   @Test
   void testCompute0_3True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(4, _32bitAdder.compute(0, 3, true));
   }
   
   @Test
   void testCompute1_0True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(2, _32bitAdder.compute(1, 0, true));
   }
   
   @Test
   void testCompute3_0True()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(4, _32bitAdder.compute(3, 0, true));
   }
   
   @Test
   void testCompute0x80000000_0x80000000False()
   {
      _32bitAdder _32bitAdder = new _32bitAdder();
      
      assertEquals(0, _32bitAdder.compute(0x80000000, 0x80000000, false));
   }
}
