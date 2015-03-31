package ru.sasik.postproc;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ru.sasik.entity.Zone;

public class PostprocCanvas extends JPanel {
	
	private static final long serialVersionUID = 3207166039085771573L;

	private static final int CANVAS_WIDTH = 1000;

	private static final int CANVAS_HEIGHT = 800;

	private static final Integer CONVERTER_DX = 70;

	private static final Integer CONVERTER_DY = -70;

	private static final Integer DX = 2 * CONVERTER_DX;

	private static final Integer DY = - 4 * CONVERTER_DY;

	private static final int POINT_RADIUS_Y = 3;

	private static final int POINT_RADIUS_X = 3;
	
	private PostprocState postprocState;
	
	public PostprocCanvas() {
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));	
	}
	public PostprocState getPostprocState() {
		return postprocState;
	}
	public void setPostprocState(PostprocState postprocState) {
		this.postprocState = postprocState;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if (postprocState == null)
			return;
		
		Graphics g2d = (Graphics2D) g;
		Zone currentZone = postprocState.getCurrentZone();
		System.out.println("PostprocCanvas.paintComponent() " + currentZone);
		for (ArrayList<Double> node : currentZone.getAll()) {
			g.drawOval(
					(int)((node.get(0) * CONVERTER_DX)  + DX), (int)((node.get(1) * CONVERTER_DY) + DY), POINT_RADIUS_X, POINT_RADIUS_Y);
		}
		
	}
	
	
	
	
}
