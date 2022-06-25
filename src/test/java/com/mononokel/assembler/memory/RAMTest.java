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

public class RAMTest
{
   @Test
   void testCompute0False0False()
   {
      RAM ram = new RAM();
      
      assertEquals(0, ram.compute((byte) 0, false, 0, false));
   }
   
   @Test
   void testCompute0True1False()
   {
      RAM ram = new RAM();
      
      assertEquals(0, ram.compute((byte) 0, true, 1, false));
   }
   
   @Test
   void testCompute0True1True_0False1True()
   {
      RAM ram = new RAM();
      ram.compute((byte) 0, true, 1, true);
      assertEquals(1, ram.compute((byte) 0, false, 1, true));
   }
   
   @Test
   void testCompute0True1True_0False42True()
   {
      RAM ram = new RAM();
      ram.compute((byte) 0, true, 1, true);
      assertEquals(1, ram.compute((byte) 0, false, 42, true));
   }
   
   @Test
   void testCompute255False0False()
   {
      RAM ram = new RAM();
      
      assertEquals(0, ram.compute((byte) 255, false, 0, false));
   }
   
   @Test
   void testCompute255True1False()
   {
      RAM ram = new RAM();
      
      assertEquals(0, ram.compute((byte) 255, true, 1, false));
   }
   
   @Test
   void testCompute255True1True_255False1True()
   {
      RAM ram = new RAM();
      ram.compute((byte) 255, true, 1, true);
      assertEquals(1, ram.compute((byte) 255, false, 1, true));
   }
   
   @Test
   void testCompute255True1True_255False42False()
   {
      RAM ram = new RAM();
      ram.compute((byte) 255, true, 1, true);
      assertEquals(1, ram.compute((byte) 255, false, 42, false));
   }
}
