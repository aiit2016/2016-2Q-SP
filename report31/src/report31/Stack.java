package report31;


/**
 * The <code>Stack</code> class represents a last-in-first-out
 * (LIFO) stack of objects.
 * <p>
 * When a stack is first created, it contains no items.
 *
 * @author  Koala Cheung
 */
public interface Stack<E> {

    /**
     * Returns the number of elements in this stack.  If this stack
     * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this stack
     */
    int size();

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     */
	public E push(E item);

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack.
     */
    public E pop();

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack.
     */
    public E peek();

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean isEmpty();

}
