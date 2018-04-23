package hackerranck;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockString {
	
//	private String s = "aabbccddeefghi";
	
	static String isValid(String s) {
		
		String result = "";
		int count = 0;
		int[] occur = new int[s.length()];
		int[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		/*
		 * Get char occurence
		*/
		for(int i = 0; i < alpha.length; i++) {
			for(char ch : s.toCharArray()) {
				if(ch == alpha[i]) {
					count++;
				}
			}
			if(count != 0) {
				occur[i] = count;
				count = 0;
			}
		}
		
		int[] cleanedOccur = removeZeros(occur);
		
		/*
		 * Sort array
		*/
		Arrays.sort(cleanedOccur);
		
		int[] sortedArray = cleanedOccur.clone();
		int[] unduplicatedArray = removeDuplicate(cleanedOccur.clone());
		
		System.out.println(Arrays.toString(sortedArray));
		System.out.println(Arrays.toString(unduplicatedArray));
		
		if(unduplicatedArray[unduplicatedArray.length - 1] - unduplicatedArray[0] == 0) {
			// "abcd"
			result = "yes";
		} else if(unduplicatedArray[unduplicatedArray.length - 1] - unduplicatedArray[0] == 1) {
			// "abbccdd", "abccdd", "aabbccd"
			// [9,9,9,9,10], [9,10,10,10,10]
			if(sortedArray[0] == sortedArray[sortedArray.length - 2] || sortedArray[1] == sortedArray[sortedArray.length - 1]) {
				result = "yes";
			} else {
				result = "no";
			}
		} else if(unduplicatedArray[unduplicatedArray.length - 1] - unduplicatedArray[0] > 1) {
			// "abbbcccddd", "abbcccddd", "abccdddeeeee"
			if(sortedArray[sortedArray.length - 1] - sortedArray[1] == 0) {
				result = "yes";
			} else {
				result = "no";
			}
		}
		return result.toUpperCase();
	}
	
	/*
	 * Remove unnecessary 0 in array
	*/
	private static int[] removeZeros(int[] array) {
		int targetIndex = 0;
		for(int sourceIndex = 0; sourceIndex < array.length; sourceIndex++)
		{
		    if(array[sourceIndex] != 0 )
		        array[targetIndex++] = array[sourceIndex];
		}
		int[] newArray = new int[targetIndex];
		System.arraycopy(array, 0, newArray, 0, targetIndex);
		return newArray;
	}
	
	/*
	 * Remove duplicate number in array
	*/
	private static int[] removeDuplicate(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(i + 1 < a.length && a[i] == a[i + 1]) {
				a[i] = 0;
			}
		}
		int[] newArray = removeZeros(a);
		return newArray;
	}
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
	}
}
