package org.fipro.cbse.online.book.store.impl;

import org.osgi.service.component.annotations.Component;

import org.fipro.cbse.online.book.store.api.INetworkConnector;

@Component(service = INetworkConnector.class)
public class NetworkConnectorImpl implements INetworkConnector {

    @Override
    public void connectToNetwork() {
    	
        System.out.println("Connecting through HTTPS...");
        
    }

    @Override
    public void disconnectFromNetwork() {
    	
        System.out.println("Disconnecting from network...");
        
    }
    
}