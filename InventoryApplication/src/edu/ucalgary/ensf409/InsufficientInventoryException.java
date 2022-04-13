package edu.ucalgary.ensf409;

public class InsufficientInventoryException extends Exception{

	public InsufficientInventoryException(String housename) {
		super ("could not get sufficient iems for " + housename);
	}
}
