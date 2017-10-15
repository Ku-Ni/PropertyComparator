package co.uk.coenie.property_comparator.dao;

public class PostcodeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6377596183525387051L;

	public PostcodeNotFoundException(String message){
		super(message);
	}
	
}
