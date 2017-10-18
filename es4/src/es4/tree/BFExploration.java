package es4.tree;

import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 */
public class BFExploration<T> implements TreeExplorationStrategy<T> {
    @Override
    public Iterator<T> getExplorationStrategy(Tree<T> tree) {
        return new BFTreeIterator<>(tree);
    }
}
