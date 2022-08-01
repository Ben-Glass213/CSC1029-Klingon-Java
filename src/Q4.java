import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q4 {

	public static void main(String[] args) {
		
		System.out.println("## Q4Example1:");
		String prog1 = readFile("src/Q4Example1.txt"); // read2FileString changed to readFile
		scan(prog1);
		
		System.out.println("\n## Q4Example2:");
		String prog2 = readFile("src/Q4Example2.txt");
		scan(prog2);
		
		System.out.println("\n## Q4Example3:");
		String prog3 = readFile("src/Q4Example3.txt");
		scan(prog3);
		
		System.out.println("\n## Q4Example4:");
		String prog4 = readFile("src/Q4Example4.txt");
		scan(prog4);
		
		System.out.println("\n## Q4Example5:");
		String prog5 = readFile("src/Q4Example5.txt");
		scan(prog5);
		
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
			
			if (s.equalsIgnoreCase ("if")) kw = TokenType.KEYWORD_IF;
			
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
			
			if (s.equalsIgnoreCase ("rltlh")) kl = TokenType.KLINGON_PRINT;
			
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
		
		public static String readFile (String fname) {
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
			char ch_next = ' ';
						
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
							continue;

						} else if (newline) {  // new line
							lineNumber ++;
							index ++;
							continue;

						} else if (sym != null) {  // find a symbol. Not null therefore we print symbol

							
							index ++;
							continue;
						
						} else if (op != null) { // find an operator
							
							TokenType doubleOp;
							
							if (ch == '>' && ch_next == '=') {
							doubleOp = TokenType.OP_GREATEREQUAL;
							
							index ++;
							index ++;
							continue;
							
							} else if (ch == '<' && ch_next == '=') { 
								doubleOp = TokenType.OP_LESSEQUAL;
								
								index ++;
								index ++;
								continue;
							
							} else if (ch == '!' && ch_next == '=') {
								doubleOp = TokenType.OP_NOTEQUAL;
								
								index ++;
								index ++;
								continue;
								
							} else if (ch == '=' && ch_next == '=') {
								doubleOp = TokenType.OP_EQUAL;
								
								index ++;
								index ++;
								continue;
						
						} else 
							
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
							
							if (keyword != null) {
								
								

							} else if (klingon != null) {
								
							
							} else {
								
								
							} 
							continue;
													
						} else if (digit) {
							String number = "";
							number += ch;
							index++;
							while (index < n) {
								ch = prog.charAt(index);
								if (isDigit(ch)) {
									number += ch;
									index++;
								}
								else break;
							}
						
						continue;
						
						} else if (ch == '\"') {
							String str = " ";
							str += ch;
							index ++;
							while (index < n) {
								ch = prog.charAt(index);
								if(ch == '\"') {
									str += ch;
									index ++;
								}
								else break;
							}
						
						continue;
						
						} else if (ch == '/' && ch_next == '/') {
							index++;
							index++;
							while(newline = false) {
								index++;
								continue;
							}
					
		
						} 
							
				}
		}
		
}


				