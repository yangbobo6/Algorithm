package TreeNode_Model;

import java.util.ArrayList;

/**
 * @Author: yangbo
 * @Date: 2022-02-18-15:26
 * @Description:
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class JZ8_GetNext {
    static ArrayList<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode treeLinkNode = pNode;
        while (treeLinkNode.next!=null){
            treeLinkNode = treeLinkNode.next;
        }

        inOrder(treeLinkNode);

        for (int i = 0; i < list.size(); i++) {
            if(pNode==list.get(i)){
                return i== list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }

    public void inOrder(TreeLinkNode t){
        if(t==null){
            return;
        }
        inOrder(t.left);
        list.add(t);
        inOrder(t.right);
    }

}
