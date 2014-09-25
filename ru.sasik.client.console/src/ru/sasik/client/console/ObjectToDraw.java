package ru.sasik.client.console;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import javax.swing.JComponent;

public class ObjectToDraw extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2542118036219574503L;

	public ObjectToDraw(int x, int y, JComponent parent) {
		this.x = x;
		this.y = y;
	}

	private int x;
	
	private int y;

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		
		g2d.setColor(Color.red);
		
		g2d.drawOval(x, y, 5, 5);
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
