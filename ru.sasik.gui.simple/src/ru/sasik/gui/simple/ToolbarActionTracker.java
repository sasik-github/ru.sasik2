package ru.sasik.gui.simple;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

import org.apache.felix.dm.tracker.ServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


@Deprecated
public class ToolbarActionTracker extends ServiceTracker{
	
	private final JToolBar toolBar;

	public ToolbarActionTracker(BundleContext context, JToolBar toolBar) {
		super(context, Action.class.getName(), null);
		this.toolBar = toolBar;
		System.out.println("Toolbar Action Tracker is activated...");
	}

	@Override
	public Object addingService(ServiceReference reference) {
		Action action = (Action) context.getService(reference);
		JButton button = new JButton(action);
		Object toolTip = reference.getProperty("action.tooltip");
		if (toolTip != null && toolTip instanceof String) {
			button.setToolTipText((String) toolTip);
		}
		toolBar.add(button);
		toolBar.revalidate();
		System.out.println("Toolbar Action Tracker is added a action " + action);
		return button;
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		JButton button = (JButton) service;
		
		toolBar.remove(button);
		toolBar.revalidate();
		toolBar.repaint();
		context.ungetService(reference);
		System.out.println("Toolbar Action Tracker is removed a action " + button);
		super.removedService(reference, service);
	}
	
	

}
