package ru.sasik.gui.simple;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.sasik.datafile.DefaultDataFile;

public class PropertiesChanger extends JDialog implements ActionListener{
	
	private CanvasPanel canvasPanel;
	private JPanel panel;
	
	
	private JTextField X_ORIGIN;

	private JTextField Y_ORIGIN;

	private JTextField X_RADIUS;

	private JTextField Y_RADIUS;

	private JTextField ORIGIN_LENGTH;

	private JTextField ORIGIN_ARROW_10;

	private JTextField ORIGIN_ARROW_5;
	
	private JTextField Y_REVERSE;

	private JTextField DX; 

	private JTextField DY;

	private JTextField CONVERTER;

//	private static Color DATA_COLOR = Color.red;
//
//	private static Color ORIGIN_COLOR = Color.blue;

	

	public PropertiesChanger(CanvasPanel canvasPanel) {
		super();
		this.canvasPanel = canvasPanel;
		
		panel = new JPanel();
		panel.add(new JLabel("Change properties of canvas"));
		
		initGUI();
		
		
		JButton button = new JButton("Ok");
		button.addActionListener(this);
		panel.add(button);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		add(panel);
		pack();
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (((JButton) e.getSource()).getText().contains("Ok")) {
			saveChange();
			canvasPanel.repaint();
		}
		setVisible(false);
		dispose();
		
	}
	
	public void initGUI() {
		JLabel lbl = new JLabel("X begin");
		X_ORIGIN = new JTextField(String.valueOf(canvasPanel.getX_ORIGIN()));
		panel.add(lbl);
		panel.add(X_ORIGIN);
		
		Y_ORIGIN = new JTextField(String.valueOf(canvasPanel.getY_ORIGIN()));
		panel.add(new JLabel("Y begin"));
		panel.add(Y_ORIGIN);
		
		X_RADIUS = new JTextField(String.valueOf(canvasPanel.getX_RADIUS()));
		panel.add(new JLabel("X radius"));
		panel.add(X_RADIUS);
		
		Y_RADIUS = new JTextField(String.valueOf(canvasPanel.getY_RADIUS()));
		panel.add(new JLabel("Y radius"));
		panel.add(Y_RADIUS);
		
		ORIGIN_LENGTH = new JTextField(String.valueOf(canvasPanel.getORIGIN_LENGTH()));
		panel.add(new JLabel("Origin length"));
		panel.add(ORIGIN_LENGTH);
		
		ORIGIN_ARROW_10 = new JTextField(String.valueOf(canvasPanel.getORIGIN_ARROW_10()));
		panel.add(new JLabel("Origin length of arrow10"));
		panel.add(ORIGIN_ARROW_10);
		
		ORIGIN_ARROW_5 = new JTextField(String.valueOf(canvasPanel.getORIGIN_ARROW_5()));
		panel.add(new JLabel("Origin length of arrow5"));
		panel.add(ORIGIN_ARROW_5);
		
		Y_REVERSE = new JTextField(String.valueOf(canvasPanel.getY_REVERSE()));
		panel.add(new JLabel("Reverse of oY"));
		panel.add(Y_REVERSE);
		
//		DX
//		
//		DY
		
		CONVERTER = new JTextField(String.valueOf(canvasPanel.getCONVERTER()));
		panel.add(new JLabel("Converter"));
		panel.add(CONVERTER);
		
	}
	
	public void saveChange() {
		canvasPanel.setX_ORIGIN(Integer.parseInt(X_ORIGIN.getText()));
		canvasPanel.setY_ORIGIN(Integer.parseInt(Y_ORIGIN.getText()));
		canvasPanel.setX_RADIUS(Integer.parseInt(X_RADIUS.getText()));
		canvasPanel.setY_RADIUS(Integer.parseInt(Y_RADIUS.getText()));
		canvasPanel.setORIGIN_LENGTH(Integer.parseInt(ORIGIN_LENGTH.getText()));
		canvasPanel.setORIGIN_ARROW_10(Integer.parseInt(ORIGIN_ARROW_10.getText()));
		canvasPanel.setORIGIN_ARROW_5(Integer.parseInt(ORIGIN_ARROW_5.getText()));
		canvasPanel.setY_REVERSE(Integer.parseInt(Y_REVERSE.getText()));
		canvasPanel.setCONVERTER(Integer.parseInt(CONVERTER.getText()));
	}
	
	

}
