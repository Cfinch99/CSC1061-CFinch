package edu.frcc.csc1061jfa24.MinHeap;

import java.util.ArrayList;
import java.util.List;
//open DSA website for exercises

public class MinHeap <E extends Comparable <E>>{
	private List<E> heapArr;
	
	public MinHeap() {
		heapArr = new ArrayList<E>();
	}
	
	public boolean isEmpty() {
		return heapArr.size()==0;
	}
	
	public int size() {
		return heapArr.size();
	}
	
	public List<E> getHeap(){
		return heapArr;
	}
	
	public int leftChild(int pos) {
		int child = (2 * pos) + 1;
		// turnary operator, same as an if condition. if true, left side of colon, false is left side
		return child >= heapArr.size() ? -1 : child;
	}
	public int rightChild(int pos) {
		int child = (2 * pos) + 2;
		return child >= heapArr.size() ? -1 : child;
	}
	public int parent(int pos) {
		if (pos == 0) {
			return -1;
		}
		int parent = (pos -1) / 2;
		return parent;
	}
	
	public boolean isLeafNode(int pos) {
		return(pos >= heapArr.size() / 2) && (pos < heapArr.size());
	}
	
	public int add(E entry) {
		heapArr.add(entry);
		return swimUp(heapArr.size() - 1);
	}
	
	private int swimUp(int current) {
		int parent = parent(current);
		while(current != 0 && (heapArr.get(current).compareTo(heapArr.get(parent(current))) < 0)) {
			swap(current, parent);
			current = parent;
			parent = parent(current);
		}
		return current;
	}
	
	private void swap(int pos1, int pos2) {
		E temp = heapArr.get(pos1);
		heapArr.set(pos1, heapArr.get(pos2));
		heapArr.set(pos2, temp);
	}
	
	public E remove() {
		return remove(0);
	}
	public E remove(int pos) {
		swap(pos, heapArr.size() - 1);
		E removedEntry = heapArr.remove(heapArr.size() - 1);
		if (heapArr.size() > 0) {
			siftDown(pos);
		}
		return removedEntry;
	}
	
	private int siftDown(int current) {
		while(!isLeafNode(current)) {
			int child = leftChild(current);
			int rchild = rightChild(current);
			
			E childEntry = heapArr.get(child);
			if(rchild > -1) {
				E rchildEntry=heapArr.get(rchild);
				if(rchildEntry.compareTo(childEntry) < 0) {
					childEntry = rchildEntry;
					child = rchild;
				}
			}
			
			if(heapArr.get(current).compareTo(childEntry) > 0) {
				swap(current, child);
				current = child;
			}
			else {
				break;
			}
		}
		return current;
	}

}

