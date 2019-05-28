package minesweeper;
import javax.swing.JOptionPane;

public class Game {

	boolean isGameOver = false;
	private Board gameBoard;
	
	public Game() {
		
		int boardLength = getBoardLength();
		setBoard(boardLength);
		
	}
	
	private int getBoardLength() {
		
		//receive board size from player
		Integer[] boardLengthOptions = {10, 12, 14, 16, 18, 20};
		int boardLength = (Integer)JOptionPane.showInputDialog(null, "Choose a N x N size of board", 
                "Board Setup", JOptionPane.QUESTION_MESSAGE, null, boardLengthOptions, boardLengthOptions[3]);
		return boardLength;
	}
	
	private void quitGame() {
		
		int toQuit = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Select an Option...",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
		
		if (toQuit == 0) {
			System.exit(0);
		}
		
	}
	
	private void setBoard(int size) {
		gameBoard = new BoardImp(size, this);
	}
	
	public void endGame() {
		
		//Disable other user interactions
		gameBoard.disableButtons();
		
		JOptionPane.showMessageDialog(null, "Game Over");
		quitGame();
	}
	
}
