package com.interview.graph;

import java.util.HashSet;
import java.util.Set;

public class CycleInDirectedGraph {

	private boolean hasCycle(Graph<Integer> graph) {
		if (graph == null)
			return false;
		Set<Vertex<Integer>> white = new HashSet<Vertex<Integer>>();
		Set<Vertex<Integer>> gray = new HashSet<Vertex<Integer>>();
		Set<Vertex<Integer>> black = new HashSet<Vertex<Integer>>();

		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			white.add(vertex);
		}

		/*
		 * for (Vertex<Integer> vertex : white) { if (dfs(white, gray, black, vertex)) {
		 * return true; } }
		 */
		
		while(white.size()>0) {
			Vertex<Integer> vertex = white.iterator().next();
			if (dfs(white, gray, black, vertex)) {
				return true;
			}
		}
		
		return false;
	}

	private boolean dfs(Set<Vertex<Integer>> white, Set<Vertex<Integer>> gray, Set<Vertex<Integer>> black,
			Vertex<Integer> vertex) {

		move(vertex, white, gray);
		for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
			//no vertex to visit, continue
			if (black.contains(v)) {
				continue;
			}
			
			if (gray.contains(v)) {
				return true;
			}
			
			if(dfs(white, gray, black, v)) {
				return true;
			}
		}
		move(vertex,gray,black);

		return false;

	}

	private void move(Vertex<Integer> v, Set<Vertex<Integer>> from, Set<Vertex<Integer>> to) {
		to.add(v);
		from.remove(v);
	}

	public static void main(String args[]) {
		Graph<Integer> graph = new Graph<>(true);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		CycleInDirectedGraph cdg = new CycleInDirectedGraph();
		System.out.println(cdg.hasCycle(graph));
	}

}
