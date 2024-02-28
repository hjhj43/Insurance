package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import AfterContract.Accident;
import Asset.AccountList.Account;
import Asset.JTextField2;
import Asset.Sign;
import Main.DB;

public class Insured extends JFrame {

	private static final long serialVersionUID = 1L;

	private Sign SignFrame;

	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel nameP;
	private JPanel buttonP;
	private JPanel RAP; // report an accident
	private JPanel leftP;
	private JPanel textFieldP;
	private JPanel sueP;
	private JPanel leftP2;
	private JPanel leftP3;
	private JPanel textFieldP2;
	private JPanel SP2;
	private JPanel CAFP; // confirm a application form
	private JPanel signP;
	private JPanel CPP; // check a proposal
	private JPanel buttonP1;
	private JPanel buttonP2;
	private JPanel buttonP3;
	private JPanel buttonP4;

	private JPanel panel;

	private JButton RA;
	private JButton Sue;
	private JButton CAF;
	private JButton CP;
	private JButton PR; // Photo Registration
	private JButton save;
	private JButton cancel;
	private JButton SR; // sue registration
	private JButton signB;
	private JButton next;
	private JButton Save;
	private JButton PP; // proposal
	private JButton add;
	private JButton delete;
	private JButton sueAdd;
	private JButton sueDelete;

	private JLabel insured;
	private JLabel date;
	private JLabel time;
	private JLabel type;
	private JLabel price;
	private JLabel fileName;

	private JLabel signL;
	private JLabel sueN;
	private JLabel sueR;

	private JTextField2 dateT;
	private JTextField2 timtT;
	private JTextField2 typeT;
	private JTextField2 priceT;
	private JTextField2 photoT;
	private JTextField2 ConfirmApplication;
	private JTextField2 sueNT;
	private JTextField2 sueRT;

	private TextArea PPT; // proposal

	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel dtm;
	private JTable table1;
	private JScrollPane scrollpane1;
	private DefaultTableModel dtm1;
	private JTable table2;
	private JScrollPane scrollpane2;
	private DefaultTableModel dtm2;

	private String kind;
	private ActionHandler actionHandler;
	private String filePath = "";
	private JFileChooser fileChooser;
	private FileNameExtensionFilter filter;
	private ActionListener actionHandlerInsured;
	private ActionSign actionSign;
	private DB DB;

	@SuppressWarnings("unused")
	private String report;
	private Vector<Accident> reportList;
	@SuppressWarnings("unused")
	private Vector<String> sueTList;
	@SuppressWarnings("unused")
	private Vector<String> SubList;
	@SuppressWarnings("unused")
	private Vector<String> proList;

	private Accident reporting;
	private Account account;

	private static int n;
	String[] accident = { "번호", "사고날짜", "사고시간", "사고유형", "피해액수" };
	String[][] accidentList = { { "예)", "2020/05/15", "16:35", "차사고", "1,300,000", "C://" } };
	String[] sue = { "사건번호", "사건내용" };
	String[][] sueList = { { "1", "교통사고" } };
	String[] sue2 = { "사건번호", "소송사유" };
	String[][] sueList2 = { { "1", "돈" } };

	public Insured(DB dB, ActionListener actionHandlerInsured, WindowListener windowHandler,
			ActionListener ActionHandlerInit) {
		this.setTitle("보험가입자");
		this.actionHandler = new ActionHandler();
		this.actionSign = new ActionSign();

		this.reportList = new Vector<Accident>();
		this.sueTList = new Vector<String>();
		this.SubList = new Vector<String>();
		this.proList = new Vector<String>();

		this.DB = dB;
		this.addWindowListener(windowHandler);
		this.mainP = new JPanel();
		this.topP = new JPanel();
		this.nameP = new JPanel();
		this.buttonP = new JPanel();
		this.centerP = new JPanel();

		this.mainP.setBackground(Color.white);
		this.topP.setBackground(Color.white);
		this.nameP.setBackground(Color.white);
		this.buttonP.setBackground(Color.white);
		this.centerP.setBackground(Color.white);

		this.insured = new JLabel();
		this.RA = new JButton("사고신고");
		this.RA.setActionCommand("A");
		this.RA.addActionListener(this.actionHandler);
		this.Sue = new JButton("소송진행");
		this.Sue.setActionCommand("B");
		this.Sue.addActionListener(this.actionHandler);
		this.CAF = new JButton("청약서확인");
		this.CAF.setActionCommand("C");
		this.CAF.addActionListener(this.actionHandler);
		this.CP = new JButton("제안서확인");
		this.CP.setActionCommand("D");
		this.CP.addActionListener(this.actionHandler);

		this.nameP.add(this.insured);
		this.buttonP.add(this.RA);
		this.buttonP.add(this.Sue);
		this.buttonP.add(this.CAF);
		this.buttonP.add(this.CP);

		this.topP.add(this.nameP);
		this.topP.add(this.buttonP);

		this.centerP.setLayout(new BorderLayout());

		this.topP.setLayout(new BorderLayout());
		this.topP.add(this.nameP, BorderLayout.NORTH);
		this.topP.add(this.buttonP, BorderLayout.SOUTH);
		this.mainP.setLayout(new BorderLayout());
		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);

