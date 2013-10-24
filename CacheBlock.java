
public class CacheBlock {

	/*
	private static int tagBits;
	private static int dataBits;
	
	public static void initCacheBlockParameters(int tagBits, int dataBits) {
		CacheBlock.tagBits = tagBits;
		CacheBlock.dataBits = dataBits;
	}
	*/
	
	private int tagValue;
	private int data;
	private boolean valid;
	
	public CacheBlock(int tagValue) {
		this(tagValue, 0, true);
	}
	
	public CacheBlock(int tagValue, int data, boolean valid) {
		this.tagValue = tagValue;
		this.data = data;
		this.valid = valid;
	}
	
	public int getTagValue() {
		return tagValue;
	}
}
