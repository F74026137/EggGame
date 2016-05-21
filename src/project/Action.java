package project;
import java.awt.event.*;
import javax.swing.*;

public class Action implements ActionListener {
	int click_r=0;
	public void actionPerformed(ActionEvent e){
		
		switch(e.getActionCommand()){
		case "Re_c":
			click_r++;
			break;
		
			
		default:
			System.out.println(e.getActionCommand());
			break;
		}
	}

}
