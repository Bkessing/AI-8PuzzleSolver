package search;

/*
 * This heuristic estimates the cost to goal by calculating the number of misplaced numbers. 
 */


public class H1 implements Heuristic {

	public int getHeuristic(Node node, String goal) {
		// Returns the number of misplaced numbers
		
		String state = node.getStringState();
		int count = 0;
		for (int i = 0; i < state.length(); i++) {
			char s = state.charAt(i);
			char g = goal.charAt(i);

			if (s != g) {
				count++;
			}
		}

		return count;

	}

}
