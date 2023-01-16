package Alberto.MINIVENTANAS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton_2 extends JFrame {
    JLabel vacio;

    JButton b1;

    JButton b2;

    JButton b3;

    JButton b4;

    public Boton_2()  {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100, 250, 250);
        setVisible(true);
        setLayout(new BorderLayout());

        //North
        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());//no es necesario
      /*  north.setBackground(Color.black);*/
        addComponentsToNorth(north);

        //East
        JPanel east = new JPanel();
        east.setLayout(new FlowLayout());//no es necesario
       /* east.setBackground(Color.red);*/

        //West

        JPanel west = new JPanel();
        west.setLayout(new FlowLayout());//no es necesario
        /*west.setBackground(Color.green);*/

        //South
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());//no es necesario
       /* south.setBackground(Color.yellow);*/
        addComponentsToSouth(south);

        //Center
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());//no es necesario
   /*     center.setBackground(Color.blue);*/
        addComponentsToCenter(center);


        //AddingToBorderLayout
        this.add("South", south);
        this.add("West", west);
        this.add("Center", center);
        this.add("East", east);
        this.add("North", north);

    }

    public void addComponentsToNorth(Container north){
        JLabel titulo = new JLabel("BOTONES LISTENERS(II)");
        Font f = new Font("Arial",  1, 20);
        titulo.setFont(f);
        north.add(titulo);

    }


    public void addComponentsToSouth(Container south){
       vacio = new JLabel();
       south.add(vacio);
    }

    public void addComponentsToCenter(Container center){
        b1 = new JButton("Bici");
        b1.addActionListener(new MiListener());
        b2= new JButton("Coche");
        b2.addActionListener(new MiListener());
        b3= new JButton("Moto");
        b3.addActionListener(new MiListener());
        b4= new JButton("Avion");
        b4.addActionListener(new MiListener());

        Font f = new Font("Arial",  10, 12);

        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);

        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.add(b1);
        center.add(b2);
        center.add(b3);
        center.add(b4);
    }


    public static void main (String [] args){
        Boton_2 boton2 = new Boton_2();
    }

    public class MiListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if(source==b1){
                vacio.setText("Has pulsado en Bici");
            }else if(source==b2){
                vacio.setText("Has pusado en Coche");
            }else if(source==b3){
                vacio.setText("Has pusado en Moto");
            }else if(source==b4){
                vacio.setText("Has pusado en Avion");
            }
        }

    }
}
