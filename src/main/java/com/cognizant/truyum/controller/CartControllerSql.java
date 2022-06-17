package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Controller
@SessionAttributes("userId")
public class CartControllerSql {
	CartDaoSqlImpl cartDaoImpl=new CartDaoSqlImpl();

	@GetMapping("/show-cart")
	public String showCart(@RequestParam long userId,ModelMap model) {
		double price = 0;
		try {
			List<MenuItem> menuList = cartDaoImpl.getAllCartItems(userId);
			for (MenuItem item : menuList) {
				price = price + item.getPrice();
			}
			model.put("menuItemList", menuList);

			model.put("totalPrice", price);
		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}

	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam int menuItemId, @RequestParam long userId,ModelMap model) {
		cartDaoImpl.addCartItem(userId, menuItemId);
		List<MenuItem> listMenu;
		double price = 0;
		try {
			listMenu = cartDaoImpl.getAllCartItems(userId);
			for (MenuItem item : listMenu) {
				price = price + item.getPrice();
			}
			model.put("totalPrice", price);
			model.put("menuItemList", listMenu);
		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}

	@GetMapping("/remove-cart-item")
	public String removeFromCart(@RequestParam int menuItemId,@RequestParam long userId, ModelMap model) {
		cartDaoImpl.removeCartItem(userId, menuItemId);
		List<MenuItem> listMenu;
		double price = 0;
		try {
			listMenu = cartDaoImpl.getAllCartItems(userId);
			for (MenuItem menuItem : listMenu) {
				price = price + menuItem.getPrice();
			}
			model.put("totalPrice", price);
			model.put("menuItemList", listMenu);

		} catch (CartEmptyException e) {
			return "empty-cart";
		}
		return "cart";
	}
}
