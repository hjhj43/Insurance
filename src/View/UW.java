package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Asset.AccountList.Account;
import Customer.Customer;
import Customer.CustomerListImpl;
import Main.DB;

public class UW extends JFrame implements ListSelectionListener { // UW
	private static final long serialVersionUID = 1L;

	ActionHandler actionHandler = new ActionHandler();

	@SuppressWarnings("unused")
	private boolean VC = false;
	@SuppressWarnings("unused")
	private boolean BC = false;
	private String kind;

	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel eastP;
	private JPanel bottomP;

	private JPanel topP1;
	private JPanel topP2;

	private JPanel centerP1;
	private JPanel centerP2;

	private JPanel acceptnacePoliciesPanel;

	private JPanel acceptnaceTestingPanel;
	private JPanel acceptnaceTestingPanel2;
	@SuppressWarnings("unused")
	private JPanel acceptnaceTestingPanel3;

	private JPanel buttonP1;
	private JPanel buttonP2;

	private JLabel company;
	private JLabel position;
	private JLabel employeeName;

	private JButton acceptnacePolicies;
	private JButton acceptnaceTesting;

	private JScrollPane sp;

	private PopUp x;
	private PopUp x2;

	private JButton testing;

	private JButton okButton;
	private JButton cancelButton;

	private TextArea acceptnacePoliciesText;

	private JTable jTable;
	private DefaultTableModel model;
	@SuppressWarnings("unused")
	private CustomerListImpl cli;

	@SuppressWarnings("unused")
	private ActionHandler ActionHandler;
	private ActionHandler2 ActionHandler2;
	private ActionHandler2 ActionHandler3;
	private ListSelectionModel select;
	@SuppressWarnings("unused")
	private Vector<String> completeTestingList;
	@SuppressWarnings("unused")
	private Vector<String> AcceptanceList;
	private String completeAcceptance = null;
	private String completeTesting = null;
	private Customer TargetCustomer;

	@SuppressWarnings("unused")
	private FileWriter fw;
	private DB DB;

	public UW(DB dB, WindowListener windowHandler, ActionListener ActionHandlerE) {
		this.setTitle("UW");
		ActionHandler2 = new ActionHandler2();
		this.model = new DefaultTableModel();
		this.cli = new CustomerListImpl();

		this.completeTestingList = new Vector<String>();
		this.AcceptanceList = new Vector<String>();
		this.DB = dB;
		this.addWindowListener(windowHandler);
		this.mainP = new JPanel();
		this.topP = new JPanel();
		this.centerP = new JPanel();
		this.eastP = new JPanel();
		this.bottomP = new JPanel();

		this.topP1 = new JPanel();
		this.topP2 = new JPanel();

		this.centerP1 = new JPanel();
		this.centerP2 = new JPanel();

		this.mainP.setBackground(Color.white);
		this.topP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);
		this.eastP.setBackground(Color.white);
		this.bottomP.setBackground(Color.white);

		this.topP1.setBackground(Color.white);
		this.topP2.setBackground(Color.white);

		this.centerP1.setBackground(Color.white);
		this.centerP2.setBackground(Color.white);

		this.company = new JLabel("신동아");
		this.position = new JLabel();
		this.employeeName = new JLabel();
		this.add(company);
		this.add(position);
		this.add(employeeName);

		this.acceptnacePolicies = new JButton("인수정책수립");
		this.acceptnacePolicies.setActionCommand("인수정책수립");
		this.acceptnacePolicies.addActionListener(actionHandler);

		this.acceptnaceTesting = new JButton("인수검사");
		this.acceptnaceTesting.setActionCommand("인수검사");
		this.acceptnaceTesting.addActionListener(actionHandler);

		this.add(acceptnacePolicies);
		this.add(acceptnaceTesting);

		this.okButton = new JButton("확인");
		this.okButton.setActionCommand("확인");
		this.okButton.addActionListener(ActionHandlerE);

		this.testing = new JButton("검사하기");
		this.testing.setActionCommand("검사하기");
		this.testing.addActionListener(ActionHandlerE);

