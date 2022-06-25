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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SplitterTest
{
   @Test
   void compute0x5()
   {
      Splitter splitter = new Splitter();
      boolean[] truth = new boolean[32];
      truth[0] = true;
      truth[2] = true;

      assertArrayEquals(truth, splitter.compute(0x5));
   }
   
   @Test
   void compute0x0()
   {
      Splitter splitter = new Splitter();
      boolean[] truth = new boolean[32];

      assertArrayEquals(truth, splitter.compute(0));
   }
   
   @Test
   void compute0xFFFFFFFF()
   {
      Splitter splitter = new Splitter();
      boolean[] truth = new boolean[32];
      Arrays.fill(truth, true);

      assertArrayEquals(truth, splitter.compute(0xFFFFFFFF));
   }
}
