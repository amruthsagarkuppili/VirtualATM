package com.techaspect.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.techaspect.atm.to.User;

@Component
public class DBconnection{
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	User user ;
	JdbcTemplate jdbcTemplate;
	String transaction = "";
	String transamt = "";
	String transdate = "";
	String tempaction = "";
	String tempamt = "";
	String tempdate = "";
	String transplusamt = "";
	
	@Autowired
	public DBconnection(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
	}
	public boolean LoginUser(final User user) {
	
		 boolean status = false;
			
		try {
			String sql = "SELECT * FROM user_info WHERE pin = ?  AND cust_id = ? AND  password = ?;";
			
			RowMapper rowMapper = new RowMapper() {
				public Object mapRow(ResultSet rs, int rows) throws SQLException {
					
					user.setFname(rs.getString("fname"));
					user.setLname(rs.getString("lname"));
					user.setUid(rs.getString("user_id"));
					
					return user;
				}
			};
			
				jdbcTemplate.queryForObject(sql, rowMapper, user.getPin(), user.getCust_id(),user.getPassword());	
			
				status = true;
			
			
		} catch (EmptyResultDataAccessException erdae) {
			erdae.printStackTrace();
		} 
		
		
		return status;
	}


	public boolean BalanceEnquiry(User user) {
		
			boolean status = false;
			
		try {
				
			String sql = "SELECT account_bal FROM account_info WHERE user_id = ?;";
			
			RowMapper rowMapper = new RowMapper() {
				public Object mapRow(ResultSet rs, int rows) throws SQLException {
					
					user.setAccbal(rs.getString("account_bal"));
				
					return user;
				}
			};
			
			
			jdbcTemplate.queryForObject(sql, rowMapper, user.getUid());	
			
			status = true;
			
			
		} catch (EmptyResultDataAccessException erdae) {
			erdae.printStackTrace();
		}
		
		
		return status;
		
		
	}


	public boolean MiniStatement( User user) {
		
		 transaction = "";
		 transamt = "";
		 transdate = "";
		 tempaction = "";
		 tempamt = "";
		 tempdate = "";
		 transplusamt = "";
		boolean status = false;
		
		int i = 0,j=0;
		
	try {
			
		String sql = "SELECT *  FROM transaction_info WHERE user_id = ?";
		
		RowMapper rowMapper = new RowMapper() {
			public Object mapRow(ResultSet rs, int rows) throws SQLException {
				 
			
				tempaction = rs.getString("trans_id");
				
				transaction += tempaction + ","; 
				
				tempamt = rs.getString("trans_amt");
				
				transamt += tempamt + ",";
				
				tempdate = rs.getString("trans_date");
				
				transdate += tempdate + ",";
			
				return user;
			}
		};
		
		
		jdbcTemplate.query(sql, rowMapper, user.getUid());	
		transplusamt = transaction + "#" + transamt + "#" + transdate;
		user.setTransaction(transplusamt);
		status = true;
		
	
	
	}catch (EmptyResultDataAccessException erdae) {
		erdae.printStackTrace();
		return false;
	}
	return status;
}


	public boolean Withdraw(String amt, User  user) {
		
			boolean status = false;
			String amttype = amt + " dr";
			
		try {
			
				
			String sql = "SELECT * FROM account_info WHERE user_id = ?;" ;
			String sql2 = "UPDATE ACCOUNT_INFO SET account_bal =? WHERE user_id = ?;";
			String sql3 = "INSERT INTO TRANSACTION_INFO VALUES (?,CEIL(RAND()*1000000),'" + amttype + "',now());";

			RowMapper rowMapper = new RowMapper() {
				public Object mapRow(ResultSet rs, int rows) throws SQLException {
					
					user.setAcctype( rs.getString("account_type"));
					user.setAccno(rs.getString("account_no"));
					int bal = Integer.parseInt(rs.getString("account_bal"));
					int amount = Integer.parseInt(amt);
					int final_bal = bal - amount;
					
					user.setAccbal(String.valueOf(final_bal));

					
					return user;
				}
			};
			
			jdbcTemplate.queryForObject(sql, rowMapper, user.getUid());
			jdbcTemplate.update(sql2,user.getAccbal(),user.getUid());
			jdbcTemplate.update(sql3,user.getUid());

		
		return status;
		
		
	}catch (EmptyResultDataAccessException erdae) {
		erdae.printStackTrace();
	}
		return status;
	}

}
