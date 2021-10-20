package za.ac.cput.views.Veterinarian;

/*
    UpdateVeterinarian.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 19 October 2021
 */
import za.ac.cput.client.VeterinarianHttpClient;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.factory.VeterinarianFactory;
import za.ac.cput.views.VeterinarianMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateVeterinarian extends JFrame implements ActionListener {
    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading,lblVetId, lblName, lblSurname, lblPhoneNumber, lblEmailAddress;
    private  JTextField  txtVetId,txtName, txtSurname, txtPhoneNumber, txtEmailAddress;
    private JButton btnRead, btnUpdate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10;


    public UpdateVeterinarian () {

        super("Update Veterinarian Screen Version: 1.0 by @Nonhlahla");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Update Veterinarian", SwingConstants.CENTER);
        lblVetId = new JLabel("Veterinarian ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Veterinarian Name: ", SwingConstants.RIGHT);
        lblSurname = new JLabel("Veterinarian Surname: ", SwingConstants.RIGHT);
        lblPhoneNumber = new JLabel("Phone Number: ", SwingConstants.RIGHT);
        lblEmailAddress = new JLabel("Email Address: ", SwingConstants.RIGHT);


        txtVetId = new JTextField();
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtPhoneNumber = new JTextField();
        txtEmailAddress= new JTextField();

        btnRead = new JButton("Read");
        btnUpdate = new JButton("Update");
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
    }
    public void setGui() {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(5,3));
        southPanel.setLayout(new GridLayout(2,4));

        //Set font
        lblHeading.setFont(ftHeading);
        lblVetId.setFont(ftTextBold);
        lblName.setFont(ftTextBold);
        lblSurname.setFont(ftTextBold);
        lblPhoneNumber.setFont(ftTextBold);
        lblEmailAddress.setFont(ftTextBold);
        txtVetId.setFont(ftText);
        txtName.setFont(ftText);
        txtSurname.setFont(ftText);
        txtPhoneNumber.setFont(ftText);
        txtEmailAddress.setFont(ftText);

        //Add components to panels
        northPanel.add(lblHeading);
        centerPanel.add(lblVetId);
        centerPanel.add(txtVetId);
        centerPanel.add(emptySpace1);

        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(emptySpace2);

        centerPanel.add(lblSurname);
        centerPanel.add(txtSurname);
        centerPanel.add(emptySpace3);

        centerPanel.add(lblPhoneNumber);
        centerPanel.add(txtPhoneNumber);
        centerPanel.add(emptySpace4);

        centerPanel.add(lblEmailAddress);
        centerPanel.add(txtEmailAddress);
        centerPanel.add(emptySpace5);

        southPanel.add(emptySpace6);
        southPanel.add(emptySpace7);
        southPanel.add(emptySpace8);
        southPanel.add(emptySpace9);
        southPanel.add(btnRead);
        southPanel.add(btnUpdate);
        southPanel.add(btnClear);
        southPanel.add(btnExit);

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(640, 320);
        this.setVisible(true);
        //Add action listener to buttons | mouse listener to hyperlink
        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Read"))
        {
            int vetId = Integer.parseInt(txtVetId.getText().trim().toString());

            if(vetId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                Veterinarian oldVeterinarian = VeterinarianHttpClient.read(vetId);

                if(oldVeterinarian != null)
                {
                    JOptionPane.showMessageDialog(null, "Veterinarian exist with ID of: " + vetId);

                    txtName.setText(oldVeterinarian.getName());
                    txtSurname.setText(String.valueOf(oldVeterinarian.getSurname()));
                    txtPhoneNumber.setText(String.valueOf("0" + oldVeterinarian.getPhoneNumber()));
                    txtEmailAddress.setText(oldVeterinarian.getEmailAddress());


                    setTextFieldToEditable(); //Set all fields to editable
                    txtVetId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No Veterinarian exists with ID of: " + vetId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int vetId = Integer.parseInt(txtVetId.getText().trim().toString());
            String name = txtName.getText().trim().toString();
            String surname = txtSurname.getText().trim().toString();
            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText().trim().toString());
            String emailAddress = txtEmailAddress.getText().trim().toString();

            if(name.isEmpty() || surname.isEmpty() ||phoneNumber < 0 || emailAddress.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a new Veterinarian.");
            }
            else {

                Veterinarian updateVeterinarian = VeterinarianFactory.updateVeterinarian(vetId, name, surname,phoneNumber, emailAddress );

                Veterinarian result = VeterinarianHttpClient.update(updateVeterinarian);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated your profile.");

                    txtVetId.setText("");
                    txtName.setText("");
                    txtSurname.setText("");
                    txtPhoneNumber.setText("");
                    txtEmailAddress.setText("");


                    txtVetId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating your profile.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtVetId.setText("");
            txtName.setText("");
            txtSurname.setText("");
            txtPhoneNumber.setText("");
            txtEmailAddress.setText("");

            txtVetId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new VeterinarianMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtVetId.setEnabled(true);
        txtName.setEnabled(false);
        txtSurname.setEnabled(false);
        txtPhoneNumber.setEnabled(false);
        txtEmailAddress.setEnabled(false);

    }

    public void setTextFieldToEditable()
    {
        txtVetId.setEnabled(false);
        txtName.setEnabled(true);
        txtSurname.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
        txtEmailAddress.setEnabled(true);

    }

    public static void main(String[] args) {
        new UpdateVeterinarian().setGui();
    }
}

