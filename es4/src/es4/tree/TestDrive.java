package es4.tree;

/**
 * Created by affo on 18/10/17.
 */
public class TestDrive {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(
                0,
                new Tree<>(
                        10,
                        new Tree<>(20),
                        new Tree<>(21)
                ),
                new Tree<>(
                        11,
                        new Tree<>(22),
                        new Tree<>(23)
                )
        );

        System.out.println(tree);

        for (Integer element : tree) {
            System.out.println(element + " ");
        }
        System.out.println();

        tree.setExplorationStrategy(new BFExploration<>());

        for (Integer element : tree) {
            System.out.println(element + " ");
        }
        System.out.println();
    }
}