		this.topP.setLayout(new GridLayout(1, 2));
		this.centerP.setLayout(new GridLayout(2, 1));
		this.bottomP.setLayout(new GridLayout(1, 2));
		this.topP.setLayout(new BoxLayout(topP, BoxLayout.Y_AXIS));
		this.centerP.setLayout(new BoxLayout(centerP, BoxLayout.X_AXIS));
		this.centerP2.setLayout(new BoxLayout(centerP2, BoxLayout.Y_AXIS));

		this.mainP.setLayout(new BorderLayout());

		this.topP1.add(this.company);
		this.topP1.add(this.position);
		this.topP1.add(this.employeeName);

		this.topP2.add(this.acceptnacePolicies);
		this.topP2.add(this.acceptnaceTesting);

		this.topP.add(this.topP1);
		this.topP.add(this.topP2);

		this.centerP.add(this.centerP1);
		this.centerP.add(this.centerP2);

		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);
		this.mainP.add(this.eastP, BorderLayout.EAST);
		this.mainP.add(this.bottomP, BorderLayout.SOUTH);
		this.add(this.mainP);

		this.setSize(900, 800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	public DB getDB() {
		return this.DB;
	}

	public boolean setEmpolyee(Account account) {
		this.employeeName.setText(account.position + " - " + account.name + " 님");
		return true;
	}

	public String getKind() {
		return this.kind;
	}

	public boolean setKind(String kind) {
		this.kind = kind;
		return true;
	}

	public void SaveAcceptancePolicies() {
		x2 = new PopUp("인수 정책의 내용을 저장하겠습니까?");
		x2.setHandler2(ActionHandler3);
		completeAcceptance = acceptnacePoliciesText.getText();
		DB.setAcceptanceList(completeAcceptance);
	}

	public void ShowAcceptnacePolicies() {
		try {
			this.acceptnacePoliciesPanel = new JPanel();
			this.acceptnacePoliciesPanel.setLayout(new BorderLayout());
			this.acceptnacePoliciesPanel.setBackground(Color.white);

			this.acceptnacePoliciesText = new TextArea("인수정책 내용을 다음 텍스트 에이리어에 입력합니다.", 40, 40);
			this.acceptnacePoliciesText.setBackground(Color.white);
			this.acceptnacePoliciesText.setFont(new Font("궁서체", Font.BOLD, 10));
			this.acceptnacePoliciesText.setForeground(Color.black);

			this.acceptnacePoliciesPanel.add(acceptnacePoliciesText);

			this.buttonP1 = new JPanel();
			this.buttonP1.setLayout(new GridLayout(2, 1));
			this.buttonP1.setBackground(Color.white);

			this.cancelButton = new JButton("취소");
			this.cancelButton.setActionCommand("취소");
			this.cancelButton.addActionListener(actionHandler);

			this.buttonP1.add(this.okButton);
			this.buttonP1.add(this.cancelButton);

			this.centerP.add(acceptnacePoliciesPanel, BorderLayout.CENTER);
			this.centerP.add(buttonP1, BorderLayout.SOUTH);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();

		} catch (Exception e) {
			@SuppressWarnings("unused")
			PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
		}
	}

	@SuppressWarnings("deprecation")
	public void ShowAcceptnaceTesting() {
		try {
			this.acceptnaceTestingPanel = new JPanel();
			this.acceptnaceTestingPanel.setBackground(Color.white);
			this.acceptnaceTestingPanel.setLayout(new BoxLayout(acceptnaceTestingPanel, BoxLayout.Y_AXIS));
			this.ActionHandler = new ActionHandler();

			this.acceptnaceTestingPanel2 = new JPanel();
			this.acceptnaceTestingPanel2.setBackground(Color.white);
			String column[] = { "이름", "ID", "나이", "생년월일", "전화번호", "주소", "직업", "병력" };

			model = new DefaultTableModel(column, 0);
			for (int i = 0; i < this.DB.getCustomerList().ShowSize(); i++) {
				String name = this.DB.getCustomerList().search(i).getName();
				String ID = this.DB.getCustomerList().search(i).getID();
				int age = this.DB.getCustomerList().search(i).getAge();
				int dob = this.DB.getCustomerList().search(i).getDateOfBirth();
				int phoneNum = this.DB.getCustomerList().search(i).getPhoneNumber();
				String address = this.DB.getCustomerList().search(i).getRegistrationAddress();
				String job = this.DB.getCustomerList().search(i).getJob();
				String medicalHistory = this.DB.getCustomerList().search(i).getMedicalHistory();
				model.addRow(new Object[] { name, ID, age, dob, phoneNum, address, job, medicalHistory });
			}
			jTable = new JTable(model);
			jTable.setCellSelectionEnabled(true);
			jTable.preferredSize();

			select = jTable.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			select.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					String Data = null;
					int[] row = jTable.getSelectedRows();
					int[] columns = jTable.getSelectedColumns();

					for (int i = 0; i < row.length; i++) {
						for (int j = 0; j < columns.length; j++) {
							Data = (String) jTable.getValueAt(row[i], 0);
						}
					}
					JOptionPane.showMessageDialog(acceptnaceTestingPanel2, Data + "님을 선택했습니다.");
					completeTesting = Data;
					TargetCustomer = DB.getCustomerList().search(jTable.getSelectedRow());
				}
			});
			sp = new JScrollPane(jTable);
			sp.setPreferredSize(new Dimension(700, 600));
			acceptnaceTestingPanel2.add(sp);

			this.acceptnaceTestingPanel3 = new JPanel();
			this.buttonP2 = new JPanel();
			this.buttonP2.setBackground(Color.white);
			this.buttonP2.add(this.testing);
			this.acceptnaceTestingPanel.add(acceptnaceTestingPanel2, BorderLayout.CENTER);

			this.centerP.add(acceptnaceTestingPanel, BorderLayout.CENTER);
			this.centerP.add(buttonP2, BorderLayout.EAST);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();
		} catch (Exception e) {
			@SuppressWarnings("unused")
			PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
		}
	}

	public boolean backtomain() {
		this.centerP.removeAll();
		this.centerP.updateUI();
		return true;
	}

	public void removeP(String button) {
		if (button == "인수정책수립") {
			this.centerP.removeAll();
		} else if (button == "인수검사") {
			this.centerP.removeAll();
			this.BC = false;
		} else if (button == "검사하기") {
			this.centerP.removeAll();
		}
	}

	public boolean saveAcceptnace() {
		@SuppressWarnings("unused")
		String filePath = "Asset.Acceptnace";
		String SaveAcceptnacePolicies = acceptnacePoliciesText.getText();
		System.out.println(SaveAcceptnacePolicies);
		System.out.println("1");
		return true;
	}

	@SuppressWarnings("unused")
	private class ActionHandler3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("확인")) {
				saveAcceptnace();
			}
		}
	}

	private class ActionHandler2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("확인")) {
				backtomain();
			}
		}
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("인수정책수립")) {
				setKind("인수정책수립");
				removeP("인수정책수립");
				ShowAcceptnacePolicies();
			} else if (e.getActionCommand().equals("인수검사")) {
				setKind("인수검사");
				removeP("인수검사");
				ShowAcceptnaceTesting();
			} else if (e.getActionCommand().equals("취소")) {
				x = new PopUp("취소할 시, 작성내용이 저장되지 않습니다. 그래도 취소하시겠습니까?");
				x.setHandler(ActionHandler2);
			}
			else if (e.getActionCommand().equals("취소버튼")) {
				x = new PopUp("취소할 시, 다음 내용이 저장되지 않습니다. 그래도 취소하시겠습니까?");
				x.setHandler(ActionHandler2);
			}
		}
	}

	public void complete() {
		this.TargetCustomer.setTesting(completeTesting);
		DB.setCompleteTestingList(TargetCustomer);
	}

	public void fail() {
		x = new PopUp("인수검사 내용을 불허가합니다.");
		x.setHandler(ActionHandler2);
		this.TargetCustomer.setTesting(completeTesting);
		DB.setCompleteTestingList(TargetCustomer);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
	}
}