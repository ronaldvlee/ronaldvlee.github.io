import java.util.*;
public class ch8hw {
	//2b
	public static boolean n2b (String s){
		return s.endsWith("**");
	}
	//3
	public static String n3 (String s){
		return s.replace("-", "");
	}
	//4b
	public static String n4b(String s) {
		if (s.substring(0, 2).indexOf("/") != -1) 
			s = "0".concat(s); 
		if (s.substring(3, 5).indexOf("/") != -1) 
			s = s.substring(0, 3).concat("0" + s.substring(3));
		return String.format("%s-%s-%s", s.substring(3, 5), s.substring(0, 2), s.substring(6));
	}
	//5 a&b
	public static void n5ab (String ccNumber){
		ccNumber = ccNumber.replace(" ","");
		String last4 = ccNumber.substring(12);
		String last5 = ccNumber.substring(11);
	}
	//6
	public static String n6 (String s) {
		return s.substring(1) + s.substring(0,1);
	}
	//7
	public static String n7 (String s) {
		return s.substring(s.indexOf(",") + 2) + s.substring(0, s.indexOf(","));
	}
	//8
	public static String n8 (String zerosAndOnes) {
		return zerosAndOnes.replace("0", "o").replace("1", "l").replace("o", "1").replace("l", "0");
	}
	//9
	public static boolean n9 (String s){
		return s.equals(n6(s));
	}
	//10
	public static String n10 (String s) {
		int openingComment = s.indexOf("/*");
		int endingComment = s.indexOf("*/") + 2;
		if (openingComment == -1 || endingComment == 1) {
			return s;
		}
		return s.substring(0, openingComment) + s.substring(endingComment);
	}
	//12
	public static int n12 (String actualString, char check, int fromPos){
		for(int i = fromPos; i<actualString.length(); i++){
			if (actualString.charAt(i)==check)
				return i;
		}
		return -1;
	}
	//13
	public static boolean n13StartsWith(String toCheck, String prefix) {
		return toCheck.substring(0, prefix.length()).equals(prefix); 
	}
	public static boolean n13EndsWith(String toCheck, String suffix) {
		return toCheck.substring(toCheck.length()-suffix.length()-1, toCheck.length()).equals(suffix);
	}
	//14
	public static String n14(String s) {
		if (s.indexOf("<") != -1 && s.indexOf("</") != -1) 
			return s.substring(0, s.indexOf("<")) + s.substring(s.indexOf(">")+1,s.indexOf("</")) + s.substring(s.indexOf(">", s.indexOf("</")) + 1);
		return s;
	}
	//16
    public static void n16(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String s1 = kb.nextLine();
        System.out.print("Enter another number: ");
        String s2 = kb.nextLine();
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        kb.close();
        System.out.println("compareTo: "+ s1.compareTo(s2)+"\n"+"n1 - n2: "+ (n1-n2));
    }
	//17 validFileName
	public static String n17(String fileName) {
		if(fileName.indexOf(".")==-1) fileName += ".TXT";
		String copyOfFileName = fileName.substring(0, fileName.lastIndexOf("."));
		String type = fileName.substring(fileName.lastIndexOf(".")).length() == 1 ? "" : fileName.substring(fileName.lastIndexOf("."));
		if (type.length() <= 4 && (copyOfFileName.indexOf(".") + copyOfFileName.indexOf(":") + copyOfFileName.indexOf("?") + copyOfFileName.indexOf("*")) == -4) {
			return (copyOfFileName + type).toUpperCase();
		}
		return null;
	}
	//18ab isPalindrome
	public static boolean n18ab(String word) {
		word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String newWord = word;
		for(int i=0; i<word.length(); i++) {
			newWord = n6(newWord);
		}
		return word.equals(newWord);
	}
	//19
	public static void n19(){
		int numberOfGuesses = 0;
		Scanner kboard = new Scanner(System.in);
        System.out.println("Try to figure out what Cooney likes:\n");
        System.out.println("Cooney likes MOON but he doesn't like SUN");
        System.out.println("Cooney likes SOCCER but he doesn't like HOCKEY");
        System.out.println("Cooney likes SUMMER but he doesn't like SPRING\n");
		String word = "";
		boolean likes = false;
		while (numberOfGuesses != 5){
			System.out.print("Does Cooney like.. ");
			word = kboard.next().toUpperCase();
			likes = false;
			for (int i = 0; i < word.length() - 1; i++) {
				if (Character.toUpperCase(word.charAt(i)) == Character.toUpperCase(word.charAt(i + 1))){
					likes = true;
					break;
				}
			}
			if (likes) {
				numberOfGuesses++;
				System.out.println("Cooney does like "+word+"!");
			} else System.out.println("Cooney does not like "+word+"!");
		}
		System.out.println("I think you got the rule... I quit!\nThaanks forr pplaying!");
	}
	//20
    public static boolean n20(String isbn){
        int sum = 0;
        int counter = 0;
        for(int i = 0; i < isbn.length(); i++){
            if(Character.isDigit(isbn.charAt(i))){
                counter++;
                if(counter % 2 == 0){
                    sum += (int)isbn.charAt(i)*3;
                }else{
                    sum += (int)isbn.charAt(i);
                }    
            }
        }
        return (sum %10 == 0);
    }
}

