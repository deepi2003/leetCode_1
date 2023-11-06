import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {
    static Map<Integer, List<Integer>> provinceMapping = new HashMap();
    public static int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        for(int row = 0; row < size; row++) {
            provinceMapping.put(row, new ArrayList<>());
            for(int col = 0; col < size; col++) {
                if(row !=col && isConnected[row][col] ==1 && isConnected[col][row] ==1) {
                    provinceMapping.get(row).add(col);
                }
            }
        }
        Map<Integer, List<Integer>> provinceMappingCopy = new HashMap();
        provinceMappingCopy.putAll(provinceMapping);
        for(Integer node: provinceMappingCopy.keySet()) {
            removeDuplicateProvince(node);
        }
        return provinceMapping.size();
    }

    private static void removeDuplicateProvince(Integer node) {
        List<Integer> directEdges = provinceMapping.get(node);
        if(directEdges != null) {
            for(Integer edge: directEdges) {
                provinceMapping.remove(edge);
            }
        }
    }

    public boolean isValidBST(TreeNode root) {
        return checkValidity(root, -100000000, 1000000);
    }


    private boolean checkValidity(TreeNode node, int minVal, int maxValue) {
        if(node == null)
//            Long.M
            return true;
        boolean left= checkValidity(node.left, minVal, node.val-1);
        boolean right = checkValidity(node.right, node.val+1,maxValue);
        if(left && right &&  validLeft(node, minVal) && validRight(node, maxValue))
            return true;
        return false;
    }

    private boolean validLeft(TreeNode node,int minVal) {
        return (node.left == null) || (node.left.val > minVal);
    }

    private boolean validRight(TreeNode node, int maxVal) {
        return node.right == null || (node.right.val < maxVal);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
