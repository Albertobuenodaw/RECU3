package Inaki.MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox_2 extends JFrame{
    JLabel vacio;

    JComboBox combo;

    JPanel south;

    public ComboBox_2(){
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
        center.setLayout(new FlowLayout());
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
        JLabel titulo = new JLabel("COMBO LISTENERS (II)");
        Font f = new Font("Arial", 20,20);
        titulo.setFont(f);
        north.add(titulo);
    }

    private void addComponentsToSouth(Container south){
        vacio = new JLabel();
        south.add(vacio);
    }

    private void addComponentsToCenter(Container center){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        combo = new JComboBox(model);
        model.addElement("Bici");
        model.addElement("Coche");
        model.addElement("Moto");
        model.addElement("Avión");

        combo.addActionListener(new MiListener());

        center.add(combo);
    }

    class MiListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JComboBox source = (JComboBox) actionEvent.getSource();
            vacio.setText(combo.getSelectedItem().toString());
        }
    }

    public static void main(String[] args) {
        ComboBox_2 b = new ComboBox_2();
    }



}
