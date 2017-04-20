import java.util.Scanner;

public class ISBNChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String isbn;
		
		//Get the ISBN
		System.out.println("Enter an ISBN: ");
		isbn = sc.nextLine();
		sc.close();
		
		//Strip out the spaces and dashes by replacing with empty char.
		isbn = isbn.replaceAll("( |-)", "");
		
		//Check depending on length.
		boolean isValid = false;
		if (isbn.length() == 10) {
			isValid = CheckISBN10(isbn);
		} else {
			isValid = false;
		}
		
		if (isValid) {
			System.out.println(isbn + " is a valid ISBN");
		} else {
			System.out.println(isbn + " is not a valid ISBN");
		}
	}

	private static boolean CheckISBN10(String isbn) {
		//Sum the digits times 10, 9, ..., 1.
		int sum = 0;
		String dStr;
		for (int d = 0; d < 10; d++) {
			dStr = isbn.substring(d, d+1);
			if (d < 9 ||  !dStr.equals("X")) {
				sum += Integer.parseInt(dStr) * (10 - d);
			} else {
				sum += 10;
			}
		}
		
		return (sum % 11 == 0);
	}

}
