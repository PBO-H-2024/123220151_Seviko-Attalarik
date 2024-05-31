package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.CRUD;

public class Main {
    CRUD connector = new CRUD();

    // initialize the frame
    JFrame window = new JFrame("Quiz Praktikum");
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JButton addButton = new JButton("Add");
    JButton editButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    JButton refreshButton = new JButton("Refresh");
    JLabel lName = new JLabel("Name");
    JLabel lPath = new JLabel("Path");
    JLabel lWriting = new JLabel("Writing");
    JLabel lCoding = new JLabel("Coding");
    JLabel lInterview = new JLabel("Interview");
    JTextField tfName = new JTextField();
    JComboBox tfPath;
    JTextField tfWriting = new JTextField();
    JTextField tfCoding = new JTextField();
    JTextField tfInterview = new JTextField();

    // table column and path list
    Object columnName[] = {
        "Name", "path", "Writing", "Coding", "Interview", "Score", "Status"
    };
    String pathList[] = {
        "Android Developer", "Web Developer" 
    };

    public Main() {
        // set the table and the frame layout
        tableModel = new DefaultTableModel(columnName, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        tfPath = new JComboBox(pathList);
        window.setLayout(null);
        window.setSize(800, 400);
//        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the components to the frame
        window.add(scrollPane);
        window.add(addButton);
        window.add(editButton);
        window.add(deleteButton);
        window.add(refreshButton);
        window.add(lName);
        window.add(lPath);
        window.add(lWriting);
        window.add(lCoding);
        window.add(lInterview);
        window.add(tfName);
        window.add(tfPath);
        window.add(tfWriting);
        window.add(tfCoding);
        window.add(tfInterview);

        // set the components position
        scrollPane.setBounds(20, 35, 500, 300);
        addButton.setBounds(540, 215, 180, 30);
        editButton.setBounds(540, 245, 180, 30);
        deleteButton.setBounds(540, 275, 180, 30);
        refreshButton.setBounds(540, 305, 180, 30);
        lName.setBounds(540, 35, 100, 20);
        lPath.setBounds(540, 65, 100, 20);
        lWriting.setBounds(540, 95, 100, 20);
        lCoding.setBounds(540, 125, 100, 20);
        lInterview.setBounds(540, 155, 100, 20);
        tfName.setBounds(620, 35, 100, 20);
        tfPath.setBounds(620, 65, 100, 20);
        tfWriting.setBounds(620, 95, 100, 20);
        tfCoding.setBounds(620, 125, 100, 20);
        tfInterview.setBounds(620, 155, 100, 20);

        // add action listener to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the input from the text field
                String name = tfName.getText();
                String path = tfPath.getSelectedItem().toString();
                float writing = tfWriting.getText().isEmpty() ? 0.0f : Float.parseFloat(tfWriting.getText());
                float coding = tfCoding.getText().isEmpty() ? 0.0f : Float.parseFloat(tfCoding.getText());
                float interview = tfInterview.getText().isEmpty() ? 0.0f : Float.parseFloat(tfInterview.getText());
        
                // validate the input
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is required");
                    return;
                }

                // validate the input for writing, coding, and interview. if the input is invalid, show the error message
                if (writing == 0.0f && coding == 0.0f && interview == 0.0f || writing < 0.0f || coding < 0.0f || interview < 0.0f || writing > 100.0f || coding > 100.0f || interview > 100.0f) {
                    JOptionPane.showMessageDialog(null, "Invalid input on writing, coding, or interview");
                    return;
                }

                // calculate the final score and status based on the path
                if (path == "Android Developer") {
                    float finalScore = (writing * 0.2f + coding * 0.5f + interview * 0.3f);

                    String status;

                    if (finalScore >= 85) {
                        status = "ACCEPTED";
                    } else {
                        status = "NOT ACCEPTED";
                    }

                    connector.insertData(name, path, writing, coding, interview, finalScore, status);
                    return;
                } else if (path == "Web Developer") {
                    float finalScore = (writing * 0.4f + coding * 0.35f + interview * 0.25f);

                    String status;

                    if (finalScore >= 85) {
                        status = "ACCEPTED";
                    } else {
                        status = "NOT ACCEPTED";
                    }

                    connector.insertData(name, path, writing, coding, interview, finalScore, status);
                    return;
                }
             }
        });

        // add action listener to the refresh button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [][] data = connector.readData();
                
                tabel.setModel((new JTable(data, columnName)).getModel());
            }
        });

        // add action listener to the table
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = tabel.getSelectedRow();
                
                // get the data from the selected row
                String name = tabel.getValueAt(row,0).toString();
                String path = tabel.getValueAt(row,1).toString();
                float writing = Float.parseFloat(tabel.getValueAt(row,2).toString());
                float coding = Float.parseFloat(tabel.getValueAt(row,3).toString());
                Float interview = Float.parseFloat(tabel.getValueAt(row,4).toString());

                // set the data to the text field
                tfName.setText(name);
                tfPath.setSelectedItem(path);
                tfWriting.setText(String.valueOf(writing));
                tfCoding.setText(String.valueOf(coding));
                tfInterview.setText(String.valueOf(interview));
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validate the input
                if (tfName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Click one of the data first");
                    return;
                }

                // delete the data
                connector.deleteData(tfName.getText());
                tfName.setText("");
                tfWriting.setText(String.valueOf(""));
                tfCoding.setText(String.valueOf(""));
                tfInterview.setText(String.valueOf(""));
            }
        });

        // add action listener to the edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the input from the text field
                String name = tfName.getText();
                String path = tfPath.getSelectedItem().toString();
                float writing = tfWriting.getText().isEmpty() ? 0.0f : Float.parseFloat(tfWriting.getText());
                float coding = tfCoding.getText().isEmpty() ? 0.0f : Float.parseFloat(tfCoding.getText());
                float interview = tfInterview.getText().isEmpty() ? 0.0f : Float.parseFloat(tfInterview.getText());
        
                // validate the input
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name is required");
                    return;
                }

                // validate the input for writing, coding, and interview. if the input is invalid, show the error message
                if (writing == 0.0f && coding == 0.0f && interview == 0.0f || writing < 0.0f || coding < 0.0f || interview < 0.0f || writing > 100.0f || coding > 100.0f || interview > 100.0f) {
                    JOptionPane.showMessageDialog(null, "Invalid input on writing, coding, or interview");
                    return;
                }

                // calculate the final score and status based on the path
                if (path == "Android Developer") {
                    float finalScore = (writing * 0.2f + coding * 0.5f + interview * 0.3f);
                    String status;

                    // set the status based on the final score
                    if (finalScore >= 85) {
                        status = "ACCEPTED";
                    } else {
                        status = "NOT ACCEPTED";
                    }

                    // update the data
                    connector.updateData(name, path, writing, coding, interview, finalScore, status);
                    return;
                } else if (path == "Web Developer") {
                    float finalScore = (writing * 0.4f + coding * 0.35f + interview * 0.25f);
                    String status;

                    // set the status based on the final score
                    if (finalScore >= 85) {
                        status = "ACCEPTED";
                    } else {
                        status = "NOT ACCEPTED";
                    }

                    connector.updateData(name, path, writing, coding, interview, finalScore, status);
                    return;
                }
            }
        });
    }
}
