package edu.frcc.csc1061jfa24.ArrayAndLinkedLists;

import java.util.List;

public class TestList {

	public static void main(String[] args) {
		
		List<Integer> ml = new MyLinkedList<Integer>();
		ml.add(1);
		ml.add(2);
		ml.add(3);
		ml.add(4);
		ml.add(5);
		ml.add(6);
		
		for(int i =0; i <ml.size();i++) {
			System.out.print(ml.get(i) + " ");
		}
		System.out.println();
		
		ml.remove(1);
		
		for(int i =0; i < ml.size(); i++) {
			System.out.print(ml.get(i) + " ");
		}
		System.out.println();
		
		// for each with iterator
		for(int i: ml) {
			System.out.print(i + " ");
		}
		

	}

}
