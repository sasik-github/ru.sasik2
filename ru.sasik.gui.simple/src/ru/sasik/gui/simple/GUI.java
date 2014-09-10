package ru.sasik.gui.simple;
//http://darkraha.com/rus/java/swing/swing00.php
//http://zetcode.com/tutorials/javaswingtutorial/swingmodels/

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import ru.sasik.gui.IGUI;

public class GUI implements IGUI{
	
	@Override
	public void startGUI() {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("ru.sasik.gui");
		JToolBar tbar = new JToolBar();
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
		f.setJMenuBar(menubar);
		
		menu = new JMenu("Edit");
		
		itm = new JMenuItem("copy");
		itm.addActionListener(actionListener);
		menu.add(itm);
		
		menubar.add(menu);
		
		
		
		
		
//		END MENU
		f.add(tbar, BorderLayout.NORTH);
		tbar.add(btn);
		btn.addActionListener(actionListener);
		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(300, 300);
		f.setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setVisible(true);
				System.out.println("fileChooser");
			}
		});
		
		f.pack();
	}
	
	public void start() {
		startGUI();
	}
	
	public class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				JMenuItem itm = (JMenuItem)e.getSource();
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

}
