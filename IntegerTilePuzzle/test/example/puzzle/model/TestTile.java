package example.puzzle.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTile {
	// testing for Tile class

	@Test
	void testTileConstruction() {
		// constructor
		Tile tile = new Tile(3);
		tile.setCol(1);
		tile.setRow(1);
		assertEquals(3, tile.number);
		assertEquals(1, tile.row);
		assertEquals(1, tile.col);
	}
	
	@Test
	void testGetLocation() {
		Tile t = new Tile(3);
		t.setCol(1);
		t.setRow(2);
		
		Coordinate coord = new Coordinate(1,2);
		assertTrue(coord.equals(t.getLocation()));
	}
	
	@Test
	void testContains() {
		Tile t = new Tile(3);
		t.setCol(0);
		t.setRow(2);
		
		assertTrue(t.contains(new Coordinate(0,2)));
		assertFalse(t.contains(new Coordinate(1,1)));
	}

	@Test
	void testLeftMove() {
		Tile t = new Tile(3);
		t.setCol(0);
		t.setRow(2);
		Tile next = new Tile(6);
		next.setCol(0);
		next.setRow(1);
		int temp = next.getNum();
		
		t.move(next, Direction.Left);
		
		assertTrue(t.removed);
		assertTrue(next.number == temp - t.number);
	}
	
	@Test
	void testRightMove() {
		Tile t = new Tile(3);
		t.setCol(0);
		t.setRow(1);
		Tile next = new Tile(6);
		next.setCol(0);
		next.setRow(2);
		int temp = next.getNum();
		
		t.move(next, Direction.Right);
		
		assertTrue(t.removed);
		assertTrue(next.number == temp + t.number);
	}
	
	@Test
	void testUpMove() {
		Tile t = new Tile(3);
		t.setCol(0);
		t.setRow(2);
		Tile next = new Tile(6);
		next.setCol(0);
		next.setRow(1);
		int temp = next.getNum();
		
		t.move(next, Direction.Up);
		
		assertTrue(t.removed);
		assertTrue(next.number == temp * t.number);
	}
	
	@Test
	void testDownMove() {
		Tile t = new Tile(3);
		t.setCol(0);
		t.setRow(2);
		Tile next = new Tile(6);
		next.setCol(0);
		next.setRow(1);
		int temp = next.getNum();
		
		t.move(next, Direction.Down);
		
		assertTrue(t.removed);
		assertTrue(next.number == temp / t.number);
	}

}
