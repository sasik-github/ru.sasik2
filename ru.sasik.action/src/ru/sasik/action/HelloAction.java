package ru.sasik.action;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class HelloAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3950735297477155794L;

	public HelloAction() {
		super("view");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog((Component) event.getSource() , "Hello World", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

}
