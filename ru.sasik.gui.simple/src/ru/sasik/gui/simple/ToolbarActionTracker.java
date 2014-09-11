package ru.sasik.gui.simple;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JToolBar;

import org.apache.felix.dm.tracker.ServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ToolbarActionTracker extends ServiceTracker{
	
	private final JToolBar toolBar;

	public ToolbarActionTracker(BundleContext context, JToolBar toolBar) {
		super(context, Action.class.getName(), null);
		this.toolBar = toolBar;
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
		return button;
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		// TODO Auto-generated method stub
		JButton button = (JButton) service;
		
		toolBar.remove(button);
		toolBar.revalidate();
		toolBar.repaint();
		context.ungetService(reference);
		super.removedService(reference, service);
	}
	
	

}
