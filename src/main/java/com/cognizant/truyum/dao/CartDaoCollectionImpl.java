package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao
{
	private static HashMap<Long, Cart> userCarts=null;
	 
	public CartDaoCollectionImpl()
	{
		super();
		if(userCarts==null)
		{
			userCarts= new HashMap<Long, Cart>();
		}
	}
	public void addCartItem(long userId,long menuItemId) throws ClassNotFoundException, IOException, SQLException
	{
		List<MenuItem> menuItemList;
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId))
		{
			Cart cart =userCarts.get(userId);
			menuItemList=cart.getMenuItemList();
			menuItemList.add(menuItem);	
		}
		else
		{
			menuItemList=new ArrayList<MenuItem>();
			menuItemList.add(menuItem);
			userCarts.put(userId, new Cart(menuItemList,0));
			System.out.println("Item added");
		}
	} 
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		Cart cart=userCarts.get(userId);
		List<MenuItem> menuItemList=cart.getMenuItemList();
		if(menuItemList.isEmpty())
		{
			throw new CartEmptyException("Empty cart");
		}
		else
		{
			double total = 0.0;
			for(MenuItem m:menuItemList)
			{
				total+=m.getPrice();
			}
			cart.setTotal(total);
		}
		return menuItemList;	
	}
	public  void removeCartItem(long userId,long menuItemId )
	{
		List<MenuItem> list=userCarts.get(userId).getMenuItemList();
		for(MenuItem m:list)
		{
			if(m.getId()==menuItemId)
			{
				list.remove(m);
				break;
			}
		}
	}
}
