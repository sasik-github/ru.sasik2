package ru.sasik.gui.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.sasik.datafile.DefaultDataFile;

public class Canvas extends JPanel implements ICanvas {

	private static final int CANVAS_WIDTH = 640;
	private static final int CANVAS_HEIGHT = 480;

	private static final long serialVersionUID = 5449765633250881495L;
	private JFrame _mainFrame;
	private Map _shapesList = new HashMap<String, IShape>();
	private IShape _defaultShape;
	private String _shapeSelected;
	private ActionListener _reusableActionListener;

	public Canvas() {

		_reusableActionListener = new ShapeButtonActionListener();
		// IShape shape = new Poi
		// addShape("Point", shape);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		setLayout(null);

	}

	@Override
	public void setMainFrame(JFrame frame) {
		_mainFrame = frame;

	}

	@Override
	public IShape getShape(String shapeName) {
		IShape shape = (IShape) _shapesList.get(shapeName);
		if (shape == null) {
			return _defaultShape;
		}
		return shape;
	}

	@Override
	public void addShape(String shapeName, IShape shape) {

		_shapesList.put(shapeName, shape);

		JButton button = new JButton(shapeName);
		button.setActionCommand(shapeName);
		button.setToolTipText(shapeName);
		button.addActionListener(_reusableActionListener);

		if (_shapeSelected == null) {
			button.doClick();
		}

		// JToolBar toolbar = _mainFrame.getToolbar();
		// toolbar.add(button);
		// toolbar.validate();
		// _mainFrame.repaint();

	}

	public class ShapeButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String shapeSelectedName = ((JButton) e.getSource())
					.getActionCommand();
			_shapeSelected = shapeSelectedName;
		}

	}

	@Override
	public void setDataFile(DefaultDataFile data) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		Rectangle r = getBounds();
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, r.width, r.height);

		// paintCoordGrid(g2d);
		paintCoord(g2d);
	}

	private void paintCoord(final Graphics2D g2d) {
		new OriginObject().draw(g2d);

	}

}
