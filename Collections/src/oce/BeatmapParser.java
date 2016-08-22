package oce;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BeatmapParser extends Parser {
	
	private int itr;
	
	public BeatmapParser(byte[] b, Beatmap bmap) {
		initialize(b, bmap);
	}
	
	private void initialize(byte[] b, Beatmap bmap) {
		itr = 0;
		bmap.setArtist(getNextString(b));
		skipString(b);
		bmap.setSong(getNextString(b));
		skipString(b);
		bmap.setMapper(getNextString(b));
		bmap.setDifficulty(getNextString(b));
		skipString(b);
		bmap.setHash(getNextString(b));
		bmap.setFilename(getNextString(b));
		bmap.setRankedStatus(b[itr++]);
		
		//skips extra information not relevant
		itr += 38;
		for (int i = 0; i < 4; i++) {
			int pairs = getNextInt(b);
			//System.out.println(pairs + "pair");
			itr += pairs * 14;
		}
		itr += 12;
		int timings = getNextInt(b);
		//System.out.println(timings);
		itr += timings * 17;
		//System.out.println(bytesToHex(Arrays.copyOfRange(b, itr, itr + 6)));
		bmap.setMapID(getNextInt(b));
		bmap.setSetID(getNextInt(b));
		itr += 14;
		bmap.setMode(b[itr++]);
		bmap.setSource(getNextString(b));
		bmap.setTags(getNextString(b));
		itr += 3;
		skipString(b);
		itr += 10;
		bmap.setFoldername(getNextString(b));
		
		if (bmap.getSetID() < 0) {
		System.out.println("Beatmap Id: " + bmap.getMapID() + 
							"\nBeatmapSET Id: " + bmap.getSetID() +
							"\n" + bmap.getSong() + " by " + bmap.getArtist() + " from " + bmap.getSource() + 
							"\n" + bmap.getDifficulty() + " mapped by " + bmap.getMapper() + 
							"\n" + bmap.getMode() + "[" + bmap.getRankedStatus() + "]" + 
							"\n" + bmap.getFoldername() + "\\" + bmap.getFilename() +
							"\nMD5: " + bmap.getHash() + "\n");
		}
							
							
	}
	
	private int getNextInt(byte[] b) {
		byte[] intbyte = Arrays.copyOfRange(b, itr, (itr += 4));
		//System.out.println(bytesToHex(intbyte));
		return byteToInt(intbyte);
	}
	
	//debugging
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	private String getNextString(byte[] b) {
		if (b[itr] == 0x0b) {
			int sLength = b[++itr] & 0xFF;
			String s = "";
			if (sLength > 0) {
				try {
					s = new String(Arrays.copyOfRange(b, ++itr, (itr += sLength)), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return s;
			}
			else {
				itr++;
				return "N/A";
			}
		}
		else if (b[itr] == 0x00) {
			itr++;
			return "Not Found";
		}
		else return "Error";
	}
	
	private boolean skipString(byte[] b) {
		if (b[itr] == 0x0b) {
			int sLength = b[++itr];
			itr += sLength + 1;
			return true;
		}
		else if (b[itr] == 0x00) {
			itr++;
			return true;
		}
		else {
			return false;
		}
	}
}
