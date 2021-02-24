package rough;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Diamond {
	
	public static void main(String args[]) {
	diamond(5);
}
	// printing diamond 
	public static void diamond(int n) {
		int space=n-1;
		for(int i=0;i<n;i++) {
			for(int j=0; j<space;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			space--;
			System.out.print("\n");
		}
		space =0;
		for(int i=n;i>0;i--) {
			for(int j=0;j<space;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.print("\n");
			space++;
		}
		
	}
}
