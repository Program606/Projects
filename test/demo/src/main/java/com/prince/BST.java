package com.prince;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> implements Iterable<T>, Comparator<T> {
	private Comparator<T> comparator;
	private Queue<T> queue = new LinkedList<T>();
	
	class BSTNode implements Comparable<BSTNode> {
		private T data;
		private BSTNode left;
		private BSTNode right;

		public BSTNode(T d) {
			setLeft(null);
			setRight(null);
			setData(d);
		}
		public T getData() { return data; }
		public void setData(T d) { data = d; }
		public void setLeft(BSTNode l) { left = l; }
		public void setRight(BSTNode r) { right = r; }
		public BSTNode getLeft() { return left; }
		public BSTNode getRight() { return right; }
		public boolean isLeaf() { return (getLeft() == null) && (getRight() == null); }
		public int compareTo(BSTNode o) {
			if(comparator != null) {
				return comparator.compare(this.getData(), o.getData());
			}else {
				return this.getData().compareTo(o.getData());
			}
		}
	}

	private BSTNode root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}
	
	public BST(Comparator<T> externalComp) {
		root = null;
		size = 0;
		comparator = externalComp;
	}
	
	public void printInOrder() {
		inOrderTraversal(root);
	}
	private void inOrderTraversal(BSTNode r) {
		if (r == null)
			return;
		else {
			inOrderTraversal(r.getLeft());
			visitPrint(r);
			inOrderTraversal(r.getRight());
		}
	}
	private void visitPrint(BSTNode r) {
		System.out.println(r.getData());
	}
	/**
	 * Return the number of nodes in the tree.
	 */
	public int size() {
		return size;
	}
	/**
	 * Return true if element d is present in the tree.
	 */
	public T find(T d) {
		return find(d, root);
	}
	public void inOrderAdd(T d) {
		BSTNode avengerNode = new BSTNode(d);
		inOrderAddRec(avengerNode);
	}

	private void inOrderAddRec(BSTNode r) {
		Queue<BSTNode> q = new LinkedList<BSTNode>(); 
		
		if(r != null) {
			q.add(r);
		}
		while(!q.isEmpty()) {
			BSTNode curr = q.remove();
			if(curr != null) {
				visit(curr);
				q.add(curr.getLeft());
				q.add(curr.getRight());
			}
		}
	}

	/**
	 * Add element d to the tree.
	 */
	public void add(T d) {
		BSTNode n = new BSTNode(d);
		size++;
		if (root == null) {
			root = n;
		} else {
			add(root, n);
		}
	}

	public void remove(T d){
		remove(d, root);
	}

	/**
	 * Return the height of the tree.
	 */
	public int height() {
		return height(root);
	}
	
	// Private methods.
	private T find(T d, BSTNode r) {
		if (r == null)
			return null;
		int c = d.compareTo(r.getData());
		if (c == 0)
			return r.getData();
		else if (c < 0)
			return find(d, r.getLeft());
		else
			return find(d, r.getRight());
	}

	/* Do the actual add of node r to tree rooted at n */
	private void add(BSTNode r, BSTNode n) {
		
		if(r == null){
			return;
		}
		
		if(r.getData() != null && n.getData() != null) {
			int c = n.compareTo(r);		

			//Checking Left
			if (c < 0) {
				if(r.getLeft() == null){
					r.setLeft(n);
				}
				else{
					add(r.getLeft(), n);
				}
			
			//Checking Right
			}else if(c > 0){

				if(r.getRight() == null){
					r.setRight(n);
				}else{
					add(r.getRight(), n);
				}
				
			}
		}
		
	}
	private BSTNode remove(T d, BSTNode root) {
		if(root == null) {
			return null;
		}else {
			int result = d.compareTo(root.getData());
			
			if(result < 0) {
				root.setLeft(remove(d, root.getLeft()));
			}else if(result > 0) {
				root.setRight(remove(d, root.getRight()));
			}else {
				if(root.getLeft() == null) {
					return root.getRight();
				}else if(root.getLeft() == null){
					return root.getLeft();
				}
				root.setData(findMax(root.getLeft()));
				root.setLeft(remove(root.getData(), root.getLeft()));
				
			}
		}
		
		return root;
		
	}


	private T findMax(BSTNode root) {
		System.out.println("The root is : "+root.getData());
		
		if(root.getRight() == null) {
			System.out.println(root.getRight());
			return findMax(root.getRight());
		}
		
		return root.getData();
		
	}

	/* Implement a height method. */
	private int height(BSTNode r) {
		int h = -1;
		
		if(r != null){
			int lh = height(r.getLeft());
			int rh = height(r.getRight());

			//finding the max of lh, rh, adding 1.
			if(rh > lh)
				h = 1 + rh;
			else
				h = 1 + lh;
		}
		return h;
		}
	private void visit(BSTNode r) {
		if (r != null) {
			queue.add(r.getData());
		}
	}
	
	public static final int INORDER = 0;
	public static final int PREORDER = 1;
	public static final int POSTORDER = 2;
	public static final int LEVELORDER = 3;
	public static final int REVINORDER = 4;
	
	
	public void traverse(int travType) {
		traverse(root, travType);
	}
	
	private void traverse(BSTNode r, int travType) {
		if(r == null) {
			return;
		}
		else {
			switch(travType) {
			case INORDER:
				traverse(r.getLeft(), travType);
				visit(r);
				traverse(r.getRight(), travType);
				break;
				
			case PREORDER:
				visit(r);
				traverse(r.getLeft(), travType);
				traverse(r.getRight(), travType);
				break;
				
			case POSTORDER:
				traverse(r.getLeft(), travType);
				traverse(r.getRight(), travType);
				visit(r);
				break;
				
			}
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new BSTIteratorInOrder();
	}
	private class BSTIteratorInOrder implements Iterator<T>{
		
		
		BSTIteratorInOrder(){
			queue.clear();
			traverse(root, INORDER);
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			return queue.remove();
		}
		
	}
	@Override
	public int compare(T o1, T o2) {
		return compareRec(o1, o2);
	}

	private int compareRec(T o1, T o2) {
		if(comparator != null) {
			return comparator.compare(o1, o2);
		}else {
			return o1.compareTo(o2);
		}
	}
	
}

