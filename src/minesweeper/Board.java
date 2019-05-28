package minesweeper;

interface Board {

	void initialiseBoard(int boardLength);
	Square getSquare(int row, int column);
	int getBoardLength();
	Game getGame();
	void disableButtons();
}
