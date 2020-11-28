package example.puzzle.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile>{
	public ArrayList<Tile> tiles = new ArrayList<>();
	public ArrayList<Tile> originals = new ArrayList<>();
	public Tile center;
	
	public Puzzle() {
		
	}
	
	public void addTile(Tile t, int col, int row) {
		t.setCol(col);
		t.setRow(row);
		
		// set center tile
		if (col == 1 && row == 1) {
			this.center = t;
		}
		
		tiles.add(t);
		originals.add(t.copy());
	}
	
	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}
	
	
	public Tile findTile(Coordinate coord) {
		// finds a tile at a certain coordinate
		Tile found = null;
		for (Tile t : tiles) {
			if (t.contains(coord)) {
				found = t;
			}
		}
		return found;
	}
	
	public boolean isVisible(Coordinate coord) {
		// asks whether the tile at a certain coordinate is visible
		for (Tile t : tiles) {
			if(t.contains(coord) && !t.removed) {
				return true;
			}
		}
		
		return false;
	}
	
	public Tile nextTile(Tile current, Direction dir) {
		// given a tile and a direction, returns the tile to be operated on in the specified direction
		int c = current.col + dir.deltaC;
		int r = current.row + dir.deltaR;
		
		Tile next = this.findTile(new Coordinate(c, r));
		return next;
	}
	
	public void reset() {
		// reset puzzle, specifically tiles
		tiles.clear();
		for (Tile t : originals) {
			tiles.add(t.copy());
		}
	}
	
}
