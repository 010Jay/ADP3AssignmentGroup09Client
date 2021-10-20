package za.ac.cput.views.staff;


import za.ac.cput.client.StaffHttpClient;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.views.StaffMenu;
import za.ac.cput.views.staff.DeleteStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStaff extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblStaffId, lblName, lblSurname;
    private JLabel lblName1, lblSurname1;
    private JTextField txtStaffId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;

    public DeleteStaff()
    {
        super("Delete Staff Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete Staff", SwingConstants.CENTER);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname : ", SwingConstants.RIGHT);


        txtStaffId = new JTextField();
        lblName1 = new JLabel("");
        lblSurname1 = new JLabel("");

        btnRead = new JButton("Read");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");

        ftHeading = new Font("Segoe UI Black", Font.PLAIN, 28);
        ftText = new Font("Arial", Font.PLAIN, 12);
        ftTextBold = new Font("Arial", Font.BOLD, 12);

        emptySpace1 = new JLabel();
        emptySpace2 = new JLabel();
        emptySpace3 = new JLabel();
        emptySpace4 = new JLabel();
        emptySpace5 = new JLabel();
        emptySpace6 = new JLabel();
        emptySpace7 = new JLabel();
        emptySpace8 = new JLabel();
        emptySpace9 = new JLabel();
        emptySpace10 = new JLabel();
        emptySpace11 = new JLabel();
        emptySpace12 = new JLabel();
        emptySpace13 = new JLabel();
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(4,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblStaffId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtStaffId.setFont(ftText);
        lblName1.setFont(ftText);
        lblSurname1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblStaffId);
        centerPanel.add(txtStaffId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(lblName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(lblSurname1);
        centerPanel.add(emptySpace3);


        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnRead);
        southPanel.add(btnDelete);
        southPanel.add(btnClear);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 280);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            int staffId = Integer.parseInt(txtStaffId.getText().trim().toString());

            if(staffId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                Staff result = StaffHttpClient.read(staffId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Staff exist with ID of: " + staffId);

                    txtStaffId.setEnabled(false);
                    lblName1.setText(result.getName());
                    lblSurname1.setText(result.getSurname());

                }
                else {
                    JOptionPane.showMessageDialog(null, "No Staff exists with ID of: " + staffId);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            int deleteStaffWithId = Integer.parseInt(txtStaffId.getText().trim().toString());

            StaffHttpClient.delete(deleteStaffWithId);
            JOptionPane.showMessageDialog(null, "The staff with ID of: " + deleteStaffWithId + " was deleted.");

            txtStaffId.setText("");
            lblName1.setText("");
            lblSurname1.setText("");

            txtStaffId.setEnabled(true);
            txtStaffId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtStaffId.setText("");
            lblName1.setText("");
            lblSurname1.setText("");

            txtStaffId.setEnabled(true);
            txtStaffId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new StaffMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteStaff().setGui();
    }
}


