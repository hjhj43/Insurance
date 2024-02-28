package Customer;

import java.util.ArrayList;

public interface CustomerList {
	public ArrayList<Customer> select();
	public boolean add(Customer customer);
	public boolean delete(int customerId);
	public Customer search(int customerId);
	public boolean update(String TypeName, String Content, int index);
	public boolean update(String TypeName, int Content, int index);
	public int ShowSize();
	public String getCustomerList(int i);
}