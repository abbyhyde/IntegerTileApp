package example.puzzle.controller;

import java.util.ArrayList;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.boundary.UpdateButtons;
import example.puzzle.model.Direction;
import example.puzzle.model.Model;

public class ResetController {
	Model model;
	TilePuzzleApp app;
	
	public ResetController(Model m, TilePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.availableMoves());
		
		app.repaint();
	}
	
	
}