package edu.frcc.CSC1061jfa24.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class FileTree implements Iterable<FileNode> {

	private FileNode root;

	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}

	/**
	 * TODO for Exam 2 Use recursion to build the tree from the directory structure.
	 * For each of node starting from the root node use listFiles() from File to get
	 * the list of files in that directory/folder. Create a node for each of the
	 * files and add it to a list of child nodes for the node Do this recursively
	 * for all the nodes.
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		// filenode.listFiles to see files starting at root
		// first create arraylist for children

		ArrayList<FileNode> nodeList = new ArrayList<>();
		FileNode node = null;
		File[] kids;
		kids = fileNode.getFile().listFiles();

		if (kids != null) {
			for (File file : kids) {
				node = new FileNode(file);
				nodeList.add(node);
			}
			fileNode.setChildNodes(nodeList);
			for (FileNode childNode : nodeList) {
				buildTree(childNode);
			}
		}

	}

	/**
	 * TODO for Exam 2 Iterator that does a post order traversal of the tree. For
	 * post-order traversal use the 2 stack approach outlined here:
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		Stack<FileNode> stck1 = new Stack<>();
		Stack<FileNode> stck2 = new Stack<>();

		public DepthFirstIterator() {
			// for each childNode, push to stack 1

			stck1.push(root);
			FileNode curr;

			while (!stck1.isEmpty()) {
				curr = stck1.pop();
				stck2.push(curr);

				for (FileNode nod : curr.getChildNodes()) {
					stck1.push(nod);
				}
			}

		}

		@Override
		public boolean hasNext() {
			return !stck2.isEmpty();
		}

		@Override
		public FileNode next() {
			return stck2.pop();
		}
	}

	/**
	 * Returns an iterator that does a breadth first traversal of the tree using a
	 * queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {

		return new BreadthFirstIterator();

	}

	/**
	 * TODO for Exam 2 Iterator that does a breadth first traversal of the tree
	 * using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		ArrayDeque<FileNode> deq1 = new ArrayDeque<>();
		ArrayDeque<FileNode> deq2 = new ArrayDeque<>();

		public BreadthFirstIterator() {
			deq1.add(root);
			while (!deq1.isEmpty()) {
				deq1.addAll(deq1.getFirst().getChildNodes());
				deq2.add(deq1.pop());
			}
		}

		@Override
		public boolean hasNext() {
			return !deq2.isEmpty();
		}

		@Override
		public FileNode next() {
			return deq2.pop();
		}

	}
}
