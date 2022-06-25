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

public class _32bitSubtractorTest
{
   @Test
   void testCompute0_0()
   {
      _32bitSubtractor _32bitSubtractor = new _32bitSubtractor();
      
      assertEquals(0, _32bitSubtractor.compute(0, 0));
   }
   
   @Test
   void testCompute0_1()
   {
      _32bitSubtractor _32bitSubtractor = new _32bitSubtractor();
      
      assertEquals(-1, _32bitSubtractor.compute(0, 1));
   }
   
   @Test
   void testCompute4_1()
   {
      _32bitSubtractor _32bitSubtractor = new _32bitSubtractor();
      
      assertEquals(3, _32bitSubtractor.compute(4, 1));
   }
   
   @Test
   void testCompute1_4()
   {
      _32bitSubtractor _32bitSubtractor = new _32bitSubtractor();
      
      assertEquals(-3, _32bitSubtractor.compute(1, 4));
   }
}
