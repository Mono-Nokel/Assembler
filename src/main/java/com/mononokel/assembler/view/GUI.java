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

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mononokel.assembler.control.Controller;
import com.mononokel.assembler.control.enums.ControllerState;
import com.mononokel.assembler.control.interfaces.ControllerUpdateListener;
import com.mononokel.assembler.view.enums.Destination;
import com.mononokel.assembler.view.enums.Instruction;
import com.mononokel.assembler.view.enums.Jump;
import com.mononokel.assembler.view.model.ProgramTableModel;
import com.mononokel.assembler.view.model.ValidLine;
import com.mononokel.assembler.view.renderers.ProgramTableCellRenderer;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ControllerUpdateListener
{
   private JTable programTable;
   private JTextField tfA;
   private JTextField tfD;
   private JTextField tfPC;
   private ProgramTableModel programTableModel = new ProgramTableModel();
   private JComboBox<Destination> destinationComboBox = new JComboBox<>();
   private JComboBox<Jump> jumpComboBox = new JComboBox<>();
   private JComboBox<Instruction> instructionComboBox = new JComboBox<>();
   private Controller controller = new Controller();
   private JTextField tfRunningState;
   private JTable tableRam;
   private String[] ramColumns = new String[] {"Ram Address", "Ram Value"};
   private DefaultTableModel ramTableModel = new DefaultTableModel(ramColumns, 256);
   private ImageIcon errorIcon = new ImageIcon(GUI.class.getClassLoader().getResource("error-icon.png"));
   private JTextField tfAStar;
   
   public GUI() {
      controller.addListenener(this);
      instructionComboBox.setEditable(true);
      Arrays.stream(Destination.values()).forEach(destinationComboBox::addItem);
      Arrays.stream(Jump.values()).forEach(jumpComboBox::addItem);
      Arrays.stream(Instruction.values()).forEach(instructionComboBox::addItem);
      setTitle("Assembler");
      GridBagLayout gridBagLayout = new GridBagLayout();
      gridBagLayout.columnWidths = new int[]{434, 0};
      gridBagLayout.rowHeights = new int[]{261, 0, 0, 0};
      gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
      gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
      getContentPane().setLayout(gridBagLayout);
      
      JSplitPane splitPane = new JSplitPane();
      splitPane.setResizeWeight(0.7);
      GridBagConstraints gbc_splitPane = new GridBagConstraints();
      gbc_splitPane.insets = new Insets(0, 0, 5, 0);
      gbc_splitPane.fill = GridBagConstraints.BOTH;
      gbc_splitPane.gridx = 0;
      gbc_splitPane.gridy = 0;
      getContentPane().add(splitPane, gbc_splitPane);
      
      JScrollPane scrollPane = new JScrollPane();
      splitPane.setLeftComponent(scrollPane);
      
      programTable = new JTable(programTableModel);
      programTable.getColumnModel().getColumn(ProgramTableModel.DESTINATION_COLUMN).setCellEditor(new DefaultCellEditor(destinationComboBox));
      programTable.getColumnModel().getColumn(ProgramTableModel.INSTRUCTION_COLUMN).setCellEditor(new DefaultCellEditor(instructionComboBox));
      programTable.getColumnModel().getColumn(ProgramTableModel.JUMP_COLUMN).setCellEditor(new DefaultCellEditor(jumpComboBox));
      programTable.setDefaultRenderer(Object.class, new ProgramTableCellRenderer());
      programTableModel.addTableModelListener(e -> validateProgram());
      programTableModel.addRow();
      scrollPane.setViewportView(programTable);
      
      JPanel state = new JPanel();
      state.setFont(new Font("Tahoma", Font.BOLD, 20));
      state.setBorder(new LineBorder(new Color(0, 0, 0)));
      splitPane.setRightComponent(state);
      GridBagLayout gbl_state = new GridBagLayout();
      gbl_state.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
      gbl_state.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
      gbl_state.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      gbl_state.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
      state.setLayout(gbl_state);
      
      JLabel lblA = new JLabel("A");
      lblA.setFont(new Font("Tahoma", Font.BOLD, 20));
      GridBagConstraints gbc_lblA = new GridBagConstraints();
      gbc_lblA.insets = new Insets(0, 0, 5, 5);
      gbc_lblA.gridx = 0;
      gbc_lblA.gridy = 0;
      state.add(lblA, gbc_lblA);
      
      tfA = new JTextField();
      tfA.setEditable(false);
      GridBagConstraints gbc_tfA = new GridBagConstraints();
      gbc_tfA.insets = new Insets(0, 0, 5, 5);
      gbc_tfA.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfA.gridx = 1;
      gbc_tfA.gridy = 0;
      state.add(tfA, gbc_tfA);
      tfA.setColumns(10);
      
      JLabel lblD = new JLabel("D");
      lblD.setFont(new Font("Tahoma", Font.BOLD, 20));
      GridBagConstraints gbc_lblD = new GridBagConstraints();
      gbc_lblD.insets = new Insets(0, 0, 5, 5);
      gbc_lblD.gridx = 0;
      gbc_lblD.gridy = 1;
      state.add(lblD, gbc_lblD);
      
      tfD = new JTextField();
      tfD.setEditable(false);
      GridBagConstraints gbc_tfD = new GridBagConstraints();
      gbc_tfD.insets = new Insets(0, 0, 5, 5);
      gbc_tfD.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfD.gridx = 1;
      gbc_tfD.gridy = 1;
      state.add(tfD, gbc_tfD);
      tfD.setColumns(10);
      
      tfPC = new JTextField();
      tfPC.setEditable(false);
      GridBagConstraints gbc_tfPC = new GridBagConstraints();
      gbc_tfPC.insets = new Insets(0, 0, 5, 5);
      gbc_tfPC.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfPC.gridx = 1;
      gbc_tfPC.gridy = 2;
      state.add(tfPC, gbc_tfPC);
      tfPC.setColumns(10);
      
      JLabel lblPC = new JLabel("PC");
      lblPC.setFont(new Font("Tahoma", Font.BOLD, 20));
      GridBagConstraints gbc_lblPC = new GridBagConstraints();
      gbc_lblPC.insets = new Insets(0, 0, 5, 5);
      gbc_lblPC.gridx = 0;
      gbc_lblPC.gridy = 2;
      state.add(lblPC, gbc_lblPC);
      
      JLabel lblAStar = new JLabel("*A");
      lblAStar.setFont(new Font("Tahoma", Font.BOLD, 20));
      GridBagConstraints gbc_lblAStar = new GridBagConstraints();
      gbc_lblAStar.insets = new Insets(0, 0, 5, 5);
      gbc_lblAStar.gridx = 0;
      gbc_lblAStar.gridy = 3;
      state.add(lblAStar, gbc_lblAStar);
      
      tfAStar = new JTextField();
      tfAStar.setEditable(false);
      GridBagConstraints gbc_tfAStar = new GridBagConstraints();
      gbc_tfAStar.insets = new Insets(0, 0, 5, 5);
      gbc_tfAStar.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfAStar.gridx = 1;
      gbc_tfAStar.gridy = 3;
      state.add(tfAStar, gbc_tfAStar);
      tfAStar.setColumns(10);
      
      tfRunningState = new JTextField();
      tfRunningState.setEditable(false);
      GridBagConstraints gbc_tfRunningState = new GridBagConstraints();
      gbc_tfRunningState.insets = new Insets(0, 0, 5, 5);
      gbc_tfRunningState.fill = GridBagConstraints.HORIZONTAL;
      gbc_tfRunningState.gridx = 1;
      gbc_tfRunningState.gridy = 4;
      state.add(tfRunningState, gbc_tfRunningState);
      tfRunningState.setColumns(10);
      
      JScrollPane scrollPane_1 = new JScrollPane();
      GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
      gbc_scrollPane_1.gridwidth = 2;
      gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
      gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
      gbc_scrollPane_1.gridx = 0;
      gbc_scrollPane_1.gridy = 5;
      state.add(scrollPane_1, gbc_scrollPane_1);
      
      tableRam = new JTable(ramTableModel);
      scrollPane_1.setViewportView(tableRam);
      
      JPanel buttons = new JPanel();
      buttons.setBorder(new LineBorder(new Color(0, 0, 0)));
      GridBagConstraints gbc_buttons = new GridBagConstraints();
      gbc_buttons.gridheight = 2;
      gbc_buttons.insets = new Insets(0, 0, 5, 0);
      gbc_buttons.fill = GridBagConstraints.BOTH;
      gbc_buttons.gridx = 0;
      gbc_buttons.gridy = 1;
      getContentPane().add(buttons, gbc_buttons);
      
      JButton btnAddInstruction = new JButton("Add Instruction");
      btnAddInstruction.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            programTableModel.addRow();
         }
      });
      buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      buttons.add(btnAddInstruction);
      
      JButton btnRemoveInstruction = new JButton("Remove Instruction");
      btnRemoveInstruction.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            programTableModel.removeRow(programTable.getSelectedRow());            
         }
      });
      buttons.add(btnRemoveInstruction);
      
      JButton btnRun = new JButton("Run");
      btnRun.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            compute(false);
         }
      });
      buttons.add(btnRun);
      
      JButton btnDebug = new JButton("Debug");
      btnDebug.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            compute(true);
         }
      });
      buttons.add(btnDebug);
      
      JButton btnStep = new JButton("Step");
      btnStep.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            controller.step();
            paused();
         }
      });
      buttons.add(btnStep);
      
      JButton btnPause = new JButton("Pause");
      btnPause.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            controller.pause();
         }
      });
      buttons.add(btnPause);
      
      JButton btnStop = new JButton("Stop");
      btnStop.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            controller.stop();
         }
      });
      buttons.add(btnStop);
      
      pack();
      stopped();
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   private void loadValues()
   {
      tfA.setText("" + controller.getA());
      tfD.setText("" + controller.getD());
      tfAStar.setText("" + controller.getAStar());
      tfPC.setText("" + controller.getProgramCounter());
      loadRamValues();
      invalidate();
   }

   private void loadRamValues()
   {
      int[] ramValues = controller.getRam();
      Integer[][] table = new Integer[256][2];
      
      for (int i = 0; i < 256; i++)
      {
         table[i][0] = i;
         table[i][1] = ramValues[i];
      }
      
      ramTableModel.setDataVector(table, ramColumns);
   }

   private void compute(boolean useBreakPoints)
   {
      if (controller.isStopped())
      {
         controller.loadProgram(programTableModel.getData());
      }
      controller.run(useBreakPoints);
   }

   @Override
   public void update(ControllerState state)
   {
      switch (state)
      {
         case paused:
            paused();
            break;
         case running:
            running();
            break;
         case stopped:
            stopped();
            break;
      }
   }

   public void paused()
   {
      tfRunningState.setBackground(Color.YELLOW);
      tfRunningState.setText("Paused");
      loadValues();
      eraseTableColor();
      programTableModel.setRowColor(controller.getProgramCounter(), Color.GREEN);
      invalidate();
   }

   public void stopped()
   {
      tfRunningState.setBackground(Color.RED);
      tfRunningState.setText("Stopped");
      invalidate();
      eraseTableColor();
   }


   public void running()
   {
      tfRunningState.setBackground(Color.GREEN);
      tfRunningState.setText("Running");
      invalidate();
   }
   
   private void validateProgram()
   {
      List<Object[]> program = programTableModel.getData();
      
      for (int i = 0; i < program.size(); i++)
      {
         setValidLine(program.get(i), i);
      }
   }
   
   private void setValidLine(Object[] line, int row)
   {
      ValidLine[] validLine = new ValidLine[programTableModel.getColumnCount()];
      Arrays.fill(validLine, new ValidLine());
      
      if (!(line[ProgramTableModel.INSTRUCTION_COLUMN] instanceof Instruction))
      {
         try
         {
            String temp = ((String)line[ProgramTableModel.INSTRUCTION_COLUMN]);
            
            if (temp.indexOf('#') > 0)
            {
               temp = temp.substring(0, temp.indexOf('#'));
            }
            
            Integer.parseInt(temp.trim());            
            
            if (line[ProgramTableModel.DESTINATION_COLUMN] != Destination.A)
            {
               validLine[ProgramTableModel.DESTINATION_COLUMN] = createErrorLine("Only A can be set to an integer value");
            }
            if (line[ProgramTableModel.JUMP_COLUMN] != Jump.None)
            {
               validLine[ProgramTableModel.JUMP_COLUMN] = createErrorLine("Jump must be empty when setting A to an integer value");
            }
         }
         catch (NumberFormatException e)
         {
            validLine[ProgramTableModel.INSTRUCTION_COLUMN] = createErrorLine("Instruction must be an integer or Instruction");
         }
      }
      
      if (line[ProgramTableModel.JUMP_COLUMN] != Jump.None && line[ProgramTableModel.JUMP_COLUMN] != Jump.JMP)
      {
         if (!(line[ProgramTableModel.INSTRUCTION_COLUMN] instanceof Instruction)
               || line[ProgramTableModel.INSTRUCTION_COLUMN] == Instruction.None)
         {
            validLine[ProgramTableModel.JUMP_COLUMN] = createErrorLine("Conditional jumps require an Instruction");
         }
      }
      
      programTableModel.setValidLineRow(validLine, row);
   }
   
   private ValidLine createErrorLine(String errorMessage)
   {
      ValidLine validLine = new ValidLine();
      validLine.errorMessage = errorMessage;
      validLine.icon = errorIcon;
      
      return validLine;
   }
   
   private void eraseTableColor()
   {
      for (int i = 0; i < programTable.getRowCount(); i++)
      {
         programTableModel.setRowColor(i, Color.WHITE);
      }      
   }
}
