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
package com.mononokel.assembler.view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class MemoryMapOut extends JFrame
{
   private JTextPane tpOut;

   public MemoryMapOut() {
      setTitle("Memory Map Out");
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{0, 0};
      gridBagLayout.rowHeights = new int[]{0, 0, 0};
      gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
      getContentPane().setLayout(gridBagLayout);
      
      JButton btnClear = new JButton("Clear");
      btnClear.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            clearOut();
         }
      });
      GridBagConstraints gbc_btnClear = new GridBagConstraints();
      gbc_btnClear.insets = new Insets(0, 0, 5, 0);
      gbc_btnClear.gridx = 0;
      gbc_btnClear.gridy = 0;
      getContentPane().add(btnClear, gbc_btnClear);
      
      tpOut = new JTextPane();
      tpOut.setPreferredSize(new Dimension(250, 100));
      tpOut.setMinimumSize(new Dimension(100, 100));
      GridBagConstraints gbc_tpOut = new GridBagConstraints();
      gbc_tpOut.fill = GridBagConstraints.BOTH;
      gbc_tpOut.gridx = 0;
      gbc_tpOut.gridy = 1;
      getContentPane().add(tpOut, gbc_tpOut);
      pack();
      setVisible(true);
   }

   private void clearOut()
   {
      tpOut.setText("");
   }
   
   public void writeCharacter(char character)
   {
      tpOut.setText(tpOut.getText() + character);
   }
}
