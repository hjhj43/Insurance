package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Asset.AccountList.Account;
import Main.DB;

public class InsuranceManager extends JFrame {
	private static final long serialVersionUID = 1L;

	private boolean VC = false;
	@SuppressWarnings("unused")
	private boolean BC = false;
	private String kind;
	String[] iCheader = { "회원ID", "이름", "나이", "분납/수금 여부" };
	String[] eCheader = { "회원ID", "이름", "나이", "만기계약 여부" };

	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel nameP;
	private JPanel buttonP;
	private JPanel CMGP;
	private JPanel guidelineP;
	private JPanel CMGPButtonP;
	private JPanel MCAP;
	private JPanel MCAPButtonP;
	private JPanel MCAP2;
	private JPanel MCAP2ButtonP;

	private JButton CMG; // enter contract management guidelines
	private JButton check;
	private JButton cancel;
	private JButton MCA; // do maintain contract activities
	private JButton MCAMCA;
	private JButton MCACancel;
	private JButton MCA2;
	private JButton MCA2MCA2;
	private JButton MCA2Cancel;

	private JLabel manager;
	private JLabel listName;
	private TextArea guidelineT;

	private JTable table;
	private JScrollPane scrollpane;
	private DB DB;

	private String guideline;

	private Vector<String> guidelineList;

	private DefaultTableModel model;

	private ActionHandler actionHandler;

	public InsuranceManager(DB dB, WindowListener windowHandler, ActionListener ActionHandlerM) {
		this.setTitle("보험관리자");
		this.actionHandler = new ActionHandler();
		this.DB = dB;
		this.addWindowListener(windowHandler);
		this.mainP = new JPanel();
		this.topP = new JPanel();
		this.nameP = new JPanel();
		this.buttonP = new JPanel();
		this.centerP = new JPanel();
		this.MCAP2 = new JPanel();

		this.setBackground(Color.white);
		this.topP.setBackground(Color.white);
		this.nameP.setBackground(Color.white);
		this.buttonP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);
		this.mainP.setBackground(Color.white);

		this.manager = new JLabel();
		this.CMG = new JButton("계약관리지침");
		this.CMG.setActionCommand("계약관리지침");
		this.CMG.addActionListener(this.actionHandler);
		this.MCA = new JButton("계약유지활동(분납/수금)");
		this.MCA.setActionCommand("계약유지활동(분납/수금)");
		this.MCA.addActionListener(this.actionHandler);
		this.MCA2 = new JButton("계약유지활동(만기계약)");
		this.MCA2.setActionCommand("계약유지활동(만기계약)");
		this.MCA2.addActionListener(this.actionHandler);

		this.nameP.add(this.manager);
		this.buttonP.add(this.CMG);
		this.buttonP.add(this.MCA);
		this.buttonP.add(this.MCA2);

		this.topP.add(this.nameP);
		this.topP.add(this.buttonP);
		this.check = new JButton("확인");
		this.check.addActionListener(ActionHandlerM);
		this.check.setActionCommand("확인");

		this.MCA2MCA2 = new JButton("만기계약");
		this.MCA2MCA2.setActionCommand("만기계약");
		this.MCA2MCA2.addActionListener(ActionHandlerM);
		this.MCAMCA = new JButton("분납/수금");
		this.MCAMCA.setActionCommand("분납/수금");
		this.MCAMCA.addActionListener(ActionHandlerM);
		
		this.topP.setLayout(new BorderLayout());
		this.topP.add(this.nameP, BorderLayout.NORTH);
		this.topP.add(this.buttonP, BorderLayout.SOUTH);
		this.mainP.setLayout(new BorderLayout());
		this.mainP.add(this.topP, BorderLayout.NORTH);

		this.add(mainP);
		this.setBackground(Color.white);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public DB getDB() {
		return this.DB;
	}

	public void ContractManagementGuidelines() {
		if (this.VC == false) {
			this.CMGP = new JPanel();
			this.guidelineP = new JPanel();
			this.CMGPButtonP = new JPanel();

			this.CMGPButtonP.setLayout(new GridLayout(2, 1));

			this.guidelineP.setBackground(Color.white);
			this.CMGPButtonP.setBackground(Color.white);

			this.guidelineT = new TextArea("----계약관리지침----", 20, 40);
			this.guidelineP.add(this.guidelineT);

			this.cancel = new JButton("취소");
			this.cancel.setActionCommand("취소");
			this.cancel.addActionListener(actionHandler);
			this.CMGPButtonP.add(check);
			this.CMGPButtonP.add(cancel);

			this.CMGP.add(this.guidelineP);
			this.CMGP.add(this.CMGPButtonP);
			this.centerP.add(this.CMGP);
			this.mainP.add(this.centerP, BorderLayout.CENTER);
			this.centerP.updateUI();
			this.VC = true;
		}
	}

