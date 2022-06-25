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

public class FullAdderTest
{
   @Test
   void testComputeTrueTrueTrue()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(3, fullAdder.compute(true, true, true));
   }
   
   @Test
   void testComputeTrueTrueFalse()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(2, fullAdder.compute(true, true, false));
   }
   
   @Test
   void testComputeTrueFalseTrue()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(2, fullAdder.compute(true, false, true));
   }
   
   @Test
   void testComputeTrueFalseFalse()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(1, fullAdder.compute(true, false, false));
   }
   
   @Test
   void testComputeFalseTrueTrue()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(2, fullAdder.compute(false, true, true));
   }
   
   @Test
   void testComputeFalseTrueFalse()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(1, fullAdder.compute(false, true, false));
   }
   
   @Test
   void testComputeFalseFalseTrue()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(1, fullAdder.compute(false, false, true));
   }
   
   @Test
   void testComputeFalseFalseFalse()
   {
      FullAdder fullAdder = new FullAdder();
      
      assertEquals(0, fullAdder.compute(false, false, false));
   }
}
