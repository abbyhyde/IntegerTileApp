package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.controller.ResetController;
import example.puzzle.controller.SelectPieceController;
import example.puzzle.controller.SlideTileController;

class TestPuzzle {
	// testing for Puzzle class
	// need constructor one for puzzle
	
	@Test
	void testAddTile() {
		// addTile method, no center tile
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		
		puzzle.addTile(t, 0, 1);
		assertTrue(t.getCol() == 0);
		assertTrue(t.getRow() == 1);
	}
	
	@Test
	void testAddCenterTile() {
		// addTile method, center tile
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		
		puzzle.addTile(t, 1, 1);
		assertTrue(t.getCol() == 1);
		assertTrue(t.getRow() == 1);
		assertTrue(puzzle.center == t);
	}
	
	@Test
	void testFindVisibleTile() {
		// findTile method, finds visible tile
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		puzzle.addTile(t, 0, 1);
		Coordinate coord = new Coordinate(0,1);
		
		assertTrue(puzzle.findTile(coord) == t);
	}
	
	@Test
	void testIsVisible() {
		// isVisible method, tile is visible
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		puzzle.addTile(t, 0, 1);
		Coordinate coord = new Coordinate(0,1);
		
		assertTrue(puzzle.isVisible(coord));
	}
	
	@Test
	void testIsntVisible() {
		// isVisible method, tile isn't visible
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		puzzle.addTile(t, 0, 1);
		Coordinate coord = new Coordinate(0,1);
		puzzle.findTile(coord).setRemoved(true);
		
		assertFalse(puzzle.isVisible(coord));
	}
	
	@Test
	void testNextTile() {
		// nextTile method, direction = down
		Puzzle puzzle = new Puzzle();
		Tile t = new Tile(6);
		puzzle.addTile(t, 0, 1);
		Tile next = new Tile(3);
		puzzle.addTile(next, 0, 2);
		
		assertEquals(puzzle.nextTile(t, Direction.Down), next);
	}
}
