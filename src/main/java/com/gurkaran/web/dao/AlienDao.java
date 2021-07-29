package com.gurkaran.web.dao;

import java.sql.*;
import com.gurkaran.web.model.Alien;

public class AlienDao  //Every class has its own dao class for table (4 operation - create, update, delete, insert)
{	
	public Alien getAlien(int aid) 
	{
		Alien a = new Alien();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gurkaran","root","root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from alien where aid="+aid);
			if(rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return a;
	}
	

}
