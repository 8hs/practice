package net.weever;

import java.util.*;

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

	public void func() {
		Queue<Integer> queue = new PriorityQueue<>(10, new CustomComparator());
		Stack<String> stack = new Stack<>();
		stack.push("");
		stack.push("");
		boolean isEmpty = stack.empty();
	}
}

class CustomComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}
}
