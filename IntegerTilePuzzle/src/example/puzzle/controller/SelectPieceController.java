package example.puzzle.controller;

import java.awt.Point;
import java.util.ArrayList;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Coordinate;
import example.puzzle.model.Direction;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class SelectPieceController {
	
	Model model;
	TilePuzzleApp app;
	
	
	public SelectPieceController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void process(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		// gets coordinate of mouse click
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {
			// if coordinate matches tile, then select
			if (t.contains(c) && !t.removed()) {
				model.clearSelectedTile();
				model.setSelectedTile(t);
				
				ArrayList<Direction> moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
			}
		}
	}
}
