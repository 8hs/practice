package net.weever.test;

import java.util.Iterator;
import java.util.List;

import net.weever.datastructure.BinarySearchTree;
import net.weever.domain.TreeNode;

public class BinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(40);
		TreeNode curr = root;
		curr.left = new TreeNode(25);
		curr.right = new TreeNode(78);
		curr = curr.left;
		curr.left = new TreeNode(10);
		curr.right = new TreeNode(32);
		
		BinarySearchTree bst = new BinarySearchTree();
		//min
		System.out.println("min:"+bst.Minimum(root));
		//min
		System.out.println("max:"+bst.Maximum(root));
		
		// inorder
		System.out.println("\ninorder:");
		PrinterOrder(bst.inorderTraversal(root));
		// postorder
		System.out.println("\npostorder:");
		PrinterOrder(bst.postorderTraversal(root));
		
		System.out.println("\npreorder2:");
		PrinterOrder(bst.preorderTraversal(root));
	}
	
	private static void PrinterOrder(List<Integer> list){
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+":");
		}
	}

}
