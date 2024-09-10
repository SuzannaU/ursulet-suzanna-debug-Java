
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {	
	public static void main(String args[]){
		try{
			int headCount = 0;
			int rashCount = 0;
			int pupilCount = 0;

			BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
			String line = null;
			line = reader.readLine();

			while (line != null) {
				if (line.equals("headache")) {
					headCount++;
				}
				else if (line.equals("rash")) {
					rashCount++;
				}
				else if (line.contains("pupils")) {
					pupilCount++;
				}
				line = reader.readLine();
			}
			reader.close();
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("altered pupils (dialated or constricted): " + pupilCount + "\n");
			writer.close();
		} catch (IOException e){
			System.out.println("File not accessible");
		}
	}
}
