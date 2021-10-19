package za.ac.cput.views.dog;

import za.ac.cput.client.DogHttpClient;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.DogFactory;
import za.ac.cput.views.DogMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDog extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblDogId, lblName, lblAge, lblColor, lblIsPuppy, lblGender, lblBreed, lblVetId, lblVaccinationStatus;
    private  JTextField  txtDogId, txtName, txtAge, txtColor, txtBreed, txtVetId, txtVaccinationStatus;
    private JRadioButton btnYes, btnNo;
    private ButtonGroup groupIsPuppy;
    private JComboBox cmbGender;
    private String[] cmbData = {"Choose...", "Male", "Female"};
    private JButton btnRead, btnCreate, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;

    public UpdateDog()
    {
        super("Update Dog Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        radioPanel = new JPanel();

        lblHeading = new JLabel("Update Dog", SwingConstants.CENTER);
        lblDogId = new JLabel("Dog ID: ", SwingConstants.RIGHT);
        lblName = new JLabel("Name: ", SwingConstants.RIGHT);
        lblAge = new JLabel("Age: ", SwingConstants.RIGHT);
        lblColor = new JLabel("Color: ", SwingConstants.RIGHT);
        lblIsPuppy = new JLabel("Is Puppy: ", SwingConstants.RIGHT);
        lblGender = new JLabel("Gender: ", SwingConstants.RIGHT);
        lblBreed = new JLabel("Breed: ", SwingConstants.RIGHT);
        lblVetId = new JLabel("Vet ID: ", SwingConstants.RIGHT);
        lblVaccinationStatus = new JLabel("Vaccination Status: ", SwingConstants.RIGHT);

        txtDogId = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtColor = new JTextField();
        btnYes = new JRadioButton("True", true);
        btnNo = new JRadioButton("False", false);
        groupIsPuppy = new ButtonGroup();
        cmbGender = new JComboBox(cmbData);
        txtBreed = new JTextField();
        txtVetId = new JTextField();
        txtVaccinationStatus = new JTextField();

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
            centerPanel.setLayout(new GridLayout(9,3));
            southPanel.setLayout(new GridLayout(2,4));
            radioPanel.setLayout(new GridLayout(1,2));

        //Set font
            lblHeading.setFont(ftHeading);
            //lblHeading.setForeground(Color.decode("#FFFFFF"));

            lblDogId.setFont(ftTextBold);
            lblName.setFont(ftTextBold);
            lblAge.setFont(ftTextBold);
            lblColor.setFont(ftTextBold);
            lblIsPuppy.setFont(ftTextBold);
            lblGender.setFont(ftTextBold);
            lblBreed.setFont(ftTextBold);
            lblVetId.setFont(ftTextBold);
            lblVaccinationStatus.setFont(ftTextBold);
            btnCreate.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            txtDogId.setFont(ftText);
            txtName.setFont(ftText);
            txtAge.setFont(ftText);
            txtColor.setFont(ftText);
            btnYes.setFont(ftText);
            btnNo.setFont(ftText);
            cmbGender.setFont(ftText);
            txtBreed.setFont(ftText);
            txtVetId.setFont(ftText);
            txtVaccinationStatus.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            //northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(lblDogId);
            centerPanel.add(txtDogId);
            centerPanel.add(emptySpace1);

            centerPanel.add(lblName);
            centerPanel.add(txtName);
            centerPanel.add(emptySpace2);

            centerPanel.add(lblAge);
            centerPanel.add(txtAge);
            centerPanel.add(emptySpace3);

            centerPanel.add(lblColor);
            centerPanel.add(txtColor);
            centerPanel.add(emptySpace4);

            groupIsPuppy.add(btnYes);
            groupIsPuppy.add(btnNo);
            radioPanel.add(btnYes);
            radioPanel.add(btnNo);
            centerPanel.add(lblIsPuppy);
            centerPanel.add(radioPanel);
            centerPanel.add(emptySpace5);

            centerPanel.add(lblGender);
            centerPanel.add(cmbGender);
            centerPanel.add(emptySpace6);

            centerPanel.add(lblBreed);
            centerPanel.add(txtBreed);
            centerPanel.add(emptySpace7);

            centerPanel.add(lblVetId);
            centerPanel.add(txtVetId);
            centerPanel.add(emptySpace8);

            centerPanel.add(lblVaccinationStatus);
            centerPanel.add(txtVaccinationStatus);
            centerPanel.add(emptySpace9);
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
            int dogId = Integer.parseInt(txtDogId.getText().trim().toString());

            if(dogId < 0)
            {
                JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
            }
            else{

                Dog oldDog = DogHttpClient.read(dogId);

                if(oldDog != null)
                {
                    JOptionPane.showMessageDialog(null, "Dog exist with ID of: " + dogId);

                    txtName.setText(oldDog.getName());
                    txtAge.setText(String.valueOf(oldDog.getAge()));
                    txtColor.setText(oldDog.getColor());

                    if(oldDog.isPuppy() == true)
                    {
                        btnYes.setSelected(true);
                        btnNo.setSelected(false);
                    }
                    else {
                        btnYes.setSelected(false);
                        btnNo.setSelected(true);
                    }


                    if(oldDog.getGender() == 'M')
                    {
                        cmbGender.setSelectedItem(1);
                    }
                    else {
                        cmbGender.setSelectedItem(2);
                    }

                    txtBreed.setText(oldDog.getBreed());
                    txtVetId.setText(String.valueOf(oldDog.getVetId()));
                    txtVaccinationStatus.setText(oldDog.getVaccinationStatus());

                    setTextFieldToEditable(); //Set all fields to editable
                    txtDogId.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "No dog exists with ID of: " + dogId);
                }
            }
        }
        else if(e.getActionCommand().equals("Update"))
        {
            int dogId = Integer.parseInt(txtDogId.getText().trim().toString());
            String name = txtName.getText().trim().toString();
            int age = Integer.parseInt(txtAge.getText().trim().toString());
            String color = txtColor.getText().trim().toString();
            boolean isPuppy = Boolean.parseBoolean(groupIsPuppy.getSelection().getActionCommand());

            char gender;
            if(cmbGender.getSelectedItem().equals("Male"))
            {
                gender = 'M';
            }
            else{
                gender = 'F';
            }

            String breed = txtBreed.getText().trim().toString();
            int vetId = Integer.parseInt(txtVetId.getText().trim().toString());
            String vaccinationStatus = txtVaccinationStatus.getText().trim().toString();

            if(name.isEmpty() || age < 0 || color.isEmpty() || cmbGender.getSelectedItem().equals("Choose...") || breed.isEmpty() || vetId < 0 || vaccinationStatus.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill in all information to create a dog.");
            }
            else {
                Dog updateDog = DogFactory.updateDog(dogId, name, age, color, isPuppy, gender, breed, vetId, vaccinationStatus);

                Dog result = DogHttpClient.update(updateDog);

                if (result != null) {
                    JOptionPane.showMessageDialog(null, "You have successfully updated a dog.");

                    txtDogId.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    txtColor.setText("");
                    btnYes.setSelected(true);
                    btnNo.setSelected(false);
                    cmbGender.setSelectedItem(0);
                    txtBreed.setText("");
                    txtVetId.setText("");
                    txtVaccinationStatus.setText("");

                    txtDogId.requestFocus();
                    setTextFieldToUneditable();
                } else {
                    JOptionPane.showMessageDialog(null, "There was an error updating the dog.");
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtDogId.setText("");
            txtName.setText("");
            txtAge.setText("");
            txtColor.setText("");
            btnYes.setSelected(true);
            btnNo.setSelected(false);
            cmbGender.setSelectedItem(0);
            txtBreed.setText("");
            txtVetId.setText("");
            txtVaccinationStatus.setText("");

            txtDogId.requestFocus();
            setTextFieldToUneditable();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new DogMenu().setGui();
            this.dispose();
        }
    }

    public void setTextFieldToUneditable()
    {
        txtDogId.setEnabled(true);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        txtColor.setEnabled(false);
        btnYes.setEnabled(false);
        btnNo.setEnabled(false);
        cmbGender.setEditable(false);
        txtBreed.setEnabled(false);
        txtVetId.setEnabled(false);
        txtVaccinationStatus.setEnabled(false);
    }

    public void setTextFieldToEditable()
    {
        txtDogId.setEnabled(false);
        txtName.setEnabled(true);
        txtAge.setEnabled(true);
        txtColor.setEnabled(true);
        btnYes.setEnabled(true);
        btnNo.setEnabled(true);
        cmbGender.setEditable(true);
        txtBreed.setEnabled(true);
        txtVetId.setEnabled(true);
        txtVaccinationStatus.setEnabled(true);
    }

    public static void main(String[] args) {
        new UpdateDog().setGui();
    }
}
