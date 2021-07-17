package DynamicProgramming;

import java.util.Scanner;

public class MinStep {
	public static int minstep(int n) {
		if(n==0 ||n==1) {
			return 0;
		}
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
		int ans1 = minstep(n-1);
		if(n%2==0) {
			ans2 = minstep(n/2);
		}	
		if(n%3==0) {
			ans3 =minstep(n/3);
		}
		int min = 1+Math.min(ans2, Math.min(ans1,ans3));
		return min;
	}
	public static int memo(int n,int[] dp) {
		if(n==0 || n==1) {
			return 0;
		}
		int ans1;
		if(dp[n-1]==-1) {
		ans1= memo(n-1, dp);
		dp[n-1] = ans1;
		}
		else {
			ans1 = dp[n-1];
		}
		int ans2 =Integer.MAX_VALUE;
		
		if(n%2==0) {
			if(dp[n/2]==-1) {
				ans2 = memo(n/2, dp);
			dp[n/2]=ans2;
			}
			else {
			ans2 =dp[n/2];
		}
		}
		
		int ans3 = Integer.MAX_VALUE;
		
		if(n%3==0) {
			if(dp[n/3]==-1) {
				ans3 = memo(n/3, dp);
			dp[n/3] = ans3;
			}
			else {
			ans3 =dp[n/3];
		}
		}
		
		int myans = Math.min(ans1, Math.min(ans2, ans3));
		return myans+1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		int ans =minstep(n);
		System.out.println(ans);
		int[] dp = new int[n+1];
		for(int i =0;i<dp.length;i++) {
			dp[i] =-1;
		}
		System.out.println(memo(n,dp)); 
	}
}
