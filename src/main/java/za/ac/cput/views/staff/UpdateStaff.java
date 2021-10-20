package za.ac.cput.views.staff;

import za.ac.cput.client.StaffHttpClient;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.views.CustomerMenu;
import za.ac.cput.views.StaffMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStaff extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblStaffId, lblName, lblSurname;
    private  JTextField  txtStaffId, txtName, txtSurname;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateStaff()
    {
        super("Update Staff Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Staff", SwingConstants.CENTER);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname: ", SwingConstants.RIGHT);

        txtStaffId = new JTextField();
        txtName = new JTextField();
        txtSurname = new JTextField();

        btnRead = new JButton("Read");
        btnCreate = new JButton("Update");
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
        emptySpace14 = new JLabel();

        //setTextFieldToUneditable(); //Set all fields to not be editable
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

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtStaffId.setFont(ftText);
        txtName.setFont(ftText);
        txtSurname.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblStaffId);
        centerPanel.add(txtStaffId);
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
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnRead);
        southPanel.add(btnCreate);
        southPanel.add(btnClear);
        southPanel.add(btnExit);
        //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnCreate.addActionListener(this);
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

                Staff oldStaff = StaffHttpClient.read(staffId);

                if(oldStaff != null)
                {
                    JOptionPane.showMessageDialog(null, "Customer exist with ID of: " + staffId);

                    txtName.setText(oldStaff.getName());
                    txtSurname.setText(String.valueOf(oldStaff.getSurname()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtStaffId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Customer exists with ID of: " + staffId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int staffId = Integer.parseInt(txtStaffId.getText().trim().toString());
            String name = txtName.getText().trim().toString();
            String surname = txtSurname.getText().trim().toString();

            if(name.isEmpty() || surname.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a staff profile.");
            }
            else {
                Staff updateStaff = StaffFactory.updateStaff(staffId, name, surname);

                Staff result = StaffHttpClient.update(updateStaff);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtStaffId.setText("");
                    txtName.setText("");
                    txtSurname.setText("");

                    txtStaffId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtStaffId.setText("");
            txtName.setText("");
            txtSurname.setText("");

            txtStaffId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new StaffMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtStaffId.setEnabled(true);
        txtName.setEnabled(false);
        txtSurname.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtStaffId.setEnabled(false);
        txtName.setEnabled(true);
        txtSurname.setEnabled(true);

    }


    public static void main(String[] args) {
        new UpdateStaff().setGui();
    }
}

