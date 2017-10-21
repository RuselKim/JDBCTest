package com;

public class Shops {
	
public Shops( String name,String adress){
	setAdress(adress);
	setName(name);
	
}

public Shops(int id, String name,String adress){
	setId(id);
	setAdress(adress);
	setName(name);
	
}

	private int id;
	private String name;
	private String adress;
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
