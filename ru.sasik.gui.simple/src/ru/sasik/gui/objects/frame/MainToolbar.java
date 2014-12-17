package ru.sasik.gui.objects.frame;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainToolbar extends JToolBar {

	private static final long serialVersionUID = 2785150601685480343L;

	public MainToolbar() {
		add(new JButton("Hello1"));
		add(new JButton("Hello2"));
	}
}
