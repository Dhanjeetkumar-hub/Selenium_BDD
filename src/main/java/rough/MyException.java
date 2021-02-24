package rough;

 class MyException extends Exception {
   
	 public MyException(String s) {
		 super(s);
	 }
	
	
}
 
 class Except{
	 public static void main(String args[]) {
		 
		 try {
			 throw new MyException("error occured");
			 
		 }
		 catch(MyException e) {
			 System.out.println(e.getMessage());
			 e.printStackTrace();
		 }
	 }
	 
 }
