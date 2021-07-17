import java.util.Scanner;
public class jaggedArray {
	


	public static void main(String[] args) {
		// Write your code here
Scanner sc =new Scanner(System.in);
        int  n=sc.nextInt();
        int rev=0;
        while(n!=0)
        {
            int m=n%10;
          
            if(m!=0)
            {
                rev=rev*10+m;
                
            }     
            n=n/10;
        }  
        System.out.println(rev);
        }
}



