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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class _32bitANDTest
{
   @Test
   void testCompute0_0()
   {
      _32bitAND _32bitAND = new _32bitAND();
      
      assertEquals(0, _32bitAND.compute(0, 0));
   }
   
   @Test
   void testCompute0_0xFFFFFFFF()
   {
      _32bitAND _32bitAND = new _32bitAND();
      
      assertEquals(0, _32bitAND.compute(0, 0xFFFFFFFF));
   }
   
   @Test
   void testCompute0xFFFFFFFF_0()
   {
      _32bitAND _32bitAND = new _32bitAND();
      
      assertEquals(0, _32bitAND.compute(0xFFFFFFFF, 0));
   }
   
   @Test
   void testCompute0x55555555_0xAAAAAAAA()
   {
      _32bitAND _32bitAND = new _32bitAND();
      
      assertEquals(0, _32bitAND.compute(0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testCompute0xFFFFFFFF_0xAAAAAAAA()
   {
      _32bitAND _32bitAND = new _32bitAND();
      
      assertEquals(0xAAAAAAAA, _32bitAND.compute(0xFFFFFFFF, 0xAAAAAAAA));
   }
}
