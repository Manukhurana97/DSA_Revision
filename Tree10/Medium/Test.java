import java.util.*;

class TreeNode{

	int val;
	TreeNode left;
	TreeNode right;


	TreeNode(int val){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class NodeDetails{
	int order;
	TreeNode node;

	NodeDetails(int order, TreeNode node){
		this.order = order;
		this.node = node;
	}
}

public class Test{

	public List<Integer> get(TreeNode root, int target){
		List<Integer> result = new ArrayList<>();
		
		if(root == null) return result;
		if(root.val == target) {
			result.add(target);
			return result;
		}

		boolean flag = dfs(root, target, result);

		return flag ? result : new ArrayList<>();
	}

	public boolean dfs(TreeNode root, int target, List<Integer> result){
		if(root == null) return false;

		result.add(root.val);

		if(root.val == target) 
			return true;

		if(dfs(root.left, target, result) || dfs(root.right, target, result)) 
			return true;

		result.remove(result.size()-1);
		return false;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);

		Test test = new Test();
		System.out.println(test.get(root, 15));

	}
}

//         1
//    2           3
// 4    5      6     7 
//8 9 10 11  12 13 14 15 