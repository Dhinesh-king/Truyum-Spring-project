package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class MenuItemDaoSqlImpl implements MenuItemDao {

	static Connection conn = ConnectionHandler.getConnection();

	/**
	 * getMenuItemListAdmin(): List<MenuItem> 1. Get connection using
	 * ConnectionHandler
	 * 
	 * 2. Initialize an ArrayList of MenuItem
	 * 
	 * 3. Using PreparedStatement execute the select query that retrieves all the
	 * records from menu_item table
	 * 
	 * 4. Iterate through the ResultSet
	 * 
	 * 5. For each item in the ResultSet create a new MenuItem instance and add it
	 * to the ArrayList created in the step 2 and return the ArrayList
	 */

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// Connection conn = ConnectionHandler.getConnection();
		List<MenuItem> menuList = new ArrayList<>();
		String sql = "select * from menu_item";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(rs.getLong(1));
				menuItem.setName(rs.getString(2));
				menuItem.setPrice(rs.getFloat(3));
				menuItem.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				menuItem.setDateOfLaunch(DateUtil.convertToDate(rs.getString(5)));
				menuItem.setCategory(rs.getString(6));
				menuItem.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));
				menuList.add(menuItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {

		List<MenuItem> menuList = new ArrayList<>();
		String sql = "select * from menu_item";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(rs.getLong(1));
				menuItem.setName(rs.getString(2));
				menuItem.setPrice(rs.getFloat(3));
				menuItem.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				menuItem.setDateOfLaunch(DateUtil.convertToDate(rs.getString(5)));
				menuItem.setCategory(rs.getString(6));
				menuItem.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));

				if (menuItem.isActive() && menuItem.getDateOfLaunch().before(new Date())) {
					menuList.add(menuItem);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	/**
	 * editMenuItem(menuItem: MenuItem): void 1. Get connection using
	 * ConnectionHandler 2. Execute update statement using PreparedStatement that
	 * modifies the values of menuItem table based on menuItemId. 3. Set the
	 * parameters of the PreparedStatement and execute the statement
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// Connection conn = ConnectionHandler.getConnection();
		String sql1="delete from menu_item where item_id=?";
		String sql ="insert into menu_item(item_id,name,price,active,date,category,free_delivery) values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setLong(1, menuItem.getId());
			ps1.executeUpdate();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, menuItem.getId());
			ps.setString(2, menuItem.getName());
			ps.setFloat(3, menuItem.getPrice());
			ps.setBoolean(4, menuItem.isActive());
			ps.setString(5, DateUtil.convertToString(menuItem.getDateOfLaunch()));
			ps.setString(6, menuItem.getCategory());
			ps.setBoolean(7, menuItem.isFreeDelivery());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Updation Failed...");
			e.printStackTrace();
		}
	}

	/**
	 * getMenuItem(menuItemId: long): MenuItem 1. Get connection using
	 * ConnectionHandler 2. Execute select query using PreparedStatement that
	 * retrieves an item from menuItem table based on menuItemId. 3. Create a
	 * MenuItem instance and set the values for this menuItem instance from the
	 * first item of the ResultSet 4. Return the menuItem created in the previous
	 * step
	 */
	public MenuItem getMenuItem(long menuItemId) {
		// Connection conn = ConnectionHandler.getConnection();
		MenuItem menuItem = new MenuItem();
		String sql = "select * from menu_item where item_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				menuItem.setId(rs.getLong(1));
				menuItem.setName(rs.getString(2));
				menuItem.setPrice(rs.getFloat(3));
				menuItem.setActive(rs.getString(4).equalsIgnoreCase("yes"));
				menuItem.setDateOfLaunch(DateUtil.convertToDate(rs.getString(5)));
				menuItem.setCategory(rs.getString(6));
				menuItem.setFreeDelivery(rs.getString(7).equalsIgnoreCase("yes"));
			}
		} catch (SQLException e) {
			System.out.println("An Error Occured.../nCannot retrieve data from the database...");
			e.printStackTrace();
		}
		return menuItem;
	}

	/**
	 * To check the SQL Connection this method is created... Connection with sql is
	 * created Successfully.....All methods are Working Fine....____Checked_____
	 */

	/**
	 * 
	 * public static void main(String[] args) {
	 * 
	 * MenuItemDaoSqlImpl misi=new MenuItemDaoSqlImpl();
	 * 
	 * MenuItem mi=misi.getMenuItem(2);
	 * 
	 * System.out.println(mi);
	 * 
	 * System.out.println(misi.getMenuItemListAdmin());
	 * 
	 * System.out.println(misi.getMenuItemListCustomer());
	 * 
	 * //System.out.println(misi.modifyMenuItem(mi));
	 * 
	 * }
	 */
	public static void main(String[] args) {
		MenuItemDaoSqlImpl misi = new MenuItemDaoSqlImpl();
		MenuItem mi = misi.getMenuItem(2);
		System.out.println(mi);
		System.out.println(misi.getMenuItemListAdmin());
		System.out.println(misi.getMenuItemListCustomer());
	}

}
