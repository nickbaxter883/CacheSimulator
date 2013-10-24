import java.io.BufferedReader;

public class CacheSimulation {
	
	final static int ASSOCIATIVITY = 0;
	int sizeBits;
	
	BufferedReader reader;
	
	public CacheSimulation (int cacheSizeBits, int blockSizeBits,
			boolean tracing, BufferedReader reader) {
		
		sizeBits = cacheSizeBits;
		
	}
	
	void step() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (Exception e) {
			
		}
		
		Address address = Address.parseAddress(line);
	}
}
