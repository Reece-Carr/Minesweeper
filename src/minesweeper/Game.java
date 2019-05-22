package minesweeper;
import javax.swing.JOptionPane;

public class Game {

	private int score = 0;
	boolean isGameOver = false;
	private Board gameBoard;
	
	public void main(String[] args) {
		
		//receive board size from player
		String boardLengthInput = JOptionPane.showInputDialog("Enter the board length");
		int boardLength =   Integer.parseInt(boardLengthInput);
		setBoard(boardLength);
		
		while (!isGameOver) {
			//receive player commands and execute 
		}
		
		endGame();
		
	}
	
	public void quitGame() {
		
		int toQuit = JOptionPane.showConfirmDialog(null, "Quit game?");
		
		if (toQuit == 0) {
			System.exit(0);
		}
		
	}
	
	public void setBoard(int size) {
		gameBoard = new BoardImp(size);
	}
	
	public void endGame() {
		
		//Disable other user interactions
		//
		
		
		JOptionPane.showMessageDialog(null, "Game Over");
		
	}
	
	public void clickSquare() {
		
		//private method calls for clicking squares, set row and column
		// 0 for test purposes
		int row = 0;
		int column = 0;
		
		//method calls for clicking squares
		Square clickedSquare = gameBoard.getSquare(row, column);
		clickedSquare.click();
		
		if (clickedSquare.isBomb()) {
			isGameOver = true;
		} else {
			score++;
		}
		
	}
	
}
