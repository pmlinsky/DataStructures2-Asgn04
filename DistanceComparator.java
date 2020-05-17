package assignment4;

import java.util.Comparator;

public class DistanceComparator<T> implements Comparator<Vertex<T>> {

	@Override
	public int compare(Vertex<T> account1, Vertex<T> account2) {
		return account1.getDistance().compareTo(account2.getDistance());
	}

}
