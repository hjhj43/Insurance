package Asset;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sign extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel OKPanel;
	private JPanel drawingPanel;
	private JPanel buttonPanel;
	private JPanel Mainp;
	private JPanel TopP;

	private Graphics Rg;
	private JLabel sign;

	private JButton OK;
	private JButton RE;
	private int px, py;

	private MouseHandler MH;
	private ActionHandler AC;

	public Sign(ActionListener ActionSign) {

		this.AC = new ActionHandler();
		this.MH = new MouseHandler();

		this.sign = new JLabel("서명");
		this.TopP = new JPanel();
		this.Mainp = new JPanel();
		this.drawingPanel = new JPanel();
		this.OKPanel = new JPanel();
		this.drawingPanel.addMouseListener(this.MH);
		this.drawingPanel.addMouseMotionListener(MH);
		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(new GridLayout(0, 2));
		this.Mainp.setLayout(new BorderLayout());

		this.TopP.setBackground(Color.white);
		this.Mainp.setBackground(Color.white);
		this.drawingPanel.setBackground(Color.white);
		this.OKPanel.setBackground(Color.white);

		this.OK = new JButton("저장");
		this.OK.setActionCommand("저장");
		this.OK.addActionListener(ActionSign);
		this.RE = new JButton("지우기");
		this.RE.setActionCommand("지우기");
		this.RE.addActionListener(AC);

		this.TopP.add(this.sign);
		this.buttonPanel.add(this.OK);
		this.buttonPanel.add(this.RE);
		this.Mainp.add(this.TopP, BorderLayout.NORTH);
		this.Mainp.add(this.drawingPanel, BorderLayout.CENTER);
		this.Mainp.add(this.buttonPanel, BorderLayout.SOUTH);
		this.add(Mainp);

		this.setLocationRelativeTo(null);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public Graphics getSign() {
		return this.Rg;
	}

	public boolean draw(int x, int y) {
		Graphics g = (this.drawingPanel.getGraphics());
		g.setColor(Color.black);
		g.drawLine(px, py, x, y);
		this.px = x;
		this.py = y;
		this.Rg = g;
		return true;
	}

	public boolean setInitial(int x, int y) {
		this.px = x;
		this.py = y;
		return true;
	}

	private class MouseHandler implements MouseMotionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			draw(e.getX(), e.getY());
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			setInitial(e.getX(), e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			draw(e.getX(), e.getY());
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

	public boolean RePaint() {
		this.drawingPanel.repaint();
		return true;
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("지우기")) {
				RePaint();
			}
		}
	}
}
