package example.puzzle.model;

public class Tile {
	int number;
	int row;
	int col;
	boolean removed;
	
	public Tile(int number) {
		this.number = number;
		this.removed = false;
	}
	
	public Tile copy() {
		Tile t = new Tile(this.number);
		t.row = this.row;
		t.col = this.col;
		
		return t;
	}
	
	public boolean removed() { return this.removed; }
	public int getRow() { return row; }
	public int getCol() { return col; }
	public int getNum() { return this.number; }
	
	public void setRemoved(boolean flag) { this.removed = flag; }
	public void setRow(int row) { this.row = row; } 
	public void setCol(int col) { this.col = col; } 
	public Coordinate getLocation() { return new Coordinate(col, row); }
	
	public boolean contains(Coordinate c) {
		if (c.col == this.col && c.row == this.row) {
			return true;
		} else {
			return false;
		}
	}
	
	public void move(Tile next, Direction dir) {
		// perform arithmetic stuff
		if (dir.equals(Direction.Right)) {
			next.number += this.number;
		} else if (dir.equals(Direction.Left)) {
			next.number = next.number - this.number;
		} else if (dir.equals(Direction.Up)) {
			next.number = next.number * this.number;
		} else if (dir.equals(Direction.Down)) {
			next.number = next.number / this.number;
		}
		
		// set tile to removed
		this.removed = true;
	}
	
	
}
