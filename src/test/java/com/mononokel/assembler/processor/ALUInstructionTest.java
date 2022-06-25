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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ALUInstructionTest
{
   @Test
   void testCompute58768_7_9_13()
   {
      ALUInstruction aluInstruction = new ALUInstruction();
      ALUInstructionResult res = aluInstruction.compute((short) 58768, 7, 9, 13);
      
      assertEquals(1, res.r);
      assertFalse(res.a);
      assertTrue(res.d);
      assertFalse(res.aStar);
      assertFalse(res.j);
   }
   
   @Test
   void testCompute57368_6_5_0()
   {
      ALUInstruction aluInstruction = new ALUInstruction();
      ALUInstructionResult res = aluInstruction.compute((short) 57368, 6, 5, 0);
      
      assertEquals(4, res.r);
      assertFalse(res.a);
      assertTrue(res.d);
      assertTrue(res.aStar);
      assertFalse(res.j);
   }
   
   @Test
   void testCompute62627_0_0_42()
   {
      ALUInstruction aluInstruction = new ALUInstruction();
      ALUInstructionResult res = aluInstruction.compute((short) 62627, 0, 0, 42);
      
      assertEquals(42, res.r);
      assertTrue(res.a);
      assertFalse(res.d);
      assertFalse(res.aStar);
      assertTrue(res.j);
   }
   
   @Test
   void testCompute62630_0_0_42()
   {
      ALUInstruction aluInstruction = new ALUInstruction();
      ALUInstructionResult res = aluInstruction.compute((short) 62630, 0, 0, 42);
      
      assertEquals(42, res.r);
      assertTrue(res.a);
      assertFalse(res.d);
      assertFalse(res.aStar);
      assertFalse(res.j);
   }
   
   @Test
   void testCompute59232_42_1_2()
   {
      ALUInstruction aluInstruction = new ALUInstruction();
      ALUInstructionResult res = aluInstruction.compute((short) 59232, 42, 1, 2);
      
      assertEquals(41, res.r);
      assertTrue(res.a);
      assertFalse(res.d);
      assertFalse(res.aStar);
      assertFalse(res.j);
   }
}
