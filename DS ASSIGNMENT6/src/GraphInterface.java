import java.util.ArrayList;
public interface GraphInterface {
	public boolean isConnected();
	public ArrayList<Integer> isReachable(int a);
	public Graph mst(int sourceVertex);
	public int shortestPath(int sourceVertex, int destinationVertex);

}
