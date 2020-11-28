package example.puzzle.model;

public class Coordinate {
	public final int col;
	public final int row;
	
	public Coordinate(int c, int r) {
		this.col = c;
		this.row = r;
	}
	
	public String toString() {
		return "(" + col + ", " + row + ")";
	}
	
	public boolean equals(Coordinate c) {
		return c.row == this.row && c.col == this.col;
	}
}
