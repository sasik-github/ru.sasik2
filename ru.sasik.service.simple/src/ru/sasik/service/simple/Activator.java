package ru.sasik.service.simple;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import ru.sasik.api.AgendaService;

public class Activator extends DependencyActivatorBase {

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		manager.add(createComponent()
				.setInterface(AgendaService.class.getName(), null)
				.setImplementation(SimpleAgendaService.class)
		);
	}

	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
