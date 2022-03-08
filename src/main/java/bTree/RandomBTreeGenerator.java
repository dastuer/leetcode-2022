package bTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomBTreeGenerator {
    public static TreeNode getTree(){
        TreeNode[] treeNodes = randomNodes();
        TreeNode root = treeNodes[0];
        int len = treeNodes.length;
        System.out.println("tree: "+Arrays.toString(treeNodes));
        for (int i = 0; i <= len/2; i++) {
            TreeNode cur = treeNodes[i];
            if (i*2+1<len){
                cur.left = treeNodes[i*2+1];
            }
            if (i*2+2<len){
                cur.right = treeNodes[i*2+2];
            }
        }
        return root;

    }
    public static TreeNode[] randomNodes(){
        Random random = new Random();
        int len = random.nextInt(5, 10);
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            nodes.add(new TreeNode(random.nextInt(1,10)));
        }
        return nodes.toArray(new TreeNode[0]);
    }
}
