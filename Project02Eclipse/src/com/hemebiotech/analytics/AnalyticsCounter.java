package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * New version of AnalyticsCounter
 * Count symptoms and sort them alphabetically
 */
public class AnalyticsCounter {
	/**
	 *
	 * @param  args - default unused parameter
	 */
	public static void main(String[] args) {

		List<String> symptomList;
		Map<String, Integer> symptomMap;
		// Read symptoms into a list, clean data and convert to lowercase
		SymptomReader reader = new SymptomReader("symptoms.txt");
		symptomList = reader.getSymptoms();
		if (symptomList.isEmpty())
			System.out.println("No symptoms found");
		else {
			// Count symptoms, sort them alphabetically and write to file
			symptomMap = SymptomUtils.countSymptoms(symptomList);
			symptomMap = SymptomUtils.sortSymptoms(symptomMap);
			SymptomWriter writer = new SymptomWriter("result.out");
			writer.putSymptoms(symptomMap);
		}

	}
}
