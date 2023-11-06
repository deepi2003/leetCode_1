import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {
    BinaryNode root;

    int height = 0;
    BinaryTree() {
        root = null;
    }

    // Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {
           currentNode = new BinaryNode();
            currentNode.value = value;
            return currentNode;
        }
        else if(currentNode.value <= value ){
             currentNode.right = insert(currentNode.right, value);
            return currentNode;
        } else {
           currentNode.left =  insert(currentNode.left, value);
            return currentNode;
        }
    }

    public void insert(int value) {
        if(root == null){
            root = new BinaryNode();
            root.value = value;
            return;
        }
        insert(root, value);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryNode parentNode) {
        if(parentNode == null){
            return;
        }
        inOrder(parentNode.left);
        System.out.println(" " + parentNode.value);
        inOrder(parentNode.right);

    }

    public void levelOrder(BinaryNode root) {
        if(root == null)
            return;
        Queue<BinaryNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            BinaryNode currentNode = nodes.remove();
            System.out.println(" " + currentNode.value);
            if(currentNode.left !=null){
                nodes.add(currentNode.left);
            }if(currentNode.right != null)
                nodes.add(currentNode.right);
        }
    }

    public int findHeight(BinaryNode root) {
        if(root == null)
            return 0;
        int height = 1;
        if(root.right != null || root.left!= null) {
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            if(leftHeight > rightHeight)
                height +=leftHeight;
            else
                height+=rightHeight;
        }
        return height;
    }


    public BinaryNode findMinimum(BinaryNode root){
        if(root == null){
            return null;
        }
        if(root.left != null){
            return findMinimum(root.left);
        }else {
//            System.out.println("Minimum Value = " + root.value);
            return root;
        }
    }

    public BinaryNode deleteNode(BinaryNode root, int value) {
        if(root == null){
            System.out.println(" Deleted Node not found");
            return null;
        }
        if(value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if( value > root.value){
            root.right = deleteNode(root.right, value);
        }
        else {
            if(root.left != null && root.right !=null) {
               root.value = findMinimum(root.right).value;
               root.right = deleteNode(root.right, root.value);
            } else if(root.left !=null) {
                root = root.left;
            }
            else if(root.right !=null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;

    }
}
