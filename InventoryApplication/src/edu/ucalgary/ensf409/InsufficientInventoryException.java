package edu.ucalgary.ensf409;

/**
 * Error for make and finalize order method
 * @author myles, muhammad
 * @version 2.2
 * @since 1.0
 */
public class InsufficientInventoryException extends Exception{

	/**
	 * Error thrown when inventory cannot meet needs of specific household
	 * @param housename name of house that throws error
	 */
	public InsufficientInventoryException(String housename) {
		super ("Could not get sufficient items for " + housename);
	}
}
