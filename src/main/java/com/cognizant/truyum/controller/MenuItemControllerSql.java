package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.LoginData;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.LoginService;

//@Controller
//@SessionAttributes("userId")
public class MenuItemControllerSql {

	MenuItemDaoSqlImpl menuDaoImpl = new MenuItemDaoSqlImpl();
	static LoginService loginService = new LoginService();

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/menu-list-customer")
	public String menuItemListCustomer(ModelMap model) {
		LOGGER.info("Start");
		model.put("menuItemList", menuDaoImpl.getMenuItemListCustomer());
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(@RequestParam int userId, ModelMap model) {
		LOGGER.info("Start");
		model.put("userId", userId);
		model.put("menuItemList", menuDaoImpl.getMenuItemListCustomer());
		LOGGER.info("End");
		return "menu-item-list-customer";
	}

	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("Start");
		model.put("menuItemList", menuDaoImpl.getMenuItemListAdmin());
		LOGGER.info("End");
		return "menu-item-list-admin";
	}

	@PostMapping("/show-menu-list-admin")
	public String loginMenuItemListAdmin(@ModelAttribute("login") LoginData loginData, ModelMap model) {
		LOGGER.info("Start");
		if (loginService.validate(loginData)) {
			model.put("login", loginData);
			model.put("menuItemList", menuDaoImpl.getMenuItemListAdmin());
			LOGGER.info("End");
			return "menu-item-list-admin";
		}
		model.put("errorMessage", "Either Username or Password is wrong!!");
		return "admin-login";
	}

	@GetMapping("/edit-menu-item")
	public String showEditMenuItem(@RequestParam int menuItemId, ModelMap model) {
		model.put("menuItem", menuDaoImpl.getMenuItem(menuItemId));
		return "edit-menu-item";
	}

	@PostMapping("/edit-menu-item")
	public String editMenuItem(@Valid MenuItem menuItem, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-menu-item";
		}
		menuDaoImpl.modifyMenuItem(menuItem);
		return "edit-menu-item-status";
	}

	@ModelAttribute("categoryList")
	public List<String> showCategoryList() {
		List<String> categorylist = new ArrayList<>();
		categorylist.add("Main Coarse");
		categorylist.add("Dessert");
		categorylist.add("Starters");
		categorylist.add("Drinks");
		return categorylist;
	}
}
