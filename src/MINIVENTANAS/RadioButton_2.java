package MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton_2 extends JFrame{
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JRadioButton b4;

    JLabel vacio;

    public RadioButton_2(){
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
        JLabel titulo = new JLabel("RADIOBOTONES LISTENERS (II)");
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
        b1.addActionListener(new MiListener());
        b2 = new JRadioButton("Coche");
        b2.addActionListener(new MiListener());
        b3 = new JRadioButton("Moto");
        b3.addActionListener(new MiListener());
        b4 = new JRadioButton("Avión");
        b4.addActionListener(new MiListener());

        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);

        center.add(b1);
        center.add(b2);
        center.add(b3);
        center.add(b4);
    }

    class MiListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Object source = actionEvent.getSource();
            if (source == b1){
                vacio.setText("Has elegido la bici!");
            }else if (source == b2){
                vacio.setText("Has elegido el coche!");
            }else if (source == b3){
                vacio.setText("Has elegido la moto!");
            }else if (source == b4){
                vacio.setText("Has elegido el avión!");
            }
        }
    }

    public static void main(String[] args) {
        RadioButton_2 b = new RadioButton_2();
    }


}



