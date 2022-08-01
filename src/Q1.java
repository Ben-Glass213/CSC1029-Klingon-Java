
public class Q1 {

	public static void main(String[] args) {
		
		//Main method used for testing token types and booleans to see if they return the correct value
		
		TokenType op1 = getOp('+'); // token type op1 = the name of the token type. "= getOp('+');" is assigning + to the token type and getOp checks to see if it returns true or false
		System.out.println("op1: " + op1); // we print the results labelling op1 and printing the return value beside it
		
		TokenType op2 = getOp("==");	// this is done for all the values below to test if it works
		System.out.println("op2: " + op2);
		
		TokenType sym = getSymbol('{');
		System.out.println("symbol: " +sym);
		
		TokenType keyword = getKeyword("int");
		System.out.println("keyword: "+keyword);
		
		TokenType klingon = getKlingon("rltlh");
		System.out.println("klingon: " +klingon);
		
		boolean letter = isLetter('a');
		System.out.println("letter: " +letter);
		
		boolean digit = isDigit('0');
		System.out.println("digit: "+digit);
		
		boolean whiteSpace = isWhiteSpace(' ');
		System.out.println("whiteSpace: "+ whiteSpace);
		
		boolean newline = isLineBreak('\n');
		System.out.println("newline: "+newline);
		
		
		
	}

	public static TokenType getOp (char ch) { // method called getOp to find operators

		TokenType Op = null; // token type is not assigned 
		
		// list of if and else if statements to assign operators with a specific token type
		
		if (ch == '*') Op = TokenType.OP_MULTIPLY;
		
		else if (ch =='/')  Op = TokenType.OP_DIVIDE;
		 
		else if (ch =='%') Op = TokenType.OP_MOD;
		 
		else if (ch =='+') Op = TokenType.OP_ADD;
		
		else if (ch == '-')  Op = TokenType.OP_SUBTRACT;
		
		else if (ch == '<') Op = TokenType.OP_LESS;
		
		else if (ch =='>')  Op = TokenType.OP_GREATER;
		
		else if (ch == '=')  Op = TokenType.OP_ASSIGN;
		
		else if (ch == '!') Op = TokenType.OP_N;
		
			return Op; // return an assigned token type
		}
			
		public static TokenType getOp (String s) { 
			
			// list of if and else if statements to assign 2 character operators with a specific token type
			
			TokenType Op1 = null; // token type is not assigned 
			
			if (s == "<=") Op1 = TokenType.OP_LESSEQUAL;
			
			else if (s ==">=") Op1 = TokenType.OP_GREATEREQUAL;
			
			else if (s == "==") Op1 = TokenType.OP_EQUAL;
			
			else if (s== "!=") Op1 = TokenType.OP_NOTEQUAL;
			
			return Op1; // return an assigned token type 
			
			}
			
		public static TokenType getSymbol (char ch) {
			
			// list of if and else if statements to assign symbols to a specific token type
			
			TokenType sy = null; // token type is not assigned 
			
			if (ch == '(') sy = TokenType.LEFT_PAREN;
			
			else if (ch == ')') sy = TokenType.RIGHT_PAREN;
			
			else if (ch == '{') sy = TokenType.LEFT_BRACE;
			
			else if (ch == '}') sy = TokenType.RIGHT_BRACE;
			
			else if (ch == '[') sy = TokenType.LEFT_BRACKET;
			
			else if (ch == ']') sy = TokenType.RIGHT_BRACE;
			
			else if (ch ==';') sy = TokenType.SEMICOLON;

			else if (ch == ':') sy = TokenType.COLON;
			
			else if (ch == ',') sy = TokenType.COMMA;
			
			return sy;  // return an assigned token type
			
		}
		
		public static TokenType getKeyword (String s) {
			
			TokenType kw = null; // token type is not assigned  
			
			// list of if and else if statements to assign words to a specific token type
			
			if (s.equalsIgnoreCase ("if")) kw = TokenType.KEYWORD_IF;
			
			else if (s.equalsIgnoreCase ("else")) kw = TokenType.KEYWORD_ELSE;
			
			else if (s.equalsIgnoreCase ("int")) kw = TokenType.KEYWORD_INT;
			
			else if (s.equalsIgnoreCase ("String")) kw = TokenType.KEYWORD_STRING;
			
			else if (s.equalsIgnoreCase ("public")) kw = TokenType.KEYWORD_PUBLIC;
			
			else if (s.equalsIgnoreCase ("class")) kw = TokenType.KEYWORD_CLASS;
			
			else if (s.equalsIgnoreCase ("void")) kw = TokenType.KEYWORD_VOID;
			
			else if (s.equalsIgnoreCase ("static")) kw = TokenType.KEYWORD_STATIC;
			
			return kw; // return an assigned token type
		}
		
		public static TokenType getKlingon (String s) {
			
			TokenType kl = null; // token type is not assigned  
			
			// list of if and else if statements to assign words to a specific token type
			
			if (s.equalsIgnoreCase ("rltlh")) kl = TokenType.KLINGON_PRINT;
			
			else if (s.equalsIgnoreCase ("boq")) kl = TokenType.KLINGON_ADD;
			
			else if (s.equalsIgnoreCase ("boqha")) kl = TokenType.KLINGON_SUBTRACT;
			
			else if (s.equalsIgnoreCase ("boqegh")) kl = TokenType.KLINGON_MULTIPLY;
			
			else if (s.equalsIgnoreCase ("boqHaegh")) kl = TokenType.KLINGON_DIVIDE;
			
			return kl; // return an assigned token type
		}
		
		public static boolean isLetter (char ch) { 
			
			// method to check a letter
			
			if (ch >='a' && ch <='z') return true; // for non capital letters
			
			else if (ch >='A' && ch <='Z') return true; // for capital letters
			
			else return false; // if not a letter return false
			
			}
		
		public static boolean isDigit (char ch) {
			
			// method to check a digit
			
			if (ch >= '0' && ch <='9') return true; // digits range from 0 - 9 because a single integer character can be 0 - 1 as numbers will be added in the scan method to make a larger number
			
			else return false; // if not a number between 0 - 9 return false
			
			}
		
		public static boolean isWhiteSpace (char ch) {
			
			// method to check that a character is a space
			
			if (ch == ' ') return true; // if the character is a blank space return true
			
			else if (ch =='\t') return true; // if the character is a tab space ie pressing tab, return true 
			
			else return false; // else its not a space and return false
			
		}
		
		public static boolean isLineBreak (char ch) {
			
			// method to check that there is a line break
			
			if (ch =='\n') return true; //  \n = line break character therefore there is a check to say that if it is \n then return true
			
			else return false; // else if its not a line break return false
			
		}
		
	}
		
	


