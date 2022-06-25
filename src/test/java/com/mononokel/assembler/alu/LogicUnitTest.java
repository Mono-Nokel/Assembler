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

public class LogicUnitTest
{
   @Test
   void testComputeFalseFalse0_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(false, false, 0, 0));
   }
   
   @Test
   void testComputeFalseFalse0_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(false, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalse0xFFFFFFFF_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(false, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalse0x55555555_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(false, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xAAAAAAAA, logicUnit.compute(false, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrue0_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(false, true, 0, 0));
   }
   
   @Test
   void testComputeFalseTrue0_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(false, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrue0xFFFFFFFF_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(false, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrue0x55555555_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(false, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(false, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeTrueFalse0_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(true, false, 0, 0));
   }
   
   @Test
   void testComputeTrueFalse0_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(true, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeTrueFalse0xFFFFFFFF_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(true, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeTrueFalse0x55555555_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(true, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeTrueFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0x55555555, logicUnit.compute(true, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeTrueTrue0_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(true, true, 0, 0));
   }
   
   @Test
   void testComputeTrueTrue0xFFFFFFFF_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(true, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeTrueTrue0x55555555_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xAAAAAAAA, logicUnit.compute(true, true, 0x55555555, 0));
   }
   
   @Test
   void testComputeTrueTrue0xAAAAAAAA_0()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0x55555555, logicUnit.compute(true, true, 0xAAAAAAAA, 0));
   }
   
   @Test
   void testComputeTrueTrue0_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xFFFFFFFF, logicUnit.compute(true, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeTrueTrue0xFFFFFFFF_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0, logicUnit.compute(true, true, 0xFFFFFFFF, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeTrueTrue0x55555555_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0xAAAAAAAA, logicUnit.compute(true, true, 0x55555555, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeTrueTrue0xAAAAAAAA_0xFFFFFFFF()
   {
      LogicUnit logicUnit = new LogicUnit();
      
      assertEquals(0x55555555, logicUnit.compute(true, true, 0xAAAAAAAA, 0xFFFFFFFF));
   }
}
