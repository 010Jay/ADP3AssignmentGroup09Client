package za.ac.cput.views.customer;

import za.ac.cput.client.CustomerHttpClient;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import za.ac.cput.views.CustomerMenu;

public class CreateCustomer extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblCustomerId, lblCustomerId1, lblName, lblSurname, lblEmailAddress,
                   lblHomeAddress, lblPhoneNumber;
    private  JTextField  txtName, txtSurname, txtEmailAddress, txtHomeAddress, txtPhoneNumber;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateCustomer()
    {
        super("Create Customer Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();


        lblHeading = new JLabel("Create Customer", SwingConstants.CENTER);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname: ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Email Address: ", SwingConstants.RIGHT);
        lblHomeAddress = new JLabel("Home Address: ", SwingConstants.RIGHT);
        lblPhoneNumber = new JLabel("Phone Number: ", SwingConstants.RIGHT);

        lblCustomerId1 = new JLabel("Auto Generated...");
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmailAddress = new JTextField();
        txtHomeAddress = new JTextField();
        txtPhoneNumber = new JTextField();

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
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,2));


        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblCustomerId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);
        lblEmailAddress.setFont(ftTextBold);
        lblHomeAddress.setFont(ftTextBold);
        lblPhoneNumber.setFont(ftTextBold);

        btnCreate.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        lblCustomerId1.setFont(ftText);
        txtName.setFont(ftText);
        txtSurname.setFont(ftText);
        txtEmailAddress.setFont(ftText);
        txtHomeAddress.setFont(ftText);
        txtPhoneNumber.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCustomerId);
        centerPanel.add(lblCustomerId1);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(txtSurname);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblEmailAddress);
        centerPanel.add(txtEmailAddress);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblHomeAddress);
        centerPanel.add(txtHomeAddress);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblPhoneNumber);
        centerPanel.add(txtPhoneNumber);
        centerPanel.add(emptySpace7);

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
        this.setSize(640, 420);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Create")) {
            String name = txtName.getText().trim().toString();
            String surname = txtSurname.getText().trim().toString();
            String emailAddress = txtEmailAddress.getText().trim().toString();
            String homeAddress = txtHomeAddress.getText().trim().toString();
            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText().trim().toString());

            if (name.isEmpty() || surname.isEmpty() || emailAddress.isEmpty() || homeAddress.isEmpty() ||
                    phoneNumber < 0)
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a profile.");
            }

            else {

                Customer createCustomer = CustomerFactory.createCustomer(name, surname, emailAddress, homeAddress, phoneNumber);

                Customer result = CustomerHttpClient.create(createCustomer);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully created your profile!.");

                    txtName.setText("");
                    txtSurname.setText("");
                    txtEmailAddress.setText("");
                    txtHomeAddress.setText("");
                    txtPhoneNumber.setText("");

                    txtName.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error creating a profile.");
                }
            }
        }

        else if(e.getActionCommand().equals("Exit"))
        {
            new CustomerMenu().setGui();
            this.dispose();
        }
   }

    public static void main(String[] args) {
        new CreateCustomer().setGui();
    }
}

