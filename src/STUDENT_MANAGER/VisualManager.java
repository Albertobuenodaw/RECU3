package STUDENT_MANAGER;

import MINIVENTANAS.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualManager extends JFrame implements ActionListener {
    //Manager
    StudentManager manager = new StudentManager();

    //East Components
    JTextField idField;
    JTextField nameField;
    JTextField cityField;
    JTextField phoneField;
    JTextField birthdateField;
    //Fin east components

    //South components
    DefaultComboBoxModel model;
    JComboBox combo;

    JButton search;
    JButton insert;
    JButton modify;
    JButton delete;

    JLabel empty;

    ArrayList<Degree> degreeList;
    //Fin south components
    public VisualManager(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBounds(10,10,450,350);
        this.setTitle("Student Manager");
        this.setVisible(true);

        //NorthPanel
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        //north.setBackground(Color.blue);
        addComponentsToNorth(north);
        this.add("North", north);
        //End northPanel

        //WestPanel
        JPanel west = new JPanel();
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        //west.setBackground(Color.red);
        west.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        addComponentsToWest(west);
        this.add("West", west);
        //End westPanel

        //EastPanel
        JPanel east = new JPanel();
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        //east.setBackground(Color.green);
        east.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        addComponentsToEast(east);
        this.add("East", east);
        //End eastPanel

        //southPanel
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        //south.setBackground(Color.yellow);
        addComponentsToSouth(south);
        this.add("South", south);
        //End southPanel
    }

    private void addComponentsToNorth(Container north){
        JLabel title = new JLabel("STUDENTS MANAGER");
        Font f = new Font("Arial", 20,20);
        title.setFont(f);
        north.add(title);
    }

    private void addComponentsToWest(Container west){
        JLabel idLabel = new JLabel("ID: ");
        JLabel nameLabel = new JLabel("Name: ");
        JLabel cityLabel = new JLabel("City: ");
        JLabel phoneLabel = new JLabel("Phone: ");
        JLabel birthdateLabel = new JLabel("Birthdate: ");
        west.add(idLabel);
        west.add(nameLabel);
        west.add(cityLabel);
        west.add(phoneLabel);
        west.add(birthdateLabel);
    }

    private void addComponentsToEast(Container east){
        idField = new JTextField();
        idField.setMaximumSize(new Dimension(220,20));
        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(220,20));
        cityField = new JTextField();
        cityField.setMaximumSize(new Dimension(220,20));
        phoneField = new JTextField();
        phoneField.setMaximumSize(new Dimension(220,20));
        birthdateField = new JTextField();
        birthdateField.setPreferredSize(new Dimension(220,20));
        //birthdateField.setMaximumSize(new Dimension(220,20));
        east.add(idField);
        east.add(nameField);
        east.add(cityField);
        east.add(phoneField);
        east.add(birthdateField);
    }

    private void addComponentsToSouth(Container south){
        //Top
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        //top.setBackground(Color.blue);
        JLabel degreeL = new JLabel("Degree: ");
        top.add(degreeL);

        degreeList = manager.allDegrees();
        model = new DefaultComboBoxModel();
        combo = new JComboBox(model);
        for (int i = 0; i <degreeList.size();i++){
            model.addElement(degreeList.get(i).getTitle());
        }
        top.add(combo);
        south.add(top);
        //Fin top

        //Middle
        JPanel middle = new JPanel();
        middle.setLayout(new FlowLayout());
        //middle.setBackground(Color.yellow);
        search = new JButton("Search");
        search.addActionListener(this);
        insert = new JButton("Insert");
        insert.addActionListener(this);
        modify = new JButton("Modify");
        delete = new JButton("Delete");
        middle.add(search);
        middle.add(insert);
        middle.add(modify);
        middle.add(delete);
        south.add(middle);
        //Fin middle

        //Bottom
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        //bottom.setBackground(Color.red);
        empty = new JLabel("Esto está vacío");
        bottom.add(empty);
        south.add(bottom);
        //Fin bottom
    }

    public static void main(String[] args) {
        VisualManager manager = new VisualManager();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == search){
            empty.setText("Search activado");
            Student s = manager.searchStudent(idField.getText());
            nameField.setText(s.getName());
            cityField.setText(s.getCity());
            phoneField.setText(s.getTelephone());
            birthdateField.setText(String.valueOf(s.getFechaNacmto()));
            //model.setSelectedItem();
        }else if(source == insert){
            empty.setText("Insert activado");
            Student s = new Student(idField.getText(),nameField.getText(), cityField.getText(), phoneField.getText(), birthdateField.getText(),manager.searchDegree(combo.getSelectedIndex()));
            manager.insertStudent(s);
        }
    }
}
