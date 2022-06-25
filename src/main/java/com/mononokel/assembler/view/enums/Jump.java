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
package com.mononokel.assembler.view.enums;

public enum Jump
{
   None("", 0b0), JLT("; JLT", 0b100), JEQ("; JEQ", 0b010), JGT("; JGT", 0b001), JLE("; JLE", 0b110), JGE("; JGE", 0b011),
   JMP("; JMP", 0b111);
   
   private int code;
   private String display; 
   
   private Jump(String display, int code)
   {
      this.code = code;
      this.display = display;
   }
   
   @Override
   public String toString()
   {
      return display;
   }
   
   public int getCode()
   {
      return code;
   }
}
