package edu.frcc.CSC1061jfa24.MyBookTree;

public class BookCreator {

	public static void main(String[] args) {
		MyBookTree myBook = new MyBookTree("Trees for Dummies");
		
		myBook.addBookNode("Chapter 5", 5, 0, 0, null);
		myBook.addBookNode("Chapter 1", 1, 0, 0, null);
		myBook.addBookNode("Chapter 3", 3, 0, 0, null);
		myBook.addBookNode("Chapter 4", 4, 0, 0, null);
		myBook.addBookNode("Chapter 2", 2, 0, 0, null);
		
		myBook.addBookNode("Section 5.5", 5, 5, 0, null);
		myBook.addBookNode("Section 4.3", 4, 3, 0, null);
		myBook.addBookNode("Section 5.1", 5, 1, 0, null);
		myBook.addBookNode("Section 1.2", 1, 2, 0, null);
		
		myBook.addBookNode("SubSection 5.5.1", 5, 5, 1, null);
		myBook.addBookNode("SubSection 1.1.1", 1, 1, 1, null);
		
		for(MyBookNode node:myBook) {
			System.out.println(node);
		}
		

	}

}
