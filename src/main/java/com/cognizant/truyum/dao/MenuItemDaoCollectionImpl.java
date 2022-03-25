package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.util.DateUtil;
import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	private List<MenuItem> menuItemList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	// Deprecated this constructor for Xml Configuration
	/*
	 * public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) { super(); if
	 * (menuItemList.isEmpty()) {
	 * 
	 * menuItemList = new ArrayList<>(); MenuItem menu1 = new MenuItem(1,
	 * "Sandwich", 99, true, DateUtil.convertToDate("15/03/2017"), "Main Course",
	 * true); MenuItem menu2 = new MenuItem(2, "Burger", 129, true,
	 * DateUtil.convertToDate("23/12/2017"), "Main Course", true); MenuItem menu3 =
	 * new MenuItem(3, "Pizza", 149, true, DateUtil.convertToDate("21/08/2018"),
	 * "Main Course", true); MenuItem menu4 = new MenuItem(4, "French Fries", 57,
	 * false, DateUtil.convertToDate("02/07/2017"), "Starters", true); MenuItem
	 * menu5 = new MenuItem(5, "Chocolate Brownie", 32, true,
	 * DateUtil.convertToDate("02/11/2022"), "Dessert", true);
	 * menuItemList.add(menu1); menuItemList.add(menu2); menuItemList.add(menu3);
	 * menuItemList.add(menu4); menuItemList.add(menu5); } this.menuItemList =
	 * menuItemList; }
	 */

	/**
	 * This method returns the list of menu items that will be displayed in the
	 * MenuItem listing screen for Admin. 1. Return the menuItemList
	 */
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * This method returns the list of menu items that will be displayed in the Menu
	 * Item listing screen for Customer. 1. Initialize an ArrayList for type
	 * MenuItem 2. Iterate through menuItemList and perform the following steps: a.
	 * Is the launch date of the menu item is today or before today? b. Is the menu
	 * item available is active? c. If the above conditions satisfy, add the menu
	 * item into the ArrayList created in the first step. 3. Return the filtered
	 * ArrayList
	 */
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerList = new ArrayList<>();
		Date today = new Date();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.isActive() && menuItem.getDateOfLaunch().before(today)) {
				customerList.add(menuItem);
			}
		}
		return customerList;
	}

	/**
	 * This method will be used to change the menu item data in the list of menu
	 * items. This method will be invoked when Customer submits the user form. 1.
	 * Iterate through the menuItemList and find the matching menu item 2. Update
	 * the matching menuItem in the ArrayList
	 */
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// menuItem = new MenuItem();
		for (MenuItem menuItem1 : menuItemList) {
			if(menuItem.getId()==menuItem1.getId()) {
				menuItem1.setName(menuItem.getName());
				menuItem1.setActive(menuItem.isActive());
				menuItem1.setCategory(menuItem.getCategory());
				menuItem1.setDateOfLaunch(menuItem.getDateOfLaunch());
				menuItem1.setPrice(menuItem.getPrice());
				menuItem1.setFreeDelivery(menuItem.isFreeDelivery());
			}
			
			/*if (menuItem.equals(menuItem1)) {
				System.out.println("Enter the new Id of the product");
				long newId = sc.nextInt();
				menuItem1.setId(newId);

				sc.nextLine();
				System.out.println("Enter the new Name of the product");
				String newName = sc.nextLine();
				menuItem1.setName(newName);

				System.out.println("Enter the new price of the product");
				long newPrice = sc.nextLong();
				menuItem1.setPrice(newPrice);

				System.out.println("Enter the new Active status of the product (Yes/No)");
				boolean newStatus = sc.nextLine().equalsIgnoreCase("Yes");
				menuItem1.setActive(newStatus);

				System.out.println("Enter the new Date of Launch of the product (dd/MM/yyyy)");
				String date = sc.nextLine();
				Date newDate = null;
				newDate = DateUtil.convertToDate(sc.nextLine());
				menuItem1.setDateOfLaunch(newDate);

				System.out.println("Enter the new Category of the product");
				String newCategory = sc.nextLine();
				menuItem1.setCategory(newCategory);

				System.out.println("Enter the new Free Delivery status of the product (Yes/No)");
				boolean newDelivery = sc.nextLine().equalsIgnoreCase("Yes");
				menuItem1.setFreeDelivery(newDelivery);

				System.out.println("Menu Item Updated....");
			}*/
		}
	}

	/**
	 * This method is used to retrieve a particular menu item�s detail from the menu
	 * item list. This method will be invoked when user click on Edit link in menu
	 * item listing screen of Admin. 1. Iterate through menuItemList and find the
	 * matching menu item 2. Return the matching menuItem from the menuItemList
	 */
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItem1 : menuItemList) {
			if (menuItemId == menuItem1.getId()) {
				return menuItem1;
			}
		}
		return null;
	}

}
