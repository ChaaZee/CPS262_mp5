package streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ScrabbleScoreStats {
	
	public static Integer scrabbleValue(String word, Map<Character, Integer> values) {
		int totalVal = 0;
		
		for(int i = 0; i < word.length(); i++) {
			totalVal += values.get(word.charAt(i));
		}
		
		return totalVal;
	}

	public static void main(String[] args) {
		Map<Character, Integer> letterValues = new HashMap<Character, Integer>();
		letterValues.put('a', 1);
		letterValues.put('b', 3);
		letterValues.put('c', 3);
		letterValues.put('d', 2);
		letterValues.put('e', 1);
		letterValues.put('f', 4);
		letterValues.put('g', 2);
		letterValues.put('h', 4);
		letterValues.put('i', 1);
		letterValues.put('j', 8);
		letterValues.put('k', 5);
		letterValues.put('l', 1);
		letterValues.put('m', 3);
		letterValues.put('n', 1);
		letterValues.put('o', 1);
		letterValues.put('p', 3);
		letterValues.put('q', 10);
		letterValues.put('r', 1);
		letterValues.put('s', 1);
		letterValues.put('t', 1);
		letterValues.put('u', 1);
		letterValues.put('v', 8);
		letterValues.put('w', 4);
		letterValues.put('x', 8);
		letterValues.put('y', 4);
		letterValues.put('z', 10);
		
		Map<Integer, String> wordValues = new TreeMap<Integer, String>(Collections.reverseOrder());
		wordValues.put(scrabbleValue("java", letterValues), "java");
		wordValues.put(scrabbleValue("program", letterValues), "program");
		wordValues.put(scrabbleValue("list", letterValues), "list");
		wordValues.put(scrabbleValue("string", letterValues), "string");
		wordValues.put(scrabbleValue("unix", letterValues), "unix");
		wordValues.put(scrabbleValue("hours", letterValues), "hours");
		wordValues.put(scrabbleValue("syntax", letterValues), "syntax");
		wordValues.put(scrabbleValue("error", letterValues), "error");
		
		Set<Integer> keys = wordValues.keySet();
		Iterator<Integer> iter = keys.iterator();
		
		System.out.println("Top Three Words are: ");
		wordValues.keySet().stream().limit(3).forEach(e -> System.out.println(wordValues.get(e) + ": " + e));
		System.out.println();
		
		iter = keys.iterator();
		int[] keysArr = new int[keys.size()];
		int i = 0;
		
		while(iter.hasNext()) {
			int num = iter.next();
			keysArr[i] = num;
			i++;
		}
		
		IntSummaryStatistics stats = IntStream.of(keysArr).summaryStatistics();
		System.out.println("Average Scrabble Value: " + stats.getAverage());
		
		System.out.print("Words Above Average: ");
		IntStream.of(keysArr).filter(e -> e > stats.getAverage()).forEach(e -> System.out.print(wordValues.get(e) + " "));
		System.out.println();
		
		System.out.print("Words Below Average: ");
		IntStream.of(keysArr).filter(e -> e < stats.getAverage()).forEach(e -> System.out.print(wordValues.get(e) + " "));
	}

}
