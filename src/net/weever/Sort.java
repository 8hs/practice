package net.weever;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"Color","Apple","Boy"};
		List<String> list = Arrays.asList(a);
		Collections.sort(list);
		System.out.println(list);
	}

}
