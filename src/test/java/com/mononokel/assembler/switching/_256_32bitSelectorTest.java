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
package com.mononokel.assembler.switching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _256_32bitSelectorTest
{
   @Test
   void testCompute0_0()
   {
      int options[] = new int[256];
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(0, _256_32bitSelector.compute((byte) 0, options));
   }
   
   @Test
   void testCompute0_42()
   {
      int options[] = new int[256];
      options[0] = 42;
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(42, _256_32bitSelector.compute((byte) 0, options));
   }
   
   @Test
   void testCompute0_0Inv42()
   {
      int options[] = new int[256];
      Arrays.fill(options, 42);
      options[0] = 0;
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(0, _256_32bitSelector.compute((byte) 0, options));
   }
   
   @Test
   void testCompute255_0()
   {
      int options[] = new int[256];
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(0, _256_32bitSelector.compute((byte) 255, options));
   }
   
   @Test
   void testCompute255_42()
   {
      int options[] = new int[256];
      options[255] = 42;
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(42, _256_32bitSelector.compute((byte) 255, options));
   }
   
   @Test
   void testCompute255_0Inv42()
   {
      int options[] = new int[256];
      Arrays.fill(options, 42);
      options[255] = 0;
      _256_32bitSelector _256_32bitSelector = new _256_32bitSelector();
      
      assertEquals(0, _256_32bitSelector.compute((byte) 255, options));
   }
}
