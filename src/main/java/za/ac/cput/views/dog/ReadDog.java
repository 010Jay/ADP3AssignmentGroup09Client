package za.ac.cput.views.dog;

import za.ac.cput.client.DogHttpClient;
import za.ac.cput.entity.Dog;
import za.ac.cput.factory.DogFactory;
import za.ac.cput.views.DogMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadDog extends JFrame implements ActionListener {

    //Attributes
    private JPanel northPanel, centerPanel, southPanel, radioPanel;
    private JLabel lblHeading, lblDogId, lblName, lblAge, lblColor, lblIsPuppy, lblGender, lblBreed, lblVetId, lblVaccinationStatus;
    private JLabel lblName1, lblAge1, lblColor1, lblIsPuppy1, lblGender1, lblBreed1, lblVetId1, lblVaccinationStatus1;
    private JTextField txtDogId;
    private JButton btnRead, btnClear, btnExit;
    private Font ftHeading, ftText, ftTextBold;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12;

    public ReadDog()
    {
        super("Read Dog Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("Read Dog", SwingConstants.CENTER);
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
        lblName1 = new JLabel("");
        lblAge1 = new JLabel("");
        lblColor1 = new JLabel("");
        lblIsPuppy1 = new JLabel("");
        lblGender1 = new JLabel("");
        lblBreed1 = new JLabel("");
        lblVetId1 = new JLabel("");
        lblVaccinationStatus1 = new JLabel("");

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
            centerPanel.setLayout(new GridLayout(9,3));
            southPanel.setLayout(new GridLayout(2,3));

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
            btnRead.setFont(ftTextBold);
            btnExit.setFont(ftTextBold);

            txtDogId.setFont(ftText);
            lblName1.setFont(ftText);
            lblAge1.setFont(ftText);
            lblColor1.setFont(ftText);
            lblIsPuppy1.setFont(ftText);
            lblGender1.setFont(ftText);
            lblBreed1.setFont(ftText);
            lblVetId1.setFont(ftText);
            lblVaccinationStatus1.setFont(ftText);

        //Add components to panels
            northPanel.add(lblHeading);
            //northPanel.setBackground(Color.decode("#4863A0"));

            centerPanel.add(lblDogId);
            centerPanel.add(txtDogId);
            centerPanel.add(emptySpace1);

            centerPanel.add(lblName);
            centerPanel.add(lblName1);
            centerPanel.add(emptySpace2);

            centerPanel.add(lblAge);
            centerPanel.add(lblAge1);
            centerPanel.add(emptySpace3);

            centerPanel.add(lblColor);
            centerPanel.add(lblColor1);
            centerPanel.add(emptySpace4);

            centerPanel.add(lblIsPuppy);
            centerPanel.add(lblIsPuppy1);
            centerPanel.add(emptySpace5);

            centerPanel.add(lblGender);
            centerPanel.add(lblGender1);
            centerPanel.add(emptySpace6);

            centerPanel.add(lblBreed);
            centerPanel.add(lblBreed1);
            centerPanel.add(emptySpace7);

            centerPanel.add(lblVetId);
            centerPanel.add(lblVetId1);
            centerPanel.add(emptySpace8);

            centerPanel.add(lblVaccinationStatus);
            centerPanel.add(lblVaccinationStatus1);
            centerPanel.add(emptySpace9);
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
                Dog result = DogHttpClient.read(dogId);

                if(result != null)
                {
                    JOptionPane.showMessageDialog(null, "Dog exist with ID of: " + dogId);

                    lblName1.setText(result.getName());
                    lblAge1.setText(String.valueOf(result.getAge()));
                    lblColor1.setText(result.getColor());
                    lblIsPuppy1.setText(String.valueOf(result.isPuppy()));
                    lblGender1.setText(String.valueOf(result.getGender()));
                    lblBreed1.setText(result.getBreed());
                    lblVetId1.setText(String.valueOf(result.getVetId()));
                    lblVaccinationStatus1.setText(result.getVaccinationStatus());
                }
                else {
                    JOptionPane.showMessageDialog(null, "No dog exists with ID of: " + dogId);
                }
            }
        }
        else if(e.getActionCommand().equals("Clear"))
        {
            txtDogId.setText("");
            lblName1.setText("");
            lblAge1.setText("");
            lblColor1.setText("");
            lblIsPuppy1.setText("");
            lblGender1.setText("");
            lblBreed1.setText("");
            lblVetId1.setText("");
            lblVaccinationStatus1.setText("");

            txtDogId.requestFocus();
        }
        else if(e.getActionCommand().equals("Exit"))
        {
            new DogMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new ReadDog().setGui();
    }
}
