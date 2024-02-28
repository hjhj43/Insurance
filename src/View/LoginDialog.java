package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.DB;

public class LoginDialog extends JFrame {
	private static final long serialVersionUID = 1L;

	private DB DB;

	private JButton login;
	private JButton signUp;
	private JTextField ID;
	private JTextField PW;
	private JLabel loginL;
	private JLabel company;
	private JPanel mainP;
	private JPanel right;
	private JPanel left;
	private JPanel RU;
	private JPanel RD;
	private ActionHadler actionHandler;
	private ActionHandlerC actionHandlerC;
	private ActionHandlerInsured actionHandlerInsured;
	private ActionHandlerD actionHandlerD;
	private ActionHandlerS ActionHandlerS;
	private WindowListener windowHandler;
	private ActionHandlerI ActionHandlerI;

	private SalesMan salesman;
	private UW UW;
	private InsuranceDesigner insuranceDesigner;
	private InsuranceManager insuranceManager;
	private IAHC IAHC;
	private Insured insured;
	private ActionListener actionHandlerInit;
	private ActionListener ActionHandlerE;
	private ActionListener ActionHandlerM;

	private SignUp Signup;

	@SuppressWarnings("unused")
	private int C = 0;

	public LoginDialog() {

		this.DB = new DB();

		this.ActionHandlerI = new ActionHandlerI();
		this.ActionHandlerS = new ActionHandlerS();
		this.ActionHandlerE = new ActionHandlerE();
		this.ActionHandlerM = new ActionHandlerM();
		this.windowHandler = new WindowHandler();
		this.actionHandlerD = new ActionHandlerD();
		this.actionHandlerInsured = new ActionHandlerInsured();
		this.actionHandlerC = new ActionHandlerC();
		this.actionHandler = new ActionHadler();
		this.mainP = new JPanel();
		this.mainP.setLayout(new GridLayout(1, 0));

		this.loginL = new JLabel("Login");
		this.company = new JLabel("신동아");

		this.left = new JPanel();
		this.left.setLayout(new BorderLayout());
		this.left.add(this.company, BorderLayout.CENTER);

		this.RD = new JPanel();
		this.RU = new JPanel();

		this.right = new JPanel();
		this.right.setLayout(new GridLayout(0, 1));
		this.RD.setLayout(new GridLayout(1, 0));
		this.RU.setLayout(new GridLayout(3, 0));

		this.ID = new JTextField("GFE");
		this.PW = new JTextField("9517");

		this.right.add(RU);
		this.RU.add(this.loginL);
		this.RU.add(this.ID);
		this.RU.add(this.PW);

		this.login = new JButton("로그인");
		this.login.setActionCommand("로그인");
		this.login.addActionListener(actionHandler);
		this.signUp = new JButton("회원가입");
		this.signUp.setActionCommand("회원가입");
		this.signUp.addActionListener(actionHandler);

		this.right.add(RD);
		this.RD.add(this.login);
		this.RD.add(this.signUp);

		this.mainP.add(this.left);
		this.mainP.add(this.right);
		this.add(this.mainP);
		this.setBackground(Color.white);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void ShowList() {
		for (int i = 0; i < this.DB.getCustomerList().ShowSize(); i++) {
			System.out.println(this.DB.getCustomerList().search(i).getName());
		}
	}

	public void checkAccount(String ID, String PW) throws FileNotFoundException {
		int Count = 0;
		try {
			for (int i = 0; i < this.DB.getAccountList().getAccountList().size(); i++) {

				if (ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					if (this.DB.getAccountList().getAccountList().get(i).getPosition().equals("SalesMan")) {
						try {
							salesman = new SalesMan(this.DB, windowHandler, ActionHandlerS);
							salesman.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 1;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition().equals("UW")) {
						try {
							UW = new UW(this.DB, windowHandler, ActionHandlerE);
							UW.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 2;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition()
							.equals("InsuredDesigner")) {
						try {
							insuranceDesigner = new InsuranceDesigner(this.DB, actionHandlerD, windowHandler,
									actionHandlerInit);
							insuranceDesigner.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 3;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition()
							.equals("InsuredManager")) {
						try {
							insuranceManager = new InsuranceManager(this.DB, windowHandler, ActionHandlerM);
							insuranceManager.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 4;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition().equals("IAHC")) {
						try {
							IAHC = new IAHC(this.DB, windowHandler, ActionHandlerI);
							IAHC.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 5;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					} else {
						try {
							insured = new Insured(this.DB, actionHandlerInsured, windowHandler, actionHandlerInit);
							insured.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 6;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("화면을 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
						}
					}
				} else if (!ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("아이디가 다릅니다.");
					}
				} else if (ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& !PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("비밀번호가 다릅니다.");
					}
				} else if (!ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& !PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("아이디와 비밀번호를 확인해주세요");
					}
				}
			}
		} catch (Exception e) {
			@SuppressWarnings("unused")
			PopUp PU = new PopUp("계정리스트를 불러들이는 중 오류가 발생하였습니다. 관리자에게 문의바랍니다");
		}
	}

	public boolean AddCustomer() {
		this.DB.getCustomerList().add(this.Signup.getCustomer());
		this.DB.getAccountList().add(this.Signup.getAccount());
		@SuppressWarnings("unused")
		PopUp pop2 = new PopUp("가입이 완료되었습니다.");
		this.Signup.dispose();
		return true;
	}

	private class ActionHandlerS implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("저장1")) {
				salesman.savePro();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("제안서 작성이 완료되었습니다.");
			} else if (e.getActionCommand().equals("저장2")) {
				salesman.saveSub();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("청약서 작성이 완료되었습니다.");
			} else if (e.getActionCommand().equals("저장3")) {
				salesman.saveSub2();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("청약서 수정이 완료되었습니다.");
			} else if (e.getActionCommand().equals("수령확인")) {
				salesman.checkReceipt();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("수령이 확인되었습니다.");
			} else if (e.getActionCommand().equals("계약")) {
				salesman.SaveContract();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("계약이 완료되었습니다.");
			}
		}
	}

	private class ActionHadler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("로그인")) {
				try {
					checkAccount(ID.getText(), PW.getText());
				} catch (FileNotFoundException e1) {
					@SuppressWarnings("unused")
					PopUp pop = new PopUp("로그인 과정 중 오류가 발생하였습니다. 관리자에게 문의바랍니다.");
				}
			} else if (e.getActionCommand().equals("회원가입")) {
				Signup = new SignUp(DB, actionHandlerC);
			}
		}
	}

	private class ActionHandlerC implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("가입")) {
				if (Signup.getIDCheck() == true) {
					AddCustomer();
				} else if (Signup.getIDCheck() == false) {
					@SuppressWarnings("unused")
					PopUp pop = new PopUp("아이디 중복을 확인하세요.");
				}
			}
		}
	}

	private class ActionHandlerE implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("확인")) {
				UW.SaveAcceptancePolicies();
				DB = UW.getDB();
			} else if (e.getActionCommand().equals("검사하기")) {
				@SuppressWarnings("unused")
				PopUp p = new PopUp("허가되었습니다.");
				UW.complete();
				DB = UW.getDB();
			}
		}
	}

	private class ActionHandlerInsured implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("신고저장")) {
				insured.Report();
				DB = insured.getDB();
			}
		}
	}

	private class WindowHandler implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
		}
		@Override
		public void windowClosing(WindowEvent e) {
		}
		@Override
		public void windowClosed(WindowEvent e) {
		}
		@Override
		public void windowIconified(WindowEvent e) {
		}
		@Override
		public void windowDeiconified(WindowEvent e) {
		}
		@Override
		public void windowActivated(WindowEvent e) {
		}
		@Override
		public void windowDeactivated(WindowEvent e) {
		}
	}

	private class ActionHandlerI implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("접수")) {
				IAHC.Receieve();
				DB = IAHC.getDB();
			} else if (e.getActionCommand().equals("완료")) {
				IAHC.Receive2();
				IAHC.completeDeal();
				DB = IAHC.getDB();
			} else if (e.getActionCommand().equals("종결")) {
				IAHC.savefinal();
				DB = IAHC.getDB();
			}
		}
	}

	private class ActionHandlerM implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("확인")) {
				insuranceManager.SaveGuidelines();
				DB = insuranceManager.getDB();
			} else if (e.getActionCommand().equals("분납/수금")) {
				insuranceManager.SavePayment();
				DB = insuranceManager.getDB();
			} else if (e.getActionCommand().equals("만기계약")) {
				insuranceManager.SaveExpiration();
				DB = insuranceManager.getDB();
			}
		}
	}

	private class ActionHandlerD implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("완료")) {
				insuranceDesigner.developInsurance();
				DB = insuranceDesigner.getDB();
			}
		}
	}
}