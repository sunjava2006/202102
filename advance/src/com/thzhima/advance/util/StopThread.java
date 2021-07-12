package com.thzhima.advance.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class StopThread extends JFrame {
	Thread t ;
	public StopThread() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width/2;
		int height = d.height/2;
		this.setSize(width, height);
		
		
		JPanel panel = new JPanel(null);
		this.setContentPane(panel);
		
		JButton btnStart = new JButton("开始");
		btnStart.setSize(80, 60);
		btnStart.setLocation(100, 100);
		panel.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProgressDialog pd = new ProgressDialog(0, 100);
				 t = new Thread() {
					public void run() {
						
						
						for(int i=0;i<100;i++ ) {
							t.interrupt();
							if(Thread.interrupted()) {
								System.out.println(t.isInterrupted());
								System.out.println("检测到打断标记。");
								break;
							}
							pd.bar.setValue(i);
							System.out.println(i);
//							try {
//								Thread.sleep(100);
//							} catch (InterruptedException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//								break;
//							}
						}
						pd.setVisible(false);
					}
				};
				
				t.start();
			}
		});
		
		JButton btnStop = new JButton("stop");
		btnStop.setSize(80, 60);
		btnStop.setLocation(200, 100);
		panel.add(btnStop);
		
		btnStop.addActionListener((e)->{
			t.interrupt();
		});
		
		this.setLocation((d.width-width)/2, (d.height-height)/2);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		StopThread st = new StopThread();
	}
}


class ProgressDialog extends JDialog{
	JProgressBar bar = null;
	ProgressDialog(int min, int max){
		this.setSize(500, 500);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocation((d.width-500)/2, (d.height-500)/2);
		
		JPanel panel = new JPanel(null);
		this.setContentPane(panel);
		
		bar = new JProgressBar(min, max);
		bar.setSize(400, 30);
		bar.setLocation(50, 100);
		
		panel.add(bar);
		
//		this.setModal(true);
		this.setVisible(true);
		
	}
	
	
}