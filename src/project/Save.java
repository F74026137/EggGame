package project;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.PrintWriter;
import java.util.Scanner;


import javax.swing.*;


public class Save extends JFrame{
	private JFrame load_f,save_f;
	private int state;
	private boolean loop=true;
	JTextField name = new JTextField(
			"Your name here", 30);
	public Save(int s_x,int s_y,int type){
		
		ImageIcon img=new ImageIcon("img/main_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(500, 500);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		this.setSize(500,500);
		if(type==0)this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		else this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		this.setLayout(null);
		this.setLocation(s_x/4, s_y/4);
		this.getContentPane().setBackground(Color.white);
		
		JButton button1 = new JButton();
		button1.setSize(300,90);
		button1.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button1.setLocation(100,165);
		button1.setIcon(new ImageIcon("img/save.jpg"));
		button1.setActionCommand("save");
		button1.addActionListener(new Click_on());
		button1.setContentAreaFilled(false);
		button1.setOpaque(false);
		if(type==1)this.add(button1);
		
		JButton button2 = new JButton();
		button2.setSize(300,90);
		button2.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button2.setLocation(100,315);
		button2.setIcon(new ImageIcon("img/load.jpg"));
		button2.setActionCommand("load");
		button2.addActionListener(new Click_on());
		button2.setContentAreaFilled(false);
		button2.setOpaque(false);
		
		this.add(button2);
		
		JButton button3 = new JButton();
		button3.setSize(300,90);
		button3.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		button3.setLocation(100,15);
		button3.setIcon(new ImageIcon("img/newgame.jpg"));
		button3.setActionCommand("newgame");
		button3.addActionListener(new Click_on());
		button3.setContentAreaFilled(false);
		button3.setOpaque(false);
		if(type==0)this.add(button3);
		
		load_f=new JFrame();
		load_f.setSize(500,500);
		load_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		load_f.setLayout(null);
		load_f.setLocation(s_x/4, s_y/4);
		load_f.getContentPane().setBackground(Color.white);
		
		save_f=new JFrame();
		save_f.setSize(500,500);
		save_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);					
		save_f.setLayout(null);
		save_f.setLocation(s_x/4, s_y/4);
		save_f.getContentPane().setBackground(Color.white);
		
		
		JButton btn1 = new JButton(new ImageIcon("img/new.jpg"));
		JButton btn2 = new JButton(new ImageIcon("img/existed.jpg"));
		btn1.addActionListener(new Click_on());
		btn2.addActionListener(new Click_on());
		btn1.setActionCommand("new");
		btn2.setActionCommand("exist");
		btn1.setLocation(100,315);
		btn2.setLocation(100,165);
		btn1.setSize(300,90);
		btn2.setSize(300,90);
		
		JPanel panel = new JPanel();
		panel.setSize(500,500);
		panel.setLocation(0,0);
		panel.setLayout(null);
		panel.add(btn1);
		panel.add(btn2);
		
		JButton btn3=new JButton(new ImageIcon("img/ok.jpg"));
		btn3.setSize(300,90);
		btn3.setLocation(100,165);
		btn3.addActionListener(new Click_on());
		btn3.setActionCommand("OK");
		
		name = new JTextField("", 30);
		name.setLocation(100,15);
		name.setSize(300,50);
		name.setFont(new Font(Font.DIALOG,Font.BOLD ,32));
		
		load_f.add(btn3);
		save_f.add(btn1);
		save_f.add(btn2);
		
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	static void save(String name){
	
		
		
		try{
		Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
		PrintWriter pr=new PrintWriter(new FileOutputStream("data/"+name+"/keep.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		scanner = new Scanner(new FileInputStream("bin/money.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/money.txt"));
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/fill.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/fill.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/save.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/save.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static void new_save(String name){
		
		File file =new File("data/"+name);
		file.mkdirs();
		
		
		try{
		Scanner scanner = new Scanner(new FileInputStream("bin/keep.txt"));
		PrintWriter pr=new PrintWriter(new FileOutputStream("data/"+name+"/keep.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		scanner = new Scanner(new FileInputStream("bin/money.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/money.txt"));
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/fill.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/fill.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		scanner = new Scanner(new FileInputStream("bin/save.txt"));
		pr=new PrintWriter(new FileOutputStream("data/"+name+"/save.txt"));			
		while (scanner.hasNext()){
			pr.write(scanner.nextLine());
		}
		
		scanner.close();
		pr.flush();
		pr.close();
		
		
		pr=new PrintWriter(new FileOutputStream("data/ID",true));
		pr.print(name+"\t");
		pr.flush();
		pr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	static void load(String name){
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/"+name+"/keep.txt"));
			PrintWriter pr=new PrintWriter(new FileOutputStream("bin/keep.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();
			
			
			scanner = new Scanner(new FileInputStream("data/"+name+"/money.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/money.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
			
			scanner = new Scanner(new FileInputStream("data/"+name+"/fill.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/fill.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
		
			scanner = new Scanner(new FileInputStream("data/"+name+"/save.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/save.txt"));				
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			scanner.close();
			pr.flush();
			pr.close();
			
			}catch(Exception e){
				e.printStackTrace();
			}
		
		
	}
	public M getM(){
		M m=null ;
		try{
			while(loop){Thread.sleep(100);}
		switch(state){
		case 0:
			 m=new M();
			 break;
		case 1:
			m= new M(name.getText());
			break;
		default:
			m=new M();
			break;
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dispose();
		return m;
	}
	
	class Click_on implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			switch(e.getActionCommand()){
			case "save":
				save_f.add(name);
				save_f.setVisible(true);
				break;
			case "load":
				load_f.add(name);
				load_f.setVisible(true);
				break;
			case "newgame":
				state=0;
				loop=false;
				break;
			case "exist":
				save(name.getText());
				save_f.setVisible(false);
				break;
			case "OK":
				System.out.println(0);
				try{
					Scanner scanner = new Scanner(new FileInputStream("data/ID"));
					while(scanner.hasNext()){
						if(name.getText().equals(scanner.next())){
							load(name.getText());
							state=1;
							load_f.setVisible(false);
							loop=false;
						}
						else {
							new mes();
						}
					}
					scanner.close();
				}catch(Exception m){
					m.printStackTrace();
				}
				break;
			case "new":
				new_save(name.getText());
				save_f.setVisible(false);
				break;
			
			}
			
			

		}
		
		
		
	}
	
	
	class mes extends JFrame{
		
		public mes(){
			this.setSize(150,100);
			JLabel lab=new JLabel("紀錄不存在");
			lab.setSize(getPreferredSize());
			lab.setFont(new Font(Font.DIALOG,Font.BOLD ,20));
			this.add(lab);
		}
	}
}
