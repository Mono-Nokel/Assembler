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

public class _32bitLatchTest
{
   @Test
   void testComputeFalse0()
   {
      _32bitLatch _32bitLatch = new _32bitLatch();
      
      assertEquals(0, _32bitLatch.compute(false, 0));
   }
   
   @Test
   void testComputeFalse42()
   {
      _32bitLatch _32bitLatch = new _32bitLatch();
      
      assertEquals(0, _32bitLatch.compute(false, 42));
   }
   
   @Test
   void testComputeTrue0()
   {
      _32bitLatch _32bitLatch = new _32bitLatch();
      
      assertEquals(0, _32bitLatch.compute(true, 0));
   }
   
   @Test
   void testComputeTrue42()
   {
      _32bitLatch _32bitLatch = new _32bitLatch();
      
      assertEquals(42, _32bitLatch.compute(true, 42));
   }
   
   @Test
   void testComputeTrue42False0()
   {
      _32bitLatch _32bitLatch = new _32bitLatch();
      _32bitLatch.compute(true, 42);      
      assertEquals(42, _32bitLatch.compute(false, 0));
   }
}
