package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import AfterContract.Accident;
import Asset.AccountList.Account;
import Asset.JTextField2;
import Main.DB;

public class IAHC extends JFrame {
	private static final long serialVersionUID = 1L;

	private boolean VC = false;
	private boolean BC = false;
	private JPanel mainP;
	private JPanel topP;
	private JPanel centerP;
	private JPanel nameP;
	private JPanel buttonP;
	private JPanel RAP;
	private JPanel PCAP;
	private JPanel DAP;
	private JPanel DAP1;
	private JPanel DAP2;
	private JPanel buttonP1;
	private JPanel buttonP2;
	private JPanel buttonP3;

	private JButton RA;
	private JButton PCA;
	private JButton DA;
	private JButton receipt;
	private JButton progress;
	private JButton complete;
	private JButton cancel;

	private JLabel IAHC;
	private JLabel CCI;

	private JTextField2 CCIT;

	private JTable table1;
	private JScrollPane scrollpane1;

	private JTable table3;
	private JScrollPane scrollpane3;
	private JTable table4;
	private JScrollPane scrollpane4;

	private DefaultTableModel dtm1;
	private DefaultTableModel dtm2;
	private DefaultTableModel dtm3;
	private DefaultTableModel dtm4;
	private String kind;
	private DB DB;
	@SuppressWarnings("unused")
	private String Register = null;
	@SuppressWarnings("unused")
	private String finish = null;
	@SuppressWarnings("unused")
	private String Compensation = null;

	private ActionHandler actionHandler;
	private ListSelectionModel select;

	private Accident ReceieveAccident;
	private Accident ReceiveRegister;

	String[] accident = { "번호", "사고날짜", "사고시간", "사고유형", "피해액수", "파일경로" };
	String[] finishAccident = { "번호", "사고날짜", "사고시간", "사고유형", "예상금액", "파일경로" };
	String[] Deal = { "사고날짜", "사고시간", "피해금액", "청구보험금" };
	String[] finish1 = { "번호", "사고날짜", "사고시간", "사고유형", "피해액수", "산정금액" };

