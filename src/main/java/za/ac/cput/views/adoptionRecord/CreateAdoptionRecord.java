package za.ac.cput.views.adoptionRecord;

import za.ac.cput.client.AdoptionRecordHttpClient;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.factory.AdoptionRecordFactory;
import za.ac.cput.views.AdoptionRecordMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.Util.*;

public class CreateAdoptionRecord extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblAdoptionRecordId, lblAdoptionRecordId1, lblDogId, lblCustomerId, lblStaffId, lblDate, lblDate1;
    private  JTextField  txtDogId, txtCustomerId, txtStaffId;
    private JButton btnCreate, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11;

    public CreateAdoptionRecord()
    {
        super("Create Adoption Record Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Create Adoption Record", SwingConstants.CENTER);
        lblAdoptionRecordId = new JLabel("Adoption Record ID: ", SwingConstants.RIGHT);
        lblDogId = new JLabel("Dog ID: ", SwingConstants.RIGHT);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);


        lblAdoptionRecordId1 = new JLabel("Auto Generated...");
        txtDogId = new JTextField();
        txtCustomerId = new JTextField();
        txtStaffId = new JTextField();
        lblDate1 = new JLabel();

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
            centerPanel.setLayout(new GridLayout(7,3));
            southPanel.setLayout(new GridLayout(2,2));

        //Set font
            lblHeading.setFont(ftHeading);
            //lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblAdoptionRecordId.setFont(ftTextBold);
            lblDogId.setFont(ftTextBold);
            lblCustomerId.setFont(ftTextBold);
            lblStaffId.setFont(ftTextBold);
            lblDate.setFont(ftTextBold);
            btnCreate.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            lblAdoptionRecordId1.setFont(ftText);
            lblDate1.setFont(ftText)
            txtDogId.setFont(ftText);
            txtCustomerId.setFont(ftText);
            txtStaffId.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            //northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(lblAdoptionRecordId);
            centerPanel.add(lblAdoptionRecordId1);
            centerPanel.add(emptySpace1);

            centerPanel.add(lblDogId);
            centerPanel.add(txtDogId);
            centerPanel.add(emptySpace2);

            centerPanel.add(lblCustomerId);
            centerPanel.add(txtCustomerId);
            centerPanel.add(emptySpace3);

            centerPanel.add(lblStaffId);
            centerPanel.add(txtStaffId);
            centerPanel.add(emptySpace4);

            centerPanel.add(lblDate);
            centerPanel.add(lblDate1);
            centerPanel.add(emptySpace5);

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

        if(e.getActionCommand().equals("Create"))
        {
            int dogId = Integer.parseInt(txtDogId.getText().trim().toString());
            int customerId = Integer.parseInt(txtCustomerId.getText().trim().toString());
            int staffId = Integer.parseInt(txtStaffId.getText().trim().toString());
            //String date = txtDate.getText().trim().toString();


            if(dogId.isEmpty() || customerId.isEmpty() || staffId.isEmpty()
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record.");
            }
            else{
                AdoptionRecord createAdoptionRecord = AdoptionRecordFactory.createAdoptionRecord(dogId, customerId, staffId, date);

                AadoptionRecord result = AdoptionRecordHttpClient.create(createAdoptionRecord);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "You have successfully created an adoption record.");

                    txtDogId.setText("");
                    txtCustomerId.setText("");
                    txtStaffId.setText("");
                    lblDate1.setText(result.getDate());

                    txtDogId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "There was an error creating the new adoption record.");
                }
            }
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new AdoptionRecordMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new CreateAdoptionRecord().setGui();
    }
}
