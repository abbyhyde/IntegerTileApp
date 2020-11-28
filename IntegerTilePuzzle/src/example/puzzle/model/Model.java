package example.puzzle.model;

import java.util.ArrayList;

public class Model {
	Puzzle puzzle;
	Tile selectedTile;
	boolean gameOver;
	
	public Model() {
		
	}
	
	public boolean tryMove(Direction dir) {
		if (selectedTile == null) { return false; }
		
		for (Direction d : availableMoves()) {
			if (d == dir) {
				// move the tile in the direction
				// get tile in direction
				Tile next = puzzle.nextTile(selectedTile, dir);
				// pass other tile into move method of selected tile
				selectedTile.move(next, dir);
				this.selectedTile = null;
				return true;
			}
		}
		
		return true;
	}
	
	public ArrayList<Direction> availableMoves() {
		ArrayList<Direction> moves = new ArrayList<>();
		if (selectedTile == null) {
			return moves; 
		} 
		return availableMoves(selectedTile); 
	}
	
	public ArrayList<Direction> availableMoves(Tile t) {
		// collects a list of moves that are valid based on the selected tile
		ArrayList<Direction> moves = new ArrayList<>();
		Coordinate coord = t.getLocation();
		
		if (t.contains(new Coordinate(1,1))) {
			return moves;
		}
		/*
		 * testing things to determine whether each direction is a valid move for the current selected tile
		 * 1. whether there is a visible tile to the side vs a removed tile or the edge of the puzzle
		 * 2. if there is a visible tile, whether the computation is valid or not
		 */
		// left?
		boolean available = true;
		Tile next = puzzle.findTile(new Coordinate(t.col-1, t.row));
		if (!puzzle.isVisible(new Coordinate(t.col-1, t.row))) {
			available = false;
			
		} else if (next.number - t.number < 1) {
			available = false;
		}
		if (available) {
			moves.add(Direction.Left);
		}
		
		// right?
		available = true;
		if (!puzzle.isVisible(new Coordinate(t.col+1, t.row))) {
			available = false;
		}
		if (available) {
			moves.add(Direction.Right);
		}
		
		// up? 
		available = true;
		if (!puzzle.isVisible(new Coordinate(t.col, t.row-1))) {
			available = false;
		}
		if (available) {
			moves.add(Direction.Up);
		}
		
		// down?
		next = puzzle.findTile(new Coordinate(t.col, t.row+1));
		available = true;
		if (!puzzle.isVisible(new Coordinate(t.col, t.row+1))) {
			available = false;
		} else if ((next.number % t.number) != 0) {
			available = false;
		}
		if (available) {
			moves.add(Direction.Down);
		}
		
		return moves;
	}
	
	public void setPuzzle(Puzzle p) { 
		puzzle = p;
		gameOver = false;
		selectedTile = null;
		}
	public Puzzle getPuzzle() { return this.puzzle; }
	
	public void setSelectedTile(Tile t) { selectedTile = t; }
	public Tile getSelectedTile() { return selectedTile; }
	public void clearSelectedTile() { selectedTile = null; }
	
	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean flag) { gameOver = flag; }
	
	public void resetPuzzle() {
		selectedTile = null;
		gameOver = false;
		// no update buttons as model is ind of gui activity
		puzzle.reset();
	}
	
	public boolean isWinCondition() {
		// so if all tiles are removed besides center tile and center tile is 11
		// if center tile is removed, then immediate fail
		if (puzzle.center.removed()) {
			return false;
		}
		for (Tile t : puzzle.tiles) {
			// otherwise, check if it's not a center piece that's been removed
			if (!t.removed() && (t.getCol() != 1 || t.getRow() != 1)) {
				return false;
			}
 		}

		if (puzzle.center.getNum() % 1 == 0) {
			this.setGameOver(true);
			return true;
		}

		return false;
	}
	
	
	public boolean isLossCondition() {
		// checks if there is a guaranteed loss
		// if two adjacent side pieces are removed
		
		if (this.isGameOver()) {
			return false;
		}
		
		Tile topLeft = this.puzzle.findTile(new Coordinate(0,0));
		Tile topMiddle = this.puzzle.findTile(new Coordinate(1,0));
		Tile topRight = this.puzzle.findTile(new Coordinate(2,0));
		Tile middleLeft = this.puzzle.findTile(new Coordinate(0,1));
		Tile middleRight = this.puzzle.findTile(new Coordinate(2,1));
		Tile bottomLeft = this.puzzle.findTile(new Coordinate(0,2));
		Tile bottomMiddle = this.puzzle.findTile(new Coordinate(1,2));
		Tile bottomRight = this.puzzle.findTile(new Coordinate(2,2));
		
		if (topMiddle.removed() && middleLeft.removed() && !topLeft.removed()) {
			return true;
		} else if (topMiddle.removed() && middleRight.removed() && !topRight.removed()) {
			return true;
		} else if (bottomMiddle.removed() && middleLeft.removed() && !bottomLeft.removed()) {
			return true;
		} else if (bottomMiddle.removed() && middleRight.removed() && !bottomRight.removed()) {
			return true;
		}

		// or there are no valid moves left
		// for each tile besides the center/removed tiles, test if there's no valid moves
		int count = 0;
		int removed = 0;
		
		for (Tile t : this.puzzle.tiles) { 
			if (!t.contains(new Coordinate(1,1)) && !t.removed()) {
				ArrayList<Direction> am = this.availableMoves(t);
				if (am.isEmpty()) {
					count++;
				}
			} else {
				removed++;
			}
		}
		
		if (count == 9 - removed) {
			return true;
		}
	
		return false;
	}
	
	
}
