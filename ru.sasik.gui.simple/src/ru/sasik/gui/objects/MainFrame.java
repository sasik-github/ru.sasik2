package ru.sasik.gui.objects;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.gui.simple.CanvasPanel;
import ru.sasik.gui.simple.FileChooserAction;
import ru.sasik.gui.simple.StatusBar;
import ru.sasik.gui.simple.ToolbarActionTracker;
import ru.sasik.gui.simple.GUIActivator.MyActionListener;

public class MainFrame extends JFrame implements IMainFrame {

	private static final int WIDTH = 640;

	private static final int HEIGHT = 400;

	private JToolBar _toolBar;

	private JTextArea _area;

	private JTabbedPane _tabbedPane;

	private ICanvas _canvas;

	private StatusBar _statusBar;

	// private ActionListener actionListener;

	private DefaultDataFile dataFile;

	private ToolbarActionTracker _actionTracker;

	private FileChooserAction _fileChooserAction;

	public MainFrame() {

	}

	private void initComponents() {
		_toolBar = new JToolBar();
		_area = new JTextArea();
		_tabbedPane = new JTabbedPane();
		_statusBar = new StatusBar();
		_canvas = new Canvas();
		// _actionListener = new MyActionListener();
		// _actionTracker = new ToolbarActionTracker(context, toolBar);
		// _actionTracker.open();
		// _fileChooserAction = new FileChooserAction(_area, this, dataFile,
		// _canvas);

		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		File file = new File("/home/sasik/Dropbox/11111/Akord/DMITRY.DAT");

		// test write function
		// AdditionFunctions.writeFile("/home/sasik/Dropbox/11111/Akord/sasik.DAT",
		// AdditionFunctions.readFile(file));

		DefaultDataFile data = new DefaultDataFile();
		data.openFromFile(file);
		data.saveToFile();
		_canvas.setDataFile(data);

		createMenuContent();

		createWorkspaceContent();

		createFrameContent();

		this.setSize(WIDTH, HEIGHT);
		// this.pack();
	}

	private void createFrameContent() {
		// TODO Auto-generated method stub

	}

	private void createWorkspaceContent() {
		// TODO Auto-generated method stub

	}

	private void createMenuContent() {
		// TODO Auto-generated method stub

	}

	@Override
	public JToolBar getToolbar() {
		return _toolBar;
	}

	@Override
	public StatusBar getStatusbar() {
		return _statusBar;
	}

	@Override
	public ICanvas getCanvas() {
		return _canvas;
	}

}
