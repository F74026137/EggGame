package project;

import javax.swing.JFrame;

abstract public class Game {
	protected boolean running=false;
	protected JFrame frame=new JFrame();
	void run(){
		running=true;				
		frame.setVisible(true);
	}
	public boolean isRunning(){
		return running;
	}
	public void close(){
		frame.dispose();		
		frame.setVisible(false);
		
	}
	abstract public String result();
	

}
