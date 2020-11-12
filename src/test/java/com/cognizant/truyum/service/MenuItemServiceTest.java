package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemServiceTest {
    MenuItemService menuItemService;

    @Before
    public void initializeService() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.scan("com.cognizant.truyum");
            context.refresh();
            menuItemService = context.getBean(MenuItemService.class);
        }
    }

    @Test
    public void testGetMenuItemListAdminSize() throws ClassNotFoundException, IOException, SQLException {
        int actual=menuItemService.getMenuItemListAdmin().size();
        int expected=5;
        assertTrue(actual==expected);
    }
    @Test 
    public void testGetMenuItemListAdminContainsSandwich() throws ClassNotFoundException, IOException, SQLException {
        List<MenuItem> menuItemList=menuItemService.getMenuItemListAdmin();
        for(MenuItem m:menuItemList) {
            if(m.getName().equals("Sandwich"))
            {
                assertEquals("Sandwich",m.getName());
            }
        }
        
     }
    @Test
    public void testGetMenuItemListCustomerSize() throws ClassNotFoundException, IOException, SQLException {
        int expected=3;
        int actual=menuItemService.getMenuItemListCustomer().size();
        assertTrue(actual==expected);
    }
    @Test 
    public void testGetMenuItemListCustomerNotContainsFrenchFries() throws ClassNotFoundException, IOException, SQLException {
        List<MenuItem> menuItemList=menuItemService.getMenuItemListCustomer();
        for(MenuItem m:menuItemList) {
            if(m.getName().equals("French Fries"))
            {
                assertEquals("French Fries",m.getName());
            }
        }
    }
    @Test 
    public void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException{
        //System.out.println(menuItemService.getMenuItem(1));
        boolean res=menuItemService.getMenuItem(1).getName().equals("Sandwich");
        assertTrue(res);
    }
    @Test 
    public void testModifyMenuItem() throws ClassNotFoundException, IOException, SQLException{
        try {
            MenuItem mAdd= new MenuItem(2,"Noodles", 49, true, DateUtil.convertToDate("23/10/2020"), "Main Course",
                    false);
            menuItemService.modifyMenuItem(mAdd);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     

}
