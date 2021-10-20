package za.ac.cput.views.adoptionRecord;

import za.ac.cput.client.AdoptionRecordHttpClient;
import za.ac.cput.entity.AdoptionRecord;
import za.ac.cput.factory.AdoptionRecordFactory;
import za.ac.cput.views.AdoptionRecordMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadAdoptionRecord extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblAdoptionRecordId, lblDogId, lblCustomerId, lblStaffId, lblDate;
    private JLabel lblDogId1, lblCustomerId1, lblStaffId1, lblDate1;
    private JTextField txtAdoptionRecordId;
    private JButton btnRead, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12;

    public ReadAdoptionRecord()
    {
        super("Read Adoption Record Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read Adoption Record", SwingConstants.CENTER);
        lblAdoptionRecordId = new JLabel("Adoption Record ID: ", SwingConstants.RIGHT);
        lblDogId = new JLabel("Dog ID: ", SwingConstants.RIGHT);
        lblCustomerId = new JLabel("Customer ID: ", SwingConstants.RIGHT);
        lblStaffId = new JLabel("Staff ID: ", SwingConstants.RIGHT);
        lblDate = new JLabel("Date: ", SwingConstants.RIGHT);

        txtAdoptionRecordId = new JTextField();
        lblDogId1 = new JLabel("");
        lblCustomerId1 = new JLabel("");
        lblStaffId1 = new JLabel("");
        lblDate1 = new JLabel("");

        btnRead = new JButton("Read");
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
    }

    public void setGui()
    {
        //Add Gridlayout to panels
            northPanel.setLayout(new FlowLayout());
            centerPanel.setLayout(new GridLayout(7,3));
            southPanel.setLayout(new GridLayout(2,3));

        //Set font
            lblHeading.setFont(ftHeading);
            //lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblAdoptionRecordId.setFont(ftTextBold);
            lblDogId.setFont(ftTextBold);
            lblCustomerId.setFont(ftTextBold);
            lblStaffId.setFont(ftTextBold);
            lblDate.setFont(ftTextBold);
            btnRead.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            txtAdoptionRecordId.setFont(ftText);
            lblDogId1.setFont(ftText);
            lblCustomerId1.setFont(ftText);
            lblStaffId1.setFont(ftText);
            lblDate1.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            //northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(lblAdoptionRecordId);
            centerPanel.add(txtAdoptionRecordId);
            centerPanel.add(emptySpace1);

            centerPanel.add(lblDogId);
            centerPanel.add(lblDogId1);
            centerPanel.add(emptySpace2);

            centerPanel.add(lblCustomerId);
            centerPanel.add(lblCustomerId1);
            centerPanel.add(emptySpace3);

            centerPanel.add(lblStaffId);
            centerPanel.add(lblStaffId1);
            centerPanel.add(emptySpace4);

            centerPanel.add(lblDate);
            centerPanel.add(lblDate1);
            centerPanel.add(emptySpace5);

            //centerPanel.setBackground(Color.decode("#CECECE"));

            southPanel.add(emptySpace10);
            southPanel.add(emptySpace11);
            southPanel.add(emptySpace12);
            southPanel.add(btnRead);
            southPanel.add(btnClear);
            southPanel.add(btnExit);
            //southPanel.setBackground(Color.decode("#CECECE"));

        //Add panels to frame
            this.add(northPanel, BorderLayout.NORTH);
            this.add(centerPanel, BorderLayout.CENTER);
            this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
            btnRead.addActionListener(this);
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
                AdoptionRecord result = AdoptionRecordHttpClient.read(adoptionRecordId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Adoption Record exist with ID of: " + adoptionRecordId);

                    lblDogId1.setText(String.valueOf(result.getDogId()));
                    lblCustomerId1.setText(String.valueOf(result.getCustomerId()));
                    lblStaffId1.setText(String.valueOf(result.getStaffId()));
                    lblDate1.setText(String.valueOf(result.getDate()));

                }
                else {
                    JOptionPane.showMessageDialog(null, "No record exists with ID of: " + adoptionRecordId);
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtAdoptionRecordId.setText("");
            lblDogId1.setText("");
            lblCustomerId1.setText("");
            lblStaffId1.setText("");
            lblDate1.setText("");

            txtAdoptionRecordId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new AdoptionRecordMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new ReadAdoptionRecord().setGui();
    }
}
