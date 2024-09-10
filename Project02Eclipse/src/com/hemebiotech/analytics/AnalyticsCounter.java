
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// duplicate with headCount below, keep only 1 of the two
	private static int rashCount = 0;		// those 3 variables should be declared inside the main method
	private static int pupilCount = 0;
	
	public static void main(String args[]) throws Exception {		//exception not handled, add try/catch 
		
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();	//initialize *line* to null before readLine

		int i = 0;	// set i to 0 ->useless, delete comment
		int headCount = 0;													//duplicates with *headacheCount* , keep only this variable
		//add declarations for rashCount and pupilCount
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);				//useless except for dev purposes -> use loggers instead
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);	//useless except for dev purposes -> use loggers instead
			}
			else if (line.equals("rush")) { //*rash* is misspelled
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}
			line = reader.readLine();
		}

		//reader.close(); -> to add
		
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");		//wrong variable used, *headacheCount* is not incremented, *headCount* is
		writer.write("rash: " + rashCount + "\n");				//*rashCount* is not incremented because of the misspell line 26 */
		writer.write("dialated pupils: " + pupilCount + "\n"); 	//counts both dialated pupils and constricted pupils -> separate symptoms
		writer.close();
	}
}
