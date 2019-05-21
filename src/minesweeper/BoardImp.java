package minesweeper;
import java.util.Random;

public class BoardImp implements Board {

	private int boardLength;
	private Square[][] grid;
	
	public BoardImp(int boardLength) {
		initialiseBoard(boardLength);
	}
	
	public void initialiseBoard(int boardLength) {
		
		//Create board of given size
		setBoardLength(boardLength);
		this.grid = new Square[boardLength][boardLength];
		
		//randomise number of bombs to plant
		int minBombs = boardLength;
		int maxBombs = (int)Math.floor(boardLength * boardLength / 2);
		int numberOfBombs = minBombs + (int)(Math.random() * ((maxBombs - minBombs) + 1));
		
		setBombs(numberOfBombs);
		
	}
	
	private void setBoardLength(int boardLength) {
		this.boardLength = boardLength;
	}
	
	public Square getSquare(int row, int column) {
		return this.grid[row][column];
	}
	
	private void setBombs(int numberOfBombs) {
		
		Random rng = new Random();
		int[] bombSquaresRandom = rng.ints(numberOfBombs, 0, boardLength * boardLength - 1).toArray();
		
		for (int i = 0; i < numberOfBombs; i++) {
			
			int row = bombSquaresRandom[i] / boardLength;
			int column = bombSquaresRandom[i] % boardLength;
			getSquare(row, column).setBombTrue();
			
		}
	}
	
}
