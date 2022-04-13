package com.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.ILoginDao;
@Repository
public class LoginDaoImpl implements ILoginDao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateUser(String username, String password) {
	
		int count=jdbcTemplate.queryForObject("select count(*) from gamelogin  where username=? and password=?",Integer.class,username,password);
		
		if (count==1)
		{	
			return true;
		}
		else
			return false;
	}
	public void insertUser(String username, String password)
	{
		String sql="insert into gamelogin values (?,?)";
		jdbcTemplate.update(sql,username,password);
		sql="insert into gamescore values (?,?,?)";
		jdbcTemplate.update(sql,username,0,0);
		System.out.println("New user inserted");
	}
	 public int getWins(String username)
	 {
		 int wins=jdbcTemplate.queryForObject("select wins from gamescore  where username=? ",Integer.class,username);
		 return wins;
	 }
	 public int getTotal(String username)
	 {
		 int total=jdbcTemplate.queryForObject("select total from gamescore  where username=? ",Integer.class,username);
		 return total;
	 }
	 public void setWins(String username, int w)
	 {
		 String sql="UPDATE gamescore SET wins=? WHERE username=?";
		 jdbcTemplate.update(sql,w,username);
	 }
	 public void setTotal(String username, int t)
	 {
		 String sql="UPDATE gamescore SET total=? WHERE username=?";
		 jdbcTemplate.update(sql,t,username);
	 }

}
