package com.guessinggame.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.ILoginDao;

@Component
public class User {
	@Autowired
	ILoginDao loginDao;
	private String Username;
	private int wins;
	private int total;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getWins() {
		int w=loginDao.getWins(Username);
		wins=w;
		return wins;
	}
	public void setWins() {
		int w=loginDao.getWins(Username);
		w=w+1;
		this.wins=w;
		loginDao.setWins(Username,w);
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		int t=loginDao.getTotal(Username);
		t=t+1;
		this.total=t;
		loginDao.setTotal(Username,t);
	}
	
}
