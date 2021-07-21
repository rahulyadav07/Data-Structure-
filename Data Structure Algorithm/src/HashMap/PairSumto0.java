package HashMap;

import java.util.HashMap;
import java.util.Scanner;
// 9368923542
// 
public class PairSumto0 {
	public static int pairSumtoZero(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count =0;
		for(int i:arr) {
			if( map.containsKey(i)) {
				map.put(i, map.get(i)+1);
				}
			else {
				map.put(i, 1);
			}
		}
		for(int i : arr) {
			int time;
			if(map.containsKey(i) && map.get(i)!=0) {
				if(i==(-i)) {
				int occuren = map.get(i);
				time = (occuren*(occuren-1))/2;
				count = count+time;
				map.put(i,0);
				}
				 
			}
		}
		//traversing on array and checking if -key is present in HashMap or not
		return count;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[] = new int[s.nextInt()];
		for(int i=0;i<arr.length;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(pairSumtoZero(arr));
	}
}
