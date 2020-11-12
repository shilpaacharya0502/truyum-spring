package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest 
{
	public static void main(String [] args) throws ClassNotFoundException, IOException, SQLException
	{
		testAddCartItem();
		testRemoveCartItem();
	}
	
	public static void testAddCartItem() throws ClassNotFoundException, IOException, SQLException
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.addCartItem(1,3);
		cartDao.addCartItem(1,5);
		try {
			for(MenuItem m:cartDao.getAllCartItems(1))
			{
				System.out.println(m.toString());
			}
			
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
		
	}
	public static void testGetAllCartItems() throws ClassNotFoundException, IOException, SQLException
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		try {
			for(MenuItem m:cartDao.getAllCartItems(1))
			{
				System.out.println(m.toString());
			}
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
	}
	public static void testRemoveCartItem() throws ClassNotFoundException, IOException, SQLException
	{
		CartDao cartDao= new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,3);
		try {
			
			System.out.println("Item removed successfully\n"+cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) 
		{
			System.out.println("Empty Cart");
		}
		
	}
}
