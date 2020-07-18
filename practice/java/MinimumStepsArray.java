/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		int min = findMin(arr, 0, 0);
		System.out.println(min);
	}
	
	public static int findMin(int[] arr, int index, int min) {
	    if (index == arr.length - 1) {
	        return min;
	    }
	    
	    if (arr[index] == 0) {
	        return Integer.MAX_VALUE;
	    }
	    
	    int maxStep = arr[index];
	    int newMin = Integer.MAX_VALUE;
	    for (int i = 1; i <= maxStep; i++) {
	        int temp = Integer.MAX_VALUE;
	        if (index + i < arr.length) {
	            temp = findMin(arr, index + i, min + 1);
	        }
	        
	        if (temp < newMin) {
	            newMin = temp;
	        }
	    }
	    
	    return (newMin == Integer.MAX_VALUE) ? Integer.MAX_VALUE : newMin;
	}
}
