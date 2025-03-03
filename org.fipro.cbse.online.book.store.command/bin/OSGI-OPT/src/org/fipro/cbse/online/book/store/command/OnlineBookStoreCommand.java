package org.fipro.cbse.online.book.store.command;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.fipro.cbse.online.book.store.api.IBookInventory;
import org.fipro.cbse.online.book.store.api.IBookOrder;
import org.fipro.cbse.online.book.store.api.IDatabaseAccess;
import org.fipro.cbse.online.book.store.api.INetworkConnector;

@Component(
    property = {
        "osgi.command.scope:String=fipro",
        "osgi.command.function:String=connect",
        "osgi.command.function:String=stockInventory",
        "osgi.command.function:String=orderBook",
        "osgi.command.function:String=disconnect"
    },
    service = OnlineBookStoreCommand.class
)
public class OnlineBookStoreCommand {

	@Reference
    private INetworkConnector networkConnector;
	
	@Reference
	private IDatabaseAccess databaseAccess;
	
    @Reference
    private IBookInventory bookInventory;

    @Reference
    private IBookOrder bookOrder;
    
    private boolean isConnected = false;

    public void stockInventory() {
    	
    	if (!isConnected) {
    		
            System.out.println("Please connect first by calling the 'connect' method");
            return; 
            
        }
    	
    	//networkConnector.connectToNetwork();
        //databaseAccess.connectToDatabase();
        bookInventory.fetchBooks();
        System.out.println("Available books:");
        
        bookInventory.getBooks().forEach(book ->
        System.out.printf("%d. %s by %s (%d) - Stock: %d%n",
            book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.getStock()));

    }

    public void orderBook(String title) {
    	
    	if (!isConnected) {
    		
            System.out.println("Please connect first by calling the 'connect' method");
            return; 
            
    	}       
    	
        bookOrder.processOrder(title);
        
    }
    
    public void connect() {
    	
        databaseAccess.connectToDatabase();
        isConnected = true;
        System.out.println("Connected to the network and database");
    	
    }
    
    public void disconnect() {
    	
    	databaseAccess.disconnectFromDatabase();
    	isConnected = false;
        System.out.println("Disconnected from the network and database");
    	
    }
    
}