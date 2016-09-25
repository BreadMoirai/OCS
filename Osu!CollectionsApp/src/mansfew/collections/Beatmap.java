package mansfew.collections;

import java.util.LinkedList;

public class Beatmap {
	private String song, artist, mapper, difficulty, 
					hash, filename, foldername, source, tags;
	private int mapID, setID;
	private byte mode, rankedStatus;
	private boolean inCollection;
	
	public Beatmap() {
		inCollection = false;
	}
	
	@Override
	public String toString() {
		return "Beatmap [song=" + song + ", artist=" + artist + ", mapper=" + mapper + ", difficulty=" + difficulty
				+ ", hash=" + hash + ", filename=" + filename + ", foldername=" + foldername + ", source=" + source
				+ ", tags=" + tags + ", mapID=" + mapID + ", setID=" + setID + ", mode=" + mode + ", rankedStatus="
				+ rankedStatus + "]";
	}

	public String getMapper() {
		return mapper;
	}

	public void setMapper(String mapper) {
		this.mapper = mapper;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getFoldername() {
		return foldername;
	}

	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public int getMapID() {
		return mapID;
	}

	public void setMapID(int mapID) {
		this.mapID = mapID;
	}

	public int getSetID() {
		return setID;
	}

	public void setSetID(int setID) {
		this.setID = setID;
	}

	public String getRankedStatus() {
		switch(this.rankedStatus) {
			case (0x02): return "Pending/Graveyard";
			case (0x04): return "Ranked";
			case (0x05): return "Approved";
			default: return "Not Submitted";
		}
	}

	public void setRankedStatus(byte rankedStatus) {
		this.rankedStatus = rankedStatus;
	}

	public String getMode() {
		switch(this.mode) {
		case (0x00): return "Standard";
		case (0x01): return "Taiko";
		case (0x02): return "Catch the Beat";
		case (0x03): return "Mania";
		default: return "Unknown";
		}
	}

	public void setMode(byte mode) {
		this.mode = mode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public boolean isInCollection() {
		return inCollection;
	}

	public void setInCollection(boolean inCollection) {
		this.inCollection = inCollection;
	}

	
}
