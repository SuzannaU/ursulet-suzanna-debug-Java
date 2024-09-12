import java.io.IOException;

import Classes.*;
import Exceptions.EmptyListException;

public class AnalyticsCounter {	
	public static void main(String args[]) throws IOException, EmptyListException{
/* 		WriteInFile file = new WriteInFile("empty.txt");
		file.getFormattedList();
		file.writeInFile(); */
		CountSymptoms count = new CountSymptoms("symptoms.txt");
		//count.printRawSymptomsCount();
		System.out.println(count.getRawSymptomsCount().toString());
		ReadSymptomDataFromFile raw = new ReadSymptomDataFromFile("symptoms.txt");
		//raw.printRawSymptomsList();
		System.out.println(raw.getRawSymptomsList().toString());
	}
}
