package dataprovider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import manager.FileReaderManager;
import testdatatypes.Customer;

public class JsonDataReader {

	private final String customerfilepath = FileReaderManager.getInstance().getConfigreader().getJsonPath();
			
	private List<Customer> customerlist;

	public JsonDataReader() {
		customerlist = getCustomerData();

	}

	private List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferedreader = null;

		try {
	
			try {
				 bufferedreader = new BufferedReader(new InputStreamReader(
				        new FileInputStream(customerfilepath), "UTF8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		/**	bufferedreader = new BufferedReader(new FileReader(customerfilepath));*/
			
			
			Customer[] customers = gson.fromJson(bufferedreader, Customer[].class);
			List<Customer> asList = Arrays.asList(customers);
			System.out.println(asList);
			return asList;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at :" + customerfilepath);
		} finally {
			try {
				if (bufferedreader != null)
					bufferedreader.close();
			} catch (IOException ignore) {
			}

		}
	}
	public final Customer getCustomerByname() {
		for(Customer customer : customerlist) {
			return  customer;
		}
		return null;
		
	}

	public final Customer getCustomerByname(String customerName) {
		for (Customer customer : customerlist) {
			if (customer.Username.equalsIgnoreCase(customerName))
				{return customer;}
			else {
				System.out.println("Name Not Equal");
			}

		}
		return null;

	}
	

	
}
