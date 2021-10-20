package za.ac.cput.views.Veterinarian;
/*
    GetAllVeterinarian.java
    Author: Nonhlahla Hlungwani (218160658)
    Date: 19 October 2021
 */
import za.ac.cput.client.VeterinarianHttpClient;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.views.VeterinarianMenu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class GetAllVeterinarian extends JFrame implements ActionListener {

    private JPanel northPanel, centerPanel, southPanel;
    private JLabel lblHeading;
    private Font ftHeading, ftText, ftTextBold;
    private JButton btnExit;
    private JLabel emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7, emptySpace8, emptySpace9, emptySpace10, emptySpace11, emptySpace12, emptySpace13, emptySpace14;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane sPane;
    String[] columnVetAttributes = {"Veterinarian ID", "Veterinarian Name", "Veterinarian Surname","Phone Number", "Email Address"};
    Veterinarian[] vetList = new Veterinarian[columnVetAttributes.length];

    private Set<Veterinarian> veterinarianSet;

    public GetAllVeterinarian()
    {
        super("Get All Veterinarian Screen version: 1.0 by @Group 09");

        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();

        lblHeading = new JLabel("All Veterinarian", SwingConstants.CENTER);

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

        //Add table data and columns to table
        table = new JTable();
        model = (DefaultTableModel) table.getModel();


        veterinarianSet = VeterinarianHttpClient.getAll();

        //Add column names to the table
        for (String column : columnVetAttributes)
        {
            model.addColumn(column);
        }

        //Add the rows to the table
        vetList = VeterinarianHttpClient.rows();

        Object[] rows = new Object[columnVetAttributes.length];

        for(int i = 0; i < vetList.length; i++) //Create object array to add each row of data to the table
        {
            for(int a = 0; a < vetList.length - 1; a++) {
                rows[a] = vetList[i].getVetId();
                rows[++a] = vetList[i].getName();
                rows[++a] = vetList[i].getSurname();
                rows[++a] = vetList[i].getPhoneNumber();
                rows[++a] = vetList[i].getEmailAddress();
                model.addRow(rows);
            }
        }

        //Set column width
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(400);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);

        //Add table to scroll pane
        sPane = new JScrollPane(table);
    }

    public void setGui()
    {
        //Add Gridlayout to panels
        northPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(1,1));
        southPanel.setLayout(new GridLayout(2,3));

        //Set font
        lblHeading.setFont(ftHeading);
        btnExit.setFont(ftTextBold);

        //Add components to panels
        northPanel.add(lblHeading);

        centerPanel.add(sPane);

        southPanel.add(emptySpace10);
        southPanel.add(emptySpace11);
        southPanel.add(emptySpace12);
        southPanel.add(emptySpace13);
        southPanel.add(btnExit);
        southPanel.add(emptySpace14);

        //Add panels to frame
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        //Add action listener to buttons | mouse listener to hyperlink
        btnExit.addActionListener(this);

        //Frame
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(860, 440);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit"))
        {
            new VeterinarianMenu().setGui();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new GetAllVeterinarian().setGui();
    }
}

