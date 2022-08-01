
public class Q1Tester {

	public static void main(String[] args) {

		// below are a test cases of each of Question 1's methods. 

		System.out.println("== Test Case 1 =="); // name of the test case printed
		getSymbol_ReturnNotNull(); // call the method from below which returns what I told it to return.
		System.out.println("\n== Test Case 2 ==");
		getSymbol_ReturnNull();
		System.out.println("\n== Test Case 3 ==");
		getOp_ReturnNotNull();
		System.out.println("\n== Test Case 4 ==");
		getOp_ReturnNull();
		System.out.println("\n== Test Case 5 ==");
		getKeyword_ReturnNotNull();
		System.out.println("\n== Test Case 6 ==");
		getKeyword_ReturnNull();
		System.out.println("\n== Test Case 7 ==");
		getKlingon_ReturnNotNull();
		System.out.println("\n== Test Case 8 ==");
		getKlingon_ReturnNull();
		System.out.println("\n== Test Case 9 ==");
		isLetter_ReturnTrue();
		System.out.println("\n== Test Case 10 ==");
		isLetter_ReturnFalse();
		System.out.println("\n== Test Case 11 ==");
		isDigit_ReturnTrue();
		System.out.println("\n== Test Case 12 ==");
		isDigit_ReturnFalse();
		System.out.println("\n== Test Case 13 ==");
		isWhiteSpace_ReturnTrue();
		System.out.println("\n== Test Case 14 ==");
		isWhiteSpace_ReturnFalse();
		System.out.println("\n== Test Case 15 ==");
		isLineBreak_ReturnTrue();
		System.out.println("\n== Test Case 16 ==");
		isLineBreak_ReturnFalse();
		System.out.println("\n== Test Case 17 ==");
		getOp2_ReturnNotNull();
		System.out.println("\n== Test Case 18 ==");
		getOp2_ReturnNull();
	}

	public static void getSymbol_ReturnNotNull () {
		TokenType t = Q1.getSymbol(',');	// here we create a method and name the token type t. we then check that the char ',' returns a value from question 1's getSymbols method
		System.out.println(t); // we then print what is returned from the method in question 1
		System.out.println("Expect: " + TokenType.COMMA); // print what we expect the result to be 
	}
	public static void getSymbol_ReturnNull () {
		TokenType t = Q1.getSymbol('a');
		System.out.println(t);
		System.out.println("Expect: " + null);
	}
	public static void getOp_ReturnNotNull () {
		TokenType t = Q1.getOp('+');
		System.out.println(t);
		System.out.println("Expect: " + TokenType.OP_ADD);
	}
	public static void getOp_ReturnNull () {
		TokenType t = Q1.getOp('a');
		System.out.println(t);
		System.out.println("Expect: " + null);
	}
	public static void getKeyword_ReturnNotNull () {
		TokenType t = Q1.getKeyword("else");
		System.out.println(t);
		System.out.println("Expect: " + TokenType.KEYWORD_ELSE);
	}
	public static void getKeyword_ReturnNull () {
		TokenType t = Q1.getKeyword("a");
		System.out.println(t);
		System.out.println("Expect: " + null);
	}
	public static void getKlingon_ReturnNotNull() {
		TokenType t = Q1.getKlingon("rltlh");
		System.out.println(t);
		System.out.println("Expected: "  + TokenType.KLINGON_PRINT);
	}
	public static void getKlingon_ReturnNull() {
		TokenType t = Q1.getKlingon("a");
		System.out.println(t);
		System.out.println("Expected: " + null);
	}
	public static void isLetter_ReturnTrue() {
		boolean t = Q1.isLetter('A');
		System.out.println(t);
		System.out.println("Expected: " + true);
	}
	public static void isLetter_ReturnFalse() {
		boolean t = Q1.isLetter('1');
		System.out.println(t);
		System.out.println("Expected: " + false);
	}
	public static void isDigit_ReturnTrue() {
		boolean t = Q1.isDigit('5');
		System.out.println(t);
		System.out.println("Expected: " + true);
	}
	public static void isDigit_ReturnFalse() {
		boolean t = Q1.isDigit('a');
		System.out.println(t);
		System.out.println("Expected: "+ false);
	}
	public static void isWhiteSpace_ReturnTrue() {
		boolean t = Q1.isWhiteSpace(' ');
		System.out.println(t);
		System.out.println("Expected: " + true);
	}
	public static void isWhiteSpace_ReturnFalse() {
		boolean t = Q1.isWhiteSpace('1');
		System.out.println(t);
		System.out.println("Expected: " + false);
	}
	public static void isLineBreak_ReturnTrue() {
		boolean t = Q1.isLineBreak('\n');
		System.out.println(t);
		System.out.println("Expected: " + true);
	}
	public static void isLineBreak_ReturnFalse() {
		boolean t = Q1.isLineBreak('1');
		System.out.println(t);
		System.out.println("Expected: " + false);
	}
	public static void getOp2_ReturnNotNull() {
		TokenType t = Q1.getOp(">=");
		System.out.println(t);
		System.out.println("Expected: " + TokenType.OP_GREATEREQUAL);
	}
	public static void getOp2_ReturnNull() {
		TokenType t = Q1.getOp("aa");
		System.out.println(t);
		System.out.println("Expected: " + null);
	}
}
















