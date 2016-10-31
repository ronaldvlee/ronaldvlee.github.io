import java.util.*;
public class ch9hw{
	private enum Colors {
		BLACK,WHITE
	}
	//1a
		//int[] numbers = {1,2,4};
	//1b
	/*  int sum = 0;
		for(int i = 0; i < numbers.length; i++)
		{
			sum += int[i];
		}	 */
	//2b
		//true
	//4
	public boolean n4(int[] input){
		return input[0] == input[input.length-1];
	}
	//6
		//counts the number of consecutive 0s 
	//7
	public double[] n7(int a, int b, int c){
		double d = (b * b) - (4 * a * c);
		if(a == 0)
			throw new IllegalArgumentException("a = 0");
		if(d < 0)
			return null;
		else if(d == 0)
			return new double[] {-b/(2 * a)}; 
		else
			return new double[] {(-b + Math.sqrt((b * b) - (4 * a * c)))/(2 * a), (-b - Math.sqrt((b * b) - (4 * a * c)))/(2 * a)}; 
	}
	//8
	public double[] n8(int a, int b, int c){
		double d = (b * b) - (4 * a * c);//discriminant
		if(a == 0)
		{
			if(b == 0 && c == 0)
				throw new IllegalArgumentException("a = b = c = 0");
			if(b == 0 && c != 0)
				return null;
			else
				return new double[] {-c/b};
		}	
		if(d < 0)
			return null;
		else if(d == 0)
			return new double[] {-b / (2 * a)}; 
		else
			return new double[] {(-b + Math.sqrt((b * b) - (4 * a * c)))/(2 * a), (-b - Math.sqrt((b * b) - (4 * a * c)))/(2 * a)}; 	
	}
	//9
	public int[] n9(int m, int n){
		if(n > m){
			int dummy = n;
			n = m;
			m = dummy;
		}
		int a = (m*m)-(n*n);
		int b = 2*m*n;
		int c = (m*m)+(n*n);
		if(b < a){
			int dummy = a;
			a = b;
			b = dummy;
		}	
		return new int[] {a, b, c};
	}
	//10
	public int[] n10(int input)//createWedge
	{
		if(input < 1)
			throw new IllegalArgumentException("nah");
		int[] array = new int[(2 * input) - 1];
		for(int i = 1; i <= input; i++)//forwards up to n
			array[i - 1] = i;
		for(int i = 1; i < input; i++)//backwards from last to n-1 from the right
			array[array.length - i] = i;
		return array;
	}
	//11
	public int[] n11(int input){
		int[] output = new int[input];
		if(input > 0){
			output[0] = 0;
			if(input > 1)
				output[1] = 1;
		}
		if(input > 2)	
			for(int i = 2; i < input; i++)
				output[i] = output[i - 1] + output[i - 2];
		return output;	
	}
	//12
	public int n12(String word)//Scrabble
	{
		word = word.toUpperCase();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		int totalScore = 0;
		for(int i = 0; i < word.length(); i++)
			totalScore += points[alphabet.indexOf(word.charAt(i))];
		return totalScore;	
	}
	//15
	/* public void n15(Color[][] board)//fillCheckerboard
	{
		
	} */
	//18a
	public int n18a(int[] input){
		int sum = 0;
		for(int num: input)
			sum += num;
		return sum;
	}
	//19a
	public String[] n19a(String word){
		String[] allSubstrings = new String[0];
		for (int from = 0; from < word.length(); from++) {
			for (int to = from + 1; to <= word.length(); to++) {
				allSubstrings = Arrays.copyOf(allSubstrings, allSubstrings.length + 1);
				allSubstrings[allSubstrings.length - 1] = word.substring(from, to);
			}
		}
		return allSubstrings;
	}
	//19b
	/*public String[] n19b(String input){
		String[] allSubstrings = new String[0];
	}*/
	//20
	/*public void n20(int input){
		char[][] pascalTriangle = new char[n+1][(2*n)+1];
		for(char[] subArray : pascalTriangle)
		{
			subArray[0] = ' ';
			for(int i = 0; i < subArray.length-1; i++)
				
			subArray[subArray.length-1] = ' ';
		}	
	}*/
	//21
		//{"One", "Two", "Three"}
	//22
	public void n22(){
		char[] hello = {' ', 'h', 'e', 'l', 'l', 'o'};
		int i = 1;
		while(i < 6)
		{
			hello[i-1] = hello[i];
			i++;
		}	
		hello[5] = '!';
	}
	//23
	public boolean n23(double[] sample, double m){
		int lessThanCounter = 0;
		int greaterThanCounter = 0;
		for(double element: sample)
		{
			if(element > m)
				greaterThanCounter++;
			if(element < m)
				lessThanCounter++;
		}
		return lessThanCounter == greaterThanCounter;
	}
	//24a
	public void n24aLeft(int[] input){
		int[] placeHolder = new int[input.length];
		for(int i = 0; i < input.length - 1 ; i++)
		{
			placeHolder[i] = input[i+1];
		}
		placeHolder[placeHolder.length - 1] = input[0];
		input = placeHolder;
	}
	public void n24aRight(int[] input){
		int[] placeHolder = new int[input.length];
		for(int i = 0; i < input.length - 1 ; i++)
		{
			placeHolder[i+1] = input[i];
		}
		placeHolder[0] = input[input.length - 1];
		input = placeHolder;
	}
	//24b
	public void n24b(int[] input, int rotateBy){
		while(rotateBy < 0)//rotating by negative number to right is same as rotating that # + length to the right
			rotateBy += input.length;
		if(rotateBy >= input.length)//if it rotates more than the length, it makes a complete cycle.
			rotateBy %= input.length;
		int[] placeHolder = new int[input.length];
		for(int i = 0; i < rotateBy; i++)//takes the last rotateBy values in the input and moves them to the beginning of a new array 
			placeHolder[i] = input[input.length - rotateBy + i];
		for(int i = rotateBy; i < placeHolder.length; i++)//takes the values not picked up by the first loop and moves them to the right of the new array
			placeHolder[i] = input[i - rotateBy];
		input = placeHolder;//sets original array to result array
		//System.out.println(Arrays.toString(input)); //TEST
	}
}