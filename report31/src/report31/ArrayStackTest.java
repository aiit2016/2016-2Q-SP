package report31;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {

	@Test
	public void testArrayStack() {
		Assert.assertNotNull(new ArrayStack<Object>());
		Assert.assertNotNull(new ArrayStack<Object>(128));
	}

	@Test
	public void testStackMethods() {
		Stack<Object4Jcf> stack = new ArrayStack<Object4Jcf>();
		Assert.assertEquals(0, stack.size());
		Assert.assertTrue(stack.isEmpty());

		Object4Jcf item1 = new Object4Jcf();
		item1.setItemOne(1);
		item1.setItemTwo(1.0);
		item1.setItemThree("1.0");
		stack.push(item1);
		Assert.assertEquals(1, stack.size());;

		Object4Jcf item2 = new Object4Jcf();
		item2.setItemOne(2);
		item2.setItemTwo(1.0);
		item2.setItemThree("1.0");
		stack.push(item2);
		Assert.assertEquals(2, stack.size());;

		Object4Jcf item2b = stack.peek();
		Assert.assertEquals(2, stack.size());;
		Assert.assertEquals(item2b, item2);;

		Object4Jcf item2c = stack.pop();
		Assert.assertEquals(1, stack.size());;
		Assert.assertEquals(item2c, item2);;
	}

	@Test
	public void testObject4Jcf() {
		Object4Jcf item1 = new Object4Jcf();
		item1.setItemOne(1);
		item1.setItemTwo(1.0);
		item1.setItemThree("1.0");

		Object4Jcf item2 = new Object4Jcf();
		item2.setItemOne(2);
		item2.setItemTwo(1.0);
		item2.setItemThree("1.0");

		Object4Jcf item3 = new Object4Jcf();
		item3.setItemOne(2);
		item3.setItemTwo(1.0);
		item3.setItemThree("1.0");

		Assert.assertNotEquals(item3, item1);;
		Assert.assertEquals(item3, item2);;

		Map<Object4Jcf, String> map = new HashMap<Object4Jcf, String>();
		map.put(item1, item1.toString());
		map.put(item2, item2.toString());
		map.get(item3);
		Assert.assertTrue(map.containsKey(item3));;
		Assert.assertNotEquals(map.get(item3), map.get(item1));;
		Assert.assertEquals(map.get(item3), map.get(item2));;
	}

}
