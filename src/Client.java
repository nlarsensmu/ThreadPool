import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Client
{
    public static void main(String[] args) throws InterruptedException {
    	
    	if (args.length != 2) {
    		return;
    	}
    	
    	int numThreads;
    	// Get the number of threads requested from args[0]
    	try {
    		numThreads = Integer.parseInt(args[0]);
    	} catch (NumberFormatException e) {
    		e.printStackTrace();
    		return;
    	}
    	
    	String fileName = args[1];
    	
//    	System.out.println(fileName);
    	
        ThreadPool pool = new ThreadPool(numThreads);
    	
    	BufferedReader reader;
    	try {
    		reader = new BufferedReader(new FileReader(fileName));
    		
    		String line = reader.readLine();
    		while(line != null) {
    			
    			String[] tokens = line.split(" ");
    			
    			switch(tokens[0]) {
    			case "Task":
    				// Get the ints and type check
    				int a, b;
    				try {
    					a = Integer.parseInt(tokens[1]);
    					b = Integer.parseInt(tokens[2]);
    				} catch (NumberFormatException e) {
    					System.err.println(line + " had bad number format");
    					break;
    				}
    				pool.add(new Task(a, b));
    				break;
    			default:
    				break;
    			}
    			
    			line = reader.readLine();
    		}
    		reader.close();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
        
        Thread.sleep(100);

        pool.shutdown();
    }
}
