package Inaki.MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton_2 extends JFrame{
    private JLabel vacio;

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;

    JPanel south;

    public Boton_2(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,250,250);
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
        south = new JPanel();
        south.setLayout(new FlowLayout());
        //south.setBackground(Color.red);
        addComponentsToSouth(south);
        this.add("South", south);
        //EndSouth
    }

    private void addComponentsToNorth(Container north){
        JLabel titulo = new JLabel("BOTONES LISTENERS (II)");
        Font f = new Font("Arial", 20,20);
        titulo.setFont(f);
        north.add(titulo);
    }

    private void addComponentsToSouth(Container south){
        vacio = new JLabel();
        south.add(vacio);
    }


    private void addComponentsToCenter(Container center){
        b1 = new JButton("Bici");
        b1.addActionListener(new MiListener());
        b2 = new JButton("Coche");
        b2.addActionListener(new MiListener());
        b3 = new JButton("Moto");
        b3.addActionListener(new MiListener());
        b4 = new JButton("Avión");
        b4.addActionListener(new MiListener());

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
                vacio.setText("Has elegido la bici");
            }else if (source == b2) {
                vacio.setText("Has elegido el coche");
            }else if (source == b3) {
                vacio.setText("Has elegido la moto");
            }else if (source == b4) {
                vacio.setText("Has elegido el avion");
            }
        }
    }

    public static void main(String[] args) {
        Boton_2 b = new Boton_2();
    }


}
