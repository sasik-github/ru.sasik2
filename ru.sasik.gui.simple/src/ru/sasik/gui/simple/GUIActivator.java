package ru.sasik.gui.simple;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import ru.sasik.gui.IGUI;

public class GUIActivator extends DependencyActivatorBase {
	
	private JFrame frame;
	private JToolBar toolBar;
	
	private ToolbarActionTracker actionTracker;

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		// TODO Auto-generated method stub
		manager.add(createComponent()
				.setInterface(IGUI.class.getName(), null)
				.setImplementation(GUI.class)
		);
		
	}

	@Override
	public void start(BundleContext context) throws Exception {
		frame = new JFrame("ru.sasik.gui");
		toolBar = new JToolBar();
		
		actionTracker = new ToolbarActionTracker(context, toolBar);
		createFrameContent();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		actionTracker.close();
		frame.dispose();
	}
	
	public class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
//				JMenuItem itm = (JMenuItem)e.getSource();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Button error");
			}
			
//			System.out.println(e.);
			System.out.println(e.getSource());
			if (e.getActionCommand().compareTo("Close") == 0) {
				System.out.println("Close operation");
				System.exit(0);
			}
			
		}
		
	}
	
	public void createFrameContent() {
		File home = new File(System.getProperty("user.home"));
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JButton btn = new JButton("d");
		ActionListener actionListener = new MyActionListener();
		
		
//		MENU
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem itm = new JMenuItem("New");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Open");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Save");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Close");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		menubar.add(menu);
		frame.setJMenuBar(menubar);
		
		menu = new JMenu("Edit");
		
		itm = new JMenuItem("copy");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		menubar.add(menu);
		
		
		
		
		
//		END MENU
		frame.add(toolBar, BorderLayout.NORTH);
		toolBar.add(btn);
		btn.addActionListener(actionListener);
		frame.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setVisible(true);
				System.out.println("fileChooser");
			}
		});
		
		frame.pack();
				
	}

}
