package minesweeper;
import javax.swing.JOptionPane;

public class Game {

	private int score = 0;
	boolean isGameOver = false;
	private Board gameBoard;
	
	public Game() {
		
		int boardLength = getBoardLength();
		setBoard(boardLength);
		
	}
	
	public void startGame() {
		
		while (isGameOver) {
			//receive player commands and execute 
		}
		
		endGame();
		
	}
	
	private int getBoardLength() {
		
		//receive board size from player
		Integer[] boardLengthOptions = {10, 12, 14, 16, 18, 20};
		int boardLength = (Integer)JOptionPane.showInputDialog(null, "Choose a N x N size of board", 
                "Board Setup", JOptionPane.QUESTION_MESSAGE, null, boardLengthOptions, boardLengthOptions[3]);
		return boardLength;
	}
	
	private void quitGame() {
		
		int toQuit = JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		
		if (toQuit == 0) {
			System.exit(0);
		}
		
	}
	
	private void setBoard(int size) {
		gameBoard = new BoardImp(size);
	}
	
	private void endGame() {
		
		//Disable other user interactions
		//
		
		
		JOptionPane.showMessageDialog(null, "Game Over");
		
	}
	
	private void clickSquare() {
		
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
