package oce;

import java.io.IOException;

public class Runner {
	
	@SuppressWarnings("unused")
	private static Collectiondb[] collectionDataBase;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		CollectionsParser c = new CollectionsParser("E:/osu!/collection.db");
		collectionDataBase = c.getcoll();
		OsuParser o = new OsuParser("E:/osu!/osu!.db");
	}

}
