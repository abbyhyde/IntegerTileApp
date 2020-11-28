package example.puzzle.controller;

import java.util.ArrayList;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Coordinate;
import example.puzzle.model.Direction;
import example.puzzle.model.Model;

public class SlideTileController {
	Model model;
	TilePuzzleApp app;
	
	public SlideTileController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public boolean move(Direction direction) {
		if (model.getSelectedTile() == null) {
			return false;
		}
		
		if (model.isGameOver()) {
			return false;
		}
		
		if (model.isLossCondition()) {
			model.setGameOver(true);
			app.repaint();
			return false;
		}
		
		if (model.isWinCondition()) {
			model.setGameOver(true);
			app.repaint();
			return false;
		}
	
		if (model.tryMove(direction)) {
			// changed state of system, so repaint
			
			// reset list of available moves
			UpdateButtons.enableButtons(app, model.availableMoves());
			
			app.repaint();
		}
		
		return true;
	}
	
	
}
