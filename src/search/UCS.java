package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * UCS takes a starting state and a goal state and find the goal state using Uniform Cost Search.
 */

public class UCS {
	Node root;
	String goal;
	Printer printer;
	SuccessorFunction successorFunction;

	public UCS(int[][] start, String goal) {
		this.root = new Node(start);
		this.goal = goal;
		printer = new Printer();
		successorFunction = new SuccessorFunction();

	}

	public void search() {
		long startTime = System.nanoTime();
		int dequeue = 0;
		int maxQueue = 0;
		
		// Visited holds all states that are either in the queue or have been dequeued.
		// Uses a priority queue with a comparator that looks at the path cost of each node. 
		Set<String> visited = new HashSet<String>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(10, new NodeComparator());

		Node current = root;
		while (!current.getStringState().equals(goal)) {
			
			// add current state to visited set
			visited.add(current.getStringState());
			
			//getSuccessors returns all children of the parent node. 
			ArrayList<Node> nodeSuccessors = successorFunction.getSuccessors(current);
			
			// For each child that is not in the visited set we:
			// add them to visitor set
			// add them to the parents child array
			// set their parent node to the current node
			// add them to the stack
			for (Node successor : nodeSuccessors) {
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
