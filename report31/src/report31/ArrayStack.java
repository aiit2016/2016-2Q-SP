package report31;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
	
    /**
     * The array in which the elements of the stack are stored.
     */
    transient Object[] elements;

    /**
     * The index of the element at the head of the stack.
     */
    transient int head;

    /**
     * The minimum capacity that we'll use for a newly created stack.
     */
    private static final int MIN_INITIAL_CAPACITY = 8;

    // ******  Array allocation and resizing utilities ******

    /**
     * Allocates empty array to hold the given number of elements.
     *
     * @param capacity  the number of elements to hold
     */
    private void allocateElements(int capacity) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (capacity >= initialCapacity) {
            initialCapacity = capacity;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        elements = new Object[initialCapacity];
    }

    /**
     * Doubles the capacity of this stack.  Call only when full.
     */
    private void doubleCapacity() {
        int n = elements.length;
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, stack too big");
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, 0, a, 0, head);
        elements = a;
    }

    // ******  Constructors ******

    /**
     * Constructs an empty array stack with an initial capacity
     * sufficient to hold 16 elements.
     */
    public ArrayStack() {
        elements = new Object[16];
    }

    /**
     * Constructs an empty array stack with an initial capacity
     * sufficient to hold the specified number of elements.
     *
     * @param capacity  lower bound on initial capacity of the stack
     */
    public ArrayStack(int capacity) {
        allocateElements(capacity);
    }

    // ******  Stack methods ******

    /**
     * {@inheritDoc}
     */
	@Override
	public int size() {
		return head;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public E push(E item) {
        if (item == null)
            throw new NullPointerException();
        elements[head] = item;
        head++;
        if (head == elements.length)
        	doubleCapacity();
		return item;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public E pop() {
		if (head == 0)
			throw new NoSuchElementException();
		@SuppressWarnings({ "unchecked" })
		E item = (E) elements[head - 1];
		head--;
		return item;
	}

    /**
     * {@inheritDoc}
     */
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		if (head == 0)
			return null;
		return (E) elements[head - 1];
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean isEmpty() {
		return head == 0;
	}

}
