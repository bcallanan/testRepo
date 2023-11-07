package com.brianc.testRepo;

public class LCAInTree {

		static class BinaryTeeNode {
		    int data;
		    BinaryTeeNode left, right;

		    BinaryTeeNode(int item) {
		        data = item;
		        left = right = null;
		    }
		}


		BinaryTeeNode root;

	    public BinaryTeeNode findLCA(int n1, int n2) {
	        return findLCA(root, n1, n2);
	    }

	    public BinaryTeeNode findLCA(BinaryTeeNode node, int n1, int n2) {
	        // Base case
	        if (node == null) {
	            return null;
	        }

	        // If node's value is greater than both n1 and n2, then LCA lies in left
	        if (node.data > n1 && node.data > n2) {
	            return findLCA( node.left, n1, n2);
	        }

	        // If node's value is smaller than both n1 and n2, then LCA lies in right
	        if (node.data < n1 && node.data < n2) {
	            return findLCA(node.right, n1, n2);
	        }

	        return node;
	    }

	    public BinaryTeeNode createNewNode(int val) {
	    	BinaryTeeNode newNode = new LCAInTree.BinaryTeeNode(val);
	        newNode.left = null;
	        newNode.right = null;
	        return newNode;
	    }
	   
	    public static void main(String args[]) {
	    	LCAInTree tree = new LCAInTree();
	    	BinaryTeeNode root = new LCAInTree.BinaryTeeNode(20);
	        tree.root = root;
	        tree.root.left = tree.createNewNode( 8 );
	        tree.root.right = tree.createNewNode( 22 );
	        tree.root.left.left = tree.createNewNode( 4 );
	        tree.root.left.right = tree.createNewNode(12 );

	        int n1 = 8;
	        int n2 = 12;
	        BinaryTeeNode t = tree.findLCA(n1, n2);
	        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
	    } 
}
