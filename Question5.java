import java.util.*;


public class Main {
	
/*
#define INT_LIT 10
#define IDENT 11
#define ASSIGN_OP 20
#define ADD_OP 21
#define SUB_OP 22
#define MULT_OP 23
#define DIV_OP 24
#define LEFT_PAREN 25
#define RIGHT_PAREN 26*/
	
	private static final int KEYWORD = 9;
	private static final int INT_LIT = 10;
	private static final int IDENT = 11;
	private static final int ASSIGN_OP = 20;
	private static final int ADD_OP = 21;
	private static final int INCREMENT_OP = 22;
	private static final int COMPAR_OP = 23;
	private static final int LEFT_PAREN = 25;
	private static final int RIGHT_PAREN = 26;
	private static final int LEFT_BRACKET = 27;
	private static final int RIGHT_BRACKET = 28;
	private static final int TERMINATE = 29;
	private static int nextToken = 0;
	private static String nextTokenString;
	private static StringTokenizer st = 
			new StringTokenizer("for ( counter = 1 ; counter <= 10 ; counter ++ ) { sum = sum + 1 ; }", " ");

			
	
	public static void main(String[] args) {
			while(st.hasMoreElements()) {
				nextToken = lex();
				expr();
			}
	}
	
	
	
	public static void factor() { //begin factor function
		System.out.println("Enter <factor>");
		
		//Determine which RHS
		if(nextToken == IDENT || nextToken == INT_LIT || nextToken == LEFT_BRACKET || nextToken == RIGHT_BRACKET || nextToken == KEYWORD ||nextToken == RIGHT_PAREN) 
		{
			nextToken = lex(); //grab the next token
		}
		else {
			if(nextToken == LEFT_PAREN) {
				nextToken = lex();
				expr();
				if(nextToken == RIGHT_PAREN)
					nextToken = lex();
				else
					error();
			} else 
				error();
		} 
		System.out.println("Exit <factor>");
	}
	
	
	public static void term() { //begin term function
		System.out.println("Enter <term>");
		
		/*parse the first factor*/
		factor();
		
		while(nextToken == ADD_OP || nextToken == INCREMENT_OP)
		{
			nextToken = lex();
			factor();
		}
		System.out.println("Exit <term>");
	} 
	
	
	public static void expr() { //begin expr function
		System.out.println("Enter <expr>");
		
		/*parse the first term*/
		term();
		
		while(nextToken == ASSIGN_OP || nextToken == COMPAR_OP)
		{
			nextToken = lex();
			term();
		}
		System.out.println("Exit <expr>");
	}
	
	public static int lex() {
		if(st.hasMoreTokens()) {
			nextTokenString = st.nextToken();
			nextToken = lookup(nextTokenString);
		}
		System.out.println("\nNext Token is: " + nextToken + 
				   " Next lexeme is " + nextTokenString);
		return nextToken;
	}
	
	public static int lookup(String token) {
		if(isNumeric(token))
			return INT_LIT;
		
		switch (token) {
			case "(":
				nextToken = LEFT_PAREN; break;
			case ")":
				nextToken = RIGHT_PAREN; break;
			case "{":
				nextToken = LEFT_BRACKET; break;
			case "}":
				nextToken = RIGHT_BRACKET; break;
			case "+":
				nextToken = ADD_OP; break;
			case "<=":
				nextToken = COMPAR_OP; break;
			case "=":
				nextToken = ASSIGN_OP; break;
			case ";":
				nextToken = TERMINATE; break;
			case "++":
				nextToken = INCREMENT_OP; break;
			case "for":
				nextToken = KEYWORD; break;
			default: //an identifier
				nextToken = IDENT; break;
		}
		return nextToken;
	}
	
	public static void error() {
		System.out.println("Token can't be found");
		System.exit(0);
	}
	
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
}
