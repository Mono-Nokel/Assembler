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

public class HalfAdderTest
{
   @Test
   void testComputeTrueTrue()
   {
      HalfAdder halfAdder = new HalfAdder();
      
      assertEquals(2, halfAdder.compute(true, true));
   }
   
   @Test
   void testComputeTrueFalse()
   {
      HalfAdder halfAdder = new HalfAdder();
      
      assertEquals(1, halfAdder.compute(true, false));
   }
   
   @Test
   void testComputeFalseTrue()
   {
      HalfAdder halfAdder = new HalfAdder();
      
      assertEquals(1, halfAdder.compute(false, true));
   }
   
   @Test
   void testComputeFalseFalse()
   {
      HalfAdder halfAdder = new HalfAdder();
      
      assertEquals(0, halfAdder.compute(false, false));
   }
}
