package ru.sasik.gui.simple;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertiesChanger extends JDialog implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2588699347574228007L;
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

//	private JTextField DX; 
//
//	private JTextField DY;

	private JTextField CONVERTER;

	private static Color DATA_COLOR = Color.red;

	private static Color ORIGIN_COLOR = Color.blue;

	

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
		setVisible(true);
		pack();
		
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
		X_ORIGIN = new JTextField(String.valueOf(CanvasPanel.getX_ORIGIN()));
		panel.add(lbl);
		panel.add(X_ORIGIN);
		
		Y_ORIGIN = new JTextField(String.valueOf(CanvasPanel.getY_ORIGIN()));
		panel.add(new JLabel("Y begin"));
		panel.add(Y_ORIGIN);
		
		X_RADIUS = new JTextField(String.valueOf(CanvasPanel.getX_RADIUS()));
		panel.add(new JLabel("X radius"));
		panel.add(X_RADIUS);
		
		Y_RADIUS = new JTextField(String.valueOf(CanvasPanel.getY_RADIUS()));
		panel.add(new JLabel("Y radius"));
		panel.add(Y_RADIUS);
		
		ORIGIN_LENGTH = new JTextField(String.valueOf(canvasPanel.getORIGIN_LENGTH()));
		panel.add(new JLabel("Origin length"));
		panel.add(ORIGIN_LENGTH);
		
		ORIGIN_ARROW_10 = new JTextField(String.valueOf(CanvasPanel.getORIGIN_ARROW_10()));
		panel.add(new JLabel("Origin length of arrow10"));
		panel.add(ORIGIN_ARROW_10);
		
		ORIGIN_ARROW_5 = new JTextField(String.valueOf(CanvasPanel.getORIGIN_ARROW_5()));
		panel.add(new JLabel("Origin length of arrow5"));
		panel.add(ORIGIN_ARROW_5);
		
		Y_REVERSE = new JTextField(String.valueOf(CanvasPanel.getY_REVERSE()));
		panel.add(new JLabel("Reverse of oY"));
		panel.add(Y_REVERSE);
		
//		DX
//		
//		DY
		
		CONVERTER = new JTextField(String.valueOf(CanvasPanel.getCONVERTER()));
		panel.add(new JLabel("Converter"));
		panel.add(CONVERTER);
		
		JButton btnColor = new JButton("Data color");
		btnColor.addActionListener(new ColorActionListener("data"));
		btnColor.setBackground(DATA_COLOR);
		panel.add(btnColor);
		
		btnColor = new JButton("Origin color");
		btnColor.addActionListener(new ColorActionListener("origin"));
		btnColor.setBackground(ORIGIN_COLOR);
		panel.add(btnColor);
		
	}
	
	public void saveChange() {
		CanvasPanel.setX_ORIGIN(Integer.parseInt(X_ORIGIN.getText()));
		CanvasPanel.setY_ORIGIN(Integer.parseInt(Y_ORIGIN.getText()));
		CanvasPanel.setX_RADIUS(Integer.parseInt(X_RADIUS.getText()));
		CanvasPanel.setY_RADIUS(Integer.parseInt(Y_RADIUS.getText()));
		CanvasPanel.setORIGIN_LENGTH(Integer.parseInt(ORIGIN_LENGTH.getText()));
		CanvasPanel.setORIGIN_ARROW_10(Integer.parseInt(ORIGIN_ARROW_10.getText()));
		CanvasPanel.setORIGIN_ARROW_5(Integer.parseInt(ORIGIN_ARROW_5.getText()));
		CanvasPanel.setY_REVERSE(Integer.parseInt(Y_REVERSE.getText()));
		CanvasPanel.setCONVERTER(Integer.parseInt(CONVERTER.getText()));
		CanvasPanel.setDATA_COLOR(DATA_COLOR);
		CanvasPanel.setORIGIN_COLOR(ORIGIN_COLOR);
	}
	
	public class ColorActionListener implements ActionListener {
		
		private String typeOfColor;
		
		

		public ColorActionListener(String typeOfColor) {
			this.typeOfColor = typeOfColor;
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			Color oldColor = null;
			Color color;
			switch (typeOfColor.toLowerCase()) {
			case "data":
				oldColor = DATA_COLOR;
				break;
			case "origin":
				oldColor = ORIGIN_COLOR;
				break;
			}
			
			color = JColorChooser.showDialog(PropertiesChanger.this, "Choose a color", oldColor);
			
			if ( color != null) {
				((JButton) e.getSource()).setBackground(color);
				switch (typeOfColor.toLowerCase()) {
				case "data":
					DATA_COLOR = color;
					break;
				case "origin":
					ORIGIN_COLOR = color;
					break;
				}
			}
			
		}
		
	}

}
