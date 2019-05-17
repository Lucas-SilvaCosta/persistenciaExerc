import java.io.File;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.lang.IllegalStateException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class CreateTextFile{
	private Formatter output;
	private Scanner input;
	private ArrayList<String> oldString;

	public void openFile(){
		System.out.println("I work");
		try{
			File savedTexts = new File("savedTexts.txt");
			System.out.println("savedTexts.exists(): "+savedTexts.exists())
			if(savedTexts.exists()){
				input = new Scanner(savedTexts);
				for(int i=0; input.hasNext(); i++){
					oldString.add(input.next());
					System.out.println("input added to oldString: "+oldString.get(i));
				}
				oldString.trimToSize();
			}
			output = new Formatter("savedTexts.txt");
		}catch(SecurityException securityException){
			System.err.println("You do not have write access to this file." );
            System.exit( 1 );
		}catch(FileNotFoundException fileNotFoundException){
			System.err.println( "Error opening or creating file." );
            System.exit( 1 );
		}
	}

	public void addTexts(String textToBeAdded){
		System.out.println("I work 2");
		try{
			if(oldString != null){
				System.out.println("\noldoString != null")
				Iterator<String> it = oldString.Iterator();
				while(it.hasNext()){
					output.format("%s\n", it.next());
					System.out.println("added again to .txt: "+it.next());
				}
			}
			output.format("%s\n", textToBeAdded);	
		}catch(FormatterClosedException formatterClosedException){
			System.err.println( "Error writing to file." );
        	System.exit( 1 );
		}catch(NoSuchElementException noSuchElementException){
			System.err.println( "Invalid input. Please try again." );
        	System.exit( 1 );
		}catch( IllegalStateException stateException ){
        	System.err.println( "Error reading from file." );
        	System.exit( 1 );
    	}
	}

	public void closeFile(){
		System.out.println("I work 3");
        if ( output != null ){	output.close();	}
    }
}