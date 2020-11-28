package example.puzzle.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.puzzle.model.Direction;
import example.puzzle.model.Model;
import example.puzzle.controller.ExitController;
import example.puzzle.controller.ResetController;
import example.puzzle.controller.SelectPieceController;
import example.puzzle.controller.SlideTileController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;
import java.awt.Component;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class TilePuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	Model model;
	
	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton btnReset;
	JButton btnQuit;
	
	public PuzzlePanel getPuzzlePanel() { return panel; }
	public JButton getUpButton() { return btnUp; }
	public JButton getDownButton() { return btnDown; }
	public JButton getLeftButton() { return btnLeft; }
	public JButton getRightButton() { return btnRight; }

	
	/**
	 * Create the frame.
	 */
	public TilePuzzleApp(Model m) {
		// top level boundary object
		super();
		this.model = m;
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 666, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(model, TilePuzzleApp.this).process(me.getPoint());
			}
		});
		
		btnUp = new JButton("^");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SlideTileController stc = new SlideTileController(model, TilePuzzleApp.this);
				stc.move(Direction.Up);
			}
		});
		
		btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SlideTileController stc = new SlideTileController(model, TilePuzzleApp.this);
				stc.move(Direction.Left);
 				
			}
		});
		
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SlideTileController stc = new SlideTileController(model, TilePuzzleApp.this);
				stc.move(Direction.Right);
			}
		});
		
		btnDown = new JButton("v");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SlideTileController stc = new SlideTileController(model, TilePuzzleApp.this);
				stc.move(Direction.Down);
			}
		});
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, TilePuzzleApp.this).reset();
			}
		});
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExitController(TilePuzzleApp.this).exit();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
							.addComponent(btnQuit)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(50)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnDown)
										.addComponent(btnUp)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnLeft)
									.addGap(61)
									.addComponent(btnRight)))
							.addGap(62))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnQuit))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addComponent(btnUp)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLeft)
								.addComponent(btnRight))
							.addGap(18)
							.addComponent(btnDown))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		UpdateButtons.enableButtons(this, new ArrayList<Direction>());
	}
}
