package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class MaximumFrequency {
	public static int max(int arr[]) {
		HashMap<Integer, Integer> map  = new HashMap<>();
		for(int i:arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i, 1);
			}
		}
		int ans =0;
		int min = Integer.MIN_VALUE;
		for(int i:arr) {
			if(map.get(i)>min) {
				min=map.get(i);
				ans =i;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		 int arr[] = new int[s.nextInt()];
		 for(int i=0;i<arr.length;i++) {
			 arr[i] =s.nextInt();
		 }
		 System.out.println(max(arr));
	}

}
