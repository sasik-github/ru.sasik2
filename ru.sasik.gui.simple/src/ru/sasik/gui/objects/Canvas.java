package ru.sasik.gui.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.datafile.Point;
import ru.sasik.gui.simpleshapes.PointShape;

public class Canvas extends JPanel implements ICanvas {

	private static final long serialVersionUID = 5449765633250881495L;

	private static final int CANVAS_WIDTH = 800;
	private static final int CANVAS_HEIGHT = 600;
	public static final int BOX = 15;

	private JFrame _mainFrame;
	private Map<String, IShape> _shapesList = new HashMap<String, IShape>();
	private IShape _defaultShape;
	private String _shapeSelected;
	private ActionListener _reusableActionListener;
	private DefaultDataFile dataFile;
	private ArrayList<ShapeComponent> shapeComponentList = new ArrayList<ShapeComponent>();

	public Canvas() {

		_reusableActionListener = new ShapeButtonActionListener();
		IShape shape = new PointShape();
		addShape("Point", shape);
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

		// System.out.println("Canvas.getShape(): Shape is " + shape);
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
		dataFile = data;
		repaint();

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		Rectangle r = getBounds();
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, r.width, r.height);

		paintGrid(g2d);

		paintCoord(g2d);

		paintData(g2d);
	}

	private void paintData(Graphics2D g2d) {
		if (dataFile != null) {
			if (dataFile.nodes != null) {
				g2d.setStroke(new BasicStroke());
				g2d.setColor(OriginObject.DATA_COLOR);
				if (shapeComponentList.isEmpty()) {
					for (Point node : dataFile.nodes) {
						String m_selected = "Point";
						ShapeComponent sc = new ShapeComponent(this, m_selected);
						sc.setBounds(
								(int) ((node.getX() + OriginObject.DX)
										* OriginObject.CONVERTER + OriginObject.X_ORIGIN),// BOX
																							// /
																							// 2
								(int) ((node.getY() + OriginObject.DY)
										* OriginObject.CONVERTER
										* OriginObject.Y_REVERSE + OriginObject.Y_ORIGIN), // -
																							// sc.displacmentX
								BOX, BOX);
						add(sc, 0);
						repaint(sc.getBounds());
						shapeComponentList.add(sc);
						validate();
					}
				} else {
					// else - if shapeComponents was created
					// we use created objects 
					Iterator<Point> iterator = dataFile.nodes.iterator();
					for (ShapeComponent shapeComponent : shapeComponentList) {
						// System.out.println("Canvas.paintData() "
						// + shapeComponent.getBounds());
						Point p = iterator.next();
						shapeComponent
								.setBounds(
										(int) ((p.getX() + OriginObject.DX)
												* OriginObject.CONVERTER + OriginObject.X_ORIGIN),
										(int) ((p.getY() + OriginObject.DY)
												* OriginObject.CONVERTER
												* OriginObject.Y_REVERSE + OriginObject.Y_ORIGIN),
										BOX, BOX);
						shapeComponent.setColor(OriginObject.DATA_COLOR);

					}
					validate();
				}

				// System.out.println("Nodes size" + dataFile.nodes.size());
			}
		}
	}

	private void paintData2(Graphics2D g2d) {
		if (dataFile != null) {
			if (dataFile.nodes != null) {
				g2d.setStroke(new BasicStroke());
				g2d.setColor(OriginObject.DATA_COLOR);
				for (Point node : dataFile.nodes) {
					g2d.fillOval(
							(int) ((node.getX() + OriginObject.DX)
									* OriginObject.CONVERTER + OriginObject.X_ORIGIN),
							(int) ((node.getY() + OriginObject.DY)
									* OriginObject.CONVERTER
									* OriginObject.Y_REVERSE + OriginObject.Y_ORIGIN),
							OriginObject.X_RADIUS, OriginObject.Y_RADIUS);
				}
				System.out.println("Nodes size" + dataFile.nodes.size());
			}
		}
	}

	private void paintCoord(final Graphics2D g2d) {
		new OriginObject().draw(g2d);

	}

	private void paintGrid(final Graphics2D g2d) {
		GridObject grid = new GridObject(this);
		grid.draw(g2d);
	}
}
