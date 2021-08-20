package com.jianzhiOffer;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//前序   中序 遍历二叉树*********    涉及分数组问题
public class JZ4_CreatBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        //为空时,返回null
        if(pre == null||pre.length==0){
            return null;
        }
        //前序遍历第一个,为根节点
        int rootVal = pre[0];
        if(pre.length == 1){
            return new TreeNode(rootVal);
        }
        //查找根节点 在中序遍历的哪个位置
        int rootIndex = 0;
        for(int i =0;i<vin.length;i++){
            if(vin[i]==rootVal){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //左右区间分别递归  构造二叉树
        // copyOfRange为左闭右开 [)， 即包括左界限不包括右界限
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(vin,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex+1 ,pre.length),Arrays.copyOfRange(vin,rootIndex+1,vin.length));
        return root;



//        维护一个指针：指向根节点在中序遍历中的索引位置的指针，栈用来保存结点
//        初始时栈中存放了根节点（前序遍历的第一个节点），指针指向中序遍历的第一个节点；
//        我们依次枚举前序遍历中除了第一个节点以外的每个节点。、
//        用前序数组一直构建左子树, 即一开始是先走到最左叶子结点，如果 index 和栈顶节点不同，我们将当前节点作为栈顶节点的左儿子；连接左子节点
//        如果 index 恰好指向栈顶节点，即表示到了左下角，这时就需要往上走并处理右子树，此时不断地弹出栈顶节点并向右移动 index，并将当前节点作为最后一个弹出的节点的右儿子；连接右子节点
//        public TreeNode reConstructBinaryTree(int[] preorder, int[] inorder) {
//            if (preorder == null || preorder.length == 0) {
//                return null;
//            }
//            TreeNode root = new TreeNode(preorder[0]);
//            Deque<TreeNode> stack = new LinkedList<TreeNode>();
//            stack.push(root);
//            // 指向根节点在中序遍历中的索引位置的指针
//            int inorderIndex = 0;
//            for (int i = 1; i < preorder.length; i++) {
//                int preorderVal = preorder[i];
//                TreeNode node = stack.peek();
//                // 用前序数组一直构建左子树, 即一开始是先走到最左叶子结点
//                if (node.val != inorder[inorderIndex]) {
//                    // 当前节点作为栈顶节点的左儿子结点
//                    node.left = new TreeNode(preorderVal);
//                    stack.push(node.left);
//                } else {
//                    // 表示到了左下角，这时就需要往上走并处理右子树
//                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                        node = stack.pop();
//                        // 指针往上走，直到碰到节点node有右子节点
//                        inorderIndex++;
//                    }
//                    // 连接右子结点
//                    node.right = new TreeNode(preorderVal);
//                    stack.push(node.right);
//                }
//            }
//            return root;
//        }
    }
}
