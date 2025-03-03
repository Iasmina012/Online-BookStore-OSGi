package org.fipro.cbse.online.book.store.api;

public interface IDatabaseAccess {
	
    void connectToDatabase();
    void disconnectFromDatabase();
    
}