package project;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import java.awt.event.*;

public class Quiz extends Game implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static public int TIME=10,Q_n=10; // TIME 倒數時間;Q_n 
	private JTextPane question=new JTextPane();
	private JButton[] choice=new JButton[4];
	public JButton exit=new JButton();
	private ImageIcon wrong,correct;
	private JLabel time_v=new JLabel(),score_v=new JLabel(),y_n=new JLabel();
	private int num,time=TIME,score=0;
	private Boolean finish=false;
	private Font font=new Font(Font.DIALOG,Font.BOLD ,20);
	private JPanel panel1;
	//private CheckWindow ch=new CheckWindow();
	
	public String result(){
		String res="";
		if(score>(Q_n*2/3))res="Clear";
		else res="Failed";
		
		
		return res;
	}
	public Quiz(){		
		this.name="Quiz";
		this.loop=true;
		this.setSize(S_X,S_Y);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);					
		this.setLayout(null);
		this.setLocation(L_X, L_Y);
		this.getContentPane().setBackground(Color.white);
		this.addWindowListener(new W_Listener());
		this.setResizable(false);		
		
		ImageIcon img=new ImageIcon("img/background.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(S_X, S_Y);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		try{
			Scanner in=new Scanner(new FileInputStream("quiz/num.txt"));
			num=in.nextInt();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		wrong=new ImageIcon("img/wrong.png");		
		correct=new ImageIcon("img/correct.png");		
		
		
		JPanel panel=new JPanel();	
		panel.setSize(500,20);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		time_v.setText("Time:"+time);
		time_v.setFont(font);
		time_v.setSize(100,20);
		time_v.setLocation(350,0);
		panel.add(time_v);
		
		score_v.setText("Score:"+score);
		score_v.setSize(100,20);
		score_v.setLocation(0, 0);
		score_v.setFont(font);
		panel.add(score_v);
		
		this.add(panel,BorderLayout.NORTH);
		
		question.setLocation(100,50);
		question.setSize(300,170);
		question.setFont(font);
		question.setEditable(false);
		question.setOpaque(false);
		this.add(question);
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setSize(300,200);
		panel1.setLocation(100, 200);
		
		
		for(int i=0;i<4;i++){
			choice[i]=new JButton();
			choice[i].addActionListener(this);
			choice[i].setFont(font);
			choice[i].setSize(300,50);
			choice[i].setVisible(false);
			choice[i].setLocation(0,0+i*50);
			choice[i].setContentAreaFilled(false);
			panel1.add(choice[i]);			
		}
		this.add(panel1);
		panel1.setOpaque(false);
		y_n.setLocation(200,200);
		y_n.setSize(100,100);
		y_n.setVisible(false);
		
		
		this.add(y_n);
		
		
	}
	
	
	public void run(){
		QuizForm quiz;
		running=true;
		this.setVisible(true);
		this.help();
		
		for(int i=0;i<4;i++)
		choice[i].setVisible(true);
		
		for(int i=0;i<Q_n;i++){
			if(!running)break;
			if(i>0){
				y_n.setVisible(true);
				panel1.setVisible(false);
				try{
					Thread.sleep(500);
					y_n.setVisible(false);
					panel1.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		int n=(int)(Math.random()*1000)%num;
		int m=(int)(Math.random()*100)%4;
		try{
			
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream("quiz/"+n+".obj"));
		quiz=(QuizForm)oin.readObject();
		
		question.setText("NO."+(i+1)+"\n"+quiz.getQuestion());
		if((i+1)==Q_n)question.setText(question.getText()+"\n 最後一題");
		for(int j=0,k=0;j<4;j++){
		
		if(j==m){
			choice[j].setText(quiz.getAanser());
			choice[j].setActionCommand("anser");
		}
		else {
			choice[j].setText(quiz.getChoice(k++));
			choice[j].setActionCommand("else");
		}
	
		}
		oin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			for(int k=0;k<100;k++){
				if(finish){
					finish=false;
					break;
				}
				else if(!running)break;
				else if(c_flag){
					while(c_flag)Thread.sleep(200);
				}
				else Thread.sleep(100);
				if(k%10==0)time_v.setText("Time:"+time--);
			}
			
			}catch(Exception e){e.printStackTrace();}
		time=TIME;
		}
		

		
	}
	
	void help(){
		String str="";
		try{
			Scanner in=new Scanner(new FileInputStream("help/"+name+".txt"));
			while(in.hasNext()){
			str=str.concat(in.nextLine());}
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JLabel back_h=new JLabel(new ImageIcon("img/"+name+"_h.jpg"));
		back_h.setSize(S_X/2, S_Y/2);
		back_h.setLocation(S_X/4,S_Y/5);
		back_h.setOpaque(true);
		JPanel frame=new JPanel();
		this.add(back_h,new Integer(Integer.MAX_VALUE));
		
		frame.setOpaque(false);
		frame.setSize(S_X/2, S_Y/2);
		frame.setLocation(S_X/4,S_Y/5);
		frame.setLayout(new BorderLayout());
		
		JTextPane text=new JTextPane();
		text.setSize(400,300);
		text.setEditable(false);
		text.setText(str);
		text.setOpaque(false);
		text.setFont(font);
		
		
		JButton btn=new JButton("OK");
		btn.setSize(50,40);
		btn.setContentAreaFilled(false);		
		btn.addActionListener(this);
		frame.add(text,BorderLayout.CENTER);
		frame.add(btn,BorderLayout.SOUTH);
		frame.setVisible(true);
		this.getLayeredPane().add(frame,new Integer(Integer.MAX_VALUE));
		try{
			while(loop){Thread.sleep(200);}
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setVisible(false);
		back_h.setVisible(false);
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("OK")){
			loop=false;
		}
		else{
		
		time=TIME;
		time_v.setText("Time:"+time);
		finish=true;
		if(e.getActionCommand().equals("anser")){
			score++;
			score_v.setText("Score:"+score);
			y_n.setIcon(correct);
		}
		else y_n.setIcon(wrong);
		
			}
	}
}
