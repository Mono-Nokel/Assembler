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

public class _32bitInverterTest
{
   @Test
   void testCompute0()
   {
      _32bitInverter _32bitInverter = new _32bitInverter();
      
      assertEquals(0xFFFFFFFF, _32bitInverter.compute(0));
   }
   
   @Test
   void testCompute0xFFFFFFFF()
   {
      _32bitInverter _32bitInverter = new _32bitInverter();
      
      assertEquals(0, _32bitInverter.compute(0xFFFFFFFF));
   }
   
   @Test
   void testCompute0x55555555()
   {
      _32bitInverter _32bitInverter = new _32bitInverter();
      
      assertEquals(0xAAAAAAAA, _32bitInverter.compute(0x55555555));
   }
   
   @Test
   void testCompute0xAAAAAAAA()
   {
      _32bitInverter _32bitInverter = new _32bitInverter();
      
      assertEquals(0x55555555, _32bitInverter.compute(0xAAAAAAAA));
   }
}
