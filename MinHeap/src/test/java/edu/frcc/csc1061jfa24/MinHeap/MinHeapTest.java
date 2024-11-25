package edu.frcc.csc1061jfa24.MinHeap;

import java.util.PriorityQueue;

public class MinHeapTest {

	public static void main(String[] args) {
		int[] nodes = {88, 85, 83, 72, 73, 42, 57, 6, 48, 60};
		MinHeap<Integer> heap = new MinHeap<>();
		
		for(int node: nodes) {
			heap.add(node);
		}
		
		System.out.println("MinHeap removal:");
		while(!heap.isEmpty()) {
			System.out.print(heap.remove() + " ");
		}
		
		PriorityQueue<Integer> qheap = new PriorityQueue<>(); 
		for(int node: nodes) {
			qheap.add(node);
		}
		System.out.println();
		System.out.println("PQHeap removal:");
		while(!qheap.isEmpty()) {
			System.out.print(qheap.remove() + " ");
		}
		// reverse order
		// qheap = new priorityqueue<>(collections.reverseOrder)
	}

}
