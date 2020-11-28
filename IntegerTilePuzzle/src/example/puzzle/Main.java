package example.puzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import example.puzzle.boundary.TilePuzzleApp;
import example.puzzle.controller.ExitController;
import example.puzzle.model.Model;
import example.puzzle.model.Puzzle;
import example.puzzle.model.Tile;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		TilePuzzleApp app = new TilePuzzleApp(m);
		Puzzle puzzle = new Puzzle();
		
		puzzle.addTile(new Tile(3), 0, 0);
		puzzle.addTile(new Tile(6), 1, 0);
		puzzle.addTile(new Tile(8), 2, 0);
		puzzle.addTile(new Tile(9), 0, 1);
		puzzle.addTile(new Tile(1), 1, 1);
		puzzle.addTile(new Tile(2), 2, 1);
		puzzle.addTile(new Tile(4), 0, 2);
		puzzle.addTile(new Tile(5), 1, 2);
		puzzle.addTile(new Tile(7), 2, 2);

		m.setPuzzle(puzzle);
		
		app.addWindowFocusListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		app.setVisible(true);
	}

}
