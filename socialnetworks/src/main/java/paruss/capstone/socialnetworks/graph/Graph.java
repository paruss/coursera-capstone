	package paruss.capstone.socialnetworks.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface Graph {
    /* Creates a vertex with the given number. */
    public void addVertex(int num);
    
    /* Creates an edge from the first vertex to the second. */
    public void addEdge(int from, int to);

    public HashMap<Integer, HashSet<Integer>> exportGraph();

	public HashSet<Integer> getUnfriendables(int user);
    
} 
