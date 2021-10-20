package za.ac.cput.views.Veterinarian;
/*
    ReadVeterinarian.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 19 October 2021
 */
import za.ac.cput.client.VeterinarianHttpClient;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.views.VeterinarianMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadVeterinarian extends JFrame implements ActionListener {
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading, lblVetId, lblName, lblSurname, lblPhoneNumber, lblEmailAddress;
    private JLabel  lblName1, lblSurname1, lblPhoneNumber1, lblEmailAddress1;
    private JTextField txtVetId;
    private JButton btnRead, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8;


    public ReadVeterinarian() {

        super("Read Veterinarian Screen Version: 1.0 by @Nonhlahla");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read Veterinarian", SwingConstants.CENTER);
        lblVetId = new JLabel("Veterinarian ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Veterinarian Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Veterinarian Surname: ", SwingConstants.RIGHT);
        lblPhoneNumber = new JLabel("Phone Number: ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Email Address: ", SwingConstants.RIGHT);

        txtVetId = new JTextField();
        lblName1 = new JLabel(" ");
        lblSurname1 = new JLabel(" ");
        lblPhoneNumber1 = new JLabel(" ");
        lblEmailAddress1 = new JLabel(" ");

        btnRead = new JButton("Read");
        btnClear= new JButton("Clear");
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
    }
    public void setGui() {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(6, 3));
        southPanel.setLayout(new GridLayout(2, 3));

        //Set font
        lblHeading.setFont(ftHeading);
        lblVetId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);
        lblPhoneNumber.setFont(ftTextBold);
        lblEmailAddress.setFont(ftTextBold);
        txtVetId.setFont(ftText);
        lblName1.setFont(ftText);
        lblSurname1.setFont(ftText);
        lblPhoneNumber1.setFont(ftText);
        lblEmailAddress1.setFont(ftText);


        //Add components to panels
        northPanel.add(lblHeading);
        centerPanel.add(lblVetId);
        centerPanel.add(txtVetId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(lblName1);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(lblSurname1);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblPhoneNumber);
        centerPanel.add(lblPhoneNumber1);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblEmailAddress);
        centerPanel.add(lblEmailAddress1);
        centerPanel.add(emptySpace5);

        southPanel.add(emptySpace6);
        southPanel.add(emptySpace7);
        southPanel.add(emptySpace8);
        southPanel.add(btnRead);
        southPanel.add(btnClear);
        southPanel.add(btnExit);

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 420);
        this.setVisible(true);
        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            int vetId = Integer.parseInt(txtVetId.getText().trim().toString());

            if(vetId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{
                Veterinarian result = VeterinarianHttpClient.read(vetId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Veterinarian exist with ID of: " + vetId);

                    lblName1.setText(result.getName());
                    lblSurname1.setText(result.getSurname());
                    lblPhoneNumber1.setText(String.valueOf(result.getPhoneNumber()));
                    lblEmailAddress1.setText(result.getEmailAddress());

                }
                else {
                    JOptionPane.showMessageDialog(null, "No Veterinarian exists with ID of: " + vetId);
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtVetId.setText("");
            lblName1.setText("");
            lblSurname1.setText("");
            lblPhoneNumber1.setText("");
            lblEmailAddress1.setText("");
            txtVetId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new VeterinarianMenu().setGui();
            this.dispose();
        }
    }
    public static void main(String[] args) {
        new ReadVeterinarian().setGui();
    }
}


