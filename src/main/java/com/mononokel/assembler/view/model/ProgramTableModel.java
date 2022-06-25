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
package com.mononokel.assembler.view.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.mononokel.assembler.view.enums.Destination;
import com.mononokel.assembler.view.enums.Instruction;
import com.mononokel.assembler.view.enums.Jump;

@SuppressWarnings("serial")
public class ProgramTableModel extends AbstractTableModel
{
   public static final int BREAK_POINT_COLUMN = 0;
   public static final int DESTINATION_COLUMN = 1;
   public static final int INSTRUCTION_COLUMN = 2;
   public static final int JUMP_COLUMN = 3;
   
   private final List<Object[]> data = new ArrayList<>();
   private String[] columns = {"BreakPoint", "Destination", "Instruction", "Jump"};
   private final List<Color> rowColors = new ArrayList<>();
   private final List<ValidLine[]> validData = new ArrayList<>();
   
   public void setRowColor(int row, Color color)
   {
      if (row >= 0 && row < rowColors.size())
      {
         rowColors.set(row, color);
         fireTableRowsUpdated(row, row);
      }
   }
   
   public Color getRowColour(int row)
   {
      return rowColors.get(row);
   }
   
   @Override
   public int getRowCount()
   {
      return data.size();
   }

   @Override
   public int getColumnCount()
   {
      return columns.length;
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex)
   {
      return data.get(rowIndex)[columnIndex];
   }
   
   public void addRow()
   {
      ValidLine[] newValidLine = new ValidLine[columns.length];
      
      for (int i = 0; i < newValidLine.length; i++)
      {
         newValidLine[i] = new ValidLine();
      }
      
      validData.add(newValidLine);
      data.add(new Object[] {Boolean.FALSE, Destination.None, Instruction.None, Jump.None});
      rowColors.add(Color.WHITE);
      fireTableDataChanged();
   }
   
   public void removeRow(int row)
   {
      if (row >= 0 && row < data.size())
      {
         data.remove(row);
         fireTableDataChanged();
      }
   }
   
   @Override
   public String getColumnName(int columnIndex)
   {
      return columns[columnIndex];
   }
   
   @Override
   public Class<?> getColumnClass(int c)
   {
      return getValueAt(0, c).getClass();
   }
   
   @Override
   public boolean isCellEditable(int row, int col)
   {
      return true;
   }
   
   @Override
   public void setValueAt(Object value, int row, int col)
   {
      if (col == 2 && !(value instanceof Instruction))
      {
         data.get(row)[col] = value;
         data.get(row)[1] = Destination.A;
         data.get(row)[3] = Jump.None;
         
         try
         {
            int valueInt = Integer.parseInt((String) value);
            
            if (Character.isLetterOrDigit(valueInt))
            {
               data.get(row)[col] = value + " #'" + Character.valueOf((char)valueInt) + "'";
            }
            else
            {
               
            }
         }
         catch (NumberFormatException e)
         {
         }

         fireTableRowsUpdated(row, row);
      }      
      else
      {
         data.get(row)[col] = value;
         fireTableCellUpdated(row, col);
      }
   }
   
   public void setValidLineRow(ValidLine[] valid, int row)
   {
      validData.set(row, valid);
   }
   
   public ValidLine getValid(int row, int col)
   {
      return validData.get(row)[col];
   }

   public List<Object[]> getData()
   {
      return data;
   }
}
