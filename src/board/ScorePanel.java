package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.TetrisApp;
import pieces.GenericPiece;

/**
 * ScorePanel.java Created by Laura Baldwin Purpose: This class is to display
 * the highscores, the block on hold, the blocks coming up, and a button to quit
 * the program
 */
public class ScorePanel extends JPanel {
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 1955286229728891072L;
	private static Point[][] heldPiece;
	private static Point[][] next1;
	private static Point[][] next2;
	private static Point[][] next3;

	public ScorePanel() {
		this.setSize(200, 600);
		this.setBounds(300, 0, 200, 600);
		this.setBackground(Color.black);
		this.setLayout(null);
		heldPiece = null;

		// create a label under which to display the scores
		JLabel title = new JLabel("Scores:", JLabel.CENTER);
		Font allFont = new Font(title.getFont().getName(), Font.BOLD, 24);
		title.setFont(allFont);
		title.setBounds(0, 0, this.getWidth(), 50);
		title.setForeground(Color.YELLOW);
		this.add(title);

		// create a label to display user score
		JLabel userScore = new JLabel("", JLabel.CENTER);
		userScore.setFont(allFont);

		// create a label in which to display high scores
		JLabel scores = new JLabel("", JLabel.CENTER);
		scores.setFont(allFont);
		scores.setBounds(0, 50, this.getWidth(), 150);
		this.add(scores);

		// create a label under which to display the block on hold

		JLabel hold = new JLabel("Hold:", JLabel.CENTER);
		hold.setFont(allFont);
		hold.setBounds(0, 150, this.getWidth(), 50);
		hold.setForeground(Color.YELLOW);
		this.add(hold);

		// create an 2x4 array of Points to hold the held piece
		heldPiece = new Point[2][4];
		for (int rows = 0; rows < 2; rows++) {
			for (int cols = 0; cols < 4; cols++) {
				heldPiece[rows][cols] = new Point(rows, cols);
			}
		}

		// display the held piece
		updateHoldDisplay();

		// create a label under which to display the next pieces
		JLabel next = new JLabel("Next:", JLabel.CENTER);
		next.setFont(allFont);
		next.setBounds(0, 300, this.getWidth(), 50);
		next.setForeground(Color.YELLOW);
		this.add(next);

		// create 3 2x4 Point Arrays to display the next pieces
		next1 = new Point[2][4];
		next2 = new Point[2][4];
		next3 = new Point[2][4];

		for (int rows = 0; rows < 2; rows++) {
			for (int cols = 0; cols < 4; cols++) {
				next1[rows][cols] = new Point(rows, cols);
				next2[rows][cols] = new Point(rows, cols);
				next3[rows][cols] = new Point(rows, cols);
			}
		}
		// display the next pieces
		updateNextPieceDisplay();

		// create button to quit game
		JButton quit = new JButton("Quit");
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.YELLOW);
		// Font quitFont = new Font(next.getFont().getName(), Font.BOLD, 24);
		quit.setFont(allFont);
		quit.setBounds(0, 570, this.getWidth(), 30);
		quit.setBorderPainted(false);

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TetrisApp.stopGame();
			}
		});
		this.add(quit);

	}
	// update nextPieces:

	public void updateHoldDisplay() {
		for (int rows = 0; rows < 2; rows++) {
			for (int cols = 0; cols < 4; cols++) {
				try {
					if(TetrisApp.getHoldPiece().getShape()[rows][cols] == 1) {
						heldPiece[rows][cols].setBackground(TetrisApp.getHoldPiece().getColor());
						heldPiece[rows][cols].setBounds(40 + (cols * 30), 200 + (rows * 30), 30, 30);
						this.add(heldPiece[rows][cols]);
					} else {
						throw new NullPointerException("Piece is not there");
					}
				} catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
					heldPiece[rows][cols].setBackground(Color.GRAY);
					heldPiece[rows][cols].setBounds(40 + (cols * 30), 200 + (rows * 30), 30, 30);
					this.add(heldPiece[rows][cols]);
				}
			}
		}
	}



	public void updateNextPieceDisplay(){
		for(int rows = 0; rows < 2; rows++){
			for(int cols = 0; cols < 4; cols++){
				try{
					next1[rows][cols].setBackground(TetrisApp.getNextPieces().get(0).getColor());
					next1[rows][cols].setBounds(40 + (cols * 30), 350 + (rows * 30), 30, 30);
					this.add(next1[rows][cols]);
				}
				catch(IndexOutOfBoundsException | ArrayIndexOutOfBoundsException e){
					next1[rows][cols].setBackground(Color.GRAY);
					next1[rows][cols].setBounds(40 + (cols * 30), 350 + (rows * 30), 30, 30);
					this.add(next1[rows][cols]);
				}
				try{
					next2[rows][cols].setBackground(TetrisApp.getNextPieces().get(1).getColor());
					next2[rows][cols].setBounds(40 + (cols * 30), 420 + (rows * 30), 30, 30);
					this.add(next2[rows][cols]);
				}
				catch(IndexOutOfBoundsException | ArrayIndexOutOfBoundsException e){
					next2[rows][cols].setBackground(Color.GRAY);
					next2[rows][cols].setBounds(40 + (cols * 30), 420 + (rows * 30), 30, 30);
					this.add(next2[rows][cols]);
				}
				try{
					next3[rows][cols].setBackground(TetrisApp.getNextPieces().get(2).getColor());
					next3[rows][cols].setBounds(40 + (cols * 30), 490 + (rows * 30), 30, 30);
					this.add(next3[rows][cols]);
				}
				catch(IndexOutOfBoundsException | ArrayIndexOutOfBoundsException e){
					next3[rows][cols].setBackground(Color.GRAY);
					next3[rows][cols].setBounds(40 + (cols * 30), 490 + (rows * 30), 30, 30);
					this.add(next3[rows][cols]);
				}
			}
		}
	}
}