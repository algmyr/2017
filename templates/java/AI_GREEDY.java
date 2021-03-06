import java.util.ArrayList;
import java.util.List;

public class AI_GREEDY extends Strategy {

	final public static String name = "Greedy";
	
	public AI_GREEDY(int C, int N) {
		super(C, N, name);
	}
	
	@Override
	public Response step(int b, List<Integer> B, List<List<Integer>> Q) {
		// Number of passengers to board
		int n = Math.min(Q.get(b).size(), this.C - B.size());
		
		// M is the passenger selection from the queue Q[b]
		List<Integer> M = new ArrayList<>();
		// Take passengers number 0, 1, ..., (n-1)
		for (int i = 0; i < n; i++) M.add(i);
		
		// If the bus is empty, go clockwise
		if (B.isEmpty() && M.isEmpty()) return new Response(M, 1);
		
		// Destination of the oldest passenger on the bus
		int t;
		if (!B.isEmpty())
			t = B.get(0);
		else
			t = Q.get(b).get(M.get(0));
		
		// Find the direction s towards the destination t
		t = N - 2 * ((t+N-b) % N);
		int s = (t > 0) ? 1 : -1;
		
		return new Response(M, s);
	}
}

