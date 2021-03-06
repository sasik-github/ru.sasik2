package ru.sasik.gui.fx;

import javafx.application.Application;
import javafx.application.Platform;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GUIActivator implements BundleActivator{

	private ServiceRegistration applicationReg;

	@Override
	public void start(BundleContext context) throws Exception {
		GUIApplication guiApplication = new GUIApplication();
		applicationReg = context.registerService(Application.class.getName(), guiApplication, null);
//		Application.launch(GUIApplication.class, "");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
//		Platform.exit();
		applicationReg.unregister();

	}
}
