package example.puzzle.boundary;

import java.util.ArrayList;
import java.util.List;

import example.puzzle.model.Direction;

public class UpdateButtons {
	public static void enableButtons(TilePuzzleApp app, ArrayList<Direction> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		
		for (Direction d : moves) {
			if (d == Direction.Left) {
				app.getLeftButton().setEnabled(true);
			} else if (d == Direction.Right) {
				app.getRightButton().setEnabled(true);
			} else if (d == Direction.Up) {
				app.getUpButton().setEnabled(true);
			} else if (d == Direction.Down) {
				app.getDownButton().setEnabled(true);
			}
		}
	}
}
