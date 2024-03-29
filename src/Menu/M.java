package Menu;
//import OX.*;

import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class M extends JFrame implements ActionListener{

	//OX.Ox p1 = new OX.Ox();
	private int flag = 0;
	JLabel label3,label1;
	
	public M(){
		//setExtendedState(Frame.MAXIMIZED_BOTH);	//Let frame be as big as windows
		setSize(1300,1000);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		
		ImageIcon img=new ImageIcon("img/main_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(1300, 1000);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		try{
			Scanner scanner = new Scanner(new FileInputStream("data/keep.txt"));
			PrintWriter pr=new PrintWriter(new FileOutputStream("bin/keep.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();
			
			scanner = new Scanner(new FileInputStream("data/fill.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/fill.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();
			scanner = new Scanner(new FileInputStream("data/save.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/save.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();scanner = new Scanner(new FileInputStream("data/money.txt"));
			pr=new PrintWriter(new FileOutputStream("bin/money.txt"));			
			while (scanner.hasNext()){
				pr.write(scanner.nextLine());
			}
			
			scanner.close();
			pr.flush();
			pr.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			Scanner scanner0 = new Scanner(new FileInputStream("bin/keep.txt"));
			int being = scanner0.nextInt();
			int which = scanner0.nextInt();
			int n1 = scanner0.nextInt();
			int n2 = scanner0.nextInt();
			int n3 = scanner0.nextInt();
			int n4 = scanner0.nextInt();
			int n5 = scanner0.nextInt();
			
			scanner0.close();
			
			//labels
//			Image img ;// ImageIO.read (new File("img/egg5.png"));
			ImageIcon icon ;// new ImageIcon(img);
			//JLabel label1 ;//= new JLabel(icon);
			
			if(being == 1){
//				img = ImageIO.read (new File("img/egg" + which + ".png"));
				icon = new ImageIcon("img/egg" + which + ".png");
				label1 = new JLabel(icon);
			}else{
				label1 = new JLabel();
				label1.setText("現在還沒有正在培養的蛋...");
			}
			label1.setBounds(100, 100, 300, 800); //(x,y,width,height)
			add(label1);
			
			icon = new ImageIcon(ImageIO.read(new File("img/money.png")));
			JLabel label2 = new JLabel(icon);
			label2.setBounds(10,0,72,71);
			add(label2);
			
			Scanner scanner = new Scanner(new FileInputStream("bin/money.txt"));
			String money = scanner.next();
			scanner.close();
			label3 = new JLabel();
			label3.setText(money);
			label3.setFont(new Font("標楷體", Font.BOLD, 48));
			label3.setBounds(92,0,150,75);
			add(label3);
			
			icon = new ImageIcon(ImageIO.read(new File("img/1.png")));
			JLabel label4 = new JLabel(icon);
			label4.setBounds(500,200,60,60);
			add(label4);
			icon = new ImageIcon(ImageIO.read(new File("img/2.png")));
			JLabel label5 = new JLabel(icon);
			label5.setBounds(500,270,60,60);
			add(label5);
			icon = new ImageIcon(ImageIO.read(new File("img/3.png")));
			JLabel label6 = new JLabel(icon);
			label6.setBounds(500,340,60,60);
			add(label6);
			icon = new ImageIcon(ImageIO.read(new File("img/4.png")));
			JLabel label7 = new JLabel(icon);
			label7.setBounds(500,410,60,60);
			add(label7);
			icon = new ImageIcon(ImageIO.read(new File("img/5.png")));
			JLabel label8 = new JLabel(icon);
			label8.setBounds(500,480,60,60);
			add(label8);
			
			if(being == 1){
				
				JLabel label9 = new JLabel();
				label9.setBounds(565,200,60,60);
				label9.setText(""+n1);
				label9.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label9);
				JLabel label10 = new JLabel();
				label10.setBounds(565,270,60,60);
				label10.setText(""+n2);
				label10.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label10);
				JLabel label11 = new JLabel();
				label11.setBounds(565,340,60,60);
				label11.setText(""+n3);
				label11.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label11);
				JLabel label12 = new JLabel();
				label12.setBounds(565,410,60,60);
				label12.setText(""+n4);
				label12.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label12);
				JLabel label13 = new JLabel();
				label13.setBounds(565,480,60,60);
				label13.setText(""+n5);
				label13.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label13);
				
				
			}
			
			
			
			
			//buttons
			icon = new ImageIcon(ImageIO.read(new File("img/cultivate.gif")));
			JButton button1 = new JButton(icon);
			button1.setBounds(750,100,300,90);
			button1.setActionCommand("btn1");
			button1.addActionListener(this);
			add(button1);
			
			icon = new ImageIcon(ImageIO.read(new File("img/depositary.gif")));
			JButton button2 = new JButton(icon);
			button2.setBounds(750,250,300,90);
			button2.setActionCommand("btn2");
			button2.addActionListener(this);
			add(button2);
			
			icon = new ImageIcon(ImageIO.read(new File("img/shop.gif")));
			JButton button3 = new JButton(icon);
			button3.setBounds(750,400,300,90);
			button3.setActionCommand("btn3");
			button3.addActionListener(this);
			add(button3);
			
			icon = new ImageIcon(ImageIO.read(new File("img/exit.gif")));
			JButton button4 = new JButton(icon);
			button4.setBounds(750,700,300,90);
			button4.setActionCommand("btn4");
			button4.addActionListener(this);
			add(button4);
			
			icon = new ImageIcon(ImageIO.read(new File("img/save.jpg")));
			JButton button5 = new JButton(icon);
			button5.setBounds(750,550,300,90);
			button5.setActionCommand("btn5");
			button5.addActionListener(this);
			add(button5);

			JButton button6 = new JButton();
			button6.setBounds(100,800,300,90);
			button6.setText("孵化");
			button6.setActionCommand("btn6");
			button6.addActionListener(this);
			add(button6);
			
			setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	public M(String name){
		//setExtendedState(Frame.MAXIMIZED_BOTH);	//Let frame be as big as windows
		setSize(1300,1000);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		ImageIcon img=new ImageIcon("img/main_b.jpg");
		JLabel bg=new JLabel(img);
		bg.setSize(1300, 1000);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		JPanel p= (JPanel)this.getContentPane();
		p.setOpaque(false);
		
		try {
			Scanner scanner0 = new Scanner(new FileInputStream("data/"+name+"/keep.txt"));
			int being = scanner0.nextInt();
			int which = scanner0.nextInt();
			int n1 = scanner0.nextInt();
			int n2 = scanner0.nextInt();
			int n3 = scanner0.nextInt();
			int n4 = scanner0.nextInt();
			int n5 = scanner0.nextInt();
			
			//labels
//			Image img ;// ImageIO.read (new File("img/egg5.png"));
			ImageIcon icon ;// new ImageIcon(img);
//			JLabel label1 ;//= new JLabel(icon);
			
			if(being == 1){
//				img = ImageIO.read (new File("img/egg" + which + ".png"));
				icon = new ImageIcon("img/egg" + which + ".png");
				label1 = new JLabel(icon);
			}else{
				label1 = new JLabel();
				label1.setText("現在還沒有正在培養的蛋...");
			}
			label1.setBounds(100, 100, 300, 800); //(x,y,width,height)
			add(label1);
			
			icon = new ImageIcon(ImageIO.read(new File("img/money.png")));
			JLabel label2 = new JLabel(icon);
			label2.setBounds(10,0,72,71);
			add(label2);
			
			Scanner scanner = new Scanner(new FileInputStream("data/"+name+"/money.txt"));
			String money = scanner.next();
			label3 = new JLabel();
			label3.setText(money);
			label3.setFont(new Font("標楷體", Font.BOLD, 48));
			label3.setBounds(92,0,150,75);
			add(label3);
			
			if(being == 1){
				icon = new ImageIcon(ImageIO.read(new File("img/1.png")));
				JLabel label4 = new JLabel(icon);
				label4.setBounds(500,200,60,60);
				add(label4);
				icon = new ImageIcon(ImageIO.read(new File("img/2.png")));
				JLabel label5 = new JLabel(icon);
				label5.setBounds(500,270,60,60);
				add(label5);
				icon = new ImageIcon(ImageIO.read(new File("img/3.png")));
				JLabel label6 = new JLabel(icon);
				label6.setBounds(500,340,60,60);
				add(label6);
				icon = new ImageIcon(ImageIO.read(new File("img/4.png")));
				JLabel label7 = new JLabel(icon);
				label7.setBounds(500,410,60,60);
				add(label7);
				icon = new ImageIcon(ImageIO.read(new File("img/5.png")));
				JLabel label8 = new JLabel(icon);
				label8.setBounds(500,480,60,60);
				add(label8);
				
				JLabel label9 = new JLabel();
				label9.setBounds(565,200,60,60);
				label9.setText(""+n1);
				label9.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label9);
				JLabel label10 = new JLabel();
				label10.setBounds(565,270,60,60);
				label10.setText(""+n2);
				label10.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label10);
				JLabel label11 = new JLabel();
				label11.setBounds(565,340,60,60);
				label11.setText(""+n3);
				label11.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label11);
				JLabel label12 = new JLabel();
				label12.setBounds(565,410,60,60);
				label12.setText(""+n4);
				label12.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label12);
				JLabel label13 = new JLabel();
				label13.setBounds(565,480,60,60);
				label13.setText(""+n5);
				label13.setFont(new Font("標楷體", Font.BOLD, 32));
				add(label13);
			}
			
			
			
			//buttons
			icon = new ImageIcon(ImageIO.read(new File("img/cultivate.gif")));
			JButton button1 = new JButton(icon);
			button1.setBounds(750,100,300,90);
			button1.setActionCommand("btn1");
			button1.addActionListener(this);
			add(button1);
			
			icon = new ImageIcon(ImageIO.read(new File("img/depositary.gif")));
			JButton button2 = new JButton(icon);
			button2.setBounds(750,250,300,90);
			button2.setActionCommand("btn2");
			button2.addActionListener(this);
			add(button2);
			
			icon = new ImageIcon(ImageIO.read(new File("img/shop.gif")));
			JButton button3 = new JButton(icon);
			button3.setBounds(750,400,300,90);
			button3.setActionCommand("btn3");
			button3.addActionListener(this);
			add(button3);
			
			icon = new ImageIcon(ImageIO.read(new File("img/exit.gif")));
			JButton button4 = new JButton(icon);
			button4.setBounds(750,700,300,90);
			button4.setActionCommand("btn4");
			button4.addActionListener(this);
			add(button4);
			
			icon = new ImageIcon(ImageIO.read(new File("img/save.jpg")));
			JButton button5 = new JButton(icon);
			button5.setBounds(750,550,300,90);
			button5.setActionCommand("btn5");
			button5.addActionListener(this);
			add(button5);

			JButton button6 = new JButton();
			button6.setBounds(100,800,300,90);
			button6.setText("孵化");
			button6.setActionCommand("btn6");
			button6.addActionListener(this);
			add(button6);
			
			setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}
	

	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
        if (cmd == "btn1") {
        	//new ChooseGame();
        	flag = 1;
      
        	
        	
        }else if(cmd == "btn2"){
    	    //new Depositary();
    	    flag = 7;
    	    //this.dispose();

        }else if(cmd == "btn3"){
        	
        	flag = 6;
        	//this.dispose();
        }else if(cmd == "btn5"){
       	  Save save=new Save(1300,1000,1);
       	  flag=0;
       	  
       }
        else if(cmd == "btn6"){
        	new Born();
        }else{
        	 System.exit(1);
        }

	}

	
	public int choose(){
		int f=flag;
		flag=0;
		return f;
	}
	
	public void setFlag(){
		flag=0;
	}
	
	public void setText(String str){
		label3.setText(str);
		try{
		Scanner scanner0 = new Scanner(new FileInputStream("bin/keep.txt"));
		int being = scanner0.nextInt();
		int which = scanner0.nextInt();
		scanner0.close();
		
		//labels
	//	Image img ;// ImageIO.read (new File("img/egg5.png"));
		ImageIcon icon ;// new ImageIcon(img);
		//JLabel label1 ;//= new JLabel(icon);
		
		if(being == 1){
			//img = ImageIO.read (new File("img/egg" + which + ".png"));
			label1.setText("");
			icon = new ImageIcon("img/egg"+which+".png");
			label1.setIcon(icon);
		}else{
			label1.setIcon(null);
			label1.setText("現在還沒有正在培養的蛋...");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}



