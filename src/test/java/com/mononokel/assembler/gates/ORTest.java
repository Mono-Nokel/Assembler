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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ORTest
{
   @Test
   void testComputeTrueTrue()
   {
      OR or = new OR();
      
      assertTrue(or.compute(true, true));
   }
   
   @Test
   void testComputeTrueFalse()
   {
      OR or = new OR();
      
      assertTrue(or.compute(true, false));
   }
   
   @Test
   void testComputeFalseTrue()
   {
      OR or = new OR();
      
      assertTrue(or.compute(false, true));
   }
   
   @Test
   void testComputeFalseFalse()
   {
      OR or = new OR();
      
      assertFalse(or.compute(false, false));
   }
}
