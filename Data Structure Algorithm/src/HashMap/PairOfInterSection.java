package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class PairOfInterSection {
	public static void intersection(int[] arr1, int[] arr2) {
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for(int i :arr1) {
	    	if(map.containsKey(i)) {
	    		map.put(i, map.get(i)+1);
	    		
	    	}
	    	else {
	    		map.put(i, 1);
	    	}
	    }
	    for(int i:arr2) {
	    	if(map.containsKey(i)) {
	    		System.out.print(i + " ");
	    		map.put(i, map.get(i)-1);
	    		if(map.get(i)==0) {
	    			map.remove(i);
	    		}
	    	}
	    }
	}
	public static int[] takeinutforArray() {
		Scanner s = new Scanner(System.in);
		int arr[] = new int[s.nextInt()];
		for(int i =0;i<arr.length;i++) {
			arr[i] = s.nextInt();
			
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr1[] = takeinutforArray();
		int arr2[] = takeinutforArray();
		intersection(arr1, arr2);
	}
}
