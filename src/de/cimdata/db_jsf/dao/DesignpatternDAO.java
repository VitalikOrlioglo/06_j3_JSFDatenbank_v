package de.cimdata.db_jsf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.cimdata.db_jsf.db.DBConnect;
import de.cimdata.db_jsf.model.Designpattern;

public class DesignpatternDAO {
	private DBConnect dbConnect = DBConnect.getIntance();
	
	public List<Designpattern> findAll() {
		ArrayList<Designpattern> list = new ArrayList<Designpattern>();
		try {
			Statement s = dbConnect.getCon().createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM designpattern");
			
			while (rs.next()) {
				Designpattern d = new Designpattern();
				d.setId(rs.getInt("id"));
				d.setName(rs.getString("name"));
				d.setBeschreibung(rs.getString("beschreibung"));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
