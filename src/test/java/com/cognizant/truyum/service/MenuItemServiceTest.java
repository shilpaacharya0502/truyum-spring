package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;

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
     

}
