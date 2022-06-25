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

public class ALUTest
{
   @Test
   void testComputeFalseFalseFalseFalseFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, false, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, false, false, false, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, false, false, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, false, false, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, true, false, false, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, false, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0x55555555_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, true, true, false, false, 0x55555555, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0xAAAAAAAA_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, true, true, false, false, 0xAAAAAAAA, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0xFFFFFFFF_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, false, 0xFFFFFFFF, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0x55555555_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, true, true, false, false, 0x55555555, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseFalse0xAAAAAAAA_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, true, true, false, false, 0xAAAAAAAA, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, false, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, true, false, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, true, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, true, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, false, true, true, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, false, true, true, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, true, false, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, true, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, true, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueFalse0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, true, false, true, false, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueFalse0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, true, false, true, false, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0x55555555_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0x55555555, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0xAAAAAAAA_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0xAAAAAAAA, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0xFFFFFFFF_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0xFFFFFFFF, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0x55555555_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0x55555555, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueFalse0xAAAAAAAA_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, false, 0xAAAAAAAA, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, true, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseFalseTrueTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, true, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, true, true, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, true, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, true, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, false, true, true, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueTrueTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, true, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, true, true, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, true, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, true, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, true, false, true, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseTrueTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, true, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0x55555555_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0x55555555, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0xAAAAAAAA_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0xAAAAAAAA, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0xFFFFFFFF_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0xFFFFFFFF, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0x55555555_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0x55555555, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueTrueTrue0xAAAAAAAA_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, true, true, 0xAAAAAAAA, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, true, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, false, false, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseFalseFalseTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xAAAAAAAA, alu.compute(false, false, false, false, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, false, true, false, true, 0, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseFalseTrueFalseTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, false, true, false, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, false, false, true, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseTrue0x55555555_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, false, false, true, 0x55555555, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueFalseFalseTrue0xFFFFFFFF_0xAAAAAAAA()
   {
      ALU alu = new ALU();
      
      assertEquals(0x55555555, alu.compute(false, true, false, false, true, 0xFFFFFFFF, 0xAAAAAAAA));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, true, 0, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0xFFFFFFFF_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, true, 0xFFFFFFFF, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0x55555555_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, true, 0x55555555, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0xAAAAAAAA_0()
   {
      ALU alu = new ALU();
      
      assertEquals(0xFFFFFFFF, alu.compute(false, true, true, false, true, 0xAAAAAAAA, 0));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, true, 0, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0xFFFFFFFF_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, true, 0xFFFFFFFF, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0x55555555_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, true, 0x55555555, 0xFFFFFFFF));
   }
   
   @Test
   void testComputeFalseTrueTrueFalseTrue0xAAAAAAAA_0xFFFFFFFF()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(false, true, true, false, true, 0xAAAAAAAA, 0xFFFFFFFF));
   }
   
   @Test
   void testCompute5_7TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(12, alu.compute(true, false, false, false, false, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, false, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, false, false, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, false, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, false, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, false, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, false, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute0_0TrueTrueFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, false, false, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, false, false, false, 0, 1));
   }
   
   @Test
   void testCompute4_1TrueTrueFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, true, false, false, false, 4, 1));
   }
   
   @Test
   void testCompute1_4TrueTrueFalseFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-3, alu.compute(true, true, false, false, false, 1, 4));
   }
   
   @Test
   void testCompute5_7TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(12, alu.compute(true, false, false, false, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, false, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, false, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, false, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(2, alu.compute(true, false, true, false, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(4, alu.compute(true, false, true, false, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0x80000001, alu.compute(true, false, true, false, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(4, alu.compute(true, true, true, false, false, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, false, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, true, false, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(2, alu.compute(true, true, true, false, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueTrueTrueFalseFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0x7FFFFFFF, alu.compute(true, true, true, false, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(7, alu.compute(true, false, false, true, false, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, true, false, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, true, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0x80000000, alu.compute(true, false, false, true, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute0_0TrueTrueFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, false, true, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, false, true, false, 0, 1));
   }
   
   @Test
   void testCompute4_1TrueTrueFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, false, true, false, 4, 1));
   }
   
   @Test
   void testCompute1_4TrueTrueFalseTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-4, alu.compute(true, true, false, true, false, 1, 4));
   }
   
   @Test
   void testCompute5_7TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueTrueTrueTrueFalse()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, false, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(12, alu.compute(true, false, false, false, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, false, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, false, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, false, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, false, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, false, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, false, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute0_0TrueTrueFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, false, false, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, true, false, false, true, 0, 1));
   }
   
   @Test
   void testCompute4_1TrueTrueFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-3, alu.compute(true, true, false, false, true, 4, 1));
   }
   
   @Test
   void testCompute1_4TrueTrueFalseFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, true, false, false, true, 1, 4));
   }
   
   @Test
   void testCompute5_7TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(8, alu.compute(true, false, true, false, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, false, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(2, alu.compute(true, false, true, false, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(4, alu.compute(true, false, true, false, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, false, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, false, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0x80000001, alu.compute(true, false, true, false, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(6, alu.compute(true, true, true, false, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, true, false, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(2, alu.compute(true, true, true, false, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, false, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueTrueTrueFalseTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0x7FFFFFFF, alu.compute(true, true, true, false, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(5, alu.compute(true, false, false, true, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, false, false, true, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, false, true, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(3, alu.compute(true, false, false, true, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0x80000000, alu.compute(true, false, false, true, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute0_0TrueTrueFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, false, true, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(0, alu.compute(true, true, false, true, true, 0, 1));
   }
   
   @Test
   void testCompute4_1TrueTrueFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-4, alu.compute(true, true, false, true, true, 4, 1));
   }
   
   @Test
   void testCompute1_4TrueTrueFalseTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, false, true, true, 1, 4));
   }
   
   @Test
   void testCompute5_7TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueFalseTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(1, alu.compute(true, false, true, true, true, 0x80000000, 0x80000000));
   }
   
   @Test
   void testCompute5_7TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 5, 7));
   }
   
   @Test
   void testCompute0_0TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 0, 0));
   }
   
   @Test
   void testCompute0_1TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 0, 1));
   }
   
   @Test
   void testCompute0_3TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 0, 3));
   }
   
   @Test
   void testCompute1_0TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 1, 0));
   }
   
   @Test
   void testCompute3_0TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 3, 0));
   }
   
   @Test
   void testCompute0x80000000_0x80000000TrueTrueTrueTrueTrue()
   {
      ALU alu = new ALU();
      
      assertEquals(-1, alu.compute(true, true, true, true, true, 0x80000000, 0x80000000));
   }
}
