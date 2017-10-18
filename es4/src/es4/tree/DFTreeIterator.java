package es4.tree;

import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 *
 * Depth-first implementation
 */
public class DFTreeIterator<T> implements Iterator<T> {
    private final Tree<T> tree;
    private T element;
    private Iterator<T> left;
    private Iterator<T> right;

    public DFTreeIterator(Tree<T> tree) {
        this.tree = tree;
        this.element = tree.element;
        if (!tree.isLeaf()) {
            left = tree.left.iterator();
            right = tree.right.iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return (element != null) || !tree.isLeaf() && (left.hasNext() || right.hasNext());
    }

    @Override
    public T next() {
        // visit root
        if (element != null) {
            T tempRef = element;
            element = null;
            return tempRef;
        }

        if (left.hasNext()) {
            return left.next();
        }

        return right.next();
    }
}
