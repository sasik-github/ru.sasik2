package ru.sasik.gui.simple;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.gui.IGUI;

public class GUIActivator extends DependencyActivatorBase {
	
	private static final String FRAME_TITLE  = "ru.sasik.gui";
	
	private JFrame frame;
	
	private JToolBar toolBar;
	
	private JTextArea area;
	
	private JTabbedPane tabbedPane;
	
	private CanvasPanel canvasPanel;
	
	private ActionListener actionListener;
	
	private DefaultDataFile dataFile;
	
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
		
		frame = new JFrame(FRAME_TITLE);
		toolBar = new JToolBar();
		area = new JTextArea();
		tabbedPane = new JTabbedPane(); 
		canvasPanel = new CanvasPanel();
		actionListener = new MyActionListener();
		actionTracker = new ToolbarActionTracker(context, toolBar);
		actionTracker.open();
		
//		File file = new File("/home/sasik/Projects/ru.sasik/data/SERG.DAT");
//		DefaultDataFile data = new DefaultDataFile();
//		data.openFromFile(file);
		
		createMenuContent();
		
		createWorkspaceContent();
		
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
			} finally {
//				System.out.println(e.);
				System.out.println(e.getSource());
				if (e.getActionCommand().compareTo("Close") == 0) {
					System.out.println("Close operation");
					System.exit(0);
				}
			}
		
			
		}
		
	}
	
	public void createMenuContent() {
//		MENU
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem itm = new JMenuItem("New");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Open");
//		itm.addActionListener(actionListener);
		menu.add(itm);
		itm.addActionListener(new FileChooserAction(area, frame, dataFile, canvasPanel));
		
		itm = new JMenuItem("Сохранить");
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
	}
	
	public void createWorkspaceContent() {
		//data source
		area.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add(area);
		
		tabbedPane.addTab("Source", pane);
		tabbedPane.addTab("Designer", canvasPanel);
		frame.add(tabbedPane);
		
	}
	
	public void createFrameContent() {
		JButton btn = new JButton("d");
		frame.add(toolBar, BorderLayout.NORTH);
		toolBar.add(btn);
		btn.addActionListener(actionListener);
		frame.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.pack();
				
	}

}
