package assignment4;

import java.util.*;

public class Graph<T> {

	private HashMap<T, Vertex<T>> vertices = new HashMap<T, Vertex<T>>();
	
	public boolean addVertex(T value) {
		if (vertices.containsKey(value)) {
			return false;
		}
		vertices.put(value, new Vertex<T>(value));
		return true;
	}
	
	public boolean addEdge(Edge<T> edge) {
		if (vertices.containsKey(edge.getPoint1()) &&
				vertices.containsKey(edge.getPoint2()) &&
				vertices.get(edge.getPoint1()).getNeighbors().contains(edge)) {
			return false;
		}
		//now we know the edge is not there
		if (!vertices.containsKey(edge.getPoint1())) {
			vertices.put(edge.getPoint1(), new Vertex<T>(edge.getPoint1()));
		}
		if (!vertices.containsKey(edge.getPoint2())) {
			vertices.put(edge.getPoint2(), new Vertex<T>(edge.getPoint2()));
		}
		Vertex<T> v1 = vertices.get(edge.getPoint1());
		Vertex<T> v2 = vertices.get(edge.getPoint2());
		v1.addNeighbor(edge);
		v2.addNeighbor(edge);
		return true;
	}
	
	public HashMap<T, Integer> getDistances(T start) {
		
		HashMap<T, Integer> distances = new HashMap<T, Integer>();		
		Vertex<T> first = vertices.get(start);
		
		first.setDistance(0);
		distances.put(start, 0);

		Queue<Vertex<T>> pq = new PriorityQueue<>(10, new DistanceComparator<T>());
		pq.addAll(vertices.values());
		
		while (!pq.isEmpty()) {
			Vertex<T> nextVertex = pq.poll();
			
			for (Edge<T> e : nextVertex.getNeighbors()) {
				Vertex<T> v = vertices.get(nextVertex.getValue() == e.getPoint1() ?
						e.getPoint2() : e.getPoint1());
				
				if (nextVertex.getDistance() == Integer.MAX_VALUE) {
					distances.put(v.getValue(), nextVertex.getDistance());					
				}
				else {
					int distance = nextVertex.getDistance() + e.getWeight();
					if (distance < v.getDistance()) {
						pq.remove(v);
						v.setDistance(distance);
						pq.offer(v);
					
						distances.put(v.getValue(), distance);
					}
				}
			}
		}		
		return distances;
	}

}
