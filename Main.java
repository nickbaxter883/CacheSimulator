import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		String s = "5";
		Integer i = 5;
		System.out.println();
		if (args.length != 4) {
			System.err.println("Usage: <num bits for cache size> " +
				"<num bits for block size> <tracing> <file>");
			System.exit(0);
		}
		
		int cacheSizeBits = 0;
		int blockSizeBits = 0;
		try {
			cacheSizeBits = Integer.parseInt(args[0]);
			blockSizeBits = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("Argument format error");
			System.exit(0);
		}
		
		if (cacheSizeBits <= 0 || blockSizeBits <= 0) {
			System.err.println("Invalid parameter");
			System.exit(0);
		}
		
		boolean tracing = false;
		if (args[2].equals("on")) {
			tracing = true;
		}
		else if (args[2].equals("off")) {
			tracing = false;
		}
		else {
			System.err.println("Tracing must be \"on\" or \"off\"");
			System.exit(0);
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(args[3]));
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist");
			System.exit(0);
		}
		
		CacheSimulation simulator = new CacheSimulation(cacheSizeBits, blockSizeBits, tracing, reader);
	}
}
