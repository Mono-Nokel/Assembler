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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ComputerTest
{
   @Test
   void testCompute()
   {
      short[] program = {(short) 0xE090, 0x0002, (short) 0xE510, (short) 0xE787};
      Computer computer = new Computer();
      
      computer.loadProgram(program);
      int[] registers = computer.getRegisters();
      int[] ram = computer.getRAM();
      
      Arrays.stream(registers).forEach(r -> assertEquals(0, r));
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      assertEquals(0, computer.getProgramCounter());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      ram = computer.getRAM();
      assertEquals(0, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(1, computer.getProgramCounter());
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      ram = computer.getRAM();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(2, computer.getProgramCounter());
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      ram = computer.getRAM();
      assertEquals(2, registers[0]);
      assertEquals(1, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(3, computer.getProgramCounter());
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      ram = computer.getRAM();
      assertEquals(2, registers[0]);
      assertEquals(1, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(2, computer.getProgramCounter());
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      ram = computer.getRAM();
      assertEquals(2, registers[0]);
      assertEquals(2, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(3, computer.getProgramCounter());
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));      
   }
   
   @Test
   void testComputeRAM()
   {
      short[] program = {0x0002, (short) 0xE088, (short) 0xF548, (short) 0xE787};
      Computer computer = new Computer();
      int[] ramTruth = new int[256];
      
      computer.loadProgram(program);
      int[] registers = computer.getRegisters();
      int[] ram = computer.getRAM();
      
      Arrays.stream(registers).forEach(r -> assertEquals(0, r));
      Arrays.stream(ram).forEach(r -> assertEquals(0, r));
      assertEquals(0, computer.getProgramCounter());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(1, computer.getProgramCounter());
      assertArrayEquals(ramTruth, computer.getRAM());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(0, registers[2]);
      assertEquals(2, computer.getProgramCounter());
      assertArrayEquals(ramTruth, computer.getRAM());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(1, registers[2]);
      assertEquals(3, computer.getProgramCounter());
      ramTruth[2] = 1;
      assertArrayEquals(ramTruth, computer.getRAM());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(1, registers[2]);
      assertEquals(2, computer.getProgramCounter());
      ramTruth[2] = 1;
      assertArrayEquals(ramTruth, computer.getRAM());
      
      assertTrue(computer.compute());
      registers = computer.getRegisters();
      assertEquals(2, registers[0]);
      assertEquals(0, registers[1]);
      assertEquals(2, registers[2]);
      assertEquals(3, computer.getProgramCounter());
      ramTruth[2] = 2;
      assertArrayEquals(ramTruth, computer.getRAM());
   }
}
