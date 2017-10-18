package es4.tree;

import java.util.Iterator;

/**
 * Created by affo on 18/10/17.
 */
public interface TreeExplorationStrategy<T> {
    Iterator<T> getExplorationStrategy(Tree<T> tree);
}
