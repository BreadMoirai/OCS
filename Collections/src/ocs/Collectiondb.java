package ocs;

public class Collectiondb {
	private String name;
	private int quantity;
	private String[] MD5Hash;
	
	private int add; 
	
	public Collectiondb(String n, int q) {
		name = n;
		quantity = q;
		MD5Hash = new String[quantity];
		add = 0;
		return;
	}
	
	public int addHash(String h) {
		MD5Hash[add] = h;
		return quantity - ++add;
	}
	
	public int getSize() {return quantity;}
	public String getName() {return name;}
}
