package edu.ucalgary.ensf409;

public class InsufficientInventoryException extends Exception{

	public InsufficientInventoryException(String housename) {
		super ("Could not get sufficient items for " + housename);
	}
}
