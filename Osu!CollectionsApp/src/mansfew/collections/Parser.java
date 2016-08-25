package mansfew.collections;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Parser {
	
	protected static int byteToInt(byte[] r) {
		ByteBuffer wrapped = ByteBuffer.wrap(r);
		wrapped.order(ByteOrder.LITTLE_ENDIAN);
		return wrapped.getInt();
	}
	

}
