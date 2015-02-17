package ru.sasik.gui.starter;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import ru.sasik.gui.objects.MainFrame;

public class GuiStarterActivator extends DependencyActivatorBase{

	
	private MainFrame frame;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		super.start(context);
		System.out.println("GuiStarterActivator.start()");
		
		frame = new MainFrame();
	}
	
	
	@Override
	public void destroy(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		System.out.println("GuiStarterActivator.destroy()");
		if(null == frame) return;
		frame.dispose();
		
	}

	@Override
	public void init(BundleContext arg0, DependencyManager arg1)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
//		super.stop(context);
		if(null == frame) return;
		frame.dispose();
	}

}
