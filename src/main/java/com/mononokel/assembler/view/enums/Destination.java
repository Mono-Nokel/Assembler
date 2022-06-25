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

public enum Destination
{
   None("", 0b0), A("A =", 0b100), D("D =", 0b010), AStar("*A =", 0b001), AandD("A, D =", 0b110), DandAStar("D, *A =", 0b011),
   AandDandAStar("A, D, *A =", 0b111);
   
   private int code;
   private String display; 
   
   private Destination(String display, int code)
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
