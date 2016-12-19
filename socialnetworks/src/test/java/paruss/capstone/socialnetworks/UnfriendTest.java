package paruss.capstone.socialnetworks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import paruss.capstone.socialnetworks.graph.CommunitiesGraph;
import paruss.capstone.socialnetworks.graph.Graph;

/**
 * Unit test for simple App.
 */
public class UnfriendTest 
{
	@Test
	public void givenHasNoFriendsReturnsEmptyList(){
		Graph graph = new CommunitiesGraph();
		graph.addVertex(1);
		HashSet<Integer> unfriendables = graph.getUnfriendables(1);
		assertThat(unfriendables).isEmpty();
	}
	
	@Test
	public void givenHasOneFriendOnlyReturnsThatFriend(){
		Graph graph = new CommunitiesGraph();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addEdge(1, 2);
		HashSet<Integer> unfriendables = graph.getUnfriendables(1);
		for(Integer friend : unfriendables){
			assertThat(friend.intValue()).isEqualTo(2);
		}
			
	}
}
