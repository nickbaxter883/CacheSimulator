
public class CacheManager {

	private boolean tracing;
	private CacheSet[] cache;
	
	private int numHits;
	private int numMisses;
	
	public CacheManager(CacheSet[] cache, boolean tracing) {
		this.cache = cache;
		this.tracing = tracing;
		
		numHits = 0;
		numMisses = 0;
		
		if (tracing) {
			System.out.println("Addr|Tag|Idx|CTag|H/M|NumH|NumM|Acc|MR|");
		}
	}
	
	public void update(Address address) {
		CacheSet set = cache[address.getIndexValue()];
		CacheBlock block = new CacheBlock(address.getTagValue());
		
		String result; 
		if (set.contains(block)) {
			numHits++;
			result = "hit";
		}
		else {
			numMisses++;
			result = "miss";
			set.moveIn(block);
		}
		
		if (tracing) {
			System.out.printf("%s|%s|%s|%s|%s|%i|%i|%i|%d\n",
				Integer.toHexString(address.getAddressValue()),
				Integer.toHexString(address.getTagValue()),
				Integer.toHexString(address.getIndexValue()),
				//Assuming a direct mapped cache, there is only one block per set
				Integer.toHexString(set.first().getTagValue()),
				result,
				numHits,
				numMisses,
				numHits + numMisses,
				getMissRatio()
			);
		}
	}
	
	public double getMissRatio() {
		return (double) numMisses / (numMisses + numHits);
	}
	
	public int getHits() {
		return numHits;
	}
	
	public int getMisses() {
		return numMisses;
	}
}
