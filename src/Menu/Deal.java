package Menu;

import java.awt.event.*;
//import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class Deal extends JFrame implements ActionListener{
	
	JTextArea label = new JTextArea();
	String obj;
	int index;
	String[] wb = new String[8]; 
	JButton button1,button2,button3;
	int flag = 0;
	

	public Deal(String str,String[] data){
		
		index = Integer.parseInt(str);
		obj = data[index];
		
		int i;
		for(i = 0;i < 8;i++)	wb[i] = data[i];
		
		setSize(300,300);
		setLocation(500,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
			int num = scanner.nextInt();
			scanner.close();
			
			button1 = new JButton();
			button1.setText("販賣");
			button1.setBounds(0, 130, 140, 70);
			button1.setActionCommand("sell");
			button1.addActionListener(this);
			add(button1);
			
			button2 = new JButton();
			button2.setText("取出");
			button2.setBounds(140, 130, 140, 70);
			button2.setActionCommand("outside");
			button2.addActionListener(this);
			
			if((obj.substring(0,3)).equals("egg")){
				if(num == 0){
					add(button2);
				}
			}
			
			label.setBounds(0,0,300,140);
			add(label);
			
			button3 = new JButton();
			button3.setText("取消");
			button3.setBounds(0, 200, 300, 60);
			button3.setActionCommand("cancel");
			button3.addActionListener(this);
			add(button3);
			
			setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		
		if(cmd.equals("cancel")){
			flag = 1;
		}
		
		if(cmd.equals("sell")){
			//System.out.println("sell "+ obj);
			
			if((obj.substring(0,3)).equals("egg")){
				label.setText("已售出\n獲得NT10");
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setText("離開");
				
				try{
					Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
					int money = scanner.nextInt();
					scanner.close();
					
					PrintWriter writer0 = new PrintWriter(new FileOutputStream("bin/money.txt"));
					writer0.println(money+10);
					writer0.flush();
					writer0.close();
					
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/save.txt"));
					int i;
					for(i = 0;i < 8;i++)	if(i != index )writer1.print(" " + wb[i] + " ");
					writer1.flush();
					writer1.close();
					
					Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
					int fill = scanner2.nextInt();
					scanner2.close();
					
					PrintWriter writer2 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer2.println(fill-1);
					writer2.flush();
					writer2.close();

					
					
				}catch(FileNotFoundException e2){
					e2.printStackTrace();
				}
			}
			
		}
		
		if(cmd.equals("outside")){
			//System.out.println(obj.charAt(3));
			
				label.setText("已取出!");
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setText("離開");
				
				try{
					Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
					int money = scanner.nextInt();
					scanner.close();
					
					PrintWriter writer1 = new PrintWriter(new FileOutputStream("bin/save.txt"));
					int i;
					for(i = 0;i < 8;i++)	if(i != index )writer1.print(" " + wb[i] + " ");
					writer1.flush();
					writer1.close();
					
					Scanner scanner2 = new Scanner(new FileInputStream("bin/fill.txt"));
					int fill = scanner2.nextInt();
					scanner2.close();
					
					PrintWriter writer2 = new PrintWriter(new FileOutputStream("bin/fill.txt"));
					writer2.println(fill-1);
					writer2.flush();
					writer2.close();
					
					PrintWriter writer3 = new PrintWriter(new FileOutputStream("bin/keep.txt"));
					writer3.println("1\t" + obj.charAt(3) + "\t0\t0\t0\t0\t0\t0");
					writer3.flush();
					writer3.close();

					
				}catch(FileNotFoundException e2){
					e2.printStackTrace();
				}
			
		}
	
	}
	
	public int close(){
		return flag;
	}
}
