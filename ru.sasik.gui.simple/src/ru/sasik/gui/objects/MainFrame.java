package ru.sasik.gui.objects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import ru.sasik.gui.objects.frame.MainMenu;
import ru.sasik.gui.objects.frame.MainToolbar;
import ru.sasik.gui.objects.frame.StatusBar;

public class MainFrame extends JFrame implements IMainFrame {

	private static final long serialVersionUID = -3012101084369765594L;

	private static final int WIDTH = 640;

	private static final int HEIGHT = 700;

	private static final String FRAME_TITLE = "ru.sasik.gui";

	private Canvas canvas;

	private JToolBar toolbar;

	private MainMenu menubar;

	private StatusBar stausBar;

	// containers for all workspace objects
	// used for BorderLayout if you want to add
	// several object to BorderLayour.North or other space
	private Container mainContentPane;
	private JPanel northContent;
	private JPanel middleContent;
	private JPanel southContent;

	public MainFrame() {

		northContent = new JPanel();
		FlowLayout northFlowLayout = new FlowLayout();
		middleContent = new JPanel();
		middleContent.setLayout(new FlowLayout());
		southContent = new JPanel();

		mainContentPane = getContentPane();
		mainContentPane.setLayout(new BorderLayout());
		mainContentPane.add(northContent, BorderLayout.NORTH);
		mainContentPane.add(middleContent, BorderLayout.CENTER);
		mainContentPane.add(southContent, BorderLayout.SOUTH);

		northContent.setLayout(northFlowLayout);
		northFlowLayout.setAlignment(FlowLayout.LEFT);

		initComponents();
		setTitle(FRAME_TITLE);
		pack();
		setVisible(true);
	}

	private void initComponents() {
		createToolbarContent();
		createMenuContent();
		createWorkspaceContent();
		createFrameContent();
		createStatusbarContent();
	}

	private void createStatusbarContent() {
		stausBar = new ru.sasik.gui.objects.frame.StatusBar();
		southContent.add(stausBar);

	}

	private void createToolbarContent() {
		toolbar = new MainToolbar();
		northContent.add(toolbar);
	}

	private void createFrameContent() {
		//

	}

	private void createWorkspaceContent() {
		canvas = new Canvas();
		canvas.setBorder(BorderFactory.createLineBorder(Color.red));
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add(canvas);
		add(pane, BorderLayout.CENTER);
	}

	private void createMenuContent() {
		menubar = new MainMenu(this);
		setJMenuBar(menubar);
	}

	@Override
	public JToolBar getToolbar() {
		return toolbar;
	}

	@Override
	public StatusBar getStatusbar() {
		return stausBar;
	}

	@Override
	public ICanvas getCanvas() {
		return null;
	}

}
