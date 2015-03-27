package ru.sasik.postproc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PostprocControllerPanel extends JPanel{
	
	
	protected static final int SPEED = 5;
	private PostprocCanvas postprocCanvas;
	private PostprocState postprocState;
	protected boolean isPlay;

	public PostprocControllerPanel(PostprocState postprocState, PostprocCanvas postprocCanvas) {
		this.postprocCanvas = postprocCanvas;
		this.postprocState = postprocState;
		
		
		createNextButton();
		createPlayButton();
		createStopButton();
		createResetButton();
		
	}

	private void createStopButton() {
		JButton btn = new JButton("Stop");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isPlay = false;
			}
		});
		add(btn);
	}

	private void createResetButton() {
		JButton btn = new JButton("Reset");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isPlay = false;
				postprocState.resetZoneIterator();;
				postprocCanvas.repaint();
			}
		});
		
		add(btn);
		
	}

	private void createPlayButton() {
		JButton btn = new JButton("Play");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isPlay = true;
					
					final Timer timer = new Timer ( 1000 / ( 10 * SPEED ), null );
					
					timer.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent ex) {
							postprocState.nextState();
							postprocCanvas.repaint();
							timer.setDelay ( 1000 / ( 10 * SPEED ) );
							if (!isPlay)
								timer.stop();
							
						}
					});
					
					timer.start();
				}
		});
		
		add(btn);
		
	}

	private void createNextButton() {
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				postprocState.nextState();
				postprocCanvas.repaint();
				
			}
		});
		
		add(nextBtn);
	}
}
