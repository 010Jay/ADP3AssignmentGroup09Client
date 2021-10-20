package za.ac.cput.views.staff;


import za.ac.cput.client.StaffHttpClient;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.views.StaffMenu;
import za.ac.cput.views.staff.CreateStaff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateStaff  extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblStaffId, lblStaffId1, lblName, lblSurname;
    private  JTextField  txtName, txtSurname;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateStaff()
    {
        super("Create Staff Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create Staff", SwingConstants.CENTER);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname: ", SwingConstants.RIGHT);

        lblStaffId1 = new JLabel("Auto Generated...");
        txtName = new JTextField();
        txtSurname = new JTextField();


        btnCreate = new JButton("Create");
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
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(3,3));
        southPanel.setLayout(new GridLayout(2,2));


        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblStaffId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblStaffId1.setFont(ftText);
        txtName.setFont(ftText);
        txtSurname.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblStaffId);
        centerPanel.add(lblStaffId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(txtSurname);
        centerPanel.add(emptySpace3);
        //centerPanel.setBackground(Color.decode("#CECECE"));

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(btnCreate);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnCreate.addActionListener(this);
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 240);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Create")) {
            String name = txtName.getText().trim().toString();
            String surname = txtSurname.getText().trim().toString();

            if (name.isEmpty() || surname.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            }

            else {

                Staff createStaff = StaffFactory.createStaff(name, surname);

                Staff result = StaffHttpClient.create(createStaff);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully created your staff profile!.");

                    txtName.setText("");
                    txtSurname.setText("");

                    txtName.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a staff profile.");
                }
            }
        }

        else if(e.getActionCommand().equals("Exit"))
        {
            new StaffMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateStaff().setGui();
    }
}


