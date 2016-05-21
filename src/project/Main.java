package project;

public class Main {
	public static void main(String[] args){
		Ox ox=new Ox();
		ox.run();
		
		//System.out.println(ox.isRunning());
		//System.out.println(ox.result());
		while(ox.isRunning())try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
		ox.close();
		System.out.println(ox.result());
	}

}
