/*
 * Cynthia C.
 * 15th April, 2020
 * sorting numbers
 */
package sorting;

import java.util.Random;
import java.util.Scanner;

public class SortingMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userChoice;
		int[] list = new int[100];
		int[] list2 = new int[100];
		
		//will loop until user wishes to exit
		do {
			System.out.println("1) selection sort\n2) insertion sort\n3) bubble sort\n4) exit");
			userChoice = input.nextInt();
			
			genArray(list);
			
			//sets the second list for the before sorting
			for(int t = 0; t < list.length; t++) {
				list2[t] = list[t];
			}
			
			//will choose an option based on userChoice
			if(userChoice == 1) {
				list = selection(list);
			}else if(userChoice == 2) {
				list = insertion(list);
			}else if(userChoice == 3) {
				list = bubble(list);
			}else if(userChoice == 4) {
				System.out.println("Bye!");			
			}else {
				System.out.println("That is not an acceptable choice\nPlease choose again");
			}
			
			//prints out the list before and after
			if(userChoice > 0 && userChoice < 4) {
				System.out.format("%s %s%n", "BEFORE SORT", "AFTER SORT");
				for(int i = 0; i < list.length; i++) {
					System.out.format("%7s %12s%n", list2[i], list[i]);
				}
			}
		}while(userChoice != 4);

	}
	
	/**
	 * will generate 100 random numbers between 1-1000
	 * will return the array
	 * @param list
	 * @return
	 */
	public static int[] genArray(int[] list) {
		Random r = new Random();
		
		//loops for the length of the array(100 times)
		for(int i = 0; i < list.length; i++) {
			list[i] = r.nextInt(1000 - 1) + 1;
		}
		
		return list;
	}
	
	/**
	 * will compare the first number in an array with every number 
	 * in the array until it finds one smaller than itself
	 * will then swap both those numbers
	 * returns the list
	 * @param list
	 * @return
	 */
	public static int[] selection(int[] list) {
		int minV, minI, swap = 0;
		
		//loops for the length of the array
		for(int i = 0; i < list.length; i++) {
			minV = list[i];
			minI = i;
			//loops for the length of the array to compare every number
			for(int j = i; j < list.length; j++) {
				//will change the minimum value if it finds one smaller than the first value in the array
				if(list[j] < minV) {
					minV = list[j];
					minI = j;
				}
			}
			//if the value is smaller than the first in the array it will swap the two numbers
			if(minV < list[i]) {
				swap = list[i];
				list[i] = list[minI];
				list[minI] = swap;
			}
		}
		
		return list;
	}
	
	/**
	 * will compare a number with all the ones to it's left
	 * if the one to the left is smaller it will swap them
	 * returns list
	 * @param list
	 * @return
	 */
	public static int[] insertion(int[] list) {
		int mc, swap, sk;
		
		//loops for the length of the array
		for(int i = 1; i < list.length; i++) {
			mc = list[i];
			sk = i - 1;
			//will loop until there are no more numbers to compare with or it has reached a number smaller than itself
			while(sk >= 0 && mc < list[sk]) {
				swap = list[sk];
				list[sk] = list[sk + 1];
				list[sk + 1] = swap;
				sk--;
			}
		}
		
		return list;
	}
	
	/**
	 * compares pairs of numbers next to each other
	 * the smaller # will move to the left
	 * with each loop through the array the one that ends up furthest right will be the largest
	 * so the array length will shorten one bc it doesn't need to check it anymore
	 * @param list
	 * @return
	 */
	public static int[] bubble(int[] list) {
		int swap = 0;
		
		//loops the length of the array - 1
		for(int i = 0; i < list.length - 1; i++) {
			//loops the length of the array subtract the number of spots the computer knows are correctly placed
			for(int j = 0; j < list.length - 1 - i; j++) {
				//will swap if one on left is higher
				if(list[j] > list[j + 1]) {
					swap = list[j];
					list[j] = list[j + 1];
					list[j + 1] = swap;
				}
			}
		}
		
		return list;
	}

}
