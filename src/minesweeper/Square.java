package minesweeper;
import javax.swing.*;

interface Square {

	void setBombTrue();
	void setBombFalse();
	void setSurroundingBombs();
	void click();
	boolean isBomb();
	int getSurroundingBombs();
	void setButton(JButton button);
	void disableButton();
	
}
