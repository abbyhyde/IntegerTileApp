package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class TestSelectPieceController {
	
	@Test
	public void testProcess() {
		Model model = new Model();
		TilePuzzleApp app = new TilePuzzleApp(model);
		SelectPieceController spc = new SelectPieceController(model, app);
		
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(3);
		puzzle.addTile(t, 0, 0);
		puzzle.addTile(new Tile(6), 1, 0);
		puzzle.addTile(new Tile(8), 2, 0);
		puzzle.addTile(new Tile(9), 0, 1);
		puzzle.addTile(new Tile(1), 1, 1);
		puzzle.addTile(new Tile(2), 2, 1);
		puzzle.addTile(new Tile(4), 0, 2);
		puzzle.addTile(new Tile(5), 1, 2);
		puzzle.addTile(new Tile(7), 2, 2);
		
		spc.model.setPuzzle(puzzle);
		
		// give controller a mock point (usually a mouse click)
		Point p = new Point();
		p.x = 20;
		p.y = 20;
		
		spc.process(p);
		
		// test to make sure it selects the right tile
		assertEquals(spc.model.getSelectedTile(), t);
		
	}
}
