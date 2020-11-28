package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestModel {
	// test cases for Model class
	
	@Test
	public void testTryMove() {
		Model model = new Model();
		Puzzle puzzle = new Puzzle();
		
		puzzle.addTile(new Tile(3), 0, 0);
		puzzle.addTile(new Tile(6), 1, 0);
		puzzle.addTile(new Tile(8), 2, 0);
		puzzle.addTile(new Tile(9), 0, 1);
		puzzle.addTile(new Tile(1), 1, 1);
		puzzle.addTile(new Tile(2), 2, 1);
		puzzle.addTile(new Tile(4), 0, 2);
		puzzle.addTile(new Tile(5), 1, 2);
		Tile t = new Tile(9);
		puzzle.addTile(t, 2, 2);

		model.setPuzzle(puzzle);
		model.setSelectedTile(t);
		model.availableMoves();
		
		model.tryMove(Direction.Up);
		
		assertTrue(model.getSelectedTile() == null);
		//assertEquals(puzzle.findTile(new Coordinate(1, 2)).getNum(), 45);
		assertTrue(puzzle.findTile(new Coordinate(2, 2)).removed());
	}
	
	@Test
	public void testIsWinCondition() {
		// isWinCondition method, returns true
		Model model = new Model();
		Puzzle puzzle = new Puzzle();
		
		Tile a = new Tile(9);
		Tile b = new Tile(9);
		Tile c = new Tile(9);
		Tile d = new Tile(9);
		Tile e = new Tile(11); // set to 11 so win condition can happen
		Tile f = new Tile(9);
		Tile g = new Tile(9);
		Tile h = new Tile(9);
		Tile i = new Tile(9);
		
		puzzle.addTile(a, 0, 0);
		puzzle.addTile(b, 1, 0);
		puzzle.addTile(c, 2, 0);
		puzzle.addTile(d, 0, 1);
		puzzle.addTile(e, 1, 1);
		puzzle.addTile(f, 2, 1);
		puzzle.addTile(g, 0, 2);
		puzzle.addTile(h, 1, 2);
		puzzle.addTile(i, 2, 2);

		model.setPuzzle(puzzle);
		
		// set all tiles to removed
		a.setRemoved(true);
		b.setRemoved(true);
		c.setRemoved(true);
		d.setRemoved(true);
		f.setRemoved(true);
		g.setRemoved(true);
		h.setRemoved(true);
		i.setRemoved(true);
		
		assertTrue(model.isWinCondition());
	}
	
	@Test
	public void testIsWinConditionNo() {
		// isWinCondition method, returns false due to not all tiles removed
		Model model = new Model();
		Puzzle puzzle = new Puzzle();
		
		Tile a = new Tile(9);
		Tile b = new Tile(9);
		Tile c = new Tile(9);
		Tile d = new Tile(9);
		Tile e = new Tile(11); // set to 11 so win condition can happen
		Tile f = new Tile(9);
		Tile g = new Tile(9);
		Tile h = new Tile(9);
		Tile i = new Tile(9);
		
		puzzle.addTile(a, 0, 0);
		puzzle.addTile(b, 1, 0);
		puzzle.addTile(c, 2, 0);
		puzzle.addTile(d, 0, 1);
		puzzle.addTile(e, 1, 1);
		puzzle.addTile(f, 2, 1);
		puzzle.addTile(g, 0, 2);
		puzzle.addTile(h, 1, 2);
		puzzle.addTile(i, 2, 2);

		model.setPuzzle(puzzle);
		
		// set all tiles to removed
		a.setRemoved(true);
		b.setRemoved(true);
		c.setRemoved(true);
		d.setRemoved(true);
		
		assertFalse(model.isWinCondition());
	}
}
