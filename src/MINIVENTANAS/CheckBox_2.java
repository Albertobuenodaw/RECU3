package MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox_2 extends JFrame{
    JLabel vacio;

    JCheckBox b1;
    JCheckBox b2;
    JCheckBox b3;
    JCheckBox b4;

    JButton seleccionar;

    JPanel south;

    public CheckBox_2(){
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
        JLabel titulo = new JLabel("CHECKBOX LISTENERS (II)");
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
        b1.addActionListener(new MiListener());
        b2 = new JCheckBox("Coche");
        b2.addActionListener(new MiListener());
        b3 = new JCheckBox("Moto");
        b3.addActionListener(new MiListener());
        b4 = new JCheckBox("Avion");
        b4.addActionListener(new MiListener());


        center.add(b1);
        center.add(b2);
        center.add(b3);
        center.add(b4);

    }

    class MiListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JCheckBox source = (JCheckBox) actionEvent.getSource();
            if (source == b1){
                vacio.setText("Bici:  " + (source.isSelected()?"seleccionado":"no seleccionado"));
            }else if (source == b2){
                vacio.setText("Coche:  " + (source.isSelected()?"seleccionado":"no seleccionado"));
            }else if (source == b3){
                vacio.setText("Moto:  " + (source.isSelected()?"seleccionado":"no seleccionado"));
            }else if (source == b4){
                vacio.setText("Avion:  " + (source.isSelected()?"seleccionado":"no seleccionado"));
            }
        }
    }

    public static void main(String[] args) {
        CheckBox_2 b = new CheckBox_2();
    }



}

