package minesweeper;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;

public class BoardImp extends JFrame implements Board {

	private int boardLength;
	private Square[][] grid;
	private int numberOfBombs;
	private final int SQUARE_SIZE = 50;
	
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
		
		//Create board graphic interface
		createInterface();
		
	}
	
	public Square getSquare(int row, int column) {
		return this.grid[row][column];
	}
	
	private void createInterface() {
		getContentPane().setBackground(Color.WHITE);
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(SQUARE_SIZE * boardLength, SQUARE_SIZE * boardLength);
        getContentPane().setLayout(null);
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
	
	public int getBoardLength() {
		return boardLength;
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