	public boolean SaveGuidelines() {
		this.guideline = this.guidelineT.getText();
		this.DB.setContractManagementGuideList(guideline);
		return true;
	}

	public boolean SaveExpiration() {
		model.setValueAt("O",this.table.getSelectedRow(), 3);
		return true;
	}

	public boolean SavePayment() {
		model.setValueAt("O",this.table.getSelectedRow(), 3);
		return true;
	}

	public boolean setEmpolyee(Account account) {
		this.manager.setText(account.position + " - " + account.name + " 님");
		return true;
	}

	public void InstallmentCollectionPayment() {
		if (this.VC == false) {
			this.MCAP = new JPanel();
			this.MCAPButtonP = new JPanel();
			this.listName = new JLabel("분납/수금 고객리스트");
			this.model = new DefaultTableModel(iCheader, 0);
			for (int i = 0; i < this.DB.getCustomerList().ShowSize(); i++) {
				String ID = this.DB.getCustomerList().search(i).getID();
				String name = this.DB.getCustomerList().search(i).getName();
				int age = this.DB.getCustomerList().search(i).getAge();
				String ox = "X";
				model.addRow(new Object[] { ID, name, age, ox });
			}

			this.table = new JTable(model);
			this.scrollpane = new JScrollPane(this.table);
			this.scrollpane.setPreferredSize(new Dimension(500, 300));
			
			this.MCACancel = new JButton("취소");

			this.MCAPButtonP.add(this.MCAMCA);
			this.MCAPButtonP.add(this.MCACancel);

			this.MCAP.setLayout(new BorderLayout());
			this.MCAP.add(this.listName, BorderLayout.NORTH);
			this.MCAP.add(this.scrollpane, BorderLayout.CENTER);
			this.centerP.add(this.MCAP, BorderLayout.CENTER);
			this.centerP.add(this.MCAPButtonP, BorderLayout.SOUTH);
			this.mainP.add(this.centerP, BorderLayout.CENTER);
			this.centerP.updateUI();
			this.VC = true;
		}
	}

	public void ExpirationContract() {
		if (this.VC == false) {
			this.MCAP2 = new JPanel();
			this.MCAP2ButtonP = new JPanel();
			this.listName = new JLabel("만기계약 고객리스트");
			this.model = new DefaultTableModel(eCheader, 0);

			for (int i = 0; i < this.DB.getCustomerList().ShowSize(); i++) {
				String ID = this.DB.getCustomerList().search(i).getID();
				String name = this.DB.getCustomerList().search(i).getName();
				int age = this.DB.getCustomerList().search(i).getAge();
				String ox = "X";
				model.addRow(new Object[] { ID, name, age, ox });
			}
			this.table = new JTable(model);
			this.scrollpane = new JScrollPane(this.table);
			this.scrollpane.setPreferredSize(new Dimension(500, 300));

			this.MCA2Cancel = new JButton("취소");
			this.MCAP2ButtonP.add(this.MCA2MCA2);
			this.MCAP2ButtonP.add(this.MCA2Cancel);

			this.MCAP2.setLayout(new BorderLayout());
			this.MCAP2.add(this.listName, BorderLayout.NORTH);
			this.MCAP2.add(scrollpane);
			this.centerP.add(this.MCAP2, BorderLayout.CENTER);
			this.centerP.add(this.MCAP2ButtonP, BorderLayout.SOUTH);
			this.mainP.add(this.centerP, BorderLayout.CENTER);
			this.centerP.updateUI();
			this.VC = true;
		}
	}

	public void remove(String button) {
		if (button == "계약관리지침") {
			this.centerP.removeAll();
			this.VC = false;
		} else if (button == "계약유지활동(분납/수금)") {
			this.centerP.removeAll();
			this.VC = false;
			this.BC = false;
		} else if (button == "계약유지활동(만기계약)") {
			this.centerP.removeAll();
			this.VC = false;
			this.BC = false;
		}
	}

	public String getKind() {
		return this.kind;
	}

	public boolean setKind(String kind) {
		this.kind = kind;
		return true;
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("계약관리지침")) {
				setKind("계약관리지침");
				remove("계약관리지침");
				ContractManagementGuidelines();
			} else if (e.getActionCommand().equals("계약유지활동(분납/수금)")) {
				setKind("계약유지활동(분납/수금)");
				remove("계약유지활동(분납/수금)");
				InstallmentCollectionPayment();
			} else if (e.getActionCommand().equals("계약유지활동(만기계약)")) {
				setKind("계약유지활동(만기계약)");
				remove("계약유지활동(만기계약)");
				ExpirationContract();
			} else if (e.getActionCommand().equals("확인")) {
				guideline = guidelineT.getText();
				guidelineList.add(guideline);
				DB.setGuidelineList(guidelineList);
			} else if (e.getActionCommand().equals("취소")) {

			}
		}
	}
}