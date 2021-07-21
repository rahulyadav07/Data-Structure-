package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence {
	public static int[] takeinutforArray() {
		Scanner s = new Scanner(System.in);
		int arr[] = new int[s.nextInt()];
		for(int i =0;i<arr.length;i++) {
			arr[i] = s.nextInt();

		}
		return arr;
	}

	public static ArrayList<Integer> consecutive(int arr[]){
		HashMap<Integer, Boolean> map = new HashMap<>();

		for(int i :arr) {
			map.put(i, true);

		}

		for(int i:arr) {
			if(map.containsKey(i-1)) {
				map.put(i, false);
			}
		}
		int start =0;
		int maxinum =0;
		for(int i:arr) {
			if(map.get(i)==true){
				int LocalLength	=1;
				int LocalStart = i;
				while(map.containsKey(LocalStart+LocalLength)) {
					LocalLength++;
				}
				if(LocalLength>maxinum) {
					start =i;
					maxinum = LocalLength;
				}
			} 
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =0;i<maxinum;i++) {
			list.add(start);
			start = start+1;
		}
		return list;
	}
	public static void main(String[] args){
		int arr1[] = takeinutforArray();
		ArrayList<Integer> list = consecutive(arr1);
		for(int i:list) {
			System.out.print(i+" ");
		}
	}

}
