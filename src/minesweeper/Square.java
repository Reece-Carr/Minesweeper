package minesweeper;

interface Square {

	void setBombTrue();
	void setBombFalse();
	void setSurroundingBombs();
	void click();
	boolean isBomb();
	int getSurroundingBombs();
	boolean isClicked();
	
}
