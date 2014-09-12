package ru.sasik.action;

import java.awt.Component;
import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

public class HelloAction extends AbstractAction {

	public HelloAction() {
		super("Hello");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JOptionPane.showMessageDialog((Component) event.getSource() , "Hello World", "Message", JOptionPane.INFORMATION_MESSAGE);
	}

}