		this.save = new JButton("저장");
		this.save.setActionCommand("신고저장");
		this.save.addActionListener(actionHandlerInsured);

		this.add(mainP);
		this.setBackground(Color.white);
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public DB getDB() {
		return this.DB;
	}

	public boolean setEmpolyee(Account account) {
		this.insured.setText(account.position + " - " + account.name + " 님");
		this.account = account;
		return true;
	}

	public boolean Report() {
		this.reporting = this.reportList.get(this.table.getSelectedRow());
		this.DB.setAccidentList(reporting);
		return true;
	}

	public void ReportAccident() {
		this.RAP = new JPanel();
		this.leftP = new JPanel();
		this.buttonP1 = new JPanel();
		this.textFieldP = new JPanel();
		this.dtm = new DefaultTableModel(accidentList, this.accident);
		this.table = new JTable(this.dtm);
		this.scrollpane = new JScrollPane(this.table);

		this.dtm.removeRow(0);

		this.leftP.setLayout(new BorderLayout());
		this.textFieldP.setLayout(new GridLayout(0, 12));
		this.buttonP1.setLayout(new GridLayout(3, 1));
		this.RAP.setLayout(new BorderLayout());

		this.RAP.setBackground(Color.white);
		this.buttonP1.setBackground(Color.white);

		this.date = new JLabel("사고날짜");
		this.time = new JLabel("사고시간");
		this.type = new JLabel("사고유형");
		this.price = new JLabel("피해액수");
		this.fileName = new JLabel();
		this.dateT = new JTextField2();
		this.timtT = new JTextField2();
		this.typeT = new JTextField2();
		this.priceT = new JTextField2();

		this.textFieldP.add(date);
		this.textFieldP.add(dateT);
		this.textFieldP.add(time);
		this.textFieldP.add(timtT);
		this.textFieldP.add(type);
		this.textFieldP.add(typeT);
		this.textFieldP.add(price);
		this.textFieldP.add(priceT);

		this.add = new JButton("추가");
		this.add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				String[] ar = { ++n + "", dateT.getText(), timtT.getText(), typeT.getText(), priceT.getText() };
				dtm.addRow(ar);
				report = ar[0];
				Accident accident = new Accident();
				accident.setAccidentDate(dateT.getText());
				accident.setAccidentTime(Integer.parseInt(timtT.getText()));
				accident.setKindsOfAccident(typeT.getText());
				accident.setAmountOfDamage(Integer.parseInt(priceT.getText()));
				reportList.add(accident);
			}
		});
		this.delete = new JButton("삭제");
		this.delete.addActionListener(new EventHandler(table));
		this.PR = new JButton("사진등록");
		this.PR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setCurrentDirectory(new File("/"));
				fileChooser.setAcceptAllFileFilterUsed(true);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				filter = new FileNameExtensionFilter("Binary File", "cd11");
				fileChooser.setFileFilter(filter);

				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					filePath = fileChooser.getSelectedFile().toString();
					fileName.setText("파일 경로 : " + filePath);
					photoT.setText(filePath);
					System.out.println(filePath);
				} else if (returnVal == JFileChooser.CANCEL_OPTION) {
					filePath = "";
				}
			}
		});
		this.cancel = new JButton("취소");
		this.scrollpane.setPreferredSize(new Dimension(100, 200));

		this.textFieldP.add(this.add);
		this.textFieldP.add(this.delete);
		this.buttonP1.add(PR);
		this.buttonP1.add(save);
		this.buttonP1.add(cancel);

		this.leftP.add(this.scrollpane, BorderLayout.CENTER);
		this.leftP.add(this.textFieldP, BorderLayout.SOUTH);
		this.RAP.add(this.buttonP1, BorderLayout.EAST);
		this.RAP.add(this.leftP, BorderLayout.CENTER);
		this.RAP.add(this.fileName, BorderLayout.SOUTH);
		this.centerP.add(this.RAP);
		this.mainP.add(this.centerP);
		this.centerP.updateUI();
	}

	public void Sue() {
		this.sueP = new JPanel();
		this.leftP2 = new JPanel();
		this.leftP3 = new JPanel();
		this.textFieldP2 = new JPanel();
		this.SP2 = new JPanel();
		this.buttonP2 = new JPanel();

		this.sueN = new JLabel("사건번호");
		this.sueR = new JLabel("소송사유");
		this.sueNT = new JTextField2();
		this.sueRT = new JTextField2();

		this.dtm1 = new DefaultTableModel(this.sueList, this.sue);
		this.table1 = new JTable(this.dtm1);
		this.scrollpane1 = new JScrollPane(this.table1);
		this.dtm2 = new DefaultTableModel(this.sueList2, this.sue2);
		this.table2 = new JTable(this.dtm2);
		this.scrollpane2 = new JScrollPane(this.table2);
		dtm2 = (DefaultTableModel) table2.getModel();
		
		this.sueAdd = new JButton("추가");
		this.sueAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] ar = { sueNT.getText(), sueRT.getText() };
				dtm2.addRow(ar);
			}
		});

		if (this.DB.getAccidentList().size() > 0) {
			for (int i = 0; i < this.DB.getAccidentList().size(); i++) {
				String[] ar = { this.DB.getAccidentList().get(i).getAccidentNumber()+" ",
						this.DB.getAccidentList().get(i).getKindsOfAccident() };
				System.out.println(ar[0]);
				dtm.addRow(ar);
			}
		}
		this.sueDelete = new JButton("삭제");
		this.sueDelete.addActionListener(new EventHandler(table2));
		this.SR = new JButton("소송하기");
		this.cancel = new JButton("취소");

		this.sueP.setLayout(new BorderLayout());
		this.leftP2.setLayout(new BorderLayout());
		this.leftP3.setLayout(new BorderLayout());
		this.textFieldP2.setLayout(new GridLayout(3, 2));
		this.SP2.setLayout(new BorderLayout());
		this.buttonP2.setLayout(new GridLayout(2, 1));

		this.dtm1.removeRow(0);
		this.dtm2.removeRow(0);

		this.sueP.setBackground(Color.white);
		this.leftP2.setBackground(Color.white);
		this.leftP3.setBackground(Color.white);
		this.textFieldP2.setBackground(Color.white);
		this.SP2.setBackground(Color.white);
		this.buttonP2.setBackground(Color.white);

		this.leftP3.setPreferredSize(new Dimension(300, 300));
		this.leftP2.setPreferredSize(new Dimension(200, 200));

		this.leftP2.add(this.scrollpane1, BorderLayout.CENTER);
		this.leftP3.add(this.scrollpane2, BorderLayout.CENTER);
		this.textFieldP2.add(this.sueN);
		this.textFieldP2.add(this.sueNT);
		this.textFieldP2.add(this.sueR);
		this.textFieldP2.add(this.sueRT);
		this.textFieldP2.add(this.sueAdd);
		this.textFieldP2.add(this.sueDelete);
		this.SP2.add(leftP3, BorderLayout.CENTER);
		this.SP2.add(this.textFieldP2, BorderLayout.SOUTH);
		this.buttonP2.add(this.SR);
		this.buttonP2.add(this.cancel);

		this.sueP.add(this.leftP2, BorderLayout.WEST);
		this.sueP.add(this.SP2, BorderLayout.CENTER);
		this.sueP.add(this.buttonP2, BorderLayout.EAST);
		this.centerP.add(this.sueP);
		this.mainP.add(this.centerP);
		this.centerP.updateUI();
	}

	public boolean ConfirmApplication() {
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		this.panel.setBackground(Color.white);
		this.CAFP = new JPanel();
		this.CAFP.setBackground(Color.white);
		this.signP = new JPanel();
		this.signP.setLayout(new GridLayout(1, 2));
		this.signP.setBackground(Color.white);
		this.buttonP3 = new JPanel();
		this.buttonP3.setLayout(new GridLayout(3, 1));
		this.buttonP3.setBackground(Color.white);
		this.ConfirmApplication = new JTextField2();
		this.ConfirmApplication.setText("반갑습니다.");
		this.ConfirmApplication.setPreferredSize(new Dimension(400, 350));
		if (this.DB.getSubscriptionFormVector().size() > 0) {
			for (int i = 0; i < this.DB.getSubscriptionFormVector().size(); i++) {
				String a = this.DB.getSubscriptionFormVector().get(i);
				String[] b = a.split("/");
				if (b[0].equals(this.account.name)) {
					this.ConfirmApplication.setText("반갑습니다.");
				}
			}
		}
		this.CAFP.add(ConfirmApplication);

		this.signL = new JLabel("서명란");
		this.signB = new JButton("전자서명");
		this.signB.setActionCommand("Sign");
		this.signB.addActionListener(this.actionHandler);

		this.signP.add(signL);
		this.signP.add(signB);

		this.next = new JButton("다음 계약서");
		this.next.setActionCommand("Next");
		this.next.addActionListener(this.actionHandler);
		this.Save = new JButton("저장");
		this.Save.setActionCommand("Save");
		this.Save.addActionListener(actionHandlerInsured);
		this.cancel = new JButton("취소");
		this.cancel.setActionCommand("Cancel");
		this.cancel.addActionListener(this.actionHandler);

		this.panel.add(CAFP, BorderLayout.CENTER);
		this.panel.add(signP, BorderLayout.SOUTH);
		this.centerP.add(panel, BorderLayout.CENTER);
		this.mainP.add(centerP);
		this.centerP.updateUI();

		return true;
	}

	public boolean CheckProposal() {
		this.CPP = new JPanel();
		this.CPP.setLayout(new BorderLayout());
		this.CPP.setBackground(Color.white);
		this.buttonP4 = new JPanel();
		this.buttonP4.setBackground(Color.white);
		this.PPT = new TextArea("안녕하세요.");
		this.PPT.setPreferredSize(new Dimension(400, 350));
		if (this.DB.getProposalVector().size() > 0) {
			for (int i = 0; i < this.DB.getProposalVector().size(); i++) {
				String a = this.DB.getProposalVector().get(i);
				String[] b = a.split("/");
				if (b[0].equals(this.account.name)) {
					this.PPT.setText(this.DB.getProposalVector().get(i));
				}
			}
		}

		this.CPP.add(PPT);
		this.PP = new JButton("확인");
		this.buttonP4.add(PP);

		this.centerP.add(CPP, BorderLayout.CENTER);
		this.centerP.add(buttonP4, BorderLayout.SOUTH);
		this.mainP.add(centerP);
		this.centerP.updateUI();
		return true;
	}

	public void removeP(String button) {
		if (button == "A") {
			this.centerP.removeAll();
		} else if (button == "B") {
			this.centerP.removeAll();
		} else if (button == "C") {
			this.centerP.removeAll();
		} else if (button == "D") {
			this.centerP.removeAll();
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
			if (e.getActionCommand().equals("A")) {
				setKind("A");
				removeP("A");
				ReportAccident();
			} else if (e.getActionCommand().equals("B")) {
				setKind("B");
				removeP("B");
				Sue();
			} else if (e.getActionCommand().equals("C")) {
				setKind("C");
				removeP("C");
				ConfirmApplication();
			} else if (e.getActionCommand().equals("D")) {
				setKind("D");
				removeP("D");
				CheckProposal();
			} else if (e.getActionCommand().equals("Sign")) {
				SignFrame = new Sign(actionSign);
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setCurrentDirectory(new File("/"));
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		filter = new FileNameExtensionFilter("Binary File", "cd11");
		fileChooser.setFileFilter(filter);

		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().toString();
			System.out.println(filePath);
		} else if (returnVal == JFileChooser.CANCEL_OPTION) {
			filePath = "";
		}
	}

	private class EventHandler implements ActionListener {
		JTable table;
		public EventHandler(JTable table) {
			this.table = table;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int n = table.getSelectedRow();
			DefaultTableModel dtm = (DefaultTableModel) table.getModel();
			if (n >= 0 && n < table.getRowCount()) {
				dtm.removeRow(n);
				reportList.remove(reportList.size() - 1);
			}
		}
	}

	private class ActionSign implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("저장")) {
				@SuppressWarnings("unused")
				PopUp p = new PopUp("서명이 완료되었습니다.");
				SignFrame.dispose();
				SignFrame.getSign();
			}
		}
	}
}