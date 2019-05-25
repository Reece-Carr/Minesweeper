package minesweeper;

public class SquareImp implements Square {

	private boolean bomb = false;
	private int surroundingBombs = 0;
	private boolean isClicked = false;
	private Board gameBoard;
	private int row;
	private int column;
	
	public SquareImp(int row, int column, Board gameBoard) {
		this.row = row;
		this.column = column;
		this.gameBoard = gameBoard;
	}
	
	public void setBombTrue() {
		this.bomb = true;
	}
	
	public void setBombFalse() {
		this.bomb = false;
	}
	
	public boolean isBomb() {
		return this.bomb;
	}
	
	public void setSurroundingBombs() {
		
		surroundingBombs = 0;
		int boardLength = gameBoard.getBoardLength();
		
		if (row > 0 && gameBoard.getSquare(row - 1, column).isBomb()) {
			surroundingBombs++;
		} 
		
		if (row > 0 && column > 0 && gameBoard.getSquare(row - 1, column - 1).isBomb()) {
			surroundingBombs++;
		} 
		
		if (row > 0 && column < boardLength - 1 && gameBoard.getSquare(row - 1, column + 1).isBomb()) {
			surroundingBombs++;
		} 
		
		if (column > 0 && gameBoard.getSquare(row, column - 1).isBomb()) {
			surroundingBombs++;
		}
		
		if (column < boardLength - 1 && gameBoard.getSquare(row, column + 1).isBomb()) {
			surroundingBombs++;
		}
		
		if (row < boardLength - 1 && gameBoard.getSquare(row + 1, column).isBomb()) {
			surroundingBombs++;
		}
		
		if (row < boardLength - 1 && column > 0 && gameBoard.getSquare(row + 1, column - 1).isBomb()) {
			surroundingBombs++;
		}
		
		if (row < boardLength - 1 && column < boardLength - 1 && gameBoard.getSquare(row + 1, column + 1).isBomb()) {
			surroundingBombs++;
		}
		
	}
	
	public int getSurroundingBombs() {
		return this.surroundingBombs;
	}
	
	public void click() {
		isClicked = true;
	}
	
	public boolean isClicked() {
		return this.isClicked;
	}
}
