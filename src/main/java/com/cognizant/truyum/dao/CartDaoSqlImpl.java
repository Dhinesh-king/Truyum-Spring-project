package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection conn = ConnectionHandler.getConnection();
		String sql = "insert into cart(user_id,menuItem_id) values(?,?)";
		try {
			PreparedStatement preps = conn.prepareStatement(sql);
			preps.setLong(1, userId);
			preps.setLong(2, menuItemId);
			System.out.println("Insertion is done... Number of rows Added: " + preps.executeUpdate());
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Error Occured while Inserting the  Date.. Check the correctness of mySQL code...");
			e.printStackTrace();
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuList = new ArrayList<>();
		Connection conn = ConnectionHandler.getConnection();
		String sql = "select * from menu_item m " + "\n join cart c on m.item_id=c.menuItem_id \n"
				+ " where c.user_id=?";
		try {
			PreparedStatement preps = conn.prepareStatement(sql);
			preps.setLong(1, userId);
			ResultSet rs = preps.executeQuery();
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
			System.out.println("SQL Error Occured while Getting the  Data.. Check the correctness of mySQL code...");
			e.printStackTrace();
		}
		if (menuList.isEmpty()) {
			throw new CartEmptyException("Cart is Empty..");
		} else {
			return menuList;
		}
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection conn = ConnectionHandler.getConnection();
		String sql = "delete from cart where user_id=? and menuItem_id=?";
		try {
			PreparedStatement preps = conn.prepareStatement(sql);
			preps.setLong(1, userId);
			preps.setLong(2, menuItemId);
			System.out.println("Deletion is done... Number of rows Deleted: " + preps.executeUpdate());
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL Error Occured while Deleting the  Data.. Check the correctness of mySQL code...");
			e.printStackTrace();
		}
	}

}
