package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Asset.AccountList.Account;
import Asset.JTextField2;
import Asset.Sign;
import Contract.Contract;
import Customer.Customer;
import Customer.CustomerList;
import Employee.Employee;
import Employee.EmployeeListImpl;
import Main.DB;

public class SalesMan extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean VC = false;

	private int I = 0;
	private JPanel mainP;
	private JPanel centerP;
	private JPanel topP;
	private JPanel labelP;
	private JPanel buttomP;
	private JPanel bottomP;
	private JPanel centerP2;

	private JPanel centerEastP;

	private JButton selectCustomer;
	private JButton proposal;
	private JButton subscriptionForm;
	private JButton fixSubscriptionForm;
	private JButton insuranceReceipt;
	private JButton finalContract;

	private JButton cancel;
	private JButton ok;

	private JButton sign;
	private JButton sign2;

	private JLabel company;
	private JLabel userName;

	@SuppressWarnings("rawtypes")
	private JList selectList;
	@SuppressWarnings("rawtypes")
	private JList selectList2;
	@SuppressWarnings("rawtypes")
	private JList selectList3;
	private JScrollPane scrollpane;
	private JScrollPane scrollpane2;
	private JScrollPane scrollpane3;

	private JTextField2 proposalField;
	private JTextField2 subscriptionFormField;
	private JTextField2 fixSubscriptionFormField;
	@SuppressWarnings("unused")
	private CustomerList customerList;

	private ActionHandler AC;
	private String targetCustomer = null;
	private Customer checkReceipt;
	@SuppressWarnings("unused")
	private String contract = null;

	private ActionSign actionSign;

	@SuppressWarnings("unused")
	private EmployeeListImpl eli;

	private Sign signFrame;
	private DB DB;
	@SuppressWarnings("unused")
	private Rectangle Bound;
	private Customer TargetCustomer;
	private Employee employee;

	public SalesMan(DB dB, WindowListener WindowHandler, ActionListener ActionHandlerS) {
		this.DB = dB;
		this.setTitle("영업사원");
		this.customerList = this.DB.getCustomerList();

		this.addWindowListener(WindowHandler);
		this.AC = new ActionHandler();

		this.actionSign = new ActionSign();
		this.company = new JLabel("신동아");
		this.userName = new JLabel("임시");

		this.mainP = new JPanel();
		this.centerP = new JPanel();
		this.topP = new JPanel();
		this.labelP = new JPanel();
		this.buttomP = new JPanel();
		this.bottomP = new JPanel();
		this.centerP2 = new JPanel();
		this.centerEastP = new JPanel();

		this.mainP.setLayout(new BorderLayout());
		this.topP.setLayout(new GridLayout(2, 0));
		this.centerP.setLayout(new BorderLayout());
		this.centerP2.setLayout(new BorderLayout());
		this.labelP.setLayout(new GridLayout(0, 2));
		this.buttomP.setLayout(new GridLayout(0, 6));
		this.centerEastP.setLayout(new GridLayout(2, 0));

		this.mainP.setBackground(Color.white);
		this.centerEastP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);
		this.topP.setBackground(Color.white);
		this.labelP.setBackground(Color.white);
		this.buttomP.setBackground(Color.white);
		this.bottomP.setBackground(Color.white);
		this.centerP2.setBackground(Color.white);

		this.selectCustomer = new JButton("고객선정");
		this.selectCustomer.setActionCommand("고객선정");
		this.selectCustomer.addActionListener(AC);
		this.proposal = new JButton("제안서작성");
		this.proposal.setActionCommand("제안서작성");
		this.proposal.addActionListener(AC);
		this.subscriptionForm = new JButton("청약서작성");
		this.subscriptionForm.setActionCommand("청약서작성");
		this.subscriptionForm.addActionListener(AC);
		this.fixSubscriptionForm = new JButton("청약서내용수정");
		this.fixSubscriptionForm.setActionCommand("청약서내용수정");
		this.fixSubscriptionForm.addActionListener(AC);
		this.insuranceReceipt = new JButton("보험료수령확인");
		this.insuranceReceipt.setActionCommand("보험료수령확인");
		this.insuranceReceipt.addActionListener(AC);
		this.finalContract = new JButton("최종계약");
		this.finalContract.setActionCommand("최종계약");
		this.finalContract.addActionListener(AC);
		this.ok = new JButton("확인");
		this.ok.setActionCommand("확인");
		this.ok.addActionListener(ActionHandlerS);
		this.cancel = new JButton("취소");
		this.cancel.setActionCommand("취소");

		this.labelP.add(this.company);
		this.labelP.add(this.userName);
		this.buttomP.add(this.selectCustomer);
		this.buttomP.add(this.proposal);
		this.buttomP.add(this.subscriptionForm);
		this.buttomP.add(this.fixSubscriptionForm);
		this.buttomP.add(this.insuranceReceipt);
		this.buttomP.add(this.finalContract);

		this.sign = new JButton("서명");
		this.sign.setActionCommand("서명");
		this.sign.addActionListener(AC);
		this.sign2 = new JButton("서명");
		this.sign2.setActionCommand("서명");
		this.sign2.addActionListener(AC);

		this.topP.add(this.labelP);
		this.topP.add(this.buttomP);

		this.centerEastP.add(this.ok);
		this.centerEastP.add(this.cancel);

		this.centerP.add(this.centerEastP, BorderLayout.EAST);
		this.centerP.add(this.centerP2, BorderLayout.CENTER);

		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);

		this.add(this.mainP);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		System.out.println(this.getLocation());
	}

	public DB getDB() {
		return this.DB;
	}

	public boolean saveSub() {
		DB.setSubscriptionFormVector(targetCustomer + "/" + subscriptionFormField.getText());
		DB.setAcceptanceTarget(this.TargetCustomer);
		return true;
	}

	public void savePro() {
		System.out.println("asd");
		DB.setProposalVector(targetCustomer + "/" + proposalField.getText());
	}

	public boolean saveSub2() {

		DB.repairSubscriptionFormVector(targetCustomer + "/" + subscriptionFormField.getText());
		return true;
	}

	public void SelectCustomer() {
		this.TargetCustomer = DB.getCustomerList().search(this.selectList.getSelectedIndex());


	}

	public void checkReceipt() {
		checkReceipt = this.DB.getCompleteTestingList().get(this.selectList2.getSelectedIndex());
		DB.setCheckReceiptList(checkReceipt);
	}

	public void SaveContract() {
		Contract contract = new Contract();
		String CID = this.I + "a";

		contract.setContract_ID(CID);
		contract.setCustomer_ID(this.DB.getCheckReceiptList().get(selectList3.getSelectedIndex()).getID());
		contract.setSalesMan_ID(this.employee.getID());
		contract.setSalesMan_Email_Address(this.employee.getEmailAddress());
		contract.setSalesMan_Employee_Number(this.employee.getEmployeeNumber());
		contract.setSalesMan_Name(this.employee.getName());
		contract.setSalesMan_Phone_Number(this.employee.getPhoneNumber());
		contract.setTargetCustomer(this.DB.getCheckReceiptList().get(selectList3.getSelectedIndex()).getName());
		DB.setfinishList(contract);
		this.I++;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean setSelectCustomer() {
		if (VC == false) {
			this.ok.setText("선정");
			this.ok.addActionListener(AC);
			this.ok.setActionCommand("선정");
			JPanel SelectP = new JPanel();
			SelectP.setBackground(Color.white);
			this.scrollpane = new JScrollPane();
			String[] list = new String[100];
			for (int i = 0; i < this.DB.getCustomerList().ShowSize(); i++) {
				list[i] = this.DB.getCustomerList().getCustomerList(i);
			}
			this.scrollpane.setPreferredSize(new Dimension(400, 350));
			this.selectList = new JList(list);
			this.selectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollpane.setViewportView(this.selectList);
			SelectP.setPreferredSize(new Dimension(400, 400));
			SelectP.add(this.scrollpane);
			this.centerP2.add(SelectP);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	public boolean setProposal() {
		if (VC == false) {
			this.ok.setText("저장");
			this.ok.setActionCommand("저장1");
			JPanel Proposal = new JPanel();
			Proposal.setBackground(Color.white);
			this.proposalField = new JTextField2();
			this.proposalField.setPreferredSize(new Dimension(400, 350));
			Proposal.add(this.proposalField);
			this.centerP2.add(Proposal);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	public boolean setSubscriptionForm() {
		if (VC == false) {
			this.ok.setText("저장");
			this.ok.setActionCommand("저장2");
			JPanel SubscriptionP = new JPanel();

			SubscriptionP.setBackground(Color.white);
			this.subscriptionFormField = new JTextField2();
			this.subscriptionFormField.setPreferredSize(new Dimension(400, 350));
			SubscriptionP.add(this.subscriptionFormField);
			this.centerP2.add(SubscriptionP);
			this.centerP2.add(SubscriptionP, BorderLayout.CENTER);
			this.centerP2.add(this.sign, BorderLayout.SOUTH);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	public boolean setFixSubscriptionForm() {
		if (VC == false) {
			this.ok.setText("저장");
			this.ok.setActionCommand("저장3");
			JPanel FixSubscriptionP = new JPanel();
			FixSubscriptionP.setBackground(Color.white);
			this.fixSubscriptionFormField = new JTextField2();
			this.fixSubscriptionFormField.setPreferredSize(new Dimension(400, 350));
			FixSubscriptionP.add(this.fixSubscriptionFormField);
			if (this.DB.getSubscriptionFormVector().size() > 0) {
				this.fixSubscriptionFormField.setText(this.DB.getSubscriptionFormVector().get(0));
			}
			this.centerP2.add(FixSubscriptionP, BorderLayout.CENTER);
			this.centerP2.add(this.sign2, BorderLayout.SOUTH);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean setInsuranceReceipt() {
		if (VC == false) {
			this.ok.setText("수령확인");
			this.ok.setActionCommand("수령확인");
			JPanel SelectP2 = new JPanel();
			SelectP2.setBackground(Color.white);
			this.scrollpane2 = new JScrollPane();
			String[] list = new String[100];
			for (int i = 0; i < this.DB.getCompleteTestingList().size(); i++) {
				list[i] = this.DB.getCompleteTestingList().get(i).getName() + " / "
						+ this.DB.getCompleteTestingList().get(i).getAge() + " / "
						+ this.DB.getCompleteTestingList().get(i).getSex();
			}
			this.scrollpane2.setPreferredSize(new Dimension(400, 350));
			this.selectList2 = new JList(list);
			scrollpane2.setViewportView(this.selectList2);
			SelectP2.add(this.scrollpane2);
			this.centerP2.add(SelectP2);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean setFinalContract() {
		if (VC == false) {
			this.ok.setText("계약");
			this.ok.setActionCommand("계약");
			JPanel SelectP3 = new JPanel();
			SelectP3.setBackground(Color.white);
			this.scrollpane3 = new JScrollPane();
			String[] list = new String[100];
			for (int i = 0; i < this.DB.getCheckReceiptList().size(); i++) {
				list[i] = this.DB.getCheckReceiptList().get(i).getName() + " / "
						+ this.DB.getCheckReceiptList().get(i).getName() + " / "
						+ this.DB.getCheckReceiptList().get(i).getPersonalRegistrationNumber() + " / "
						+ this.DB.getCheckReceiptList().get(i).getPhoneNumber();
			}
			this.scrollpane3.setPreferredSize(new Dimension(400, 350));
			this.selectList3 = new JList(list);
			scrollpane3.setViewportView(this.selectList3);
			SelectP3.add(this.scrollpane3);
			this.centerP2.add(SelectP3);
			this.centerP.updateUI();
			VC = true;
		}
		return true;
	}

	public boolean removeP(String type) {
		if (type.equals("고객선정")) {
			this.centerP2.removeAll();
			VC = false;
		} else if (type.equals("제안서작성")) {
			this.centerP2.removeAll();
			VC = false;
		} else if (type.equals("청약서작성")) { 
			this.centerP2.removeAll();
			VC = false;
		} else if (type.equals("청약서내용수정")) {
			this.centerP2.removeAll();
			VC = false;
		} else if (type.equals("최종계약")) {
			this.centerP2.removeAll();
			VC = false;
		} else if (type.equals("보험료수령확인")) {
			this.centerP2.removeAll();
			VC = false;
		}
		return true;
	}

	public boolean setEmpolyee(Account account) {
		this.userName.setText(account.position + " - " + account.name + " 님");
		for (int i = 0; i < this.DB.getEmployeeList().ShowSize(); i++) {
			if (this.DB.getEmployeeList().search(i).getName().equals(account.name)) {
				this.employee = this.DB.getEmployeeList().search(i);
			}
		}
		return true;
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("고객선정")) {
				removeP(e.getActionCommand());
				setSelectCustomer();
			} else if (e.getActionCommand().equals("제안서작성")) {
				removeP(e.getActionCommand());
				setProposal();
			} else if (e.getActionCommand().equals("청약서작성")) {
				removeP(e.getActionCommand());
				setSubscriptionForm();
			} else if (e.getActionCommand().equals("청약서내용수정")) {
				removeP(e.getActionCommand());
				setFixSubscriptionForm();
			} else if (e.getActionCommand().equals("최종계약")) {
				removeP(e.getActionCommand());
				setFinalContract();
			} else if (e.getActionCommand().equals("보험료수령확인")) {
				removeP(e.getActionCommand());
				setInsuranceReceipt();
			} else if (e.getActionCommand().equals("서명")) {
				signFrame = new Sign(actionSign);
			} else if (e.getActionCommand().equals("선정")) {
				SelectCustomer();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("목표 고객이 선정되었습니다.");
			}
		}
	}

	private class ActionSign implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("저장")) {
				@SuppressWarnings("unused")
				PopUp p = new PopUp("서명이 완료되었습니다.");
				signFrame.dispose();
				signFrame.getSign();
			}
		}
	}
}
