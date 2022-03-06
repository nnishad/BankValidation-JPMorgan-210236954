package com.nikhilnishad.bankservice.model;

import java.util.ArrayList;

public class Request{
    public String accountNumber;
    public ArrayList<String> sources;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public ArrayList<String> getSources() {
		return sources;
	}
	public void setSources(ArrayList<String> sources) {
		this.sources = sources;
	}
}


