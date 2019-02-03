package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * AStar takes a starting state and a goal state and find the goal state using A*.
 */

public class AStar {
	private Node root;
	private String goal;
	private Printer printer;
	private SuccessorFunction successorFunction;

	public AStar(int[][] start, String goal) {
		this.root = new Node(start);
		this.goal = goal;
		this.printer = new Printer();
		this.successorFunction = new SuccessorFunction();

	}

	public void search(Heuristic h) {

		long startTime = System.nanoTime();
		int dequeue = 0;
		int maxQueue = 0;

		// Visited holds all states that are either in the queue or have been dequeued.
		// Uses a priority queue with a comparator that looks at the heuristic value, for this I set each nodes h to the heuristic value + path cost
		
		Set<String> visited = new HashSet<String>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, new NodeComparatorUsingH());

		Node current = root;
		
		// set the starting node's h 
		current.setH(h.getHeuristic(current, goal) + current.getTotalCost());
		
		while (!current.getStringState().equals(goal)) {
			
			// add current state to visited set
			visited.add(current.getStringState());
			
			//getSuccessors returns all children of the parent node. 
			ArrayList<Node> nodeSuccessors = successorFunction.getSuccessors(current);

			// 	// set the heuristic value for each child (heuristic value + path cost)
			// For each child that is not in the visited set we:
			// add them to visitor set
			// add them to the parents child array
			// set their parent node to the current node
			// add them to the stack
			for (Node successor : nodeSuccessors) {
				successor.setH(h.getHeuristic(successor, goal) + successor.getTotalCost());
				if (!visited.contains(successor.getStringState())) {
					visited.add(successor.getStringState());
					current.setChildrenNodes(successor);
					successor.setParentNode(current);
					queue.add(successor);
				}

			}

			// if queue is not empty then we set current to queue.poll()
			if (queue.peek() != null) {
				if (maxQueue < queue.size()) {
					maxQueue = queue.size();

				}
				dequeue++;
				current = queue.poll();

			} else {
				System.out.println("failed");
				return;
			}
		}

		// logistics and printing
		long endTime = System.nanoTime();
		long timeElapsed = (endTime - startTime) / 1000000;

		printer.printPath(current);
		printer.printLogistics(current, dequeue, timeElapsed, maxQueue);
	}

}
