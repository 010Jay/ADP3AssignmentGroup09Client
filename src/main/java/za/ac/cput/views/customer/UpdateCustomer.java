package za.ac.cput.views.customer;

import za.ac.cput.client.CustomerHttpClient;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.views.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCustomer extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblCustomerId, lblName, lblSurname, lblEmailAddress, lblHomeAddress, lblPhoneNumber;
    private  JTextField  txtCustomerId, txtName, txtSurname, txtEmailAddress, txtHomeAddress, txtPhoneNumber;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateCustomer()
    {
        super("Update Customer Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Customer", SwingConstants.CENTER);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname: ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Email Address: ", SwingConstants.RIGHT);
        lblHomeAddress = new JLabel("Home Address: ", SwingConstants.RIGHT);
        lblPhoneNumber = new JLabel("Phone Number: ", SwingConstants.RIGHT);

        txtCustomerId = new JTextField();
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmailAddress = new JTextField();
        txtHomeAddress = new JTextField();
        txtPhoneNumber = new JTextField();


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
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,4));
        radioPanel.setLayout(new GridLayout(1,2));

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

        txtCustomerId.setFont(ftText);
        txtName.setFont(ftText);
        txtSurname.setFont(ftText);
        txtEmailAddress.setFont(ftText);
        txtHomeAddress.setFont(ftText);
        txtPhoneNumber.setFont(ftText);


        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCustomerId);
        centerPanel.add(txtCustomerId);
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
        centerPanel.add(emptySpace6);

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
        this.setSize(640, 420);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            int customerId = Integer.parseInt(txtCustomerId.getText().trim().toString());

            if(customerId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                Customer oldCustomer = CustomerHttpClient.read(customerId);

                if(oldCustomer != null)
                {
                    JOptionPane.showMessageDialog(null, "Customer exist with ID of: " + customerId);

                    txtName.setText(oldCustomer.getName());
                    txtSurname.setText(String.valueOf(oldCustomer.getSurname()));
                    txtEmailAddress.setText(oldCustomer.getEmailAddress());
                    txtHomeAddress.setText(oldCustomer.getHomeAddress());
                    txtPhoneNumber.setText(String.valueOf(oldCustomer.getPhoneNumber()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtCustomerId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Customer exists with ID of: " + customerId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int customerId = Integer.parseInt(txtCustomerId.getText().trim().toString());
            String name = txtName.getText().trim().toString();
            String surname = txtSurname.getText().trim().toString();
            String emailAddress = txtEmailAddress.getText().trim().toString();
            String homeAddress = txtHomeAddress.getText().trim().toString();
            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText().trim().toString());

            if(name.isEmpty() || surname.isEmpty() || emailAddress.isEmpty() || homeAddress.isEmpty()
                || phoneNumber < 0)
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a customer.");
            }
            else {
                Customer updateCustomer = CustomerFactory.updateCustomer(customerId, name, surname, emailAddress,
                                     homeAddress, phoneNumber);

                Customer result = CustomerHttpClient.update(updateCustomer);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtCustomerId.setText("");
                    txtName.setText("");
                    txtSurname.setText("");
                    txtEmailAddress.setText("");
                    txtHomeAddress.setText("");
                    txtPhoneNumber.setText("");

                    txtCustomerId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtCustomerId.setText("");
            txtName.setText("");
            txtSurname.setText("");
            txtEmailAddress.setText("");
            txtHomeAddress.setText("");
            txtPhoneNumber.setText("");

            txtCustomerId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new CustomerMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtCustomerId.setEnabled(true);
        txtName.setEnabled(false);
        txtSurname.setEnabled(false);
        txtEmailAddress.setEnabled(false);
        txtHomeAddress.setEnabled(false);
        txtPhoneNumber.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtCustomerId.setEnabled(false);
        txtName.setEnabled(true);
        txtSurname.setEnabled(true);
        txtEmailAddress.setEnabled(true);
        txtHomeAddress.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
   }


    public static void main(String[] args) {
        new UpdateCustomer().setGui();
    }
}
