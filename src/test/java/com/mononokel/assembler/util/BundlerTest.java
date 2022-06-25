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
package com.mononokel.assembler.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BundlerTest
{
   @Test
   void testComputeTrueFalseTrue()
   {
      Bundler bundler = new Bundler();
      boolean input[] = new boolean[32];
      
      input[0] = true;
      input[2] = true;
      
      assertEquals(5, bundler.compute(input));
   }
   
   @Test
   void testComputeAllFalse()
   {
      Bundler bundler = new Bundler();
      boolean input[] = new boolean[32];
      
      assertEquals(0, bundler.compute(input));
   }
   
   @Test
   void testComputeAllTrue()
   {
      Bundler bundler = new Bundler();
      boolean input[] = new boolean[32];
      Arrays.fill(input, true);
      
      assertEquals(0xFFFFFFFF, bundler.compute(input));
   }
}
