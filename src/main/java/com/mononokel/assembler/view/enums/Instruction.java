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

public enum Instruction
{
   None("", 0b0),
   DplusA("D+A", 0b10000),
   DplusAStar("D+*A", 0b1010000),
   DminusA("D-A", 0b11000),
   DminusAStar("D-*A", 0b1011000),
   AminusD("A-D", 0b11001),
   AStarminusD("*A-D", 0b1011001),
   Dplus1("D+1", 0b10100),
   Aplus1("A+1", 0b10101),
   AStarplus1("*A+1", 0b1010101),
   Dminus1("D-1", 0b11100),
   Aminus1("A-1", 0b11101),
   AStarminus1("*A-1", 0b1011101),
   negD("-D", 0b11011),
   negA("-A", 0b11010),
   negAStar("-*A", 0b1011010),
   negOne("-1", 0b11110),
   one("1", 0b10110),
   D("D", 0b10011),
   A("A", 0b10010),
   AStar("*A", 0b1010010),
   DandA("D&A", 0b0),
   DandAStar("D&*A", 0b1000000),
   DorA("D|A", 0b00100),
   DorAStar("D|*A", 0b1000100),
   invertD("~D", 0b01100),
   invertA("~A", 0b01101),
   invertAStar("~*A", 0b1001101),
   zero("0", 0b00010);
   
   private int code;
   private String display; 
   
   private Instruction(String display, int code)
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
