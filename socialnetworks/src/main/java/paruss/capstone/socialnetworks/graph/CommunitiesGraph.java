package paruss.capstone.socialnetworks.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CommunitiesGraph implements Graph {

	private HashMap<Integer, HashSet<Integer>> graphMap;

	public CommunitiesGraph() {
		graphMap = new HashMap<Integer, HashSet<Integer>>();
	}

	public void addVertex(int num) {
		this.graphMap.put(num, new HashSet<Integer>());

	}

	public void addEdge(int from, int to) {
		graphMap.get(from).add(to);

	}

	public HashMap<Integer, HashSet<Integer>> exportGraph() {
		return graphMap;
	}

	public HashSet<Integer> getUnfriendables(int user) {
		HashSet<Integer> friends = graphMap.get(user);
		return friends;
	}

}
