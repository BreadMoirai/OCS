package mansfew.collections;

import java.util.Comparator;

public class BeatmapComparator implements Comparator<Beatmap> {
	
	private String field;
	
	public BeatmapComparator() {field = "song";}
	public BeatmapComparator(String s) {field = s;}
	
	@Override
	public int compare(Beatmap arg0, Beatmap arg1) {
		if (field.equals("song")) {
			return arg0.getSong().compareTo(arg1.getSong());
		}
		else if (field.equals("artist")) {
			return arg0.getArtist().compareTo(arg1.getArtist());
		}
		else if (field.equals("setid")) {
			return arg0.getSetID() - arg1.getSetID();
		}
		else if (field.equals("-song")) {
			return arg1.getSong().compareTo(arg0 .getSong());
		}
		else if (field.equals("-artist")) {
			return arg1.getArtist().compareTo(arg0.getArtist());
		}
		else if (field.equals("-setid")) {
			return arg1.getSetID() - arg0.getSetID();
		}
		return 0;
	}

}
