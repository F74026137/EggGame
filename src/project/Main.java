package project;

public class Main {
	public static void main(String[] args){
		
		Game ox=new Quiz();
	
		ox.run();
		
		//System.out.println(ox.isRunning());
		//System.out.println(ox.result());
		//while(ox.isRunning())try{Thread.sleep(200);}catch(Exception e){e.printStackTrace();};
		//ox.close();
	    //System.out.println(ox.result());
	    
	    //ox=new Reaction();
	    //ox.run();
	    ox.close();
	    System.out.println(ox.result());
	}

}
