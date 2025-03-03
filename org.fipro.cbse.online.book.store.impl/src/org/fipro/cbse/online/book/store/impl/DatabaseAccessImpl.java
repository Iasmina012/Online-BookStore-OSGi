package org.fipro.cbse.online.book.store.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.fipro.cbse.online.book.store.api.IDatabaseAccess;
import org.fipro.cbse.online.book.store.api.INetworkConnector;

@Component(service = IDatabaseAccess.class)
public class DatabaseAccessImpl implements IDatabaseAccess {
	
	@Reference
    private INetworkConnector networkConnector;

    @Override
    public void connectToDatabase() {
    	
    	networkConnector.connectToNetwork();
        System.out.println("Connecting to database...");
        
    }

    @Override
    public void disconnectFromDatabase() {
    	
        System.out.println("Disconnecting from database...");
        networkConnector.disconnectFromNetwork();
        
    }
    
}