package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.sasik.gui.objects.IMainFrame;

/**
 * take responsibility of init variables 
 * and invoke getAction method
 * @author sasik
 *
 */
public abstract class MenuActionListenerAbstract implements ActionListener {
	
	protected IMainFrame mainFrame;
	protected ActionEvent event;
	
	

	public MenuActionListenerAbstract(IMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		event = e;
		getAction(actionCommand);
	}

	
	protected abstract void getAction(String actionCommand);

}
