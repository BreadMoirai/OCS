package mansfew.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CollectionsParser extends Parser { 
	
	private Collectiondb[] collects;
	
	private int versionNumber, totalCollections;
	private int proccessedTotal;
	
	public CollectionsParser(String fileIn)
	{
		//System.out.println("collection.db");
		try {
			in = new FileInputStream(fileIn);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not Found\n" + e.getMessage());
			e.printStackTrace();
		}
		proccessedTotal = 0;
		parse();
	}
	
	void parse() {
		
		versionNumber = nextInt();
		totalCollections = nextInt();
		collects = new Collectiondb[totalCollections];
		//System.out.println("Version: " + versionNumber + "\nTotalCollections: " + totalCollections);
		
		for (int a = 0; a < totalCollections; a++) {
			//String name = nextString();
			//int collsize = nextInt();
			collects[a] = new Collectiondb(nextString(), nextInt());
			System.out.println(collects[a].getName() + " (" + collects[a].getSize() + ")");
			
			for (int b = 0; b < collects[a].getSize(); b++) {
					collects[a].addHash(nextString());
					//System.out.println("#" + (1 + b)  + " " + new String(bmByte, "UTF-8"));
					proccessedTotal++;
				}
			collects[a].sort();
		}
		System.out.println("Total Beatmaps Proccessed: " + proccessedTotal + "\n\n");
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public Collectiondb[] getcoll() {
		return collects;
	}

}
