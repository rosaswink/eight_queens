/**
 * Program: EightQueens
 * Authors: Rosa Swink
 * 
 * This program provides a puzzle to the user known as 'Eight Queens'. The user must
 * input the position of eight queens so that none of them can take each other, which
 * means that any piece can not be in the same row, column, or diagonal as another
 * piece.
 * 
 * Input: The placement of queen pieces in chess format (a1, b2, etc)
 * 
 * Output: The solution to the puzzle, if obtained.
 * 
 * Bugs and limitations: None known.
 * 
 */

import java.util.Scanner;


public class EightQueens {

	/*
	 * Main Method
	 * Does all of the checking, inputting, and outputting. Holds most
	 * of the variables and has several methods to reduce the length of
	 * the main method's code.
	 * 
	 * Input: The position of a queen piece.
	 * 
	 * Output: Feedback on position of queen piece, and a congratulation
	 * message with the array printed.
	 */

	public static void main(String [] args){
		//Creating variables necessary for the program
		int i = 0;
		int j = 0;
		int Qonboard = 0;
		String Blank = " ";
		String Queen = "Q";
		//creating a blank 2d array (I have typed out the size of the board at the very bottom of the code)
		String[][] chessboard = new String[8][19];
		for(i=0; i<8; i++){
			for(j=0; j<18; j++){
				chessboard[i][j] = Blank;
			}
		}
		//end of creating a blank 2d array

		//Creating the edge
		chessboard[0][0] = chessboard[0][18] = "8";
		chessboard[1][0] = chessboard[1][18] = "7";
		chessboard[2][0] = chessboard[2][18] = "6";
		chessboard[3][0] = chessboard[3][18] = "5";
		chessboard[4][0] = chessboard[4][18] = "4";
		chessboard[5][0] = chessboard[5][18] = "3";
		chessboard[6][0] = chessboard[6][18] = "2";
		chessboard[7][0] = chessboard[7][18] = "1";
		//end of creating the edge

		while(Qonboard<8){ //loop until there are 8 valid queens on the chessboard
			System.out.print("Enter the position of a queen piece: ");
			Scanner input = new Scanner(System.in);
			String position = input.next(); // get position
			char x1 = position.charAt(0); //letter of position
			char y1 = position.charAt(1); //number of position
			i = locatepositioni(y1, position);
			if(i >= 0){
				j = locatepositionj(x1, position);
				if(j >= 0){

					int b = positionCheck(i,j, chessboard, Queen); //check if the queen position has conflicts with other existing queens
					if(b == 0){//set a queen on that position
						chessboard[i][j] = Queen;
						Qonboard++; //Queen on board +1
					}
					else if(b == 1){
						chessboard[i][j] = Blank; ////Queen on board remains the same
						System.out.print("Illegal move at " + position + ". ");
					}
					else if(b == 2){//reset the position to blank if there has already been a queen
						chessboard[i][j] = Blank;
						Qonboard--; //Queen on board -1
						System.out.print("Removing queen from " + position + ". "); 
					}
				}
			}

		}


		System.out.println("\nCongratulations! You have successfully solved the 8-queens puzzle.");
		System.out.println("Your solution is:");
		System.out.println("\n  a b c d e f g h  ");
		arrayPrint(chessboard); // print the array
		System.out.println("  a b c d e f g h  ");
		System.out.println("\n Bye.");
	}
	//end of the main method

	/*
	 * arrayPrint(String[][] chesssboard)
	 * Scans the array for possible locations of "Q". If it finds a
	 * "Q", it will then print out a Q. If it does not, it will print
	 * a space instead.
	 * 
	 * Input: None.
	 * 
	 * Output: A printed array.
	 */
	private static void arrayPrint(String[][] chessboard) {
		//int counter = 8;
		for(int i=0;i<chessboard.length;i++){
			for(int j=0;j<chessboard[i].length;j++){
				System.out.print(chessboard[i][j]);
			}
			System.out.println();
		}
	}
	//end of printing the array

