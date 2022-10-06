package br.com.inverter.enums;

public enum Systems {
	NL(1, "NL"),
	MICROVIX(2, "MICROVIX"),
	PCI(3, "PCI");

	private Integer id;
	private String name;

	private Systems(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static Integer getId(String name) {
		for(Systems e : values()) {
	        if(e.name.equals(name)) return e.id;
	    }
	    return null;
		
	}
}
