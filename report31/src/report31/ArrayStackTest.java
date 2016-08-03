package report31;

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
		Stack<StackItem> stack = new ArrayStack<StackItem>();
		Assert.assertEquals(0, stack.size());
		Assert.assertTrue(stack.isEmpty());

		StackItem item1 = new StackItem();
		item1.setItemOne(1);
		item1.setItemTwo(1.0);
		item1.setItemThree("1.0");
		stack.push(item1);
		Assert.assertEquals(1, stack.size());;

		StackItem item2 = new StackItem();
		item2.setItemOne(2);
		item2.setItemTwo(1.0);
		item2.setItemThree("1.0");
		stack.push(item2);
		Assert.assertEquals(2, stack.size());;

		StackItem item2b = stack.peek();
		Assert.assertEquals(2, stack.size());;
		Assert.assertEquals(item2b, item2);;

		StackItem item2c = stack.pop();
		Assert.assertEquals(1, stack.size());;
		Assert.assertEquals(item2c, item2);;

		StackItem item2d = new StackItem();
		item2d.setItemOne(2);
		item2d.setItemTwo(1.0);
		item2d.setItemThree("1.0");
		Assert.assertEquals(item2d, item2);;
		Assert.assertNotEquals(item2d, item1);;
	}

}
