package ru.sasik.gui.objects.frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ru.sasik.gui.objects.ICanvas;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.OriginObject;

public class PropertiesChanger extends JDialog implements ActionListener {

	private static final long serialVersionUID = 2588699347574228007L;

	private JFrame mainFrame;

	private JPanel panel;

	private JTextField X_ORIGIN;

	private JTextField Y_ORIGIN;

	private JTextField X_RADIUS;

	private JTextField Y_RADIUS;

	private JTextField ORIGIN_LENGTH;

	private JTextField ORIGIN_ARROW_10;

	private JTextField ORIGIN_ARROW_5;

	private JTextField Y_REVERSE;

	// private JTextField DX;
	//
	// private JTextField DY;

	private JTextField CONVERTER;

	private static Color DATA_COLOR = OriginObject.DATA_COLOR;

	private static Color ORIGIN_COLOR = OriginObject.ORIGIN_COLOR;

	public PropertiesChanger(IMainFrame frame) {
		super();
		this.mainFrame = (JFrame) frame;
		this.setTitle("Properties");
		panel = new JPanel();
//		panel.sets
		
		panel.add(new JLabel("Change properties of canvas"));
		
		initGUI();

		JPanel actionsPanel = new JPanel();
		JButton button = new JButton("Ok");
		button.addActionListener(this);
		actionsPanel.add(button);
		button = new JButton("Cancel");
		button.addActionListener(this);
		actionsPanel.add(button);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(actionsPanel);
		add(panel);
		setLocationRelativeTo(this.mainFrame);
		setVisible(true);
		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (((JButton) e.getSource()).getText().contains("Ok")) {
			saveChange();
			mainFrame.repaint();
		}
		setVisible(false);
		dispose();

	}

	public void initGUI() {
		JLabel lbl = new JLabel("X begin");
		X_ORIGIN = new JTextField(String.valueOf(OriginObject.X_ORIGIN));
		panel.add(lbl);
		panel.add(X_ORIGIN);

		Y_ORIGIN = new JTextField(String.valueOf(OriginObject.Y_ORIGIN));
		panel.add(new JLabel("Y begin"));
		panel.add(Y_ORIGIN);

		X_RADIUS = new JTextField(String.valueOf(OriginObject.X_RADIUS));
		panel.add(new JLabel("X radius"));
		panel.add(X_RADIUS);

		Y_RADIUS = new JTextField(String.valueOf(OriginObject.Y_RADIUS));
		panel.add(new JLabel("Y radius"));
		panel.add(Y_RADIUS);

		ORIGIN_LENGTH = new JTextField(
				String.valueOf(OriginObject.ORIGIN_LENGTH));
		panel.add(new JLabel("Origin length"));
		panel.add(ORIGIN_LENGTH);

		ORIGIN_ARROW_10 = new JTextField(
				String.valueOf(OriginObject.ORIGIN_ARROW_10));
		panel.add(new JLabel("Origin length of arrow10"));
		panel.add(ORIGIN_ARROW_10);

		ORIGIN_ARROW_5 = new JTextField(
				String.valueOf(OriginObject.ORIGIN_ARROW_5));
		panel.add(new JLabel("Origin length of arrow5"));
		panel.add(ORIGIN_ARROW_5);

		Y_REVERSE = new JTextField(String.valueOf(OriginObject.Y_REVERSE));
		panel.add(new JLabel("Reverse of oY"));
		panel.add(Y_REVERSE);

		// DX
		//
		// DY

		CONVERTER = new JTextField(String.valueOf(OriginObject.CONVERTER));
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
		OriginObject.X_ORIGIN = Integer.parseInt(X_ORIGIN.getText());
		OriginObject.Y_ORIGIN = Integer.parseInt(Y_ORIGIN.getText());
		OriginObject.X_RADIUS = Integer.parseInt(X_RADIUS.getText());
		OriginObject.Y_RADIUS = Integer.parseInt(Y_RADIUS.getText());
		OriginObject.ORIGIN_LENGTH = Integer.parseInt(ORIGIN_LENGTH.getText());
		OriginObject.ORIGIN_ARROW_10 = Integer.parseInt(ORIGIN_ARROW_10
				.getText());
		OriginObject.ORIGIN_ARROW_5 = Integer
				.parseInt(ORIGIN_ARROW_5.getText());
		OriginObject.Y_REVERSE = Integer.parseInt(Y_REVERSE.getText());
		OriginObject.CONVERTER = Integer.parseInt(CONVERTER.getText());
		OriginObject.DATA_COLOR = DATA_COLOR;
		OriginObject.ORIGIN_COLOR = ORIGIN_COLOR;
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

			color = JColorChooser.showDialog(PropertiesChanger.this,
					"Choose a color", oldColor);

			if (color != null) {
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
