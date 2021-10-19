package za.ac.cput.views.customer;

import za.ac.cput.client.CustomerHttpClient;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.views.CustomerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCustomer extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblCustomerId, lblName, lblSurname, lblEmailAddress,lblHomeAddress, lblPhoneNumber;
    private JLabel lblName1, lblSurname1, lblEmailAddress1, lblHomeAddress1, lblPhoneNumber1;;
    private JTextField txtCustomerId;
    private JButton btnRead, btnDelete, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13;

    public DeleteCustomer()
    {
        super("Delete Customer Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Delete Customer", SwingConstants.CENTER);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Surname : ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Email Address: ", SwingConstants.RIGHT);
        lblHomeAddress = new JLabel("Home Address: ", SwingConstants.RIGHT);
        lblPhoneNumber = new JLabel("Phone Number : ", SwingConstants.RIGHT);

        txtCustomerId = new JTextField();
        lblName1 = new JLabel("");
        lblSurname1 = new JLabel("");
        lblEmailAddress1 = new JLabel("");
        lblHomeAddress1 = new JLabel("");
        lblPhoneNumber1 = new JLabel("");


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
        centerPanel.setLayout(new GridLayout(8,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        //lblHeading.setForeground(Color.decode("#FFFFFF"));

        lblCustomerId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);
        lblEmailAddress.setFont(ftTextBold);
        lblHomeAddress.setFont(ftTextBold);
        lblPhoneNumber.setFont(ftTextBold);

        btnRead.setFont(ftTextBold);
        btnExit.setFont(ftTextBold);

        txtCustomerId.setFont(ftText);
        lblName1.setFont(ftText);
        lblSurname1.setFont(ftText);
        lblEmailAddress1.setFont(ftText);
        lblHomeAddress1.setFont(ftText);
        lblPhoneNumber1.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        //northPanel.setBackground(Color.decode("#4863A0"));

        centerPanel.add(lblCustomerId);
        centerPanel.add(txtCustomerId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(lblName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(lblSurname1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblEmailAddress);
        centerPanel.add(lblEmailAddress1);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblHomeAddress);
        centerPanel.add(lblHomeAddress1);
        centerPanel.add(emptySpace5);

        centerPanel.add(lblPhoneNumber);
        centerPanel.add(lblPhoneNumber1);
        centerPanel.add(emptySpace6);

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
                Customer result = CustomerHttpClient.read(customerId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Customer exist with ID of: " + customerId);

                    txtCustomerId.setEnabled(false);
                    lblName1.setText(result.getName());
                    lblSurname1.setText(result.getSurname());
                    lblEmailAddress1.setText(result.getEmailAddress());
                    lblHomeAddress1.setText(result.getHomeAddress());
                    lblPhoneNumber1.setText(String.valueOf(result.getPhoneNumber()));

                }
                else {
                    JOptionPane.showMessageDialog(null, "No customer exists with ID of: " + customerId);
                }
            }
        }
        else if(e.getActionCommand().equals("Delete"))
        {
            int deleteCustomerWithId = Integer.parseInt(txtCustomerId.getText().trim().toString());

            CustomerHttpClient.delete(deleteCustomerWithId);
            JOptionPane.showMessageDialog(null, "The customer with ID of: " + deleteCustomerWithId + " was deleted.");

            txtCustomerId.setText("");
            lblName1.setText("");
            lblSurname1.setText("");
            lblEmailAddress1.setText("");
            lblHomeAddress1.setText("");
            lblPhoneNumber1.setText("");

            txtCustomerId.setEnabled(true);
            txtCustomerId.requestFocus();
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtCustomerId.setText("");
            lblName1.setText("");
            lblSurname1.setText("");
            lblEmailAddress1.setText("");
            lblHomeAddress1.setText("");
            lblPhoneNumber1.setText("");

            txtCustomerId.setEnabled(true);
            txtCustomerId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new CustomerMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer().setGui();
    }
}

