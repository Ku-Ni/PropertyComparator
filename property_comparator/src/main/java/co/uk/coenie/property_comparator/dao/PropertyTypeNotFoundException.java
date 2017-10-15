package co.uk.coenie.property_comparator.dao;

public class PropertyTypeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8668778264463937233L;
	
	public PropertyTypeNotFoundException(String message){
		super(message);
	}

}
