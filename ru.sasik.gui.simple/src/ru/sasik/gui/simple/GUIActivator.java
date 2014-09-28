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
import ru.sasik.helper.AdditionFunctions;

public class GUIActivator extends DependencyActivatorBase {
	
	private static final String FRAME_TITLE  = "ru.sasik.gui";
	
	private static int WIDTH = 1000;
	
	private static int HEIGHT = 700;
	
	private JFrame frame;
	
	private JToolBar toolBar;
	
	private JTextArea area;
	
	private JTabbedPane tabbedPane;
	
	private CanvasPanel canvasPanel;
	
	private StatusBar statusBar;
	
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
		statusBar = new StatusBar();
		canvasPanel = new CanvasPanel(statusBar);
		actionListener = new MyActionListener();
		actionTracker = new ToolbarActionTracker(context, toolBar);
		actionTracker.open();
		
		

		File file = new File(
				"/home/sasik/Dropbox/11111/Akord/DMITRY.DAT"
		);
		
		AdditionFunctions.writeFile("/home/sasik/Dropbox/11111/Akord/sasik.DAT", AdditionFunctions.readFile(file));
		
		DefaultDataFile data = new DefaultDataFile();
		data.openFromFile(file);
		canvasPanel.setDataFile(data);

		createMenuContent();

		createWorkspaceContent();

		createFrameContent();
		frame.setSize(WIDTH, HEIGHT);
//		frame.pack();
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		actionTracker.close();
		frame.dispose();
	}

	public class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			// TODO Auto-generated method stub
			try {
//				JMenuItem itm = (JMenuItem)e.getSource();
			} catch (Exception e2) {
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
		itm.addActionListener(
				new FileChooserAction(
						area,
						frame,
						dataFile,
						canvasPanel
				)
		);

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
		
		itm = new JMenuItem("Properties");
		itm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PropertiesChanger(canvasPanel);
				
			}
		});
		menu.add(itm);

		menubar.add(menu);
//		END MENU
	}
	
	public void createWorkspaceContent() {
		//data source
		area.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add(area);

		tabbedPane.addTab("Designer", canvasPanel);
		tabbedPane.addTab("Source", pane);
		
		frame.add(tabbedPane);
		
		frame.add(statusBar, BorderLayout.SOUTH);

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
//		frame.pack();
	}

}
