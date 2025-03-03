package org.fipro.cbse.online.book.store.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.fipro.cbse.online.book.store.api.IBookInventory;
import org.fipro.cbse.online.book.store.api.IDatabaseAccess;
import org.fipro.cbse.online.book.store.api.INetworkConnector;
import org.fipro.cbse.online.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

@Component(service = IBookInventory.class)
public class BookInventoryImpl implements IBookInventory {

    private final List<Book> books;
    
    @Reference
    private INetworkConnector networkConnector;

    @Reference
    private IDatabaseAccess databaseAccess;

    public BookInventoryImpl() {
    	
        books = new ArrayList<>();
        books.add(new Book(1, "1984", "George Orwell", 1949, 5));
        books.add(new Book(2, "A Walk To Remember", "Nicholas Sparks", 2002, 3));
        books.add(new Book(3, "Divergent", "Veronica Roth", 2011, 1));
        books.add(new Book(4, "The Cousins", "McManus, Karen", 2020, 4));
        books.add(new Book(5, "As Long as the Lemon Trees Grow", "Zoulfa Katouh", 2022, 7));
    }
    
    @Override
    public void fetchBooks() {
    	
    	System.out.println("Fetching books from database...");
    	
    }

    @Override
    public List<Book> getBooks() {
    	
        return books;
        
    }
    
    private Book findBookById(int bookId) {
    	
        for (Book book : books) {
           
        	if (book.getId() == bookId) {
                return book;
            }
            
        }
        
        return null;
        
    }
    
    @Override
    public void removeBooks(int bookId) {
    	
        Book book = findBookById(bookId);
        
        if (book != null) {
           
        	books.remove(book);
            System.out.println("'" + book.getTitle() + "' has been removed from the inventory due to being sold out");
        
        } else {
        	
            System.out.println("Book with ID:  " + bookId + " was not found");
            
        }
        
    }
    
}