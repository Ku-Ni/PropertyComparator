package co.uk.coenie.property_comparator.model;

public enum PropertyType {
	MANSION("Mansion"),
	TERRACED("Terraced"),
	DETACHED("Detached"),
	FLAT("Flat");

	private String name;

	private PropertyType(String name){
		this.name = name;
	}


	public String getName(){
		return name;
	}


}
