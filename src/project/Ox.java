package project;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Ox extends Game implements ActionListener{
	private boolean running=false;
	private JFrame frame=new JFrame();
	private ImageIcon em,img_o,img_x;
	private int turn=0,winner=0;
	private int[] map={0,0,0,0,0,0,0,0,0};
	JButton[] icon=new JButton[9];
	public Ox(){
		Image img=null;
		try {
			img = ImageIO.read (new File("img/e.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em=new ImageIcon(img);
		try {
			img = ImageIO.read (new File("img/O.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img_o=new ImageIcon(img);
		try {
			img = ImageIO.read (new File("img/X.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		img_x=new ImageIcon(img);
		
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		frame.setLayout(null);
		for(int i=0;i<9;i++){
		icon[i]=empty(i);
		icon[i].addActionListener(this);
		frame.add(icon[i]);
		icon[i].setActionCommand(""+i);
		}
		
	}
	
	public void run(){
		running=true;				
		frame.setVisible(true);
	//	while (running);
		while(running)try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
				
		
	}

	
	public void actionPerformed(ActionEvent e){
		int i =Integer.valueOf(e.getActionCommand());
		
		if(running){
		icon[i].setIcon(img_o);
		map[i]=1;
		turn++;
		checkEnd();
		ai_action();}						
		
	}
	private void ai_action(){
		if(running){
			
			
		int i=(int) (Math.random()*10)%9;
		while(map[i]!=0)i=(int) (Math.random()*10)% 9;
		for(int j=0;j<9;j+=3){
	        if(map[j]==map[j+1]){
	            if(map[j]!=0){
	            	if(map[j+2]==0)
	            		i=j+2;
	            }
	        }
	        else if (map[j]==map[j+2]){
	        	if(map[j]!=0){
	            	if(map[j+1]==0)
	            		i=j+1;
	            }
	        }
	        else if (map[j+1]==map[j+2]){
	        	if(map[j+1]!=0){
	            	if(map[j]==0)
	        		i=j;
	            }
	        }	        		
		}
		
		for(int j=0;j<3;j++){
	        if(map[j]==map[j+3]){
	            if(map[j]!=0){
	            	if(map[j+6]==0)
	            		i=j+6;
	            }
	        }
	        else if (map[j]==map[j+6]){
	        	if(map[j]!=0){
	            	if(map[j+3]==0)
	            		i=j+3;
	            }
	        }
	        else if (map[j+3]==map[j+6]){
	        	if(map[j+3]!=0){
	            	if(map[j]==0)
	        		i=j;
	            }
	        }	        		
		}
		
		if(map[0]==map[4]){
            if(map[0]!=0){
                if(map[8]==0)
                	i=8;
            }
        }
		if(map[0]==map[8]){
            if(map[0]!=0){
                if(map[4]==0)
                	i=4;
            }
        }
		if(map[4]==map[8]){
            if(map[4]!=0){
                if(map[0]==0)
                	i=0;
            }
        }
		if(map[2]==map[6]){
            if(map[2]!=0){
                if(map[4]==0)
                	i=4;
            }
        }
		if(map[2]==map[4]){
            if(map[2]!=0){
                if(map[6]==0)
                	i=6;
            }
        }
		if(map[4]==map[6]){
            if(map[4]!=0){
                if(map[2]==0)
                	i=2;
            }
        }
		
		map[i]=2;
		icon[i].setIcon(img_x);
		
		turn++;	
		checkEnd();}
		}
	
	
	private void checkEnd(){
		
		//橫向
		for(int i=0;i<9;i+=3){
	        if((map[i]==map[i+1])&&(map[i]==map[i+2])){
	            if(map[i]!=0){
	                winner=map[i];
	                running=false;
	                
	            }
	        }
	    }
		
		//縱向
		for(int i=0;i<3;++i){
	        if((map[i]==map[i+3])&&(map[i]==map[i+6])){
	            if(map[i]!=0){
	                winner=map[i];
	                running=false;
	            }
	        }
	    }
		//斜向
		
	        if((map[0]==map[4])&&(map[0]==map[8])){
	            if(map[0]!=0){
	                winner=map[0];
	                running=false;
	            }
	        }
	        if((map[2]==map[4])&&(map[2]==map[6])){
	            if(map[2]!=0){
	                winner=map[2];
	                running=false;
	            }
	        }
	    if(turn>8)running=false;
	   // if(!running)this.close();
		
		
	}
	
	
	
	private JButton empty(int m){

		int x,y;
		x=(m%3)*100;
		y=(m/3)*100;
		
		JButton icon=new JButton(em);
		icon.setLocation(100+x,100+y);
		icon.setSize(100,100);
		return icon;
	}
	

	public boolean isRunning(){
		return running;
	}
	public void close(){
		//frame.setVisible(false);
		frame.dispose();
		//System.out.println(result());
		frame.setVisible(false);
		
	}
	
	public String result(){
		String res="";
		switch(winner){
		case 0:
			res="Duse";
			break;
		case 1:
		res="Clear";
		break;
		case 2:
			res="Failed";
			break;
		}
		
		return res;
	}

}
