package project;
import java.util.*;
import java.io.*;

public class Quiz_Create {
	static public void main(String[] args){
		String str;
		String[] exp;
		QuizForm quiz;
		ObjectOutputStream output;
		int n=0;
	try{
		Scanner in = new Scanner(new FileInputStream("bin/project/quiz.txt"));
		
		 while(in.hasNextLine()){
			 str=in.nextLine();
			 exp=str.split("0");
			 quiz=new QuizForm(exp[0],exp[1],exp[2],exp[3],exp[4]);
		
			 try{
				 output=new ObjectOutputStream(new FileOutputStream("quiz/"+n+".obj"));
				 output.writeObject(quiz);
				 output.flush();
				 output.close();
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 n++;
			 
		 }
		in.close();
	}catch(Exception e){
		e.printStackTrace();
		}
	
	
	}
}
