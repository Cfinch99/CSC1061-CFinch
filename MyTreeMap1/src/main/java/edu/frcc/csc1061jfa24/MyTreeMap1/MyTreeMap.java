package edu.frcc.csc1061jfa24.MyTreeMap1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTreeMap <K,V> implements Map<K,V>, Iterable<V>{
	private Node root = null;
	private int size = 0;
	
	private class Node {
		private K key;
		private V value;
		private Node left = null;
		private Node right = null;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
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
			return value;
		}
		Node parent = null;
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		while(current != null) {
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
		
		size++;
		return value;
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
