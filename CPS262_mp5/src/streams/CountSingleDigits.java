package streams;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSingleDigits {

	public static void main(String[] args) {
		int[] intArr = new int[100];
		
		for(int i = 0; i < intArr.length; i++) {
			int randNum = (int)(Math.random()*10);
			intArr[i] = randNum;
		} 
		
		IntStream.of(intArr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting())).forEach((k, v) -> System.out.println(k + ": " + v));
	}

}
