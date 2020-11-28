package example.puzzle.boundary;

import javax.swing.JPanel;

import example.puzzle.model.Coordinate;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class PuzzlePanel extends JPanel {
	
	Model model;
	public static final int tileSize = 120; 
	public static final int offset = 2; 
	
	public PuzzlePanel(Model m) {
		this.model = m;
	}
	
	public Rectangle computeRectangle(Tile t) {
		int col = t.getCol();
		int row = t.getRow();
		
		Rectangle rect = new Rectangle(col*tileSize, row*tileSize, tileSize - offset, tileSize - offset);
		return rect;
	}
	
	public Coordinate pointToCoordinate(Point p) {
		// mainly used by controller
		return new Coordinate(p.x/tileSize, p.y/tileSize);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Comic Sans MS", Font.PLAIN, 52);
		g.setFont(font);
		g.setColor(Color.pink);
		
		if (model == null) { return; } // for windowbuilder
		if (model.isWinCondition()) {
			model.getPuzzle().tiles.clear();
			Rectangle r = new Rectangle();
			g.fillRect(0, 0, 364, 364);
			
			g.setColor(Color.black);
			g.drawString("You won!", 80, 100);
			Font font2 = new Font("Comic Sans MS", Font.PLAIN, 26);
			g.setFont(font2);
			g.drawString("Click reset to play again", 40, 140);
			g.drawString("or quit to exit", 80, 175);
		}
		
		if (model.isLossCondition()) {
			model.getPuzzle().tiles.clear();
			Rectangle r = new Rectangle();
			g.fillRect(0, 0, 364, 364);
			
			g.setColor(Color.black);
			g.drawString("You lost!", 80, 100);
			Font font2 = new Font("Comic Sans MS", Font.PLAIN, 26);
			g.setFont(font2);
			g.drawString("Click reset to play again", 40, 140);
			g.drawString("or quit to exit", 80, 175);
		}
		
		
		Tile selectedTile = model.getSelectedTile();
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {
			// put the piece on the board
			if (t.equals(selectedTile)) {
				g.setColor(Color.green);
			} else if (t.removed()) {
				g.setColor(Color.lightGray);
			} else {
				g.setColor(Color.gray);
			}
			
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);
			
			g.setColor(Color.black);
			if (!t.removed()) {
				g.drawString("" + t.getNum(), r.x + (tileSize/4), r.y+(tileSize/2));
			}
			// if time, figure out how to make the numbers look better
		}
	}
	
}

