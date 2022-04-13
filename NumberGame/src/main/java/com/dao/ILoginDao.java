package com.dao;

public interface ILoginDao {
	boolean validateUser(String username, String password);
	void insertUser(String username, String password);
	 public int getWins(String username);
	 public int getTotal(String username);
	 public void setWins(String username, int w);
	 public void setTotal(String username, int t);

}
