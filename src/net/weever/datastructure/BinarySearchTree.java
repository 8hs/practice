package net.weever.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.weever.domain.TreeNode;

public class BinarySearchTree {
	
	public void Insert(TreeNode root,TreeNode node){
		
		if(root == null){
			root = node;
		} else{
			insertRec(root,node);
		}
		
	}

	private void insertRec(TreeNode preNode, TreeNode node) {
		if(preNode.val > node.val){
			if(preNode.left == null)
				preNode.left = node;
			else
				insertRec(preNode.left,node);
		}else{
			if(preNode.right == null)
				preNode.right = node;
			else
				insertRec(preNode.right,node);
		}
		
	}
	
	public int Minimum(TreeNode root){
		if(root == null) return -1;
		TreeNode current = root;
		while(current.left != null){
			current = current.left;
		}
		return current.val;
	}
	
	public int Maximum(TreeNode root){
		if(root == null) return -1;
		TreeNode current = root;
		while(current.right != null){
			current = current.right;
		}
		return current.val;
	}
	
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<Integer>();
		if(root == null)
			return list;
		
		inorderRec(list,root);
		
		return list;
	}
	
    private void inorderRec(List<Integer> list, TreeNode lastroot) {
		if(lastroot.left != null)
			inorderRec(list,lastroot.left);
		list.add(lastroot.val);
		if(lastroot.right != null)
			inorderRec(list,lastroot.right);
		
	}
    
    public List<Integer> preorderTraversal(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
    	
    	preOrderRec(list, root);
    	
    	return list;
    }

	private void preOrderRec(List<Integer> list, TreeNode lastroot) {
		list.add(lastroot.val);
		if(lastroot.left!=null)
			preOrderRec(list,lastroot.left);
		if(lastroot.right!=null)
			preOrderRec(list,lastroot.right);
		
	}

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode pre = null;
        
        while(!stack.empty()){
            TreeNode curr = stack.peek();
            
            if(pre == null || pre.left == curr || pre.right == curr){
                if(curr.left != null){
                    stack.push(curr.left);
                }else if (curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    list.add(curr.val);
                }
            } else if(curr.left == pre){
                if(curr.right != null){
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    list.add(curr.val);
                }
            } else if( curr.right == pre){
                stack.pop();
                list.add(curr.val);
            }
            
            pre = curr;
        }
        
        return list;
    }
}
