import java.util.ArrayList;
import java.util.List;

public class HeapTree {

   List<Integer> tree = new ArrayList<>();
    public HeapTree() {
       tree.add(0000000000);
    }

    private static void accept(Integer e) {
        System.out.println(e + " ");
    }

    public void insertNode(int value) {
        tree.add(value);
        heapifyBottomToTop(value);
    }

    public void deleteNode(int value) {
        int elementIndex = tree.lastIndexOf(value);
        if(elementIndex == -1) {
            System.out.println("value not found " );
            return;
        }
        if(tree.size() > elementIndex*2) {
            int leftChild = tree.get(elementIndex*2);
            int rightChild = tree.get(elementIndex*2 +1);
            if(leftChild < rightChild) {
                tree.set(elementIndex, leftChild);
                adjustElements(elementIndex * 2);
            } else {
                tree.set(elementIndex, rightChild);
                adjustElements(elementIndex*2 +1);
            }
        }
    }

    private void adjustElements(int adjustmentIndex) {
        for (int i = adjustmentIndex; i < tree.size() - 1; i++) {
            tree.set(i, tree.get(i + 1));
        }
        tree.remove(tree.size() - 1);
    }

    private void heapifyBottomToTop(int value) {
        int elementIndex = tree.indexOf(value);
        int parentIndex =  elementIndex/2;
        while(value < tree.get(parentIndex)) {
            int temp = tree.get(elementIndex);
            int parent = tree.get(parentIndex);
            tree.set(parentIndex, temp);
            tree.set(elementIndex, parent);
            elementIndex = parentIndex;
            parentIndex = elementIndex/2;
        }
    }

    private void heapifyTopToBottom(int index) {
        int leftIndex = index*2;
        int rightIndex = index*2 +1;
        if(tree.size() < leftIndex)
            return;


    }

    public void printTree(){
        tree.forEach(HeapTree::accept);
    }

}
