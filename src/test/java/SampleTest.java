import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


class SampleTest {

    @Test
    void test() {
        int[][] t = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Sample.findCircleNum(t);
        Sample sample = new Sample();

    }


    @Test
    void testBinarySerachTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(5);
        binaryTree.insert(8);
        binaryTree.insert(15);
        binaryTree.insert(30);
        String test = "423";
        int i = 18;
        StringBuilder temp = new StringBuilder(test);
        int t = temp.charAt(0) * '2';
        test += i % 10;


        System.out.println(t);


//        binaryTree.findMinimum(binaryTree.root);

//        binaryTree.deleteNode(binaryTree.root, 11);


        binaryTree.insert(17);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(2);

        binaryTree.levelOrder(binaryTree.root);

        System.out.println("Height:  " + binaryTree.findHeight(binaryTree.root));

//        binaryTree.deleteNode(binaryTree.root, 3);

//        System.out.println("After deletion");
//        binaryTree.inOrder();
    }

    @Test
    void addString() {
        int[] digits = {1, 2, 3, 4};
        digits = new int[digits.length + 1];
        digits[0] = 1;

        String result = multiply("123456789", "987654321");
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        // int resultLength = num1.length > num2.length ? num1.length: num2.length;

        // List<String> answer = new ArrayList();
        String leftString, rightString;
        if (num1.length() > num2.length()) {
            leftString = num2;
            rightString = num1;
        } else {
            leftString = num1;
            rightString = num2;
        }
        String answer = "";
        StringBuilder th = new StringBuilder();
        return null;

    }

    private int getDigit(char c) {
        return c - '0';
    }

    private String addStrings(String num1, String num2) {
        int index = 0;
        String answer = "";
        int carryOver = 0;
        int addSingleDigit = 0;
        while (index < num1.length() && index < num2.length()) {
            addSingleDigit = getDigit(num1.charAt(index)) + getDigit(num2.charAt(index)) + carryOver;
            answer += addSingleDigit % 10;
            carryOver = addSingleDigit / 10;
            index++;
        }
        while (index < num1.length()) {
            addSingleDigit = getDigit(num1.charAt(index)) + carryOver;
            answer += addSingleDigit % 10;
            carryOver = addSingleDigit / 10;
            index++;
        }
        while (index < num2.length()) {
            addSingleDigit = getDigit(num2.charAt(index)) + carryOver;
            answer += addSingleDigit % 10;
            carryOver = addSingleDigit / 10;
            index++;
        }
        if (carryOver > 0) {
            answer += carryOver;
        }
        return answer;
    }


    private String singleDigitMultiply(int digit, String num) {
        int carryOver = 0;
        String result = "";
        for (int j = num.length() - 1; j >= 0; j--) {
            int temp = (getDigit(num.charAt(j)) * digit) + carryOver;
            carryOver = 0;
            result += (temp % 10);
            if (temp > 9) {
                carryOver = temp / 10;
            }
        }
        if (carryOver > 0)
            result += carryOver;
        return result;
    }


    @Test
    void findMinimum() {
        minWindow("ADOBECODEBANC", "ABC");
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        if (s.equals(t))
            return s;

        Map<Character, Integer> tCharsMapping = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            tCharsMapping.merge(t.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> sCharsMapping = new HashMap();
        int i = 0, j = 0;
        String output = "";

        SortedSet<Integer> indexes = new TreeSet();
        while (j < s.length()) {
            if (tCharsMapping.get(s.charAt(j)) != null) {
                sCharsMapping.merge(s.charAt(j), 1, Integer::sum);
                indexes.add(j);
            }
            if (tCharsMapping.equals(sCharsMapping)) {
                if (output.isEmpty())
                    output = s.substring(i, j + 1);
                else
                    output = output.length() < s.substring(i, j + 1).length() ? output : s.substring(i, j + 1);
                if (indexes.size() > 0) {
                    i = indexes.first();
                    indexes.remove(i);
                    sCharsMapping.put(s.charAt(j), sCharsMapping.get(s.charAt(j)) - 1);
                }

            }
            j++;
        }
        return output;
    }

    private void updateIndex(String s, Map<Character, Integer> tCharsMapping, Map<Character, SortedSet<Integer>> sCharsMapping, int i, int j) {
        StringBuilder test = new StringBuilder();


        SortedSet<Integer> currentIndexList = sCharsMapping.get(s.charAt(j));
        List<Integer> a = new ArrayList<>();
        if (currentIndexList == null) {
            SortedSet<Integer> temp = new TreeSet<>();
            temp.add(j);
            sCharsMapping.put(s.charAt(j), temp);
        } else {
            if (currentIndexList.size() == tCharsMapping.get(s.charAt(j)))
                currentIndexList.remove(currentIndexList.first());
            currentIndexList.add(j);
        }
    }

    private int findMinimumIndex(Map<Character, SortedSet<Integer>> chars, int len) {
        int min = len;
        Iterator<SortedSet<Integer>> iterator = chars.values().iterator();
        while (iterator.hasNext()) {
            SortedSet<Integer> temp = iterator.next();
            min = Math.min(min, temp.first());
        }
        return min;
    }

   @Test
    void median() {

   }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        int remaining = targetSum - root.val;
        return (findSum(root.left, remaining) == remaining || findSum(root.right, remaining) == remaining);

    }

    private int findSum(TreeNode node, int targetSum) {
        if(node == null) {
            return 0;
        }
        int remaining = targetSum - node.val;
        int leftSum = node.val + findSum(node.left, targetSum-node.val);
        if (leftSum == remaining) {
            return leftSum;
        } else {

        }
        int rightSum = node.val + findSum(node.right, targetSum-node.val);
        if (rightSum == remaining) {
            return rightSum;
        }
        return 0;
    }

       class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


}