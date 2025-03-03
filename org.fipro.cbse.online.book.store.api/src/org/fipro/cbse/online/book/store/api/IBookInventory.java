package org.fipro.cbse.online.book.store.api;

import java.util.List;

import org.fipro.cbse.online.book.store.model.Book;

public interface IBookInventory {
	
    void fetchBooks();
	List<Book> getBooks();
	void removeBooks(int bookId);
    
}