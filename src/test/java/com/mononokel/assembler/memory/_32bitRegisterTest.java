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
package com.mononokel.assembler.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _32bitRegisterTest
{
   @Test
   void testComputeFalse0False()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(false, 0, false));
   }
   
   @Test
   void testComputeFalse42False()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(false, 42, false));
   }
   
   @Test
   void testComputeTrue0False()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(true, 0, false));
   }
   
   @Test
   void testComputeTrue42False()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(true, 42, false));
   }
   
   @Test
   void testComputeFalse0True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(false, 0, true));
   }
   
   @Test
   void testComputeFalse42True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(false, 42, true));
   }
   
   @Test
   void testComputeTrue0True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(0, _32bitRegister.compute(true, 0, true));
   }
   
   @Test
   void testComputeTrue42True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      
      assertEquals(42, _32bitRegister.compute(true, 42, true));
   }
   
   @Test
   void testComputeTrue42FalseTrue0True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      _32bitRegister.compute(true, 42, false);      
      assertEquals(0, _32bitRegister.compute(true, 0, true));
   }
   
   @Test
   void testComputeTrue42TrueFalse0True()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      _32bitRegister.compute(true, 42, true);      
      assertEquals(42, _32bitRegister.compute(false, 0, true));
   }
   
   @Test
   void testComputeTrue42TrueeTrue0TrueeTrue21False()
   {
      _32bitRegister _32bitRegister = new _32bitRegister();
      _32bitRegister.compute(true, 42, true);
      _32bitRegister.compute(true, 0, true);
      assertEquals(0, _32bitRegister.compute(true, 21, false));
   }
}
