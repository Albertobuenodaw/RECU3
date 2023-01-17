package events.lists;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListEventsPerson extends JFrame {
	
	private JList<Person> list;
	private DefaultListModel<Person> lModel;

	public ListEventsPerson() {
		
		super("JList example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension (500, 500));
		
		lModel = new DefaultListModel<Person>();
		lModel.addElement(new Person("Asis", "Caballero"));
		lModel.addElement(new Person("Ana", "Vachadze"));
		lModel.addElement(new Person("Mikel", "Martin"));
		
		list = new JList<Person>(lModel);
		list.setPreferredSize(new Dimension (200, 500));
		
        list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					Person p = (Person)list.getSelectedValue();
					System.out.println(p.toString());
				}
				
			}
		});
		
        add(list, BorderLayout.LINE_START);
		
		// Display the window.
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListEventsPerson();
	}
}
