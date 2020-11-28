package example.puzzle.controller;

import javax.swing.JOptionPane;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.model.Model;

public class ExitController {
	TilePuzzleApp app;
	
	public ExitController(TilePuzzleApp app) {
		this.app = app;
	}
	
	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit the application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
