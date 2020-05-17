package assignment4;

import java.util.*;

public class Vertex<T> {

	private T value;
	private Set<Edge<T>> neighbors = new HashSet<Edge<T>>();
	private Integer distance = Integer.MAX_VALUE;
	
	public Vertex(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public Set<Edge<T>> getNeighbors() {
		return neighbors;
	}
	
	public boolean addNeighbor(Edge<T> neighbor) {
		return neighbors.add(neighbor);
	}
	
	public boolean removeNeighbor(Edge<T> neighbor) {
		return neighbors.remove(neighbor);
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
}
