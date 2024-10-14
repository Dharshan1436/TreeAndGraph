
package treeAndGraph.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Tree<T> {
	static <T> void inOrder(Node<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	static <T> void preOrder(Node<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	static <T> void postOrder(Node<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	static <T> int heightOf(Node<T> root) {
		if (root == null) {
			return 0;
		} else {
			int lh = heightOf(root.left);
			int rh = heightOf(root.right);
			return (lh > rh ? lh : rh) + 1;
		}
	}

	static <T> void printKDist(Node<T> root, int k) {
		if (root != null) {
			if (k == 0) {
				System.out.print(root.data + " ");
			} else {
				printKDist(root.left, k - 1);
				printKDist(root.right, k - 1);
			}
		}
	}

	static <T> void levelOrder(Node<T> root) {
		Queue<Node<T>> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
			while (q.size() > 0) {
				Node<T> curr = q.poll();
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}

	static <T> int size(Node<T> root) {
		if (root == null) {
			return 0;
		} else {
			int s1 = size(root.left);
			int s2 = size(root.right);
			return s1 + s2 + 1;
		}
	}
	static int max(Node  root) {
		if(root==null) {
			return Integer.MIN_VALUE;
			
		}else {
			int leftMax=max(root.left);
			int rightMax=max(root.right);
			return Math.max(Math.max(leftMax, rightMax), (int)root.data); 
		}
	}
	static int min(Node  root) {
		if(root==null) {
			return Integer.MAX_VALUE;
			
		}else {
			int leftMax=min(root.left);
			int rightMax=min(root.right);
			return Math.min(Math.min(leftMax, rightMax), (int)root.data); 
		}
	}
	static <T> void levelOrderLineByLine (Node<T> root) {
		Queue<Node<T>> q = new LinkedList<>();
		if (root != null) {
			q.add(root);
			q.add(null);
			while (q.size() > 1) {
				Node<T> curr = q.poll();
				if(curr==null) {
					System.out.println();
					q.add(null);
				}else {
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
				}
			}
		}
	}
	
}

public class BinaryTreeImplementation {

	public static void main(String[] args) {
		Node<Integer> root = new Node<>(10);
		root.left = new Node<>(20);
		root.right = new Node<>(30);
		root.left.left = new Node<>(40);
		root.right.left = new Node<>(50);
		root.right.right = new Node<>(60);

		Tree.inOrder(root);
		System.out.println();
		Tree.preOrder(root);
		System.out.println();
		Tree.postOrder(root);
		System.out.println();
		System.out.println(Tree.heightOf(root));
		Tree.printKDist(root, 2);
		System.out.println();
		Tree.levelOrder(root);
		System.out.println();
		System.out.println(Tree.size(root));
		System.out.println(Tree.max(root));
		System.out.println(Tree.min (root));
		Tree.levelOrderLineByLine(root);
	}
}
