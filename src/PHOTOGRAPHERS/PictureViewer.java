package PHOTOGRAPHERS;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PictureViewer extends JFrame implements ActionListener {
    DefaultComboBoxModel model;
    JComboBox combo;

    DefaultListModel modelList;
    JList l;


    PhotographerManager manager = new PhotographerManager();
    public PictureViewer(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Photography");
        this.setLayout(new GridLayout(3,2));
        this.setBounds(10,10,500,300);
        this.setVisible(true);

        //PanelPrimerBoton
        JPanel panelBoton1 = new JPanel();
        panelBoton1.setLayout(new GridLayout(1,1));
        addComponentsToPanelBoton1(panelBoton1);
        this.add(panelBoton1);
        //Fin panel primer boton

        //PanelSegundoBoton
        JPanel panelBoton2 = new JPanel();
        panelBoton2.setLayout(new GridLayout(1,1));
        addComponentsToPanelBoton2(panelBoton2);
        this.add(panelBoton2);
        //Fin panel primer boton

        //Panel11
        JPanel panel11 = new JPanel();
        panel11.setLayout(new FlowLayout());
        //panel11.setBackground(Color.red);
        addComponentsTo11(panel11);
        this.add(panel11);
        //Fin panel11

        //Panel12
        JPanel panel12 = new JPanel();
        panel12.setLayout(new FlowLayout());
        //panel12.setBackground(Color.green);
        addComponentsTo12(panel12);
        this.add(panel12);
        //Fin panel12

        //Panel21
        JPanel panel21 = new JPanel();
        panel21.setLayout(new GridLayout(1,1));
        //panel21.setBackground(Color.blue);
        panel21.setBorder(BorderFactory.createEmptyBorder(0,5,5,0));
        addComponentsTo21(panel21);
        this.add(panel21);
        //Fin panel12

        //Panel22
        JPanel panel22 = new JPanel();
        panel22.setLayout(new FlowLayout());
        //panel22.setBackground(Color.yellow);
        addComponentsTo22(panel22);
        this.add(panel22);
        //Fin panel22
    }

    private void addComponentsToPanelBoton1(Container panelBoton1){
        JButton award = new JButton("Award");
        panelBoton1.add(award);
    }

    private void addComponentsToPanelBoton2(Container panelBoton2){
        JButton remove = new JButton("Remove");
        panelBoton2.add(remove);
    }


    private void addComponentsTo11(Container panel11) {
        JLabel photographerL = new JLabel("Photographer: ");
        panel11.add(photographerL);
        ArrayList<Photographer> photographerList = manager.allPhotographers();
        model = new DefaultComboBoxModel();
        combo = new JComboBox(model);
        for (int i = 0; i<photographerList.size();i++){
            model.addElement(photographerList.get(i).getName());
        }
        panel11.add(combo);
        combo.addActionListener(this);


    }

    private void addComponentsTo12(Container panel12) {
        JLabel photosAfter = new JLabel("Photos after");
        panel12.add(photosAfter);

        JXDatePicker picker = new JXDatePicker();
        picker.setFormats("yyyy-MM-dd");
        panel12.add(picker);
    }

    private void addComponentsTo21(Container panel21) {

        modelList = new DefaultListModel<>();
        l = new JList(modelList);
        /*modelList.addElement("A");
        modelList.addElement("A");
        modelList.addElement("A");
        modelList.addElement("A");*/
        JScrollPane scroll = new JScrollPane(l, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        panel21.add(scroll);
    }

    private void addComponentsTo22(JPanel panel22) {
        JLabel pictureLabel = new JLabel();
        ImageIcon image = new ImageIcon("images/vangogh1.jpg");
        image.setImage(image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
        pictureLabel.setIcon(image);

        panel22.add(pictureLabel);
    }

    public static void main(String[] args) {
        PictureViewer pv = new PictureViewer();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == combo){
            modelList.removeAllElements();
            ArrayList<Picture> listaPictures = manager.picturesOfPhotographerName((String) model.getSelectedItem());
            for (int i = 0; i<listaPictures.size();i++){
                modelList.addElement(listaPictures.get(i).getTitle());
            }

        }

    }
}
