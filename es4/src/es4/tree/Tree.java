package es4.tree;

import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 */
public final class Tree<T> implements Iterable<T> {
    public final T element;
    public final Tree<T> left, right;
    private TreeExplorationStrategy<T> explorationStrategy;

    public Tree(T element) {
        this(element, null, null);
    }

    public Tree(T element, Tree<T> left, Tree<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.explorationStrategy = new DFExploration<>();
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void setExplorationStrategy(TreeExplorationStrategy<T> explorationStrategy) {
        this.explorationStrategy = explorationStrategy;
    }

    @Override
    public String toString() {
        if (isLeaf()) {
            return element.toString();
        }

        return element + " -> " + "[" + left + ", " + right + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return explorationStrategy.getExplorationStrategy(this);
    }
}
