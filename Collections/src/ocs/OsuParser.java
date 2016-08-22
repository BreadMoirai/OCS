package ocs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class OsuParser extends Parser{
		
		@SuppressWarnings("unused")
		private FileInputStream in;
		
		private int versionNumber, folderCount, totalBeatmaps, proccessedTotal;
		private String playerName;
		private HashMap<String, Beatmap> beatmaps;	
		
		public OsuParser(String fileIn) throws IOException
		{
			System.out.println("osu!.db");
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
			folderCount = byteToInt(r);
			//GetPlayerName, skips rest
			while(in.read() != 11) {}
			int nameLength = in.read();
			byte[] nameByte = new byte[nameLength];
			in.read(nameByte);
			playerName = new String(nameByte, "UTF-8");
			
			in.read(r);
			totalBeatmaps = byteToInt(r);
			
			System.out.println("Version: " + versionNumber + 
					"\nFolderCount: " + folderCount + 
					"\nPlayerName: " + playerName + 
					"\nTotalBeatmaps: " + totalBeatmaps);
			
			beatmaps = new HashMap<String, Beatmap>(totalBeatmaps);

			for (int i = 0; i < totalBeatmaps; i++) {
				in.read(r);
				int beatmapSize = byteToInt(r);
				byte[] b = new byte[beatmapSize];
				in.read(b);
				Beatmap bmap = new Beatmap();
				@SuppressWarnings("unused")
				BeatmapParser bparser = new BeatmapParser(b, bmap);
				beatmaps.put(bmap.getHash(), bmap);
			}
			
			in.read(r);
			int unknown = byteToInt(r);
			if ( unknown != 4) {
				System.out.println("Beatmaps Parsed: " + proccessedTotal);
			}
			if (in.read() == -1) {
				System.out.println("Parsing Complete.");
			}
			in.close();
			return;
		}
		
		public HashMap<String, Beatmap> getHash() {return beatmaps;}
}
