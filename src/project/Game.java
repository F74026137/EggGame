package project;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



abstract public class Game extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean running=false;
	static public int L_X=700,L_Y=300,S_X=500,S_Y=500; //視窗位置 尺寸
	
	void run(){
		running=true;				
		this.setVisible(true);
	}
	public boolean isRunning(){
		return running;
	}
	public void close(){
		this.dispose();		
		this.setVisible(false);		
		running=false;
	}
	abstract public String result();
	
	protected void setMouse(String route){
		Image img=null;
		try {
			img = ImageIO.read (new File(route));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Cursor cr =Toolkit.getDefaultToolkit().createCustomCursor(img, new Point(), "humer");
		
		this.setCursor(cr);
		
	}
	
	class W_Listener implements WindowListener {
		
		public void windowActivated(WindowEvent e) {
					
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			CheckWindow ch=new CheckWindow();
			ch.setVisible(true);			
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	class CheckWindow extends JFrame implements ActionListener{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;


		public CheckWindow(){
			setSize(250,150);
			setLocation(L_X+S_X/4,L_Y+S_Y/4);
			setLayout(new BorderLayout());									
			JLabel text=new JLabel(" 確定關閉? \n(未完成遊戲以失敗論)");
			text.setFont(new Font("SansSerif",Font.PLAIN ,15));
			add(text,BorderLayout.CENTER);
			
			JPanel button = new JPanel();
			button.setLayout(new FlowLayout());
			JButton exit=new JButton("離開");
			exit.setActionCommand("exit");
			
			JButton back=new JButton("返回");
			exit.setFont(new Font("SansSerif",Font.PLAIN,15));
			back.setFont(new Font("SansSerif",Font.PLAIN,15));
			back.setActionCommand("back");
			exit.addActionListener(this);
			back.addActionListener(this);
			
			button.add(exit);
			button.add(back);
			add(button,BorderLayout.SOUTH);
		}

		
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("exit")){
				close();						
				dispose();
			}
			else {
				dispose();
				
			
			}
			
		
			
		}

	}
}
