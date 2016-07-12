package report02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class ListPerformanceTest {
	private static int COUNT = 100000;

	@Test
	public void testArrayList() {
		System.out.println("-----------testArrayList start-----------");
		testList(new ArrayList<Object>());
		System.out.println("-----------testArrayList  end -----------");
	}

	@Test
	public void testLinkedList() {
		System.out.println("-----------testLinkedList start-----------");
		testList(new LinkedList<Object>());
		System.out.println("-----------testLinkedList  end -----------");
	}

	private void testList(List<Object> list) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.add(String.valueOf(i));
		}
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("list.add totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.get(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.get totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.indexOf(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.indexOf totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.contains(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.contains totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.set(i, String.valueOf(COUNT - i - 1));
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.set totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			list.remove(COUNT - i - 1);
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.remove totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		ListIterator<Object> iterator = list.listIterator();
		for (int i = 0; i < COUNT; i++) {
			iterator.add(String.valueOf(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.listIterator.add totalTime: %d", endTime - startTime));

		startTime = System.currentTimeMillis();
		iterator = list.listIterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		endTime = System.currentTimeMillis();
		System.out.println(String.format("list.listIterator.next totalTime: %d", endTime - startTime));
	}

}
