package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Asset.AccountList;
import Asset.AccountList.Account;
import Customer.Customer;
import Main.DB;

public class SignUp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel bottomP;
	private JPanel IDP;
	private JPanel radioP;
	private JPanel CPRNP;

	private JLabel CA;
	private JLabel CDB;
	private JLabel CEA;
	private JLabel CID;
	private JLabel CJ;
	private JLabel CMH;
	private JLabel CN;
	private JLabel CPW;
	private JLabel CPAN;
	private JLabel CPRN;
	private JLabel CPN;
	private JLabel CRA;
	private JLabel CS;
	private JLabel l;

	private JTextField CAT;
	private JTextField CDBT;
	private JTextField CEAT;
	private JTextField CIDT;
	private JTextField CJT;
	private JTextField CMHT;
	private JTextField CNT;
	private JTextField CPWT;
	private JTextField CPANT;
	private JTextField CPRNT1;
	private JTextField CPRNT2;
	private JTextField CPNT;
	private JTextField CRAT;
	private JRadioButton CSM;
	private JRadioButton CSW;
	private ButtonGroup radio;

	private JButton checkID;
	private JButton ok;
	private JButton cancel;

	private boolean idCheck = false;

	private JLabel signUp;

	private ActionHandlerA AC;
	@SuppressWarnings("unused")
	private AccountList accountList;

	private DB DB;

	public SignUp(DB dB2, ActionListener ActionHandlerC) {
		this.accountList = new AccountList();
		this.AC = new ActionHandlerA();
		this.DB = dB2;

		this.signUp = new JLabel("ȸ������");
		this.mainP = new JPanel();
		this.topP = new JPanel();
		this.centerP = new JPanel();
		this.bottomP = new JPanel();
		this.IDP = new JPanel();
		this.radioP = new JPanel();
		this.CPRNP = new JPanel();

		this.CA = new JLabel("����");
		this.CDB = new JLabel("����");
		this.CEA = new JLabel("�̸���");
		this.CID = new JLabel("���̵�");
		this.CJ = new JLabel("����");
		this.CMH = new JLabel("����");
		this.CN = new JLabel("�̸�");
		this.CPW = new JLabel("��й�ȣ");
		this.CPAN = new JLabel("���¹�ȣ");
		this.CPRN = new JLabel("�ֹι�ȣ");
		this.CPN = new JLabel("��ȭ��ȣ");
		this.CRA = new JLabel("�ּ�");
		this.CS = new JLabel("����");
		this.l = new JLabel("-");

		this.CAT = new JTextField();
		this.CDBT = new JTextField();
		this.CEAT = new JTextField();
		this.CIDT = new JTextField();
		this.CJT = new JTextField();
		this.CMHT = new JTextField();
		this.CNT = new JTextField();
		this.CPWT = new JTextField();
		this.CPANT = new JTextField();
		this.CPRNT1 = new JTextField();
		this.CPRNT2 = new JTextField();
		this.CPNT = new JTextField();
		this.CRAT = new JTextField();
		this.CSW = new JRadioButton("����");
		this.CSM = new JRadioButton("����");
		this.CSW.setSelected(true);
		this.radio = new ButtonGroup();
		this.radio.add(CSW);
		this.radio.add(CSM);

		this.CSW.setActionCommand("����");
		this.CSM.setActionCommand("����");

		this.mainP.setBackground(Color.white);
		this.topP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);
		this.bottomP.setBackground(Color.white);
		this.IDP.setBackground(Color.white);
		this.radioP.setBackground(Color.white);
		this.CPRNP.setBackground(Color.white);

		this.centerP.setLayout(new GridLayout(13, 2));
		this.bottomP.setLayout(new GridLayout(1, 2));
		this.mainP.setLayout(new BorderLayout());
		this.IDP.setLayout(new BorderLayout());
		this.CPRNP.setLayout(new BoxLayout(CPRNP, BoxLayout.X_AXIS));

		this.checkID = new JButton("�ߺ�");
		this.checkID.setActionCommand("�ߺ�");
		this.checkID.addActionListener(AC);

		this.ok = new JButton("����");
		this.ok.setActionCommand("����");
		this.ok.addActionListener(ActionHandlerC);

		this.cancel = new JButton("���");
		this.cancel.setActionCommand("���");
		this.cancel.addActionListener(AC);

		this.radioP.add(this.CSW);
		this.radioP.add(this.CSM);
		this.IDP.add(this.CIDT, BorderLayout.CENTER);
		this.IDP.add(this.checkID, BorderLayout.EAST);
		this.CPRNP.add(this.CPRNT1);
		this.CPRNP.add(this.l);
		this.CPRNP.add(this.CPRNT2);
		this.centerP.add(this.CN);
		this.centerP.add(this.CNT);
		this.centerP.add(this.CA);
		this.centerP.add(this.CAT);
		this.centerP.add(this.CDB);
		this.centerP.add(this.CDBT);
		this.centerP.add(this.CID);
		this.centerP.add(this.IDP);
		this.centerP.add(this.CPW);
		this.centerP.add(this.CPWT);
		this.centerP.add(this.CS);
		this.centerP.add(this.radioP);
		this.centerP.add(this.CEA);
		this.centerP.add(this.CEAT);
		this.centerP.add(this.CPAN);
		this.centerP.add(this.CPANT);
		this.centerP.add(this.CPN);
		this.centerP.add(this.CPNT);
		this.centerP.add(this.CRA);
		this.centerP.add(this.CRAT);
		this.centerP.add(this.CPRN);
		this.centerP.add(this.CPRNP);
		this.centerP.add(this.CJ);
		this.centerP.add(this.CJT);
		this.centerP.add(this.CMH);
		this.centerP.add(this.CMHT);

		this.topP.add(this.signUp);
		this.bottomP.add(this.ok);
		this.bottomP.add(this.cancel);
		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);
		this.mainP.add(this.bottomP, BorderLayout.SOUTH);
		this.add(this.mainP);

		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public boolean CheckID() {
		int count = 0;
		for (int i = 0; i < this.DB.getAccountList().getAccountList().size(); i++) {
			if (this.CIDT.getText().equals(this.DB.getAccountList().getAccountList().get(i).id)) {
				return false;
			} else {
				count++;
			}
		}
		if (count == this.DB.getAccountList().getAccountList().size()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Typehehe() {
		if (CheckDataType(this.CAT).equals("int") && CheckDataType(this.CDBT).equals("int")
				&& CheckDataType(this.CEAT).equals("String") && CheckDataType(this.CIDT).equals("String")
				&& CheckDataType(this.CJT).equals("String") && CheckDataType(this.CMHT).equals("String")
				&& CheckDataType(this.CNT).equals("String") && CheckDataType(this.CPWT).equals("String")
				&& CheckDataType(this.CPANT).equals("int") && CheckDataType(this.CPRNT1).equals("int")
				&& CheckDataType(this.CPRNT2).equals("int") && CheckDataType(this.CPNT).equals("int")
				&& CheckDataType(this.CRAT).equals("String")) {
			return false;
		} else {
			return true;
		}
	}

	public String CheckDataType(JTextField textField) {
		if (!textField.getText().getClass().getName().equals("java.lang.Integer")) {
			String a = "int";
			return a;
		} else if (!textField.getText().getClass().getName().equals("java.lang.String")) {
			String b = "String";
			return b;
		} else {
			return null;
		}
	}

	public boolean CheckContent() {
		if (this.CAT.getText().isBlank() || this.CDBT.getText().isBlank() || this.CEAT.getText().isBlank()
				|| this.CIDT.getText().isBlank() || this.CJT.getText().isBlank() || this.CMHT.getText().isBlank()
				|| this.CNT.getText().isBlank() || this.CPWT.getText().isBlank() || this.CPANT.getText().isBlank()
				|| this.CPRNT1.getText().isBlank() || this.CPRNT2.getText().isBlank() || this.CPNT.getText().isBlank()
				|| this.CRAT.getText().isBlank()) {
		}
		return true;
	}

	public Customer getCustomer() {
		Customer customer = new Customer();
		if (Typehehe() == true) {
			customer.setAge(Integer.parseInt(this.CAT.getText()));
			customer.setDateOfBirth(Integer.parseInt(this.CDBT.getText()));
			customer.setEmailAddress(this.CEAT.getText());
			customer.setID(this.CIDT.getText());
			customer.setJob(this.CJT.getText());
			customer.setMedicalHistory(this.CMHT.getText());
			customer.setName(this.CNT.getText());
			customer.setPassword(this.CPWT.getText());
			customer.setPersonalAccountNumber(Integer.parseInt(this.CPANT.getText()));
			customer.setPersonalRegistrationNumber(Integer.parseInt(this.CPRNT1.getText()));
			customer.setPersonalRegistrationNumber(Integer.parseInt(this.CPRNT2.getText()));
			customer.setPhoneNumber(Integer.parseInt(this.CPNT.getText()));
			customer.setRegistrationAddress(this.CRAT.getText());
			this.DB.insert(customer);

			if (this.CSW.isSelected()) {
				customer.setSex(this.CSW.getText());
			} else if (this.CSM.isSelected()) {
				customer.setSex(this.CSM.getText());
			}
			return customer;
		} else {
			@SuppressWarnings("unused")
			PopUp a = new PopUp("�ùٸ� �Է� ������ �ƴմϴ�! �ٽ� �ѹ� Ȯ�����ּ���!");
			return null;
		}
	}

	public Account getAccount() {
		Account account = new Account();
		if (Typehehe() == true) {
			account.setID(this.CIDT.getText());
			account.setPosition(this.CJT.getText());
			account.setName(this.CNT.getText());
			account.setPW(this.CPWT.getText());
			this.DB.insert(account);
			return account;
		} else {
			@SuppressWarnings("unused")
			PopUp a = new PopUp("�ùٸ� �Է� ������ �ƴմϴ�! �ٽ� �ѹ� Ȯ�����ּ���!");
			return null;
		}
	}

	public boolean getIDCheck() {
		return this.idCheck;
	}

	public void CloseSignUp() {
		this.dispose();
	}

	private class ActionHandlerA implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�ߺ�")) {
				if (CheckID() == true) {
					@SuppressWarnings("unused")
					PopUp o = new PopUp("��� ������ ���̵��Դϴ�.");
					idCheck = true;
				} else if (CheckID() == false) {
					@SuppressWarnings("unused")
					PopUp x = new PopUp("�ߺ��� ���̵��Դϴ�.");
					idCheck = false;
				}
			} else if (e.getActionCommand().equals("���")) {
				dispose();
			}
		}
	}
}