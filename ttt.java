import java.util.Scanner;

public class tictactoe {
	
	public static void main(String[] args) {
			
		Scanner in = new Scanner(System.in);
	
		//Who is playing?
		System.out.print("Player 1, enter your name! ");
		String p1 = in.nextLine();
		System.out.print("Player 2, enter your name! ");
		String p2 = in.nextLine();
	
		//3x3 TicTacToe board
		//- empty space
		//x player 1
		//o player 2
		char[][] board = new char[3][3];
	
		//fill board with lines
		for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                board[i][j] = '-'; 
            }
		}
	
		//Draw TicTacToe Board
		drawBoard(board);
		
		//When does the game end?
		boolean isPlayer1 = true;
		boolean gameEnded = false;
		while(!gameEnded) {
		
		//Keep track of what symbol we are using to player
		char symbol = '-';
		if(isPlayer1) {
		   symbol = 'x';
		} else { 
		   symbol = 'o';
		}
		
		//Whose turn is it
		if(isPlayer1) {
		  System.out.println(p1 + "'s Turn (x):");
		} else {
		  System.out.println(p2 + "'s Turn (o):");
		}
		
		char c = 'c';
		if(isPlayer1) {
		  symbol = 'x';
		} else {
		  symbol = 'o';
		} 
		
		//Create row and col variables which represent indexe that correspond to a position on our board
		int row = 0;
		int col = 0;
		
		while(true) {
		
		  //ask user for what position they want to place their x or o 
		  System.out.print("Enter a row (0, 1, or, 2): ");
		  row = in.nextInt();
		  System.out.print("Enter a column number (0, 1, or 2) : ");
		  col = in.nextInt();
		
		  if(row < 0 || col < 0 || row > 2 || col > 2) {
		    System.out.println("This position is off the bounds of the board!.");
		  
		  //Check if position on the board the user entered is empty or not
		  } else if(board[row][col] != '-') {
		    System.out.println("This position is already filled!");
			
		
		  } else {
		    break;
		  }
		
		}
		
		board[row][col] = symbol;
		
		//Check if either player has won
		if(playerHasWon(board) == 'x') {
		  System.out.println(p1 + "has won!");
		  gameEnded = true;
		}
                
                if(playerHasWon(board) == 'o') {
		  gameEnded = true;
                }
		
		if(boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
		}
		  
		drawBoard(board);
		
		}		

		if(boardIsFull(board)) {
        	 System.out.println("It's a tie!");
        	 gameEnded = true;
       		} else {
      	        //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                isPlayer1 = isPlayer1;
         	}
                 //Draw the board at the end of the game
                drawBoard(board);
     	 }
         	 //Make a function to draw the tic tac toe board
            public static void drawBoard(char[][] board) {
              System.out.println("Board:");
              for(int i = 0; i < 3; i++) {
                 //The inner for loop prints out each row of the board
                for(int j = 0; j < 3; j++) {
                   System.out.print(board[i][j]);
                }
                //This print statement makes a new line so that each row is on a separate line
               System.out.println();
             }
           }
 
        //Make a function to see if someone has won and return the winning char
             public static char playerHasWon(char[][] board) {

                //Check each row
                for(int i = 0; i < 3; i++) {
                  if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && 
                         board[i][0] != '-') {
                       return board[i][0];
                   }   
                }

                //Check each column
                for(int j = 0; j < 3; j++) {
                  if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && 
                            board[0][j] != '-') {
                    return board[0][j];
                  }
                }

                //Check the diagonals
                if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                  return board[0][0];
                }
                if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
                  return board[2][0];
                }
                //Otherwise nobody has not won yet
                return ' ';
             }
 
        //Make a function to check if all of the positions on the board have been filled
        public static boolean boardIsFull(char[][] board) {
          for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
              if(board[i][j] == '-') {
                return false;
              }
            }
          }
         return true;
        }
}

