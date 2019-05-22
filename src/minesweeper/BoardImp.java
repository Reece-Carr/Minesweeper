package minesweeper;
import java.util.Random;

public class BoardImp implements Board {

	private int boardLength;
	private Square[][] grid;
	private int numberOfBombs;
	
	public BoardImp(int boardLength) {
		initialiseBoard(boardLength);
		createInterface();
		
	}
	
	public void initialiseBoard(int boardLength) {
		
		//Create board of given size
		this.boardLength = boardLength;
		this.grid = new Square[boardLength][boardLength];
		
		//randomise number of bombs to plant
		int minBombs = boardLength;
		int maxBombs = (int)Math.floor(boardLength * boardLength / 2);
		numberOfBombs = minBombs + (int)(Math.random() * ((maxBombs - minBombs) + 1));
		
		//Initialise grid and setup bombs
		initSquares();
		setBombs(numberOfBombs);
		updateSurroundingBombs();
		
	}
	
	public Square getSquare(int row, int column) {
		return this.grid[row][column];
	}
	
	private void createInterface() {
		
	}
	
	private void initSquares() {
		
		for (int i = 0; i < boardLength; i++) {
			
			for (int j = 0; j < boardLength; j++) {
				grid[i][j] = new SquareImp(i, j, this);
			}
			
		}
	}
	
	public int getNumberOfBombs() {
		return this.numberOfBombs;
	}
	
	private void updateSurroundingBombs() {
		
	    for (int i = 0; i < boardLength; i++) {

			for (int j = 0; j < boardLength; j++) {
				getSquare(i, j).setSurroundingBombs();
			}
			
		}
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
