package ru.sasik.client.console;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import ru.sasik.api.AgendaService;

public class Activator extends DependencyActivatorBase{

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		manager.add(createComponent()
				.setInterface(Object.class.getName(), null)
				.setImplementation(ConsoleClient.class)
				.add(createServiceDependency().setService(AgendaService.class))
		);
		
	}

}
