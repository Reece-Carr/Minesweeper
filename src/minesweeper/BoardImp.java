package minesweeper;

public class BoardImp implements Board {

	private int boardLength;
	private int score = 0;
	private boolean isBombHit = false;
	private Square[][] grid;
	
	public BoardImp(int boardLength) {
		initialiseBoard(boardLength);
	}
	
	public void initialiseBoard(int boardLength) {
		setBoardLength(boardLength);
		this.grid = new Square[boardLength][boardLength];
		//call private methods for setting bombs
	}
	
	private void setBoardLength(int boardLength) {
		this.boardLength = boardLength;
	}
	
	public Square getSquare(int row, int column) {
		return this.grid[row][column];
	}
	
}
