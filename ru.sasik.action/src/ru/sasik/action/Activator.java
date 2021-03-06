package ru.sasik.action;

import javax.swing.Action;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator{
	
	private ServiceRegistration actionReg;

	@Override
	public void start(BundleContext context) throws Exception {
		HelloAction action = new HelloAction();
		
		actionReg = context.registerService(Action.class.getName(), action, null);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		actionReg.unregister();
		
	}

}
