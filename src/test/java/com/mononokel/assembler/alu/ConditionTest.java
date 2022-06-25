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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ConditionTest
{
   @Test
   void testComputeFalseFalseFalse0()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, false, false, 0));
   }
   
   @Test
   void testComputeFalseFalseFalse1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, false, false, 1));
   }
   
   @Test
   void testComputeFalseFalseFalseNeg1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, false, false, -1));
   }
   
   @Test
   void testComputeTrueFalseFalse0()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(true, false, false, 0));
   }
   
   @Test
   void testComputeTrueFalseFalse1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(true, false, false, 1));
   }
   
   @Test
   void testComputeTrueFalseFalseNeg1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, false, false, -1));
   }
   
   @Test
   void testComputeFalseTrueFalse0()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(false, true, false, 0));
   }
   
   @Test
   void testComputeFalseTrueFalse1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, true, false, 1));
   }
   
   @Test
   void testComputeFalseTrueFalseNeg1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, true, false, -1));
   }
   
   @Test
   void testComputeFalseFalseTrue0()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, false, true, 0));
   }
   
   @Test
   void testComputeFalseFalseTrue1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(false, false, true, 1));
   }
   
   @Test
   void testComputeFalseFalseTrueNeg1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, false, true, -1));
   }
   
   @Test
   void testComputeTrueTrueFalse0()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, true, false, 0));
   }
   
   @Test
   void testComputeTrueTrueFalse1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(true, true, false, 1));
   }
   
   @Test
   void testComputeTrueTrueFalseNeg1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, true, false, -1));
   }
   
   @Test
   void testComputeTrueFalseTrue0()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(true, false, true, 0));
   }
   
   @Test
   void testComputeTrueFalseTrue1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, false, true, 1));
   }
   
   @Test
   void testComputeTrueFalseTrueNeg1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, false, true, -1));
   }
   
   @Test
   void testComputeFalseTrueTrue0()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(false, true, true, 0));
   }
   
   @Test
   void testComputeFalseTrueTrue1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(false, true, true, 1));
   }
   
   @Test
   void testComputeFalseTrueTrueNeg1()
   {
      Condition condition = new Condition();
      
      assertFalse(condition.compute(false, true, true, -1));
   }
   
   @Test
   void testComputeTrueTrueTrue0()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, true, true, 0));
   }
   
   @Test
   void testComputeTrueTrueTrue1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, true, true, 1));
   }
   
   @Test
   void testComputeTrueTrueTrueNeg1()
   {
      Condition condition = new Condition();
      
      assertTrue(condition.compute(true, true, true, -1));
   }
}
