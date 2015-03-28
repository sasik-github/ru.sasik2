package ru.sasik.gui.actionlisteners;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

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
	
	protected String invokeSwtDialog(IMainFrame mainFrame, String description, int typeOperation,
			final String fileFilter) {
		
		FileDialog openDialog = new FileDialog((Frame)mainFrame, description, typeOperation);
		openDialog.setFilenameFilter(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if (name.toLowerCase().endsWith(fileFilter))
					return true;
				return false;
			}
		});
		openDialog.setVisible(true);
		String fileName = openDialog.getDirectory() + openDialog.getFile();
		return fileName;
	}

}
