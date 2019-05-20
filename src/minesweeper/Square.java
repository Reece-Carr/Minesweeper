package minesweeper;

interface Square {

	void setBombTrue();
	void setBombFalse();
	void setSurroundingBombs(int surroundingBombs);
	boolean isBomb();
	int getSurroundingBombs();
	boolean isClicked();
	
}
