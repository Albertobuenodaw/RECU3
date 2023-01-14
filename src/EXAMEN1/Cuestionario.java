package Examen;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Cuestionario extends JFrame implements ActionListener {
    GestorBD manager = new GestorBD();

    //NorthComponents
    List<JCheckBox> checkBoxes;
    JButton jugar;
    //Fin northComponents

    DefaultListModel<Pregunta> model;
    JList list;

    JTextArea text;

    JTextField fieldRespuestaCorrecta;

    private int correcta;
    private Pregunta pregunta;

    JLabel puntuacion3;
    JLabel puntuacion2;
    JLabel puntuacion1;

    public Cuestionario(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBounds(10,10,500,300);
        setTitle("TEST");
        setVisible(true);

        //NorthPanel
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.setBackground(Color.blue);
        addComponentsToNorth(north);
        this.add("North", north);
        //Fin north

        //CenterPanel
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        center.setBackground(Color.red);
        addComponentsToCenter(center);
        this.add("Center", center);
        //Fin center

        //EastPanel
        JPanel east = new JPanel();
        east.setLayout(new GridLayout(2,1));
        //east.setBackground(Color.green);
        east.setBorder(BorderFactory.createEmptyBorder(0,10,5,0));
        addComponentsToEast(east);
        this.add("East", east);
        //Fin east

        //SouthPanel
        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
        //south.setBackground(Color.black);
        addComponentsToSouth(south);
        this.add("South", south);
        //Fin east
    }

    private void addComponentsToNorth(Container north) {
        //Top panel
        JPanel top = new JPanel();
        //top.setBackground(Color.pink);
        top.setLayout(new FlowLayout());
        JLabel eligeTemas = new JLabel("Elige temas");
        top.add(eligeTemas);
        north.add(top);
        //Fin top panel

        //Middle panel
        JPanel middle = new JPanel();
        //middle.setBackground(Color.cyan);
        List<String> nombres = manager.todasCategorias();
        checkBoxes = new ArrayList<JCheckBox>();
        for (int i = 0; i < nombres.size();i++){
            checkBoxes.add(new JCheckBox(nombres.get(i).toString()));
            middle.add(checkBoxes.get(i));
        }
        north.add(middle);
        //Fin middle panel

        //Bottom panel
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        jugar = new JButton("JUGAR");
        bottom.add(jugar);
        jugar.addActionListener(this);
        north.add(bottom);
        //Fin bottom panel
    }

    private void addComponentsToSouth(Container south){
        JLabel respuestaCorrecta = new JLabel("Nº respuesta correcta: ");
        fieldRespuestaCorrecta = new JTextField();
        fieldRespuestaCorrecta.setMaximumSize(new Dimension(200,20));
        puntuacion1 = new JLabel("0");
        puntuacion2 = new JLabel("/");
        puntuacion3 = new JLabel("0");
        south.add(respuestaCorrecta);
        south.add(fieldRespuestaCorrecta);
        south.add(puntuacion1);
        south.add(puntuacion2);
        south.add(puntuacion3);

        fieldRespuestaCorrecta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(fieldRespuestaCorrecta.getText().toString());
                if (Integer.parseInt(fieldRespuestaCorrecta.getText().toString()) > 4 ||
                        Integer.parseInt(fieldRespuestaCorrecta.getText().toString()) < 1 ||
                        fieldRespuestaCorrecta.getText().toString() == ""){
                    try {
                        throw new NRespuestaException("No válido");
                    } catch (NRespuestaException e) {
                        e.printStackTrace();
                    }
                }else{

                    System.out.println("Activado");
                    int respuestaField = Integer.parseInt(fieldRespuestaCorrecta.getText());
                    if (correcta == respuestaField){
                        JOptionPane.showMessageDialog(null, "Has acertado","Hey", JOptionPane.INFORMATION_MESSAGE);
                        int numeroIzquierdo = Integer.parseInt(puntuacion1.getText());
                        manager.guardarAcierto(pregunta);
                        numeroIzquierdo++;
                        puntuacion1.setText(String.valueOf(numeroIzquierdo));

                        System.out.println(fieldRespuestaCorrecta.getText());
                    }else{
                        JOptionPane.showMessageDialog(null, "Has fallado","Hey", JOptionPane.ERROR_MESSAGE);
                        manager.guardarFallo(pregunta);
                    }
                    int numeroDerecho = Integer.parseInt(puntuacion3.getText());
                    numeroDerecho++;
                    puntuacion3.setText(String.valueOf(numeroDerecho));

                    System.out.println(fieldRespuestaCorrecta.getText());
                }

            }
        });
    }

    private void addComponentsToCenter(Container center){
        model = new DefaultListModel<>();
        list = new JList(model);
        list.setSize(new Dimension(150,150));


        center.add(list);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                System.out.println("Activado");
                System.out.println();
                ArrayList<Respuesta> respuestas = manager.getRespuestasDePregunta(model.getElementAt(list.getSelectedIndex()).toString());
                text.setText("");
                for (int i = 0; i < respuestas.size();i++){

                    text.append(i+1 +  ".- " + respuestas.get(i).getRespuestaTexto()+"\n");
                    if (respuestas.get(i).getCorrecta()==1){
                        correcta = i+1;
                    }

                }
                pregunta = model.getElementAt(list.getSelectedIndex());

            }
        });


    }

    private void addComponentsToEast(Container east){
        JLabel posiblesRespuestas = new JLabel("Posibles respuestas");
        text = new JTextArea();
        text.setMinimumSize(new Dimension(70,90));
        east.add(posiblesRespuestas);
        east.add(text);
    }

    public static void main(String[] args) {
        Cuestionario w = new Cuestionario();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == jugar){
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog(this, "Cuantas preguntas?"));

            ArrayList<String> seleccionados = new ArrayList<String>();
            for (int i = 0; i < checkBoxes.size(); i++){
                if (checkBoxes.get(i).isSelected()){
                    seleccionados.add(checkBoxes.get(i).getText());
                }
            }
            System.out.println(seleccionados.toString());
            ArrayList<Pregunta> misPreguntas = manager.preguntasAlAzar(seleccionados,respuesta);
            System.out.println(misPreguntas.toString());

            model.removeAllElements();
            for (int i = 0; i <misPreguntas.size(); i++){
                model.addElement(misPreguntas.get(i));

            }

        }


    }
}
