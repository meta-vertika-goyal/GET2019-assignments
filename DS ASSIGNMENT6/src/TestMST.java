import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;
public class TestMST {
	@Test
	public void testMST() {
		Graph graph=new Graph(5);
		LinkedList<Edge> adjacentVertices;
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(1,2,2));
			add(new Edge(1,3,5));
		}};
		graph.addEdge(1, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(2,1,2));
			add(new Edge(2,4,4));
			add(new Edge(2,3,2));
		}
		};
		graph.addEdge( 2, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(3,1,5));
			add(new Edge(3,4,5));
			add(new Edge(3,2,2));
			add(new Edge(3,5,5));}
		};
		graph.addEdge(3, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(4,5,2));
			add(new Edge(4,3,5));
			add(new Edge(4,2,4));
		}
		};
		graph.addEdge(4, adjacentVertices );
		adjacentVertices = new LinkedList<Edge>() { {
			add(new Edge(5,3,5));
			add(new Edge(5,4,2));}
		};
		graph.addEdge(5, adjacentVertices );
		Graph mst=new Graph(5);
		LinkedList<Edge> adjacentVerticesMST;
		adjacentVerticesMST = new LinkedList<Edge>() { {
			add(new Edge(1,2,2));

		}};
		mst.addEdge(1, adjacentVerticesMST );
		adjacentVerticesMST = new LinkedList<Edge>() { {
			add(new Edge(2,3,2));
		}
		};
		mst.addEdge( 2, adjacentVerticesMST );
		adjacentVerticesMST = new LinkedList<Edge>() { {
			add(new Edge(3,4,4));}

		};
		mst.addEdge(3, adjacentVerticesMST );
		adjacentVerticesMST = new LinkedList<Edge>() { {
			add(new Edge(4,5,2));
		}
		};
		mst.addEdge(4, adjacentVerticesMST );
		adjacentVerticesMST = new LinkedList<Edge>() { };
		mst.addEdge(5, adjacentVerticesMST );
		Graph actualMST=graph.mst(1);
		actualMST.showGraph();
		for( int i = 1; i <= 5; i++ ) {
			adjacentVertices = actualMST.adjacencyList[i];
			adjacentVerticesMST=mst.adjacencyList[i];
			for(int j=0; j < adjacentVertices.size(); j++) {
				assertEquals(adjacentVertices.get(j).destinationVertex,adjacentVerticesMST.get(j).destinationVertex);
				assertEquals(adjacentVertices.get(j).weight,adjacentVerticesMST.get(j).weight);
			}
		}
	}
}
