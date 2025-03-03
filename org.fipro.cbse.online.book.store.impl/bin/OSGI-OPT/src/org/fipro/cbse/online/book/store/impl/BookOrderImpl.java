package org.fipro.cbse.online.book.store.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.fipro.cbse.online.book.store.model.Book;

import org.fipro.cbse.online.book.store.api.IBookInventory;
import org.fipro.cbse.online.book.store.api.IBookOrder;
import org.fipro.cbse.online.book.store.api.IDatabaseAccess;
import org.fipro.cbse.online.book.store.api.INetworkConnector;

import java.util.HashSet;
import java.util.Set;

@Component(service = IBookOrder.class)
public class BookOrderImpl implements IBookOrder {

    @Reference
    private INetworkConnector networkConnector;
    
    @Reference
    private IDatabaseAccess databaseAccess;
    
    @Reference
    private IBookInventory bookInventory;
    
    private Set<String> soldOutBooks = new HashSet<>();

    @Override
    public void processOrder(String title) {
    	
    	if (soldOutBooks.contains(title)) {
    		
            System.out.println("Book is out of stock: '" + title + "'");
            return;
            
        }

        for (Book book : bookInventory.getBooks()) {
        	
            if (book.getTitle().equalsIgnoreCase(title)) {
            	
                if (book.getStock() > 0) {
                	
                    book.decreaseStock();
                    System.out.println("Order placed successfully for: '" + title + "'");
                    if (book.getStock() == 0) {  
                    	
                    	soldOutBooks.add(title);
                        bookInventory.removeBooks(book.getId());
                        
                    }
                    
                }
                
                //databaseAccess.disconnectFromDatabase();
                //networkConnector.disconnectFromNetwork();
                return;
                
            }
       
        }

        System.out.println("Book not found: " + title);
        //databaseAccess.disconnectFromDatabase();
        //networkConnector.disconnectFromNetwork();
        
    }
    
}