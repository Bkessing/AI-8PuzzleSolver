package search;

/*
 * This heuristic estimates the cost to goal by calculating the Manhattan distance for each number that is misplaced. 
 */

public class H2 implements Heuristic {

	@Override
	public int getHeuristic(Node node, String goal) {
		// Returns the Manhattan distance for each number misplaced. 
		
		String state = node.getStringState();
		int count = 0;
		for (int i = 0; i < state.length(); i += 1)
			for (int j = 0; j < goal.length(); j += 1)
				if (state.charAt(i) == goal.charAt(j))
					count = count + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 + j / 3));
		return count;
	}

}