	/*
	 * locatepositionj(char y1, String position)
	 * Takes the letter given by the chess piece's location and assigns it to
	 * an integer value.
	 * 
	 * Output: An invalid position if the char exceeds H, and a returned integer
	 * value.
	 */
	//locating the queen position with the x coordinates
	private static int locatepositionj(char y1, String position) {
		int j;
		if(y1 == 'a' || y1 == 'A'){
			j = 2; 
			return j;
		}
		else if(y1 == 'b' || y1 == 'B'){
			j = 4;
			return j;
		}
		else if(y1 == 'c' || y1 == 'C'){
			j = 6;
			return j;
		}
		else if(y1 == 'd' || y1 == 'D'){
			j = 8;
			return j;
		}
		else if(y1 == 'e' || y1 == 'E'){
			j = 10;
			return j;
		}
		else if(y1 == 'f' || y1 == 'F'){
			j = 12; 
			return j;
		}
		else if(y1 == 'g' || y1 == 'G'){
			j = 14;
			return j;
		}
		else if(y1 == 'h' || y1 == 'H'){
			j = 16;
			return j;
		}
		else{
			System.out.println("Invalid position at " + position);
			j = -1;
			return j;
		}
	}
	//end of locating the queen position with the x coordinates


	/*
	 * locatepositioni(char x1, String position)
	 * Takes the number given by the chess piece's location and flips it,
	 * as the example on the class website required that the board was facing
	 * the user.
	 * 
	 * Output: An invalid position if the number exceeds 8 or below 1, as well
	 * as a returned integer value.
	 */
	private static int locatepositioni(char x1, String position) {
		int i;
		if(x1 == '1'){  
			i = 7;
			return i;
		}
		else if(x1 == '2'){
			i = 6;	
			return i;
		}
		else if(x1 == '3'){
			i = 5;
			return i;
		}
		else if(x1 == '4'){
			i = 4;
			return i;
		}
		else if(x1 == '5'){
			i = 3;	
			return i;
		}
		else if(x1 == '6'){
			i = 2;	
			return i;
		}
		else if(x1 == '7'){
			i = 1;	
			return i;
		}
		else if(x1 == '8'){
			i = 0;	
			return i;
		}
		else{
			System.out.println("Invalid position at " + position);
			i = -1;
			return i;
		}

	}

	/*
	 * positionCheck(int i, int j, String[][] chessboard, String queen)
	 * This method checks to see if the newly placed queen will conflict with
	 * another queen in any row, column, or diagnol.
	 * 
	 * Output: A returned integer value.
	 */
	private static int positionCheck(int i, int j, String[][] chessboard, String queen) {
		int m;
		int n;
		int b = 0;
		if(chessboard[i][j] != queen){
			for(m=0;m<=7;m++){ //checking the column
				if(chessboard[m][j] == queen){
					b = 1;
					return b;
				}
			}
			for(n=2;n<=16;n+=2){ //checking the row
				if(chessboard[i][n] == queen){
					b = 1;
					return b;
				}
			}
			for(m=i,n=j;m>=0 && n<=16;m--,n+=2){//checking upper right diagonal
				if(chessboard[m][n] == queen){   
					b = 1;
					return b;
				}
			}
			for(m=i,n=j;m<=7 && n<=16;m++,n+=2){//checking lower right diagonal
				if(chessboard[m][n] == queen){
					b = 1;
					return b;
				}
			}
			for(m=i,n=j;m>=0 && n>=2;m--,n-=2){//checking upper left diagonal
				if(chessboard[m][n] == queen){
					b = 1;
					return b;
				}
			}
			for(m=i,n=j;m<=7 && n>=2;m++,n-=2){//checking lower left diagonal
				if(chessboard[m][n] == queen){
					b = 1;
					return b;
				}
			}
			b = 0;
			return b;

		}
		else{
			b = 2;
			return b;
		}
	}//end of checking if the position entered has conflicts with other existing queen
}

/*0123456789012345678 (array space count(j) : 19)
 *  a b c d e f g h (not in the array)
 *8                 8  0
 *7                 7  1
 *6                 6  2
 *5                 5  3       
 *4                 4  4 (array space count(i) : 8)
 *3                 3  5
 *2                 2  6
 *1                 1  7
 *  a b c d e f g h (not in the array)  
 */
