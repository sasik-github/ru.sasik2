package ru.sasik.gui.objects;

import javax.swing.JToolBar;

import ru.sasik.gui.objects.frame.StatusBar;

public interface IMainFrame {

	public JToolBar getToolbar();

	public StatusBar getStatusbar();

	public ICanvas getCanvas();

}
