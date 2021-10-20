package za.ac.cput.views.adoptionRecord;

import za.ac.cput.client.AdoptionRecordHttpClient;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.factory.AdoptionRecordFactory;
import za.ac.cput.views.AdoptionRecordMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class UpdateAdoptionRecord extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblAdoptionRecordId, lblDogId, lblCustomerId, lblStaffId, lblDate, lblDate1;
    private  JTextField  txtAdoptionRecordId, txtDogId, txtCustomerId, txtStaffId;
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateAdoptionRecord()
    {
        super("Update Adoption Record Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Adoption Record", SwingConstants.CENTER);
        lblAdoptionRecordId = new JLabel("Adoption Record ID: ", SwingConstants.RIGHT);
        lblDogId = new JLabel("Dog ID: ", SwingConstants.RIGHT);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);
        //lblDate1 = new JLabel("Date: ", SwingConstants.RIGHT);

        txtAdoptionRecordId = new JTextField();
        txtDogId = new JTextField();
        txtCustomerId = new JTextField();
        txtStaffId = new JTextField();
        lblDate1 = new JLabel();

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

        setTextFieldToUneditable(); //Set all fields to not be editable
    }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new FlowLayout());
            centerPanel.setLayout(new GridLayout(5,3));
            southPanel.setLayout(new GridLayout(2,4));

        //Set font
            lblHeading.setFont(ftHeading);
            //lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblAdoptionRecordId.setFont(ftTextBold);
            lblDogId.setFont(ftTextBold);
            lblCustomerId.setFont(ftTextBold);
            lblStaffId.setFont(ftTextBold);
            lblDate.setFont(ftTextBold);
            lblDate1.setFont(ftTextBold);

            txtAdoptionRecordId.setFont(ftText);
            txtDogId.setFont(ftText);
            txtCustomerId.setFont(ftText);
            txtStaffId.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            //northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(lblAdoptionRecordId);
            centerPanel.add(txtAdoptionRecordId);
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
            this.setSize(640, 340);
            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            int adoptionRecordId = Integer.parseInt(txtAdoptionRecordId.getText().trim().toString());

            if(adoptionRecordId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                AdoptionRecord oldAdoptionRecord = AdoptionRecordHttpClient.read(adoptionRecordId);

                if(oldAdoptionRecord != null)
                {
                    JOptionPane.showMessageDialog(null, "Adoption Record exist with ID of: " + adoptionRecordId);

                    txtDogId.setText(String.valueOf(oldAdoptionRecord.getDogId()));
                    txtCustomerId.setText(String.valueOf(oldAdoptionRecord.getCustomerId()));
                    txtStaffId.setText(String.valueOf(oldAdoptionRecord.getStaffId()));
                    lblDate1.setText(String.valueOf(oldAdoptionRecord.getDate()));

                    setTextFieldToEditable(); //Set all fields to editable
                    txtAdoptionRecordId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No record exists with ID of: " + adoptionRecordId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int adoptionId = Integer.parseInt(txtAdoptionRecordId.getText().trim().toString());
            int dogId = Integer.parseInt(txtDogId.getText().trim().toString());
            int customerId = Integer.parseInt(txtCustomerId.getText().trim().toString());
            int staffId = Integer.parseInt(txtStaffId.getText().trim().toString());
            Date date = new Date();

            if(dogId < 0 || customerId < 0 || staffId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a record");
            }
            else {
                AdoptionRecord updateAdoptionRecord = AdoptionRecordFactory.updateAdoptionRecord(adoptionId, dogId, customerId, staffId, date);

                AdoptionRecord result = AdoptionRecordHttpClient.update(updateAdoptionRecord);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated an adoption record");

                    txtAdoptionRecordId.setText("");
                    txtDogId.setText("");
                    txtCustomerId.setText("");
                    txtStaffId.setText("");
                    lblDate1.setText("");

                    txtAdoptionRecordId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating the record");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtAdoptionRecordId.setText("");
            txtDogId.setText("");
            txtCustomerId.setText("");
            txtStaffId.setText("");

            txtAdoptionRecordId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new AdoptionRecordMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtAdoptionRecordId.setEnabled(true);
        txtDogId.setEnabled(false);
        txtCustomerId.setEnabled(false);
        txtStaffId.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtAdoptionRecordId.setEnabled(false);
        txtDogId.setEnabled(true);
        txtCustomerId.setEnabled(true);
        txtStaffId.setEnabled(true);

    }

    public static void main(String[] args) {
        new UpdateAdoptionRecord().setGui();
    }
}
