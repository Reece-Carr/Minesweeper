package minesweeper;

public class SquareImp implements Square {

	private boolean bomb = false;
	private int surroundingBombs = 0;
	private boolean isClicked = false;
	
	public void setBombTrue() {
		this.bomb = true;
	}
	
	public void setBombFalse() {
		this.bomb = false;
	}
	
	public boolean isBomb() {
		return this.bomb;
	}
	
	public void setSurroundingBombs(int surroundingBombs) {
		this.surroundingBombs = surroundingBombs;
	}
	
	public int getSurroundingBombs() {
		return this.surroundingBombs;
	}
	
	public boolean isClicked() {
		return this.isClicked;
	}
}
