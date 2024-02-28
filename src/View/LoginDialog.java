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
		this.company = new JLabel("�ŵ���");

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

		this.login = new JButton("�α���");
		this.login.setActionCommand("�α���");
		this.login.addActionListener(actionHandler);
		this.signUp = new JButton("ȸ������");
		this.signUp.setActionCommand("ȸ������");
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
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition().equals("UW")) {
						try {
							UW = new UW(this.DB, windowHandler, ActionHandlerE);
							UW.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 2;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
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
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition()
							.equals("InsuredManager")) {
						try {
							insuranceManager = new InsuranceManager(this.DB, windowHandler, ActionHandlerM);
							insuranceManager.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 4;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
						}
					} else if (this.DB.getAccountList().getAccountList().get(i).getPosition().equals("IAHC")) {
						try {
							IAHC = new IAHC(this.DB, windowHandler, ActionHandlerI);
							IAHC.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 5;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
						}
					} else {
						try {
							insured = new Insured(this.DB, actionHandlerInsured, windowHandler, actionHandlerInit);
							insured.setEmpolyee(this.DB.getAccountList().getAccountList().get(i));
							C = 6;
						} catch (Exception e) {
							@SuppressWarnings("unused")
							PopUp PU = new PopUp("ȭ���� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
						}
					}
				} else if (!ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("���̵� �ٸ��ϴ�.");
					}
				} else if (ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& !PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("��й�ȣ�� �ٸ��ϴ�.");
					}
				} else if (!ID.equals(this.DB.getAccountList().getAccountList().get(i).getID())
						&& !PW.equals(this.DB.getAccountList().getAccountList().get(i).getPW())) {
					Count++;
					if (Count == this.DB.getAccountList().getCount()) {
						@SuppressWarnings("unused")
						PopUp pop = new PopUp("���̵�� ��й�ȣ�� Ȯ�����ּ���");
					}
				}
			}
		} catch (Exception e) {
			@SuppressWarnings("unused")
			PopUp PU = new PopUp("��������Ʈ�� �ҷ����̴� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�");
		}
	}

	public boolean AddCustomer() {
		this.DB.getCustomerList().add(this.Signup.getCustomer());
		this.DB.getAccountList().add(this.Signup.getAccount());
		@SuppressWarnings("unused")
		PopUp pop2 = new PopUp("������ �Ϸ�Ǿ����ϴ�.");
		this.Signup.dispose();
		return true;
	}

	private class ActionHandlerS implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("����1")) {
				salesman.savePro();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("���ȼ� �ۼ��� �Ϸ�Ǿ����ϴ�.");
			} else if (e.getActionCommand().equals("����2")) {
				salesman.saveSub();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("û�༭ �ۼ��� �Ϸ�Ǿ����ϴ�.");
			} else if (e.getActionCommand().equals("����3")) {
				salesman.saveSub2();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("û�༭ ������ �Ϸ�Ǿ����ϴ�.");
			} else if (e.getActionCommand().equals("����Ȯ��")) {
				salesman.checkReceipt();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("������ Ȯ�εǾ����ϴ�.");
			} else if (e.getActionCommand().equals("���")) {
				salesman.SaveContract();
				DB = salesman.getDB();
				@SuppressWarnings("unused")
				PopUp p = new PopUp("����� �Ϸ�Ǿ����ϴ�.");
			}
		}
	}

	private class ActionHadler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�α���")) {
				try {
					checkAccount(ID.getText(), PW.getText());
				} catch (FileNotFoundException e1) {
					@SuppressWarnings("unused")
					PopUp pop = new PopUp("�α��� ���� �� ������ �߻��Ͽ����ϴ�. �����ڿ��� ���ǹٶ��ϴ�.");
				}
			} else if (e.getActionCommand().equals("ȸ������")) {
				Signup = new SignUp(DB, actionHandlerC);
			}
		}
	}

	private class ActionHandlerC implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("����")) {
				if (Signup.getIDCheck() == true) {
					AddCustomer();
				} else if (Signup.getIDCheck() == false) {
					@SuppressWarnings("unused")
					PopUp pop = new PopUp("���̵� �ߺ��� Ȯ���ϼ���.");
				}
			}
		}
	}

	private class ActionHandlerE implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Ȯ��")) {
				UW.SaveAcceptancePolicies();
				DB = UW.getDB();
			} else if (e.getActionCommand().equals("�˻��ϱ�")) {
				@SuppressWarnings("unused")
				PopUp p = new PopUp("�㰡�Ǿ����ϴ�.");
				UW.complete();
				DB = UW.getDB();
			}
		}
	}

	private class ActionHandlerInsured implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�Ű�����")) {
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
			if (e.getActionCommand().equals("����")) {
				IAHC.Receieve();
				DB = IAHC.getDB();
			} else if (e.getActionCommand().equals("�Ϸ�")) {
				IAHC.Receive2();
				IAHC.completeDeal();
				DB = IAHC.getDB();
			} else if (e.getActionCommand().equals("����")) {
				IAHC.savefinal();
				DB = IAHC.getDB();
			}
		}
	}

	private class ActionHandlerM implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Ȯ��")) {
				insuranceManager.SaveGuidelines();
				DB = insuranceManager.getDB();
			} else if (e.getActionCommand().equals("�г�/����")) {
				insuranceManager.SavePayment();
				DB = insuranceManager.getDB();
			} else if (e.getActionCommand().equals("������")) {
				insuranceManager.SaveExpiration();
				DB = insuranceManager.getDB();
			}
		}
	}

	private class ActionHandlerD implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("�Ϸ�")) {
				insuranceDesigner.developInsurance();
				DB = insuranceDesigner.getDB();
			}
		}
	}
}