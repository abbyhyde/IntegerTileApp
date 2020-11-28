package example.puzzle.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.model.Coordinate;
import example.puzzle.model.Direction;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class TestSlideTileController {
	
	@Test
	public void testMove() {
		Model model = new Model();
		TilePuzzleApp app = new TilePuzzleApp(model);
		SlideTileController stc = new SlideTileController(model, app);
		
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
		
		stc.model.setPuzzle(puzzle);
		
		// set a selected tile, call move in a certain direction
		stc.model.setSelectedTile(t);
		
		stc.move(Direction.Down);
		// test to determine if the move was made correctly
		assertTrue(stc.model.getSelectedTile() == null);
		//assertEquals(puzzle.findTile(new Coordinate(1, 2)).getNum(), 45);
		assertTrue(stc.model.getPuzzle().findTile(new Coordinate(0, 0)).removed());
		
	}
}
