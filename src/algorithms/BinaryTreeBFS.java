package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBFS {
	public static List<Double> averageOfLevels(TreeNode root) {
		if(root == null) {
			return null;
		}
		List<Double> list = new ArrayList<Double>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			double sum = 0.0;
			int n = q.size();
			for(int i=0; i<n; i++) {
				TreeNode t = q.poll();
				if(t.left != null) {
					q.add(t.left);
				}
				if(t.right != null) {
					q.add(t.right);
				}
				sum += t.val;
			}
			list.add(sum/n);
		}
		
		return list;
	}
	
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}