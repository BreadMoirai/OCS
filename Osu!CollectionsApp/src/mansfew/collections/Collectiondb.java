package mansfew.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Collectiondb {
	private String name;
	private int quantity;
	private String[] MD5Hash;
	private LinkedList<Beatmap> bmaps;
	private int add;
	
	public Collectiondb(String n, int q) {
		name = n;
		quantity = q;
		MD5Hash = new String[quantity];
		add = 0;
		return;
	}
	
	public void initMaps(HashMap<String, Beatmap> hmap) {
		bmaps = new LinkedList<Beatmap>();
		for (String s: MD5Hash) {
			bmaps.add(hmap.get(s));
		}
	}
	
	public int addHash(String h) {
		MD5Hash[add] = h;
		return quantity - ++add;
	}
	
	public LinkedList<Beatmap> getBeatmaps() {return bmaps;}
	public int getSize() {return quantity;}
	public String getName() {return name;}
	public String[] getHashes() {return MD5Hash;}
	public void sort() {Arrays.sort(MD5Hash);}
	public void sort(String s) {Collections.sort(bmaps, new BeatmapComparator(s));}
}
