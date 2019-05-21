package minesweeper;

public class GameImp implements Game {

	private int score = 0;
	boolean isGameOver = false;
	private Board gameBoard;
	
	public int getScore() {
		return this.score;
	}
	
	public boolean isGameOver() {
		return this.isGameOver;
	}
	
	public void startGame() {
		//receive board size from player
		int boardLength = 10;
		setBoard(boardLength);
		
		while (!isGameOver) {
			//receive player commands and execute 
		}
		
		endGame();
		
	}
	
	public void quitGame() {
		
	}
	
	public void setBoard(int size) {
		gameBoard = new BoardImp(size);
	}
	
	public void endGame() {
		
	}
	
	public void resultScreen() {
		
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
		}
		
	}
	
}
