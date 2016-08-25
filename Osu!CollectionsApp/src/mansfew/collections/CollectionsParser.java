package mansfew.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CollectionsParser extends Parser { 
	
	@SuppressWarnings("unused")
	private FileInputStream in;
	private Collectiondb[] collects;
	
	private int versionNumber, totalCollections;
	private int proccessedTotal;
	
	public CollectionsParser(String fileIn) throws IOException
	{
		System.out.println("collection.db");
		FileInputStream in = null;
		proccessedTotal = 0;
		
		
		try {
			in = new FileInputStream(fileIn);
		}
		catch(FileNotFoundException e) {
			System.err.println("File not Found\n" + e.getMessage());
			return;
		}
		
		byte[] r = new byte[4];
		in.read(r);
		versionNumber = byteToInt(r);
		in.read(r);
		totalCollections = byteToInt(r);
		collects = new Collectiondb[totalCollections];
		System.out.println("Version: " + versionNumber + "\nTotalCollections: " + totalCollections);
		
		for (int a = 0; a < 10; a++) {
			if (in.read() == 11) {
				int nameLength = in.read();
				byte[] nameByte = new byte[nameLength];
				in.read(nameByte);
				byte[] collectionSize = new byte[4];
				in.read(collectionSize);
				collects[a] = new Collectiondb(new String(nameByte, "UTF-8"), byteToInt(collectionSize));
				System.out.println(collects[a].getName() + " (" + collects[a].getSize() + ")");
				
				for (int b = 0; b < collects[a].getSize(); b++) {
					if (in.read() == 11) {
						byte[] bmByte = new byte[in.read()];
						in.read(bmByte);
						collects[a].addHash(new String(bmByte, "UTF-8"));
						System.out.println("#" + (1 + b)  + " " + new String(bmByte, "UTF-8"));
						proccessedTotal++;
					}
				}
			}
			
		}
		System.out.println("Total Beatmaps Proccessed: " + proccessedTotal + "\n\n");
		in.close();
		return;
	}
	
	public Collectiondb[] getcoll() {
		return collects;
	}

}
