package assignment4;

public class Edge<T> {

	private T point1;
	private T point2;
	private int weight;
	
	public Edge(T point1, T point2, int weight) {
		this.point1 = point1;
		this.point2 = point2;
		this.weight = weight;
	}
	
	public T getPoint1() {
		return point1;
	}
	public void setPoint1(T point1) {
		this.point1 = point1;
	}
	public T getPoint2() {
		return point2;
	}
	public void setPoint2(T point2) {
		this.point2 = point2;
	}
	public int getWeight() {
		return weight;
	}
}
