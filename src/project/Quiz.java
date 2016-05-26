package project;
import java.awt.Color;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
public class Quiz extends Game implements ActionListener{
	private JTextPane question=new JTextPane();
	private JButton[] choice=new JButton[4];
	
	private JLabel time_v=new JLabel(),score_v=new JLabel();
	private int num=2,time=10,score=0,Q_n=10;
	private Boolean finish=false;
	private Font font=new Font("SansSerif",Font.ITALIC ,20);
	public String result(){
		String res="";
		if(score>(Q_n*2/3))res="Clear";
		else res="Failed";
		
		
		return res;
	}
	public Quiz(){
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		frame.setLayout(null);
		frame.setLocation(700, 300);
		frame.getContentPane().setBackground(Color.white);
		
		time_v.setText("Time:"+time);
		time_v.setSize(50,20);
		time_v.setLocation(350, 20);
		frame.add(time_v);
		
		score_v.setText("Score:"+score);
		score_v.setSize(50,20);
		score_v.setLocation(0, 0);
		frame.add(score_v);
		
		question.setLocation(100,50);
		question.setSize(200,100);
		question.setFont(font);
		frame.add(question);
		for(int i=0;i<4;i++){
			choice[i]=new JButton();
			choice[i].addActionListener(this);
			choice[i].setFont(font);
			choice[i].setSize(150,50);
			choice[i].setBackground(Color.white);
			choice[i].setLocation(150,200+i*50);
			frame.add(choice[i]);			
		}
		
	}
	
	
	public void run(){
		QuizForm quiz;
		
		for(int i=0;i<Q_n;i++){
		int n=(int)(Math.random()*1000)%num;
		int m=(int)(Math.random()*100)%4;
		try{
			
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream("quiz/"+n+".obj"));
		quiz=(QuizForm)oin.readObject();
		
		question.setText(quiz.getQuestion());
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
		frame.setVisible(true);
		try{
			for(int k=0;k<100;k++){
				if(finish){
					finish=false;
					break;
				}
				else Thread.sleep(100);
				if(k%10==0)time_v.setText("Time:"+time--);
			}
			
			}catch(Exception e){e.printStackTrace();}
		}
		
		frame.setVisible(false);
		
	}
	
	public void actionPerformed(ActionEvent e){
		time=10;
		time_v.setText("Time:"+time);
		finish=true;
		if(e.getActionCommand().equals("anser")){
			score++;
			score_v.setText("Score:"+score);
		}			
		
			}
}
