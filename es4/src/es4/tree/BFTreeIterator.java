package es4.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by affo on 18/10/17.
 *
 * Breadth-first implementation
 */
public class BFTreeIterator<T> implements Iterator<T> {
    private List<Tree<T>> toExplore = new ArrayList<>();
    private List<T> nextElements = new ArrayList<>();

    public BFTreeIterator(Tree<T> tree) {
        toExplore.add(tree);
        nextElements.add(tree.element);
    }

    @Override
    public boolean hasNext() {
        if (nextElements.isEmpty()) {
            // dobbiamo ripopolare le strutture dati
            List<Tree<T>> tempExplore = new ArrayList<>();
            for (Tree<T> t : toExplore) {
                if (!t.isLeaf()) {
                    tempExplore.add(t.left);
                    tempExplore.add(t.right);
                    nextElements.add(t.left.element);
                    nextElements.add(t.right.element);
                }
            }
            toExplore = tempExplore;
        }

        return !toExplore.isEmpty();
    }

    @Override
    public T next() {
        return nextElements.remove(0);
    }
}
