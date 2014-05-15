package net.weever;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = {"Color","Apple","Boy"};
		List<String> list = Arrays.asList(a);
		Collections.sort(list);
		System.out.println(list);
		Iterator<String> t = list.iterator();
		while(t.hasNext()){
			System.out.println(t.next());
		}
		ListIterator<String> lt = list.listIterator();
		while(lt.hasNext()){
			lt.set(lt.next()+"#");
		}
		while(lt.hasPrevious()){
			System.out.println(lt.previous());
		}
	}

}
