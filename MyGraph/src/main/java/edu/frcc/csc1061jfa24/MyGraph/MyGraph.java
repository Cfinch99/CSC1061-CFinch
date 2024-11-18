package edu.frcc.csc1061jfa24.MyGraph;

import java.util.ArrayList;
import java.util.List;

public class MyGraph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	private class Vertex {
		
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getElem() {
			return elem;
		}

		public void setElem(E elem) {
			this.elem = elem;
		}

		public List<Edge> getNeighbors() {
			return neighbors;
		}
		@Override
		public String toString() {
			return elem.toString();
		}
	}
	
	private class Edge implements Comparable<Edge>{
		private Vertex s;
		private Vertex d;
		private int weight;
		
		public Edge(Vertex s, Vertex d, int weight) {
			super();
			this.s = s;
			this.d = d;
			this.weight = weight;
		}
		
		

		public Vertex getS() {
			return s;
		}
		public void setS(Vertex s) {
			this.s = s;
		}
		public Vertex getD() {
			return d;
		}
		public void setD(Vertex d) {
			this.d = d;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [s=" + s + ", d=" + d + ", weight=" + weight + "]";
		}


		@Override
		public boolean equals(Object edge) {
			return (s.equals(((Edge)edge).s) && d.equals(((Edge)edge).d));
		}
		@Override
		public int compareTo(MyGraph<E>.Edge o) {
			return weight - o.weight;
		}
	}
	
	public MyGraph(List<Vertex> vertices) {
		for(Vertex v: vertices) {
			this.vertices.add(v);
		}
	}
	public MyGraph(List<E> elements, E[][] edges) {
		for(E e: elements) {
			this.vertices.add(new Vertex(e));
		}
		createAdjacencyLists(edges);
		
	}
	private Vertex findVertex(E key) {
		for(Vertex v: vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	
	public boolean addEdge(Edge edge) {
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		}
		else {
			return false;
		}
	}
	
	private void createAdjacencyLists( E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			Vertex src = findVertex(edges[i][0]);
			Vertex dst = findVertex(edges[i][1]);
			addEdge(new Edge(src, dst, (int) edges[i][2]));
		}
	}
	
	public void printEdges() {
		for (int i = 0; i < vertices.size(); i ++) {
			Vertex ver = vertices.get(i);
			System.out.print("Vertex: " + ver + ":");
			List<Edge> neighbors = ver.neighbors;
			for(Edge edge : neighbors) {
				System.out.print("(" + edge.s + "," + edge.d + "," + edge.weight + ")" );
			}
			System.out.println();
		}
	}
	// non recursive depth first search
	// use deque, return in dfs order
	public List<Vertex> dfs(Vertex root){
		
		
		
	}
}
