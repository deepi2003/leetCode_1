public class AVLTree extends BinaryTree{

    public void insertNode(BinaryNode root, int value) {
        if(root == null){
            root = new BinaryNode();
            root.value = value;
            return;
        }
        insert(value);
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(leftHeight - rightHeight > 1) {
            // rotate left
        } else if(rightHeight - leftHeight > 1) {
            // rotate right
        }
    }

    private void rotate() {

    }
}
