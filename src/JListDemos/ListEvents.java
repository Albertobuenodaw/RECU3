package events.lists;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListEvents extends JFrame {
	
	private JList<String> list;
	private DefaultListModel<String> lModel;

	public ListEvents() {
		
		super("JList example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension (500, 500));
		
		lModel = new DefaultListModel<String>();
		lModel.addElement("a");
		lModel.addElement("b");
		lModel.addElement("c");
		lModel.addElement("d");
		
		list = new JList<String>(lModel);
		list.setPreferredSize(new Dimension (200, 500));
		
        list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					System.out.println(list.getSelectedValue());
				}
				
			}
		});
		
        add(list, BorderLayout.LINE_START);
		
		// Display the window.
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListEvents();
	}
}