	public IAHC(DB dB, WindowListener windowHandler, ActionListener ActionHandlerI) {
		this.setTitle("보험사고처리사");
		this.actionHandler = new ActionHandler();
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

		this.IAHC = new JLabel();
		this.RA = new JButton("사고접수");
		this.RA.setActionCommand("A");
		this.RA.addActionListener(this.actionHandler);
		this.PCA = new JButton("손해사정");
		this.PCA.setActionCommand("B");
		this.PCA.addActionListener(this.actionHandler);
		this.DA = new JButton("사고종결");
		this.DA.setActionCommand("C");
		this.DA.addActionListener(this.actionHandler);
		this.cancel = new JButton("취소");
		this.cancel.setActionCommand("취소");

		this.nameP.add(this.IAHC);
		this.buttonP.add(this.RA);
		this.buttonP.add(this.PCA);
		this.buttonP.add(this.DA);

		this.receipt = new JButton("접수");
		this.receipt.setActionCommand("접수");
		this.receipt.addActionListener(ActionHandlerI);

		this.topP.add(this.nameP);
		this.topP.add(this.buttonP);

		this.topP.setLayout(new BorderLayout());
		this.topP.add(this.nameP, BorderLayout.NORTH);
		this.topP.add(this.buttonP, BorderLayout.SOUTH);
		this.mainP.setLayout(new BorderLayout());
		this.mainP.add(this.topP, BorderLayout.NORTH);
		this.mainP.add(this.centerP, BorderLayout.CENTER);

		this.complete = new JButton("완료");
		this.complete.setActionCommand("완료");
		this.complete.addActionListener(ActionHandlerI);

		this.add(mainP);
		this.setBackground(Color.white);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public DB getDB() {
		return this.DB;
	}

	private void accidentData() {
		if (this.BC == false) {
			if (this.DB.getAccidentList().size() > 0) {
				for (int i = 0; i < this.DB.getAccidentList().size(); i++) {
					int num = this.DB.getAccidentList().get(i).getAccidentNumber();
					String date = this.DB.getAccidentList().get(i).getAccidentDate();
					int time = this.DB.getAccidentList().get(i).getAccidentTime();
					String kind = this.DB.getAccidentList().get(i).getKindsOfAccident();
					int amountOfDamage = this.DB.getAccidentList().get(i).getAmountOfDamage();
					dtm1.addRow(new Object[] { num, date, time, kind, amountOfDamage });
				}
			}
			this.BC = true;
		}
	}

	public boolean Receive2() {
		ReceiveRegister = this.DB.getRegisterList().get(this.table1.getSelectedRow());

		return true;

	}

	public boolean Receieve() {
		ReceieveAccident = this.DB.getAccidentList().get(this.table1.getSelectedRow());
		this.DB.setRegisterList(ReceieveAccident);
		return true;
	}

	public void ReceieveAccident() {
		if (this.VC == false) {
			this.RAP = new JPanel();
			this.RAP.setLayout(new BorderLayout());
			this.RAP.setBackground(Color.white);
			this.buttonP1 = new JPanel();
			this.buttonP1.setLayout(new GridLayout(2, 1));
			this.buttonP1.setBackground(Color.white);

			this.dtm1 = new DefaultTableModel(accident, 0);
			accidentData();
			this.table1 = new JTable(this.dtm1);
			table1.getTableHeader().setReorderingAllowed(false);

			select = table1.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			this.scrollpane1 = new JScrollPane(this.table1);
			this.scrollpane1.setPreferredSize(new Dimension(500, 300));

			this.RAP.add(this.scrollpane1, BorderLayout.CENTER);
			this.buttonP1.add(receipt);
			this.buttonP1.add(cancel);
			this.centerP.add(RAP, BorderLayout.CENTER);
			this.centerP.add(buttonP1, BorderLayout.SOUTH);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();
			this.VC = true;
		}
	}

	public void finishAccident() {
		if (this.VC == false) {
			this.RAP = new JPanel();
			this.RAP.setLayout(new BorderLayout());
			this.RAP.setBackground(Color.white);
			this.buttonP1 = new JPanel();
			this.buttonP1.setLayout(new GridLayout(2, 1));
			this.buttonP1.setBackground(Color.white);
			System.out.println("ASdasdsad");
			this.dtm4 = new DefaultTableModel(finish1, 0);
			finalData();
			this.table4 = new JTable(this.dtm4);
			table4.getTableHeader().setReorderingAllowed(false);

			select = table4.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			this.scrollpane4 = new JScrollPane(this.table4);
			this.scrollpane4.setPreferredSize(new Dimension(500, 300));

			this.RAP.add(this.scrollpane4, BorderLayout.CENTER);
			this.receipt.setText("종결");
			this.buttonP1.add(receipt);

			this.buttonP1.add(cancel);
			this.centerP.add(RAP, BorderLayout.CENTER);
			this.centerP.add(buttonP1, BorderLayout.SOUTH);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();
			this.VC = true;
		}
	}
	public boolean savefinal() {
		this.DB.setEndAccident(this.DB.getCompleteDealList().get(this.table4.getSelectedRow()));
		return true;
	}
	
	private void finalData() {
		if (this.DB.getCompleteDealList().size() > 0) {
			for (int i = 0; i < this.DB.getCompleteDealList().size(); i++) {
				int num = this.DB.getCompleteDealList().get(i).getAccidentNumber();
				String date = this.DB.getCompleteDealList().get(i).getAccidentDate();
				int time = this.DB.getCompleteDealList().get(i).getAccidentTime();
				String kind = this.DB.getCompleteDealList().get(i).getKindsOfAccident();
				int amountOfDamage = this.DB.getCompleteDealList().get(i).getAmountOfDamage();
				int Calculate = this.DB.getCompleteDealList().get(i).getCalculatedInsuranceFee();
				dtm4.addRow(new Object[] { num, date, time, kind, amountOfDamage,Calculate });
			}
		}
	}

	private void finishData() {
		if (this.BC == false) {
			if (this.DB.getRegisterList().size() > 0) {
				for (int i = 0; i < this.DB.getRegisterList().size(); i++) {
					int num = this.DB.getRegisterList().get(i).getAccidentNumber();
					String date = this.DB.getRegisterList().get(i).getAccidentDate();
					int time = this.DB.getRegisterList().get(i).getAccidentTime();
					String kind = this.DB.getRegisterList().get(i).getKindsOfAccident();
					int calculatedFee = this.DB.getRegisterList().get(i).getCalculatedInsuranceFee();
					dtm2.addRow(new Object[] { num, date, time, kind, calculatedFee });
				}
			}
			this.BC = true;
		}
	}

	public void ClaimAdjustment() {
		if (this.VC == false) {
			this.PCAP = new JPanel();
			this.PCAP.setLayout(new BorderLayout());
			this.PCAP.setBackground(Color.white);
			this.buttonP2 = new JPanel();
			this.buttonP2.setLayout(new GridLayout(2, 1));
			this.buttonP2.setBackground(Color.white);

			this.dtm2 = new DefaultTableModel(finishAccident, 0);
			finishData();
			this.table1 = new JTable(this.dtm2);
			this.scrollpane1 = new JScrollPane(this.table1);
			this.scrollpane1.setPreferredSize(new Dimension(500, 300));

			this.progress = new JButton("진행");
			this.progress.setActionCommand("진행");
			this.progress.addActionListener(actionHandler);

			this.PCAP.add(this.scrollpane1, BorderLayout.CENTER);
			this.buttonP2.add(progress);
			this.buttonP2.add(cancel);
			this.centerP.add(PCAP, BorderLayout.CENTER);
			this.centerP.add(buttonP2, BorderLayout.SOUTH);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();
			this.VC = true;
		}
	}

	public void DealwithAccident() {
		if (this.VC == false) {
			this.DAP = new JPanel();
			this.DAP2 = new JPanel();
			this.DAP.setLayout(new BorderLayout());
			this.DAP.setBackground(Color.white);
			this.DAP1 = new JPanel();
			this.DAP1.setBackground(Color.white);

			this.buttonP3 = new JPanel();
			this.buttonP3.setLayout(new GridLayout(2, 1));
			this.buttonP3.setBackground(Color.white);

			String name = this.ReceiveRegister.getCutomerName();
			String date = this.ReceiveRegister.getAccidentDate();
			int time = this.ReceiveRegister.getAccidentTime();
			int AmountOfDamage = this.ReceiveRegister.getAmountOfDamage();

			this.dtm3 = new DefaultTableModel(Deal, 0);

			dtm3.addRow(new Object[] { name, date, time, AmountOfDamage });

			accidentData();
			this.table3 = new JTable(this.dtm3);
			table3.getTableHeader().setReorderingAllowed(false);

			select = table3.getSelectionModel();
			select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			this.scrollpane3 = new JScrollPane(this.table3);
			this.scrollpane3.setPreferredSize(new Dimension(500, 300));

			this.CCI = new JLabel("산정보험금");
			this.CCIT = new JTextField2();
			this.CCIT.setPreferredSize(new Dimension(150, 30));

			this.DAP2.add(CCI);
			this.DAP2.add(CCIT);
			this.DAP1.add(this.scrollpane3);

			this.DAP.add(DAP1, BorderLayout.CENTER);
			this.DAP.add(DAP2, BorderLayout.SOUTH);
			this.buttonP3.add(complete);
			this.buttonP3.add(cancel);
			this.centerP.add(DAP, BorderLayout.CENTER);
			this.centerP.add(buttonP3, BorderLayout.SOUTH);
			this.mainP.add(this.centerP);
			this.centerP.updateUI();
			this.VC = true;
		}
	}
    
	public boolean completeDeal() {
		this.ReceiveRegister.setCalculatedInsuranceFee(Integer.parseInt(this.CCIT.getText()));
		this.DB.setCompleteDealList(this.ReceiveRegister);
		System.out.println(this.DB.getCompleteDealList().get(0).getCalculatedInsuranceFee());
		return true;
	}

	public boolean setEmpolyee(Account account) {
		this.IAHC.setText(account.position + " - " + account.name + " 님");
		return true;
	}

	public void removeP(String button) {
		if (button == "A") {
			this.centerP.removeAll();
			this.VC = false;
			this.BC = false;
		} else if (button == "B") {
			this.centerP.removeAll();
			this.BC = false;
			this.VC = false;
		} else if (button == "C") {
			this.centerP.removeAll();
			this.VC = false;
		} else if (button == "진행") {
			this.centerP.removeAll();
			this.VC = false;
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
				ReceieveAccident();
			} else if (e.getActionCommand().equals("B")) {
				setKind("B");
				removeP("B");
				ClaimAdjustment();
			} else if (e.getActionCommand().equals("C")) {
				setKind("C");
				removeP("C");
				finishAccident();

			} else if (e.getActionCommand().equals("진행")) {
				setKind("진행");
				removeP("진행");
				Receive2();
				DealwithAccident();
			}
		}
	}
	@SuppressWarnings("unused")
	private class ListHandler implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			Register = e.getSource().toString();
		}
	}
}