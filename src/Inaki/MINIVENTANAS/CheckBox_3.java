package Inaki.MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox_3 extends JFrame implements ActionListener {
    JLabel vacio;

    JCheckBox b1;
    JCheckBox b2;
    JCheckBox b3;
    JCheckBox b4;

    JButton seleccionar;

    JPanel south;

    public CheckBox_3(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,260,250);
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
        JLabel titulo = new JLabel("CHECKBOX LISTENERS (III)");
        Font f = new Font("Arial", 20,20);
        titulo.setFont(f);
        north.add(titulo);
    }

    private void addComponentsToSouth(Container south){
        vacio = new JLabel();
        south.add(vacio);
    }

    private void addComponentsToCenter(Container center){
        b1 = new JCheckBox("Bici");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBox source = (JCheckBox) actionEvent.getSource();
                vacio.setText("Bici:  " + (source.isSelected()?"seleccionado" : "no seleccionado"));
            }
        });
        b2 = new JCheckBox("Coche");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBox source = (JCheckBox) actionEvent.getSource();
                vacio.setText("Coche:  " + (source.isSelected()?"seleccionado" : "no seleccionado"));
            }
        });
        b3 = new JCheckBox("Moto");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBox source = (JCheckBox) actionEvent.getSource();
                vacio.setText("Moto:  " + (source.isSelected()?"seleccionado" : "no seleccionado"));
            }
        });
        b4 = new JCheckBox("Avion");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JCheckBox source = (JCheckBox) actionEvent.getSource();
                vacio.setText("Avion:  " + (source.isSelected()?"seleccionado" : "no seleccionado"));
            }
        });


        center.add(b1);
        center.add(b2);
        center.add(b3);
        center.add(b4);

    }

    public static void main(String[] args) {
        CheckBox_3 b = new CheckBox_3();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

}

