package edu.frcc.csc1061jfa24.MyAVLTree;

// homework is right right imbalance and right left imbalance
// look at visualizer in d2l

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyAVLTree <K,V> implements Map<K,V>, Iterable<V>{
	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>();
	
	protected class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;
		private int height;
		
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}


		public K getKey() {
			return key;
		}


		public void setKey(K key) {
			this.key = key;
		}


		public V getValue() {
			return value;
		}


		public void setValue(V value) {
			this.value = value;
		}


		public Node getLeft() {
			return left;
		}


		public void setLeft(Node left) {
			this.left = left;
		}


		public Node getRight() {
			return right;
		}


		public void setRight(Node right) {
			this.right = right;
		}


		public int getHeight() {
			return height;
		}


		public void setHeight(int height) {
			this.height = height;
		}
		
	}

	@Override
	public Iterator<V> iterator() {
		return new RecursiveIterator();
	}
	
	private class RecursiveIterator implements Iterator<V> {
		private List<V> list = new LinkedList<>();
		
		public RecursiveIterator() {
			preOrder(root);
		}
		
		private void inOrder(Node node) {
			if(node == null) {
				return;
			}
			// in order traversal(left, parent, right)left, add,right
			// pre order would be add, left, then right
			// post order would be left, right, then add
			inOrder(node.left);
			list.add(node.value);
			inOrder(node.right);
		}
		
		private void preOrder(Node node) {
			if(node == null) {
				return;
			}
			list.add(node.value);
			preOrder(node.left);
			preOrder(node.right);
		}
		private void postOrder(Node node) {
			if(node == null) {
				return;
			}
			
			postOrder(node.left);
			postOrder(node.right);
			list.add(node.value);
		}

		@Override
		public boolean hasNext() {
			return !list.isEmpty();
		}

		@Override
		public V next() {
			return list.remove(0);
		}
		
	}
	private class NonRecursiveIterator implements Iterator<V> {
// example iterator non recursively, similar to exam 2 but in order
		private Deque<Node> stack = new ArrayDeque<>();
		public NonRecursiveIterator() {
			pushOnStack(root);
		}
		public void pushOnStack(Node node) {
			Node current = node;
			while(current != null) {
				stack.push(current);
				current=current.left;
			}
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public V next() {
			Node node = stack.pop();
			V value = node.value;
			pushOnStack(node.right);
			return value;
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if(k.compareTo(current.key) < 0) {
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				current = current.right;
			}
			else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if(root==null) {
			Node newNode = new Node(key, value);
			root = newNode;
			size++;
			updateHeight(root);
			return value;
		}
		
		path.clear();
		Node parent = null;
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		while(current != null) {
			path.add(current);
			if(k.compareTo(current.key) < 0) {
				parent = current;
				current = current.left;
			}
			else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.right;
			}
			else {
				V oldVal = current.value;
				current.value = value;
				return oldVal;
			}
		}
		
		Node newNode = new Node(key, value);
		if(k.compareTo(parent.key) < 0) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
		updateHeight(root);
		
		size++;
		return value;
	}
	private void updateHeight(Node node) {
		if (node.left == null && node.right == null) {
			node.height = 0;
		}
		else if (node.left == null) {
			node.height = node.right.height + 1;
		}
		else if (node.right == null) {
			node.height = node.left.height + 1;
		}
		else {
			node.height = Math.max(node.left.height, node.right.height) + 1;
		}
	}
	
	private int balanceFactor(Node current) {
		int balanceFactor = 0;
		if (current.right == null) {
			balanceFactor = -current.height;
		}
		else if (current.left == null) {
			balanceFactor = current.height;
		}
		else {
			balanceFactor = current.right.height - current.left.height;
		}
		return balanceFactor;
	}
	
	private void balancePath() {
		for(int i = path.size() - 1; i >= 0; i--) {
			Node gp = path.get(i);
			updateHeight(gp);
			Node parent_of_gp = null;
			if(i > 0) {
				parent_of_gp = path.get(i -1);
			}
			
			switch(balanceFactor(gp)) {
				case -2:
					if(balanceFactor(gp.left) <= 0) {
						//LL imbalance
						balanceLL(gp, parent_of_gp);
					}
					else {
						//LR imbalance
					}
					break;
				case 2:
					if(balanceFactor(gp.right) >= 0) {
						//RR imbalance
					}
					else {
						//RL imbalance
					}
					break;
			}
		}
	}
	
	private void balanceLL(Node gp, Node parentOfGp) {
		Node parent = gp.left;
		Node child = parent.left;
		
		// deal with gp connection to rest of tree
		if (gp == root) {
			root = parent;
		}
		else {
			if (parentOfGp.left == gp){
				parentOfGp.left = parent;
			}
			else {
				parentOfGp.right = parent;
			}
		}
		// make node hanging off parent move to gp
		gp.left = parent.right;
		// move gp to right of parent
		parent.right = gp;
		
		// go bottom up, updating parent first would be wrong, using gp and childs old heights
		updateHeight(gp);
		updateHeight(child);
		updateHeight(parent);
	}
	
	private void balanceLR(Node gp, Node parentOfGp) {
		Node parent = gp.left;
		Node child = parent.right;
		
		if (gp == root) {
			root = child;
		}
		else {
			if (parentOfGp.left == gp){
				parentOfGp.left = child;
			}
			else {
				parentOfGp.right = child;
			}
		}
		// since child is going to lose it's nodes
		// assign them to the right place first
		parent.right = child.left;
		gp.left = child.right;
		
		//now change child's child nodes
		child.left = parent;
		child.right = gp;
		
		updateHeight(gp);
		updateHeight(parent);
		updateHeight(child);
	}
	
	//homework
	private void balanceRR(Node gp, Node parentOfGp) {
			Node parent = gp.right;
			Node child = parent.right;
			
			if (gp == root) {
				root = parent;
			}
			else {
				if (parentOfGp.left == gp){
					parentOfGp.left = parent;
				}
				else {
					parentOfGp.right = parent;
				}
			}
			gp.right = parent.left;
			parent.left = gp;
			updateHeight(gp);
			updateHeight(child);
			updateHeight(parent);
		}
	private void balanceRL(Node gp, Node parentOfGp) {
		Node parent = gp.right;
		Node child = parent.left;
		
		if (gp == root) {
			root = child;
		}
		else {
			if (parentOfGp.left == gp){
				parentOfGp.left = child;
			}
			else {
				parentOfGp.right = child;
			}
		}
		parent.left = child.right;
		gp.right = child.left;
		child.right = parent;
		child.left = gp;
		
		updateHeight(gp);
		updateHeight(parent);
		updateHeight(child);
	}
	@Override
	public V remove(Object key) {
		// homework, 3 cases, look in D2L
		// 1st step, find node. comparable K. keep track of parent
		// 2nd check children
		// cut off leaf, copy leaf, or in order predecessor through recursion
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
