package paruss.capstone.socialnetworks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

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
	
	@Test
	public void givenHasTwoFriendsWhoAreFriendsIsEmpty(){
		Graph graph = new CommunitiesGraph();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		HashSet<Integer> unfriendables = graph.getUnfriendables(1);
		assertThat(unfriendables).isEmpty();
	}
	
	@Test
	public void givenHasTwoFriendsWhoAreNotFriendsReturnsThoseFriends(){
		Graph graph = new CommunitiesGraph();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		HashSet<Integer> unfriendables = graph.getUnfriendables(1);
		assertThat(unfriendables).contains(3, 2);
	}
	
	@Test
	public void givenHasFourFriendsOneOfWhichHasNoFriendsReturnsThatFriend(){
		Graph graph = new CommunitiesGraph();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 1);
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		HashSet<Integer> unfriendables = graph.getUnfriendables(1);
		assertThat(unfriendables).contains(4);
	}

}
