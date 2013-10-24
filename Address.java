
public class Address {

	private static final int ADDRESS_NUM_BITS = 32;
	private static int tagNumBits;
	private static int indexNumBits;
	private static int offsetNumBits;

	static void initAddressParameters(int indexNumBits, int blockSizeNumBits) {
		Address.indexNumBits = indexNumBits;
		Address.offsetNumBits = blockSizeNumBits;
		Address.tagNumBits = ADDRESS_NUM_BITS - indexNumBits - offsetNumBits;
	}
	
	private int addressValue;
	private int tagValue;
	private int indexValue;
	private int offsetValue;
	
	public Address(String representation) {
		this(Integer.decode(representation));
	}
	
	public Address(int decimalAddress) {
		this.addressValue = decimalAddress;
		this.tagValue = (decimalAddress >>> offsetNumBits) >>> indexNumBits;
		this.indexValue = (decimalAddress >>> offsetNumBits) % (int)Math.pow(2,indexNumBits);
		this.offsetValue = decimalAddress % (int)Math.pow(2,offsetNumBits);
	}
	
	public int getAddressValue() {
		return addressValue;
	}
	
	public int getTagValue() {
		return tagValue;
	}
	
	public int getIndexValue() {
		return indexValue;
	}
}
