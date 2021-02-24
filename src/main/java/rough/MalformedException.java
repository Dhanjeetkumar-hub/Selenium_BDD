package rough;

 public class MalformedException extends Exception{
	 public MalformedException(String s) {
		super(s); 
	 }
	 
 }
class Excep extends Exception{
	
	public static void main(String args[]) {
		
		try {
			
			throw new MalformedException("error occured");
		}
		catch(MalformedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}