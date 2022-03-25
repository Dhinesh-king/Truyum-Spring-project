package com.cognizant.truyum.dao;

import java.util.*;


import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	Map<Long, Cart> userCart = new HashMap<>();

	MenuItemDaoCollectionImpl midc = new MenuItemDaoCollectionImpl();

	public Map<Long, Cart> getUserCart() {
		return userCart;
	}

	public MenuItemDaoCollectionImpl getMidc() {
		return midc;
	}

	public void setMidc(MenuItemDaoCollectionImpl midc) {
		this.midc = midc;
	}

	public void setUserCart(Map<Long, Cart> userCart) {
		this.userCart = userCart;
	}

	public CartDaoCollectionImpl() {
		super();

	}

	/**
	 * This is an Unimplemented method... private CartDaoCollectionImpl(Map<Long,
	 * Cart> userCart) { super(); if(userCart.isEmpty()) { Cart cart=new Cart(list,
	 * 1000); userCart.put((long) 123, cart); }
	 * 
	 * this.userCart = userCart; } .
	 */
	/**
	 * This method is invoked when Customer clicks Add to Cart link in menu item
	 * listing screen. This method gets the menu item list from the HashMap for the
	 * specific user and adds the menu item into the menu item list. If there is no
	 * such user in the HashMap, then a new entry needs to be added in the HashMap
	 * with userId as key and new ArrayList of Menu Items as value. 1. Instantiate
	 * MenuItemDaoCollectionImpl and assign it MenuItemDao reference variable
	 * menuItemDao. 2. Get the menuItem using menuItemDao.getMenuItem(menuItemId)
	 * method 3. Check existence of user in userCarts based on userId 4. If user
	 * exists in userCarts, perform the steps below: a. Get the menuItemList from
	 * the userCarts b. Add the menuItem obtained in previous step into menuItemList
	 * 5. If user does not exist in userCarts, perform the steps below: a. Create a
	 * new Cart instance with new ArrayList b. Add the menu item obtained in step
	 * one and add it to menuItemList created in previous step c. Put the userId and
	 * ArrayList of MenuItem into the userCarts
	 */
	@Override
	public void addCartItem(long userId, long menuItemId) {
		// MenuItemDaoCollectionImpl midc = (MenuItemDaoCollectionImpl)
		// ctx.getBean("menuItemDaoImpl");
		Set<Long> keySet = userCart.keySet();
		boolean check = true;
		for (Long key : keySet) {
			if (key == userId) {
				MenuItem menuItem = midc.getMenuItem(menuItemId);
				userCart.get(key).getMenuItemList().add(midc.getMenuItem(menuItemId));
				userCart.get(key).setPrice(userCart.get(key).getPrice() + menuItem.getPrice());
				check = false;
			}
		}
		if (check) {
			MenuItem menuItem = midc.getMenuItem(menuItemId);
			List<MenuItem> menuList = new ArrayList<>();
			menuList.add(menuItem);
			Cart cart = new Cart(menuList, menuItem.getPrice());
			userCart.put(userId, cart);

		}
	}

	/** Method to remove the Item in a Cart */
	@Override
	public void removeCartItem(long userId, long menuItemId) {
		double itemPrice=midc.getMenuItem(menuItemId).getPrice();
		Set<Long> keySet = userCart.keySet();
		boolean check=true;
		for (Long key : keySet) {
			if(key==userId) {
				userCart.get(key).setPrice(userCart.get(key).getPrice()-itemPrice);
				userCart.get(key).getMenuItemList().remove(midc.getMenuItem(menuItemId));
				check=false;
			}
		}
		if(check) {
			throw new NullPointerException();
		}
	}

	/**
	 * Method to get list of menu items added by a customer to Cart. 1. Get the
	 * menuItemList based on userId from the HashMap of userCarts 2. If the returned
	 * list is empty a. Create new CartEmptyException and throw it 3. If the
	 * returned list is not empty a. Iterate through the menuItemList and add up the
	 * prices. b. Set the total instance variable of cart with the added up menu
	 * item prices. c. return cart
	 */
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		List<MenuItem> listMenu;
		try {
			listMenu = userCart.get(userId).getMenuItemList();
		} catch (NullPointerException e) {
			throw new CartEmptyException("Your Cart Is Empty Add Some Products..");
		}
		return listMenu;
	}

}
