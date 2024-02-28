package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Asset.AccountList.Account;
import Asset.JTextField2;
import Insurance.Insurance;
import Main.DB;

public class InsuranceDesigner extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel nameP;
	private JPanel buttonP;
	private JPanel IDP;
	private JPanel radioP;

	@SuppressWarnings("unused")
	private PopUp x;

	private boolean VC = false;

	private JButton ID; // Insurance Development
	private JButton OK;
	private JButton cancel;

	private JLabel develop;
	private JLabel KI; // Kinds of Insurance
	private JLabel IT; // Insurance Target
	private JLabel R; // Restriction
	private JLabel IP; // Insurance Period
	private JLabel IF; // Insurance Fee
	private JLabel GC; // Guaranteed Content
	private JLabel P; // Penalty

	private JTextField2 ITT;
	private JTextField2 RT;
	private JTextField2 IPT;
	private JTextField2 IFT;
	private JTextField2 GCT;
	private JTextField2 PT;
	private JRadioButton KIC;
	private JRadioButton KIF;
	private JRadioButton KIIA;
	private JRadioButton KIL;
	private JRadioButton KIMH;
	private ButtonGroup radio;
	private DB DB;

	private ActionHandler actionHandler;
	@SuppressWarnings("unused")
	private ActionHandler2 actionHandler2;
	private ActionHandlerR actionHandlerr;
	@SuppressWarnings("unused")
	private ActionListener actionListener;

	private ArrayList<Insurance> iList;

	public InsuranceDesigner(DB dB, ActionListener ActionListener, WindowListener windowHandler,
			ActionListener ActionHandlerInit) {
		this.setTitle("보험설계사");
		this.iList = new ArrayList<Insurance>();

		this.DB = dB;
		this.addWindowListener(windowHandler);
		this.actionHandler = new ActionHandler();
		this.actionHandler2 = new ActionHandler2();

		this.actionListener = ActionListener;

		this.mainP = new JPanel();
		this.topP = new JPanel();
		this.nameP = new JPanel();
		this.buttonP = new JPanel();
		this.centerP = new JPanel();

		this.topP.setBackground(Color.white);
		this.nameP.setBackground(Color.white);
		this.buttonP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);

		this.develop = new JLabel();
		this.ID = new JButton("상품개발");
		this.ID.setActionCommand("상품개발");
		this.ID.addActionListener(this.actionHandler);

		this.nameP.add(this.develop);
		this.buttonP.add(this.ID);
		this.cancel = new JButton("취소");
		this.cancel.setActionCommand("취소");
		this.cancel.addActionListener(ActionHandlerInit);
		this.topP.add(this.nameP);
		this.topP.add(this.buttonP);

		this.topP.setLayout(new BorderLayout());
		this.topP.add(this.nameP, BorderLayout.NORTH);
		this.topP.add(this.buttonP, BorderLayout.SOUTH);
		this.mainP.setLayout(new BorderLayout());
		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);

		this.OK = new JButton("완료");
		this.OK.setActionCommand("완료");
		this.OK.addActionListener(ActionListener);

		this.add(mainP);
		this.setBackground(Color.white);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public DB getDB() {
		return this.DB;
	}

	public boolean InsuranceDevelopment() {
		this.actionHandlerr = new ActionHandlerR();

		if (VC == false) {
			this.IDP = new JPanel();
			this.IDP.setLayout(new GridLayout(9, 2));
			this.IDP.setBackground(Color.white);
			this.radioP = new JPanel();
			this.radioP.setBackground(Color.white);

			this.KI = new JLabel("보험 종류");
			this.IT = new JLabel("보험 대상");
			this.R = new JLabel("제약(나이, 직업, 병력)");
			this.IP = new JLabel("보장 기간");
			this.IF = new JLabel("보험료");
			this.GC = new JLabel("보장 내용");
			this.P = new JLabel("위반 시 위약금");

			this.ITT = new JTextField2();
			this.RT = new JTextField2();
			this.IPT = new JTextField2();
			this.IFT = new JTextField2();
			this.GCT = new JTextField2();
			this.PT = new JTextField2();

			this.KIC = new JRadioButton("Car");
			this.KIC.setActionCommand("Car");
			this.KIC.addActionListener(actionHandlerr);

			this.KIF = new JRadioButton("Fire");
			this.KIF.setActionCommand("Fire");
			this.KIF.addActionListener(actionHandlerr);

			this.KIIA = new JRadioButton("IndustrialAccident");
			this.KIIA.setActionCommand("IndustrialAccident");
			this.KIIA.addActionListener(actionHandlerr);

			this.KIL = new JRadioButton("Life");
			this.KIL.setActionCommand("Life");
			this.KIL.addActionListener(actionHandlerr);

			this.KIMH = new JRadioButton("MedicalHistory");
			this.KIMH.setActionCommand("MedicalHistory");
			this.KIMH.addActionListener(actionHandlerr);

			this.radio = new ButtonGroup();

			this.radio.add(KIC);
			this.radio.add(KIF);
			this.radio.add(KIIA);
			this.radio.add(KIL);
			this.radio.add(KIMH);

			this.radioP.add(KIC);
			this.radioP.add(KIF);
			this.radioP.add(KIIA);
			this.radioP.add(KIL);
			this.radioP.add(KIMH);
			this.IDP.add(KI);
			this.IDP.add(radioP);
			this.IDP.add(IT);
			this.IDP.add(ITT);
			this.IDP.add(R);
			this.IDP.add(RT);
			this.IDP.add(IP);
			this.IDP.add(IPT);
			this.IDP.add(IF);
			this.IDP.add(IFT);
			this.IDP.add(GC);
			this.IDP.add(GCT);
			this.IDP.add(P);
			this.IDP.add(PT);

			this.IDP.add(OK);
			this.IDP.add(cancel);

			this.centerP.add(IDP, BorderLayout.CENTER);
			this.revalidate();
			this.repaint();
			this.setVisible(true);
			VC = true;
		}
		return true;
	}

	public void developInsurance() {
		if (this.KIC.getText() == "Car") {
			Insurance insurance = new Insurance();
			String car = "car";
			insurance.setInsuranceType(car);
			insurance.setInsuranceTarget(this.ITT.getText());
			insurance.setRestriction(this.RT.getText());
			insurance.setInsurancePeriod(this.IPT.getText());
			insurance.setGuaranteedContent(this.GCT.getText());
			insurance.setInsuranceFee(Integer.parseInt(this.IFT.getText()));
			insurance.setPenalty(Integer.parseInt(this.PT.getText()));
			saveInsurance(insurance);
		} else if (this.KIF.getText() == "Fire") {
			String fire = "fire";
			Insurance insurance = new Insurance();
			insurance.setInsuranceType(fire);
			insurance.setInsuranceTarget(this.ITT.getText());
			insurance.setRestriction(this.RT.getText());
			insurance.setInsurancePeriod(this.IPT.getText());
			insurance.setGuaranteedContent(this.GCT.getText());
			insurance.setInsuranceFee(Integer.parseInt(this.IFT.getText()));
			insurance.setPenalty(Integer.parseInt(this.PT.getText()));
			saveInsurance(insurance);
		} else if (this.KIIA.getText() == "IndustrialAccident") {
			String industrialAccident = "IndustrialAccident";
			Insurance insurance = new Insurance();
			insurance.setInsuranceType(industrialAccident);
			insurance.setInsuranceTarget(this.ITT.getText());
			insurance.setRestriction(this.RT.getText());
			insurance.setInsurancePeriod(this.IPT.getText());
			insurance.setInsuranceFee(Integer.parseInt(this.IFT.getText()));
			insurance.setGuaranteedContent(this.GCT.getText());
			insurance.setPenalty(Integer.parseInt(this.PT.getText()));
			saveInsurance(insurance);
		} else if (this.KIL.getText() == "Life") {
			String life = "Life";
			Insurance insurance = new Insurance();
			insurance.setInsuranceType(life);
			insurance.setInsuranceTarget(this.ITT.getText());
			insurance.setRestriction(this.RT.getText());
			insurance.setInsurancePeriod(this.IPT.getText());
			insurance.setInsuranceFee(Integer.parseInt(this.IFT.getText()));
			insurance.setGuaranteedContent(this.GCT.getText());
			insurance.setPenalty(Integer.parseInt(this.PT.getText()));
			saveInsurance(insurance);
		} else if (this.KIMH.getText() == "MedicalHistory") {
			String medicalHistory = "MedicalHistory";
			Insurance insurance = new Insurance();
			insurance.setInsuranceType(medicalHistory);
			insurance.setInsuranceTarget(this.ITT.getText());
			insurance.setRestriction(this.RT.getText());
			insurance.setInsurancePeriod(this.IPT.getText());
			insurance.setInsuranceFee(Integer.parseInt(this.IFT.getText()));
			insurance.setGuaranteedContent(this.GCT.getText());
			insurance.setPenalty(Integer.parseInt(this.PT.getText()));
			saveInsurance(insurance);
		}
	}

	public void saveInsurance(Insurance insurance) {
		this.DB.setInsuranceList(insurance);
		this.DB.insert(insurance);
		System.out.println("ok");
	}

	public boolean setEmpolyee(Account account) {
		this.develop.setText(account.position + " - " + account.name + " 님");
		return true;
	}

	public ArrayList<Insurance> getIList() {
		return this.iList;
	}

	private class ActionHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("완료")) {
				removeAll();
			}
		}
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("상품개발")) {
				InsuranceDevelopment();
			}
		}
	}

	private class ActionHandlerR implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			switch(e.getActionCommand()) {
			case "Car":
				KIC.setText("car");
				break;
			case "Fire":
				KIF.setText("fire");
				break;
			case "IndustrialAccident":
				KIIA.setText("industrialAccident");
				break;
			case "Life":
				KIL.setText("life");
				break;
			case "MedicalHistory":
				KIMH.setText("medicalHistory");
				break;
			default:
				break;
			}
		}
	}
}