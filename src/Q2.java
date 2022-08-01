import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q2 {

	public static void main(String[] args) {
		
		String prog = readFile2String("src/KlingonExample.txt");
		scan(prog);
		
		
	}

	public static TokenType getOp (char ch) {

		TokenType Op = null;
		
		if (ch == '*') Op = TokenType.OP_MULTIPLY;
		
		else if (ch =='/')  Op = TokenType.OP_DIVIDE;
		 
		else if (ch =='%') Op = TokenType.OP_MOD;
		 
		else if (ch =='+') Op = TokenType.OP_ADD;
		
		else if (ch == '-')  Op = TokenType.OP_SUBTRACT;
		
		else if (ch == '<') Op = TokenType.OP_LESS;
		
		else if (ch =='>')  Op = TokenType.OP_GREATER;
		
		else if (ch == '=')  Op = TokenType.OP_ASSIGN;
		
		else if (ch == '!') Op = TokenType.OP_N;
		
			return Op;
		}
			
		public static TokenType getOp (String s) { 
			
			TokenType Op1 = null;
			
			if (s == "<=") Op1 = TokenType.OP_LESSEQUAL;
			
			else if (s ==">=") Op1 = TokenType.OP_GREATEREQUAL;
			
			else if (s == "==") Op1 = TokenType.OP_EQUAL;
			
			else if (s== "!=") Op1 = TokenType.OP_NOTEQUAL;
			
			return Op1; 
			
			}
			
		public static TokenType getSymbol (char ch) {
			
			TokenType sy = null;
			
			if (ch == '(') sy = TokenType.LEFT_PAREN;
			
			else if (ch == ')') sy = TokenType.RIGHT_PAREN;
			
			else if (ch == '{') sy = TokenType.LEFT_BRACE;
			
			else if (ch == '}') sy = TokenType.RIGHT_BRACE;
			
			else if (ch == '[') sy = TokenType.LEFT_BRACKET;
			
			else if (ch == ']') sy = TokenType.RIGHT_BRACE;
			
			else if (ch ==';') sy = TokenType.SEMICOLON;

			else if (ch == ':') sy = TokenType.COLON;
			
			else if (ch == ',') sy = TokenType.COMMA;
			
			return sy;
			
}
		
		public static TokenType getKeyword (String s) {
			
			TokenType kw = null;
			
			if (s.equalsIgnoreCase ("if")) kw = TokenType.KEYWORD_IF; // couldn't use a standard (s == "if") as it wouldn't work with my keyword and klingon statements in the scan method therefore
 																	// therefore used .equalsIgnoreCase to remove the issue of it being case sensitive causing the method not to work and now it works
			else if (s.equalsIgnoreCase ("else")) kw = TokenType.KEYWORD_ELSE;
			
			else if (s.equalsIgnoreCase ("int")) kw = TokenType.KEYWORD_INT;
			
			else if (s.equalsIgnoreCase ("String")) kw = TokenType.KEYWORD_STRING;
			
			else if (s.equalsIgnoreCase ("public")) kw = TokenType.KEYWORD_PUBLIC;
			
			else if (s.equalsIgnoreCase ("class")) kw = TokenType.KEYWORD_CLASS;
			
			else if (s.equalsIgnoreCase ("void")) kw = TokenType.KEYWORD_VOID;
			
			else if (s.equalsIgnoreCase ("static")) kw = TokenType.KEYWORD_STATIC;
			
			return kw;
		}
		
		public static TokenType getKlingon (String s) {
			
			TokenType kl = null;
			
			if (s.equalsIgnoreCase ("rltlh")) kl = TokenType.KLINGON_PRINT; // used the same method as before for the same reason
			
			else if (s.equalsIgnoreCase ("boq")) kl = TokenType.KLINGON_ADD;
			
			else if (s.equalsIgnoreCase ("boqha")) kl = TokenType.KLINGON_SUBTRACT;
			
			else if (s.equalsIgnoreCase ("boqegh")) kl = TokenType.KLINGON_MULTIPLY;
			
			else if (s.equalsIgnoreCase ("boqHaegh")) kl = TokenType.KLINGON_DIVIDE;
			
			return kl;
		}
		
		public static boolean isLetter (char ch) {  
			
			if (ch >='a' && ch <='z') return true;
			
			else if (ch >='A' && ch <='Z') return true;
			
			else return false;
			
			}
		
		public static boolean isDigit (char ch) {
			
			if (ch >= '0' && ch <='9') return true;
			
			else return false;
			
			}
		
		public static boolean isWhiteSpace (char ch) {
			
			if (ch == ' ') return true;
			
			else if (ch =='\t') return true;
			
			else return false;
			
		}
		
		public static boolean isLineBreak (char ch) {
			
			if (ch =='\n') return true;
			
			else return false;
			
		}
		/**
		 * This method reads a file and returns its content as a string
		 * @param fname this is the file name
		 * @return the file content as a string
		 */
		
		public static String readFile2String (String fname) {
			String content = null;
			try {
				content = new String (Files.readAllBytes(Paths.get(fname)));
			}catch (IOException e) {
				System.out.println("fail to read a file");
			}
			return content;
		}
		
		public static void scan (String prog) {
			
		int	n = prog.length();
		int	index = 0;
		int	lineNumber = 1;
		 
						
		while (index < n) {
			char ch = prog.charAt(index); // getting the current character for each index
			char ch_next = ' '; // used to store the next character 
						
						if(index < n - 1) {
							ch_next = prog.charAt(index+1);}
						// only one of the following six methods calls can be "not null" or "true" for a character
						
						boolean whiteSpace = isWhiteSpace(ch);
						boolean newline = isLineBreak(ch);
						TokenType sym = getSymbol(ch);
						TokenType op = getOp(ch);
						boolean letter = isLetter(ch);
						boolean digit = isDigit(ch);
						
						
						if (whiteSpace) {  // simply skip white space
							index ++; // update index to prevent infinite loop
							continue; // continue the code to check for other things

						} else if (newline) {  // new line
							lineNumber ++; // increase line number 
							index ++;
							continue;

						} else if (sym != null) {  // find a symbol. Not null therefore we print symbol

							System.out.println(lineNumber + ", " + sym + ", " + ch);
							index ++;
							continue;
						
						} else if (op != null) { // find an operator
							
							TokenType doubleOp;
							
							if (ch == '>' && ch_next == '=') { 
							doubleOp = TokenType.OP_GREATEREQUAL; // assigns the token type to the operator and prints 
							System.out.println(lineNumber + ", " + doubleOp + ", " + ch+ ch_next); // code is used to detect that whether or not the symbol has another symbol beside it that could change the operator
							index ++;
							index ++;
							continue;
							
							} else if (ch == '<' && ch_next == '=') { 
								doubleOp = TokenType.OP_LESSEQUAL;// assigns the token type to the operator and prints
								System.out.println(lineNumber + ", " + doubleOp + ", " + ch+ ch_next); // code is used to detect that whether or not the symbol has another symbol beside it that could change the operator
								index ++;
								index ++;
								continue;
							
							} else if (ch == '!' && ch_next == '=') {
								doubleOp = TokenType.OP_NOTEQUAL;// assigns the token type to the operator and prints
								System.out.println(lineNumber + ", " + doubleOp + ", " + ch+ ch_next); // code is used to detect that whether or not the symbol has another symbol beside it that could change the operator
								index ++;
								index ++;
								continue;
								
							} else if (ch == '=' && ch_next == '=') {
								doubleOp = TokenType.OP_EQUAL;// assigns the token type to the operator and prints
								System.out.println(lineNumber + ", " + doubleOp + ", " + ch + ch_next); // code is used to detect that whether or not the symbol has another symbol beside it that could change the operator
								index ++;
								index ++;
								continue;
						
						} else 
							System.out.println(lineNumber + ", " + op + ", " + ch);
							index++;
							continue;
							
						} else if (letter) { // find a letter

							String word = "";
							word += ch;
							index ++; // next letter of the word
							while (index < n) {  // use this while loop to identify e.g. the variable name
								ch = prog.charAt(index);
								if (isLetter(ch)) { // if letter, add it to the word and update index, else break out of this while loop 
									word += ch;
									index ++;
								}
								else break; 
						}
							
							TokenType keyword = getKeyword(word); 
							TokenType klingon = getKlingon(word);
							
							if (keyword != null) { // if the token type is a keyword this if branch continues
								
								System.out.println(lineNumber + ", " + keyword + ", " + word); // prints line number and the keyword as well as the word found in the text file

							} else if (klingon != null) {
								System.out.println(lineNumber + ", " + klingon + ", " + word); // prints line number and the keyword as well as the word found in the text file if klingon is not null
							
							} else {
								System.out.println(lineNumber + ", " + TokenType.IDENTIFIER + ", " + word); // if both are null above then the string must be an identifier
								continue;
							}	
							
						} else if (digit) { // code used to determine whether or not there is an integer
							String number = ""; // integer stored here
							number += ch;// if digit is true the character of the number is added to the string
							index++; // next character
							while (index < n) {
								ch = prog.charAt(index);
								if (isDigit(ch)) { // if the next character is another number (true)
									number += ch;// character is added to the string 
									index++;			
								}
								else break;
							}
						System.out.println(lineNumber + ", " + TokenType.INTEGER + ", " + number); // number given the token type integer and printed
						continue;
						
						} else if (ch == '\"') {
							String str = "";
							String word ="";
							str += ch;
							index ++;
							
							while (index < n) {
								ch = prog.charAt(index);
								if(ch == '\"') {
									str += ch;
									index ++;
								
					
									continue;
								}
								else break;
							}
						System.out.println(lineNumber + ", " + TokenType.STRING + ", " + str + word);
						continue;
						
						} else {
							
							System.out.println("Encountered something not expected: " + ch);
							index ++;
							continue; // This part of the code checks for errors and informs the user
						}
							
				}
		}
		
}


				