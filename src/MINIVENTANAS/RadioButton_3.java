package MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton_3 extends JFrame implements ActionListener {
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JRadioButton b4;

    JLabel vacio;

    public RadioButton_3(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,300,250);
        setVisible(true);
        setLayout(new BorderLayout());

        //North
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        //north.setBackground(Color.blue);
        addComponentsToNorth(north);
        this.add("North", north);
        //End north

        //Center
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        //center.setBackground(Color.black);
        addComponentsToCenter(center);
        this.add("Center", center);
        //EndCenter

        //South
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        //south.setBackground(Color.red);
        addComponentsToSouth(south);
        this.add("South", south);
        //EndSouth
    }

    private void addComponentsToNorth(Container north){
        JLabel titulo = new JLabel("RADIOBOTONES LISTENERS (III)");
        Font f = new Font("Arial", 20,20);
        titulo.setFont(f);
        north.add(titulo);
    }

    private void addComponentsToSouth(Container south){
        vacio = new JLabel();
        south.add(vacio);
    }

    private void addComponentsToCenter(Container center){
        ButtonGroup group = new ButtonGroup();
        b1 = new JRadioButton("Bici");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vacio.setText("Has elegido la bicicleta");
            }
        });
        b2 = new JRadioButton("Coche");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vacio.setText("Has elegido el coxe");
            }
        });
        b3 = new JRadioButton("Moto");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vacio.setText("Has elegido la motocicleta");
            }
        });
        b4 = new JRadioButton("Avión");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                vacio.setText("Has elegido la avioneta");
            }
        });

        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);

        center.add(b1);
        center.add(b2);
        center.add(b3);
        center.add(b4);
    }

    public static void main(String[] args) {
        RadioButton_3 b = new RadioButton_3();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}

