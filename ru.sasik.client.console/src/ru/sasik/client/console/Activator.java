package ru.sasik.client.console;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ru.sasik.api.AgendaService;

public class Activator extends DependencyActivatorBase{

	protected Application service;
	private Platform platform;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
//		super.start(context);
		ServiceReference serviceReference = context.getServiceReference(Application.class.getName());
		service = (Application) context.getService(serviceReference);
		System.out.println("Activator.init() " + service);
//		Application.launch(null);
		try {
			
			new JFXPanel();
			
			Platform.runLater(new Runnable() {
				
				@Override
				public void run() {
					try {
						service.start(new Stage());
						service.launch(null);
						
						System.out.println("Activator.init() Service is launched and started");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.err.println("" + e);
					}
					
				}
			});
		} catch (Exception e) {
			System.err.println(e);
			service.start(new Stage());
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
//		super.stop(context);
		try {
			if (Platform.isFxApplicationThread()) {
				Platform.exit();
				System.out.println("Activator.stop() is FX APPlication");
			}
			if (service != null)
				service.stop();
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		manager.add(createComponent()
				.setInterface(Object.class.getName(), null)
				.setImplementation(ConsoleClient.class)
				.add(createServiceDependency().setService(AgendaService.class).setRequired(true))
		);
		
	}

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
