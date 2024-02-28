package Asset;

import java.util.Vector;

public class AccountList {

	private Vector<Account> accountlist;
	private int count;

	public AccountList() {
		this.accountlist = new Vector<Account>();
	}

	public Vector<Account> getAccountList() {
		return this.accountlist;
	}

	public void add(String id, String pw, String position, String name) {
		Account account = new Account(id, pw, position, name);
		System.out.println(account.getAccount());
		accountlist.add(account);

	}

	public int getCount() {
		return this.count;
	}

	public static class Account {
		public String id;
		public String pw;
		public String position;
		public String name;

		public Account(String id, String pw, String position, String name) {
			this.id = id;
			this.pw = pw;
			this.position = position;
			this.name = name;
		}

		public Account() {

		}

		public String getAccount() {
			String account = this.id + " " + this.pw + " " + this.position + " " + this.name;
			return account;
		}

		public String getID() {
			return this.id;
		}

		public String getPW() {
			return this.pw;
		}

		public String getPosition() {
			return this.position;
		}

		public String getName() {
			return this.name;
		}

		public void setID(String id) {
			this.id = id;
		}

		public void setPW(String pw) {
			this.pw = pw;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public void add(Account account) {
		this.accountlist.add(account);
	}
}
