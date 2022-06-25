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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class _256SwitchTest
{
   @Test
   void testCompute0_0()
   {
      _256Switch _256_32bitSwitch = new _256Switch();
      boolean[] results = _256_32bitSwitch.compute((byte) 0, false);
      
      assertFalse(results[0]);
      
      for (int i = 1; i < 256; i++)
      {
         assertFalse(results[i]);   
      }
   }
   
   @Test
   void testCompute0_42()
   {
      _256Switch _256_32bitSwitch = new _256Switch();
      boolean[] results = _256_32bitSwitch.compute((byte) 0, true);
      
      assertTrue(results[0]);
      
      for (int i = 1; i < 256; i++)
      {
         assertFalse(results[i]);   
      }
   }
   
   @Test
   void testCompute255_0()
   {
      _256Switch _256_32bitSwitch = new _256Switch();
      boolean[] results = _256_32bitSwitch.compute((byte) 255, false);
      
      assertFalse(results[255]);
      
      for (int i = 0; i < 255; i++)
      {
         assertFalse(results[i]);   
      }
   }
   
   @Test
   void testCompute255_42()
   {
      _256Switch _256_32bitSwitch = new _256Switch();
      boolean[] results = _256_32bitSwitch.compute((byte) 255, true);
      
      assertTrue(results[255]);
      
      for (int i = 0; i < 255; i++)
      {
         assertFalse(results[i]);   
      }
   }
}
