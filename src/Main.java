

public class Main {
	public static void main(String[] args){
		
		Game ox=new Quiz();
	
		ox.run();
	    ox.close();
	    System.out.println(ox.result());
	    
	    ox=new Reaction();
	    
	    ox.run();
	    ox.close();
	    System.out.println(ox.result());
	    
	    ox=new Ox();
	    ox.run();
	    ox.close();
	    System.out.println(ox.result());
	    
	}

}
