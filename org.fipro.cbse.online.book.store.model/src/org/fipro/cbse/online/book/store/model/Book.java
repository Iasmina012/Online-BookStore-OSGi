package org.fipro.cbse.online.book.store.model;

public class Book {
	
	private int id;
    private String title;
    private String author;
    private int year;
    private int stock;

    public Book(int id, String title, String author, int year, int stock) {
    	
        this.id = id;
    	this.title = title;
        this.author = author;
        this.year = year;
        this.stock = stock;
        
    }
    
    public int getId() { return id; }
    
    public String getTitle() { return title; }
    
	public String getAuthor() { return author; }
    
	public int getYear() { return year; }

	public int getStock() { return stock; }
	
	
	public void setId(int id) { this.id = id; }

	public void setTitle(String title) { this.title = title; }

	public void setAuthor(String author) { this.author = author; }
	
	public void setYear(int year) {	this.year = year; }
	
	public void setStock(int stock) { this.stock = stock; }

	public void decreaseStock() {
		
        if (stock > 0) {
            stock--;
        }
        
    }

	@Override
    public String toString() { 
		
		return id + ". " + title + " by " + author + " (" + year + ") - Stock: " + stock;
   
	}
    
}