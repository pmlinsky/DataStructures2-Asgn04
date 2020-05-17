package assignment4;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Graph<String> graph = new Graph<>();
		graph.addEdge(new Edge<String>("0", "2", 1));
		graph.addEdge(new Edge<String>("0", "5", 2));
		graph.addEdge(new Edge<String>("1", "4", 3));
		graph.addEdge(new Edge<String>("1", "5", 3));
		graph.addEdge(new Edge<String>("2", "3", 2));
		graph.addEdge(new Edge<String>("2", "4", 2));
		graph.addEdge(new Edge<String>("4", "6", 1));
		graph.addEdge(new Edge<String>("4", "9", 1));
		graph.addEdge(new Edge<String>("9", "7", 9));
		graph.addEdge(new Edge<String>("6", "8", 8));
		graph.addEdge(new Edge<String>("8", "7", 3));
		graph.addEdge(new Edge<String>("10", "11", 2));
		
		HashMap<String, Integer> distances = graph.getDistances("5");
		for (String s : distances.keySet()) {
			if (distances.get(s) != Integer.MAX_VALUE) {
				System.out.println(s + "\t\t" + distances.get(s));
			}
			else {
				System.out.println(s + "\t\t Cannot be reached");
			}
		}
	}

}
