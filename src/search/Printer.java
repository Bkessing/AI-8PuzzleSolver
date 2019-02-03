package search;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Printer is a class that has two important methods
 * One for getting logistics printLogistics()
 * One for printing the path to the goal state printPath()
 */

public class Printer {

	// function that prints the path from start to goal
	// Uses helper function getPath() and formatter()
	public void printPath(Node end) {
		ArrayList<Node> path = this.getPath(end);
		for (int i = 0; i < path.size(); i++) {
			this.formatter(path.get(i));
		}

	}

	// function that returns all the logistics of running a specific algorithm
	public void printLogistics(Node end, int dequeue, long time, int maxQueue) {
		System.out.println("");
		System.out.println("Total cost to get to goal state: " + end.getTotalCost());
		System.out.println("Goal state found at depth: " + end.getDepth());
		System.out.println("Elapsed execution time in milliseconds: " + time);
		System.out.println("Number of nodes dequeued: " + dequeue);
		System.out.println("Max number on queue: " + maxQueue + "\n");

	}

	// get path takes the end node and adds all the nodes up to the starting node into a list
	// that list is then reversed and returned 
	private ArrayList<Node> getPath(Node end) {
		ArrayList<Node> path = new ArrayList<Node>();
		Node current = end;
		while (current.getParentNode() != null) {
			path.add(current);
			current = current.getParentNode();
		}
		path.add(current);
		Collections.reverse(path);

		return path;

	}

	// formatter takes the string state of each node in order of start to finish and prints it into a neat board like fashion
	// also adds some logistics to the top of each state
	private void formatter(Node node) {
		if (node.getAction() != null) {
			System.out.println("Cost of move: " + node.getPathCost());
			System.out.println("Action: " + node.getAction());
		} else {
			System.out.println("Starting Node");
		}
		String state = node.getStringState();
		for (int i = 0; i < state.length(); i++) {
			if (i == 3) {
				System.out.println("");
			}
			if (i == 6) {
				System.out.println("");
			}

			System.out.print("     " + state.charAt(i));

		}
		System.out.println("");
		System.out.println("--------------------------------");

	}

}
