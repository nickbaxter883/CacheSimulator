import java.util.Random;

public class CacheSet {

	private CacheBlock[] setBlocks;
	private int setSize;
	private Random rand = new Random();
	
	public CacheSet(final int ASSOCIATIVITY) {
		this.setSize = 1 << ASSOCIATIVITY;
		setBlocks = new CacheBlock[setSize];
		for (CacheBlock block : setBlocks) {
			block = new CacheBlock(0);
		}
	}
	
	public boolean contains(CacheBlock other) {
		for (CacheBlock block : setBlocks) {
			if (block.getTagValue() == other.getTagValue()) {
				return true;
			}
		}
		return false;
	}
	
	public int moveIn(CacheBlock block) {
		int index = rand.nextInt() % setBlocks.length;
		setBlocks[index] = block;
		return index;
	}
	
	public CacheBlock first() {
		return setBlocks[0];
	}
}
