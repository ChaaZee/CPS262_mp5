package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class sort_2dArray {

	public static void main(String[] args) {
		int[][] intArr = {{34,89},{56,3},{27,61},{45,8},{45,89}};
		
		Stream.of(intArr).flatMapToInt(e -> IntStream.of(e)).sorted().forEach(e -> System.out.print(e + " "));
	}

}
