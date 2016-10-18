package session6.assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Uniquecharacters {
	HashMap<String, List<Character>> uniqueString;
	List<Character> uniqueCharacter;

	/**
	 * Constructor that initialises member variables
	 */
	Uniquecharacters() {
		uniqueString = new HashMap<String, List<Character>>();
		uniqueCharacter = new ArrayList<Character>();
	}

	/**
	 * Following function adds the String in the HashMap.
	 * @param word(String) is a string that has to be added in the HashMap
	 * @return true/false depending on whether string added or not.
	 */
	public boolean addString(String word) {
		word = word.toLowerCase();
		if (uniqueString.containsKey(word)) {
			return false;
		}

		uniqueCharacter = new ArrayList<Character>();
		for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
			char ch = word.charAt(wordIndex);
			if (!uniqueCharacter.contains(ch) && ch != ' ') {
				uniqueCharacter.add(ch);
			}
		}
		uniqueString.put(word, uniqueCharacter);
		return true;
	}

	/**
	 * Following function displays the string and their no. of Unique Characters
	 */
	public void display() {
		@SuppressWarnings("rawtypes")
		Set keys = uniqueString.keySet();
		@SuppressWarnings("rawtypes")
		Iterator itr = keys.iterator();

		String key;
		ArrayList<Character> value;
		while (itr.hasNext()) {
			key = (String) itr.next();
			value = (ArrayList<Character>) uniqueString.get(key);
			int noOfCharacter = value.size();
			System.out.println(key + "\t-" + noOfCharacter);
		}
	}
}
