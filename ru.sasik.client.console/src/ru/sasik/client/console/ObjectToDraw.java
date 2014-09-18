package ru.sasik.client.console;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.TransferHandler;

public class ObjectToDraw extends JComponent {
	
	public ObjectToDraw(int x, int y) {
		this.x = x;
		this.y = y;
		addMouseListener(new DragMouseAdapter());
		setTransferHandler(new TransferHandler("point"));
		setPreferredSize(new Dimension(10, 10));;
	}

	private int x;
	
	private int y;

	@Override
	protected void paintComponent(Graphics arg0) {
		Graphics2D g2d = (Graphics2D) arg0;
		
		g2d.drawOval(x, y, 3, 3);
	}
	
	
	class DragMouseAdapter extends MouseAdapter {

//		@Override
//		public void mousePressed(MouseEvent e) {
//			
//			System.out.println(e.getSource());
//			JComponent c = (JComponent) e.getSource();
//			TransferHandler handler = c.getTransferHandler();
//			handler.exportAsDrag(c, e, TransferHandler.COPY);
//		}
		
		
	}

}
