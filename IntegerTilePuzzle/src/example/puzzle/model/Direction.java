package example.puzzle.model;

public enum Direction {
	Left(-1,0), Right(1,0), Up(0,-1), Down(0,1);
	
	final int deltaR;
	final int deltaC;
	
	Direction(int dc, int dr) {
		this.deltaC = dc;
		this.deltaR = dr; 
	}
}
