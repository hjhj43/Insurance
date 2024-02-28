package Asset;

import javax.swing.JTextField;

public class JTextField2 extends JTextField {
	private static final long serialVersionUID = 1L;

	private String stringText;
	private int intText;

	public JTextField2() {

	}

	public void setStringText() {
		try {
			this.stringText = this.getText();
		} catch (Exception e) {
			System.out.println("not String");
		}
	}

	public void setIntText() {
		try {
			this.intText = Integer.parseInt(this.getText());
		} catch (Exception e) {
			System.out.println("not int");
		}
	}

	public int getIntText() {
		setStringText();
		return this.intText;
	}

	public String getStringText() {
		setStringText();
		return this.stringText;
	}

}
