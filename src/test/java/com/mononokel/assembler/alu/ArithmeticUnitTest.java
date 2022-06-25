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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArithmeticUnitTest
{
   @Test
   void testCompute5_7FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(12, arithmeticUnit.compute(false, false, 5, 7));
   }
   
   @Test
   void testCompute0_0FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0, arithmeticUnit.compute(false, false, 0, 0));
   }
   
   @Test
   void testCompute0_1FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(1, arithmeticUnit.compute(false, false, 0, 1));
   }
   
   @Test
   void testCompute0_3FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(3, arithmeticUnit.compute(false, false, 0, 3));
   }
   
   @Test
   void testCompute1_0FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(1, arithmeticUnit.compute(false, false, 1, 0));
   }
   
   @Test
   void testCompute3_0FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(3, arithmeticUnit.compute(false, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000FalseFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0, arithmeticUnit.compute(false, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute0_0TrueFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0, arithmeticUnit.compute(true, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(-1, arithmeticUnit.compute(true, false, 0, 1));
   }
   
   @Test
   void testCompute4_1TrueFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(3, arithmeticUnit.compute(true, false, 4, 1));
   }
   
   @Test
   void testCompute1_4TrueFalse()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(-3, arithmeticUnit.compute(true, false, 1, 4));
   }
   
   @Test
   void testCompute5_7FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(6, arithmeticUnit.compute(false, true, 5, 7));
   }
   
   @Test
   void testCompute0_0FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(1, arithmeticUnit.compute(false, true, 0, 0));
   }
   
   @Test
   void testCompute0_1FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(1, arithmeticUnit.compute(false, true, 0, 1));
   }
   
   @Test
   void testCompute0_3FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(1, arithmeticUnit.compute(false, true, 0, 3));
   }
   
   @Test
   void testCompute1_0FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(2, arithmeticUnit.compute(false, true, 1, 0));
   }
   
   @Test
   void testCompute3_0FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(4, arithmeticUnit.compute(false, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000FalseTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0x80000001, arithmeticUnit.compute(false, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(4, arithmeticUnit.compute(true, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(-1, arithmeticUnit.compute(true, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(-1, arithmeticUnit.compute(true, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(-1, arithmeticUnit.compute(true, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0, arithmeticUnit.compute(true, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(2, arithmeticUnit.compute(true, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueTrue()
   {
      ArithmeticUnit arithmeticUnit = new ArithmeticUnit();
      
      assertEquals(0x7FFFFFFF, arithmeticUnit.compute(true, true, 0x80000000, 0x80000000));
   }
}
