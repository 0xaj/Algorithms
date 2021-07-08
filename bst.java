package linkedlist;



public class bst {

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //        List<List<Integer>> res = new ArrayList<>();
    //        if (root == null)   return res;
    //        Queue<TreeNode> q = new LinkedList<>();
    //        q.add(root);
    //        while (q.size() > 0) {
    //            List<Integer> temp = new ArrayList<>();
    //            int size = q.size();
    //            while (size > 0) {
    //                temp.add(q.peek().val);
    //                if (q.peek().left != null)  q.add(q.peek().left);
    //                if (q.peek().right != null) q.add(q.peek().right);
    //                q.remove();
    //                size--;
    //            }
    //            res.add(temp);
    //        }
    //        return res;
    //    }
    
//    int max = 0;
//
//		public int diameterOfBinaryTree(TreeNode root) {
//		    helper(root);
//		    return max;
//		}
//
//		int helper(TreeNode root) {
//		    if(root==null)
//			return 0;
//
//		    int left = helper(root.left);
//		    int right = helper(root.right);
//
//		    if(max < left+right)
//			max = left+right;
//
//		    return Math.max(left,right)+1;
//		}
//
//  	      return helper(root,null,null);
//  	  }
//
//	    public boolean helper(TreeNode root, TreeNode l, TreeNode r){
//
//		if(root == null) return true;
//
//		if(l != null && root.val <= l.val) return false;
//		if(r != null && root.val >= r.val) return false;
//
//		return helper(root.left, l, root) && helper(root.right, root, r);
//	    }
//
//	      Node lca(Node node, int n1, int n2)
//	    {
//		if (node == null)
//		    return null;
//
//		// If both n1 and n2 are smaller than root, then LCA lies in left
//		if (node.data > n1 && node.data > n2)
//		    return lca(node.left, n1, n2);
//
//		// If both n1 and n2 are greater than root, then LCA lies in right
//		if (node.data < n1 && node.data < n2)
//		    return lca(node.right, n1, n2);
//
//		return node;
//	    }

}
