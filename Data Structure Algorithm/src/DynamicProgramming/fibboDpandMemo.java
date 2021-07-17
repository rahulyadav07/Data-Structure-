package DynamicProgramming;

import java.util.Scanner;

public class fibboDpandMemo {
	public static int memo(int n,int dp[]) {
		if(n==0 || n==1) {
			return n;
		}
		int ans1,ans2;
		if(dp[n-1]==-1) {
			ans1 = memo(n-1, dp);
			dp[n-1] = ans1;
		}
		else {
			ans1 = dp[n-1];
		}
		if(dp[n-2]==-1) {
			ans2 = memo(n-2, dp);
			dp[n-2] = ans1;
		}
		else {
			ans2 = dp[n-2];
		}
		int myans = ans1+ans2;
		return myans;
	}
	public static int dp(int n) {
		if(n==0 || n==1) {
			return n;
		}
		int[] dparray =new int[n+1];
		
		dparray[0] = 0;
		dparray[1] =1;
		for(int i =2;i<dparray.length;i++) {
			dparray[i] = dparray[i-1]+dparray[i-2];
		}
		return dparray[n];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n+1];
		for(int i=0;i<arr.length;i++) {
			arr[i] = -1;
		}
		
		int ans = memo(n, arr);
		int ans1 = dp(n);
		System.out.println(ans+" "+ans1);
		
	}

}
