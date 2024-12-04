package edu.frcc.csc1061jfa24.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();

	private class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();

		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;

			if (elem.equals(((Vertex) other).elem)) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return elem.toString();
		}
	}

	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}

	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {

		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for (Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}

	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int) edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}

	/*
	 * TODO: Implement the DFS algorithm for a graph either recursively or
	 * iteratively using a stack. It should return a list of all the vertices in the
	 * pre-order depth-first traversal.
	 */
	public List<Vertex> dfs(Vertex root) {
		Stack<Vertex> stck = new Stack<>();
		List<Vertex> visited = new ArrayList<>();
		stck.add(root);
		Vertex current;
		while (!stck.isEmpty()) {
			current = stck.pop();
			if (!visited.contains(current)) {
				visited.add(current);
			}
			for (Edge edge : current.neighbors) {
				if (!visited.contains(edge.d)) {
					stck.add(edge.d);
				}
			}
		}
		return visited;
	}

	/*
	 * TODO: Implement the BFS algorithm for a graph. It should return a list of all
	 * the vertices in the breadth-first traversal.
	 */
	public List<Vertex> bfs(Vertex root) {
		ArrayDeque<Vertex> qyoo = new ArrayDeque<>();
		List<Vertex> visited = new ArrayList<>();
		Vertex current;
		qyoo.add(root);
		while (!qyoo.isEmpty()) {
			current = qyoo.pop();
			if (!visited.contains(current)) {
				visited.add(current);
			}
			for (Edge edge : current.neighbors) {
				if (!visited.contains(edge.d)) {
					qyoo.add(edge.d);
				}

			}
		}
		return visited;
	}

	/*
	 * TODO: Create a spanning tree using Kruskal's Algorithm and return it. The
	 * spanning tree will be a new graph
	 */
	public Graph<E> findMinimumSpanningTree() {
		List<Edge> sortedEdges = new ArrayList<>();
		List<Edge> kruskal = new ArrayList<>();
		List<Vertex> vertices2 = new ArrayList<>();
		List<Vertex> visited = new ArrayList<>();
		
		// copy vertex list
		for(Vertex vertex : vertices) {
			vertices2.add(vertex);
		}
		// get all edges into list to be sorted
		for (Vertex vertex : vertices) {
			for (Edge edge : vertex.neighbors) {
				sortedEdges.add(edge);
			}
		}
		// clear all paths from the vertices for new graph
		for(Vertex vertex : vertices2) {
			vertex.neighbors.clear();
		}
		
		//sort edges
		Collections.sort(sortedEdges);
		
		// add first element as starting point
		// first element should be lowest
		Edge firstOne = sortedEdges.get(0);
		kruskal.add(firstOne);
		
		// add reversed path since it's not a directed graph
		kruskal.add(new Edge(firstOne.d, firstOne.s, firstOne.weight));
		
		//add to visited list to prevent loop/cycle
		visited.add(firstOne.d);
		visited.add(firstOne.s);
		
		// look for edges that connect unconnected vertices
		for(Edge edge : sortedEdges) {
			if(!visited.contains(edge.s) || !visited.contains(edge.d)){
				// add the new path and it's reverse
				kruskal.add(edge);
				kruskal.add(new Edge(edge.d, edge.s, edge.weight));
				//mark vertices visited
				visited.add(edge.d);
				visited.add(edge.s);
			}
		}
		
		// create new graph, update vertices paths
		Graph<E> spanTree = new Graph<E>(vertices2);
		for(Edge edge : kruskal) {
			spanTree.addEdge(edge);
		}
		//update graph vertices
		spanTree.vertices = vertices2;

		return spanTree;
	}
}
