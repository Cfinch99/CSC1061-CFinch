package edu.frcc.CSC1061jfa24.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class MyBookTree implements Iterable<MyBookNode>{
	private MyBookNode root;
	
	public MyBookTree(String title) {
		root = new MyBookNode(title, 0,0,0, null);
	}
	
	public MyBookNode getBook() {
		return root;
	}
	
	public boolean addBookNode(String title, int cNum, int sNum, int ssNum, String txt) {
		MyBookNode node = new MyBookNode(title, cNum, sNum, ssNum, txt);
		
		if(sNum == 0) {
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}
		
		if(ssNum == 0) {
			for(MyBookNode cNode:root.getChildNodes()) {
				if(cNum == cNode.getChapNum()) {
					cNode.getChildNodes().add(node);
					Collections.sort(cNode.getChildNodes());
					return true;
				}
			}
		}
		MyBookNode chNode = null;
		for(MyBookNode cNode:root.getChildNodes()) {
			if(cNum == cNode.getChapNum()) {
				chNode = cNode;
				break;
			}
		}
		if(chNode == null) {
			return false;
		}
		
		for(MyBookNode sNode:chNode.getChildNodes()) {
			if(sNum == sNode.getSectNum()) {
				sNode.getChildNodes().add(node);
				Collections.sort(sNode.getChildNodes());
				return true;
			}
		}
		return false;
		
	}

	@Override
	public Iterator<MyBookNode> iterator() {
		
		return new BookNodeIterator(root);
	}
	
	private class BookNodeIterator implements Iterator<MyBookNode> {
		Deque<MyBookNode> stack;
		public BookNodeIterator(MyBookNode node) {
			stack = new ArrayDeque<>();
			stack.push(node);
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		@Override
		public MyBookNode next() {
			MyBookNode node = stack.pop();
			
			List<MyBookNode> childs = new ArrayList<>(node.getChildNodes());
			Collections.reverse(childs);
			for(MyBookNode child:childs) {
				stack.push(child);
			}
			return node;
		}
		
		
	}

}
