package paruss.capstone.socialnetworks.graph;

import java.util.HashMap;
import java.util.HashSet;

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
		HashSet<Integer> unfriendables = new HashSet<Integer>();
		for(Integer friend : friends){
			HashSet<Integer> friendsFriends = graphMap.get(friend);
			friendsFriends.remove(user);
			if(friendsFriends.isEmpty()){
				unfriendables.add(friend);
			}
			for(Integer friendsFriend :friendsFriends){
				if(!friends.contains(friendsFriend)){
					unfriendables.add(friend);
				}
			}
			
		}
		return unfriendables;
	}
}
