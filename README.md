# Lexical-Analyzer
This program takes in an inputted small program in the form of a string. It is then get dissected into tokens. 

In this program, a for-loop function is lexically analyzed. The output prints out the steps that the Lexical Analyzer takes while processing the string. 

for ( counter = 1; counter <= 10; counter ++) { 
  sum=sum+1; 
} 

Example output: ------------------------------------------
Next Token is: 9 Next lexeme is for
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 25 Next lexeme is (
Exit <factor>
Exit <term>
Exit <expr>

Next Token is: 11 Next lexeme is counter
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 20 Next lexeme is =
Exit <factor>
Exit <term>

Next Token is: 10 Next lexeme is 1
Enter <term>
Enter <factor>

Next Token is: 29 Next lexeme is ;
Exit <factor>
Exit <term>
Exit <expr>

Next Token is: 11 Next lexeme is counter
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 23 Next lexeme is <=
Exit <factor>
Exit <term>

Next Token is: 10 Next lexeme is 10
Enter <term>
Enter <factor>

Next Token is: 29 Next lexeme is ;
Exit <factor>
Exit <term>
Exit <expr>

Next Token is: 11 Next lexeme is counter
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 22 Next lexeme is ++
Exit <factor>

Next Token is: 26 Next lexeme is )
Enter <factor>

Next Token is: 27 Next lexeme is {
Exit <factor>
Exit <term>
Exit <expr>

Next Token is: 11 Next lexeme is sum
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 20 Next lexeme is =
Exit <factor>
Exit <term>

Next Token is: 11 Next lexeme is sum
Enter <term>
Enter <factor>

Next Token is: 21 Next lexeme is +
Exit <factor>

Next Token is: 10 Next lexeme is 1
Enter <factor>

Next Token is: 29 Next lexeme is ;
Exit <factor>
Exit <term>
Exit <expr>

Next Token is: 28 Next lexeme is }
Enter <expr>
Enter <term>
Enter <factor>

Next Token is: 28 Next lexeme is }
Exit <factor>
Exit <term>
Exit <expr>

-----------------------------------------------------------
