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
package com.mononokel.assembler.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CombinedMemoryTest
{
   @Test
   void testComputeFalseFalseFalse0False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, false, false, 0, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseFalseFalse42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, false, false, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseFalseFalse42False_FalseFalseFalse42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(false, false, false, 42, false);
      int[] results = combinedMemory.compute(false, false, false, 42, true);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueFalseFalse42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(true, false, false, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseTrueFalse42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, true, false, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseFalseTrue42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, false, true, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueTrueFalse42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(true, false, false, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueFalseTrue42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, true, false, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseTrueTrue42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, false, true, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueTrueTrue42False()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      int[] results = combinedMemory.compute(false, false, true, 42, false);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueTrueFalse42True_FalseFalseFalse0True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, true, false, 42, true);
      int[] results = combinedMemory.compute(false, false, false, 0, true); 
      
      assertEquals(42, results[0]);
      assertEquals(42, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueFalseFalse42False_TrueFalseFalse42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, false, false, 42, false);
      int[] results = combinedMemory.compute(true, false, false, 42, true);
      
      assertEquals(42, results[0]);
      assertEquals(0, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseTrueFalse42False_FalseTrueFalse42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(false, true, false, 42, false);
      int[] results = combinedMemory.compute(false, true, false, 42, true);
      
      assertEquals(0, results[0]);
      assertEquals(42, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeFalseFalseTrue42False_FalseFalseTrue42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(false, false, true, 42, false);
      int[] results = combinedMemory.compute(false, false, true, 42, true);
      
      assertEquals(0, results[0]);
      assertEquals(0, results[1]);
      assertEquals(42, results[2]);
   }
   
   @Test
   void testComputeTrueTrueFalse42False_TrueTrueFalse42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, true, false, 42, false);
      int[] results = combinedMemory.compute(true, true, false, 42, true);
      
      assertEquals(42, results[0]);
      assertEquals(42, results[1]);
      assertEquals(0, results[2]);
   }
   
   @Test
   void testComputeTrueFalseTrue42False_TrueFalseTrue42True_TrueFalseTrue42False_TrueFalseTrue42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, false, true, 42, false);
      combinedMemory.compute(true, false, true, 42, true);
      combinedMemory.compute(true, false, true, 42, false);
      int[] results = combinedMemory.compute(true, false, true, 42, true);
      
      assertEquals(42, results[0]);
      assertEquals(0, results[1]);
      assertEquals(42, results[2]);
   }
   
   @Test
   void testComputeFalseTrueTrue42False_FalseTrueTrue42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(false, true, true, 42, false);
      int[] results = combinedMemory.compute(false, true, true, 42, true);
      
      assertEquals(0, results[0]);
      assertEquals(42, results[1]);
      assertEquals(42, results[2]);
   }
   
   @Test
   void testComputeTrueTrueTrue42False_TrueTrueTrue42True_TrueTrueTrue42False_TrueTrueTrue42True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, true, true, 42, false);
      combinedMemory.compute(true, true, true, 42, true);
      combinedMemory.compute(true, true, true, 42, false);
      int[] results = combinedMemory.compute(true, true, true, 42, true);
      
      assertEquals(42, results[0]);
      assertEquals(42, results[1]);
      assertEquals(42, results[2]);
   }
   
   @Test
   void testComputeTrueFalseFalse42False_FalseFalseTrue21False_FalseFalseFalse33True()
   {
      CombinedMemory combinedMemory = new CombinedMemory();
      combinedMemory.compute(true, false, false, 42, true);
      combinedMemory.compute(false, false, true, 21, true);
      
      int[] results = combinedMemory.compute(false, false, false, 33, true); 
      
      assertEquals(42, results[0]);
      assertEquals(0, results[1]);
      assertEquals(21, results[2]);
   }
}
