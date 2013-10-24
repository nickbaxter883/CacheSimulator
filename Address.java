
public class Address {

	final static int ADDRESS_SIZE = 32;

	static int offsetBits;
	static int indexBits;
	static int tagBits;
	
	int tag;
	int index;
	int offset;
	
	public Address(int tag, int index, int offset) {
		this.tag = tag;
		this.index = index;
		this.offset = offset;
	}
	
	static void setAddressParameters(int cacheSizeBits, int blockSizeBits) {
		offsetBits = blockSizeBits;
		indexBits = cacheSizeBits - blockSizeBits - CacheSimulation.ASSOCIATIVITY;
		tagBits = ADDRESS_SIZE - indexBits - offsetBits;
	}
	
	static Address parseAddress(String representation) {
		int number = Integer.decode(representation);
		int tag = (number >>> offsetBits) >>> indexBits;
		int index = (number >>> offsetBits) % (int)Math.pow(2,indexBits);
		int offset = number % (int)Math.pow(2,offsetBits);
		
		return new Address(tag, index, offset);
	}
}
