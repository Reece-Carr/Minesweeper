package minesweeper;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class BoardImp extends JFrame implements Board {

	private int boardLength;
	private Square[][] grid;
	private int numberOfBombs;
	private final int SQUARE_SIZE = 15;
	private final Game minesweeperGame;
	
	public BoardImp(int boardLength, Game minesweeperGame) {
		this.minesweeperGame = minesweeperGame;
		initialiseBoard(boardLength);
		createGameScreen();
		
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
	
	private void createGameScreen() {
		getContentPane().setBackground(Color.WHITE);
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(SQUARE_SIZE * boardLength, SQUARE_SIZE * boardLength);
        setLocationRelativeTo(null);
        
        Container boardPanel = this.getContentPane();
        boardPanel.setLayout(new GridBagLayout());
        
        for (int i = 0; i < boardLength; i++) {
        	for (int j = 0; j < boardLength; j++) {
        		
        		JButton gridButton = new JButton(new ImageIcon("src/images/10.png"));
        		grid[i][j].setButton(gridButton);
        		
        		GridBagConstraints c = new GridBagConstraints();
        		c.fill = GridBagConstraints.BOTH;
                c.gridx = j;       
                c.gridy = i;    
                c.weightx = 1;
                c.weighty = 1;
                
        		boardPanel.add(gridButton, c);
        		
        	}
        }
        
        setVisible(true);
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
	
	public void disableButtons() {
		
		for (int i = 0; i < boardLength; i++) {

			for (int j = 0; j < boardLength; j++) {
				getSquare(i, j).disableButton();
			}
			
		}
	}
	
	public Game getGame() {
		return minesweeperGame;
	}
}
