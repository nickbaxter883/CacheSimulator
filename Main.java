import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {
		
		int cacheSizeNumBits = 0;
		int blockSizeNumBits = 0;
		String tracingOption = "";
		boolean tracing = false;
		String file = "";
		FileReader reader = null;
		
		if (args.length != 4) {
			System.err.println("Usage: <num bits for cache size> " +
				"<num bits for block size> <tracing> <file>");
			System.exit(0);
		}
		
		try {
			cacheSizeNumBits = Integer.parseInt(args[0]);
			blockSizeNumBits = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.println("Argument format error");
			System.exit(0);
		}
		
		if (cacheSizeNumBits <= 0 || blockSizeNumBits <= 0 || cacheSizeNumBits < blockSizeNumBits) {
			System.err.println("Invalid size parameter");
			System.exit(0);
		}
		
		tracingOption = args[2];
		if (tracingOption.equals("on")) {
			tracing = true;
		}
		else if (tracingOption.equals("off")) {
			tracing = false;
		}
		else {
			System.err.println("Tracing must be \"on\" or \"off\"");
			System.exit(0);
		}
		
		file = args[3];
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.err.println("File " + file + " does not exist");
			System.exit(0);
		}
		
		CacheSimulation simulator = new CacheSimulation(cacheSizeNumBits, blockSizeNumBits, tracing, reader);
		simulator.begin();
		
		System.out.println("Nicholas Barnes");
		System.out.println(String.format("%d %d %s %s",
				cacheSizeNumBits, blockSizeNumBits, tracingOption, file));
		simulator.printStats();
	}
}
