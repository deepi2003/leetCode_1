import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTreeTest {

    @Test
    void testTree() {
        HeapTree tree =new HeapTree();
        tree.insertNode(10);
        tree.insertNode(30);
        tree.insertNode(50);
        tree.insertNode(60);
        tree.insertNode(40);
        tree.insertNode(5);
        tree.insertNode(1);

        tree.printTree();

        tree.deleteNode(30);
        tree.printTree();
    }

}