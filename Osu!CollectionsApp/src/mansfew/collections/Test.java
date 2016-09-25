package mansfew.collections;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Beatmap> BeatmapData = (new OsuParser2("src/resources/osu!.db")).getBeatmaps();
	}

}
