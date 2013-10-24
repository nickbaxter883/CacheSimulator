import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CacheSimulation {
	
	private final int ASSOCIATIVITY = 0;
	private int cacheSizeNumBits;
	private int blockSizeNumBits;
	private int indexNumBits;
	private int numSets;
	
	private CacheSet[] cache;
	private CacheManager manager;
	private BufferedReader reader;
	
	public CacheSimulation (int cacheSizeNumBits, int blockSizeNumBits,
			boolean tracing, FileReader reader) {
		
		this.cacheSizeNumBits = cacheSizeNumBits;
		this.blockSizeNumBits = blockSizeNumBits;
		this.indexNumBits = cacheSizeNumBits - blockSizeNumBits - ASSOCIATIVITY;
		this.numSets = (int)Math.pow(2, indexNumBits);
		
		cache = new CacheSet[numSets];
		for (CacheSet set : cache) {
			set = new CacheSet(ASSOCIATIVITY);
		}
		
		Address.initAddressParameters(indexNumBits, blockSizeNumBits);
		this.reader = new BufferedReader(reader);
		manager = new CacheManager(cache, tracing);
	}
	
	void begin() {
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();
		
				Address address = new Address(line);
				manager.update(address);
			}
		} catch (IOException e) {
			System.err.println("Something went wrong while reading the file");
		}
	}
}
