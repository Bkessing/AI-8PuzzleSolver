package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/*
 * DFS takes a starting state and a goal state and find the goal state using Depth First Search.
 */


public class DFS {
	private Node root;
	private String goal;
	private Printer printer;
	private SuccessorFunction successorFunction;

	public DFS(int[][] start, String goal) {
		this.goal = goal;
		this.root = new Node(start);
		this.printer = new Printer();
		this.successorFunction = new SuccessorFunction();
	}

	public void search() {
		long startTime = System.nanoTime();
		int dequeue = 0;
		int maxQueue = 0;

		// Visited holds all states that are either in the queue or have been dequeued.
		// Uses a stack instead of a queue to pop nodes off in first come first out order. 
		Set<String> visited = new HashSet<String>();
		Stack<Node> stack = new Stack<Node>();

		Node current = root;
		
		// Looks at current node.state and checks to see if it is equal to the goal state.
		while (!current.getStringState().equals(goal)) {
			
			// add current state to visited set
			visited.add(current.getStringState());
			
			//getSuccessors returns all children of the parent node. 
			ArrayList<Node> nodeSuccessors = successorFunction.getSuccessors(current);
			
			// For each child that is not in the visited set we:
			// add them to visitor set
			// add them to the parents child array
			// set their parent node to the current node
			// and them to the stack
			for (Node successor : nodeSuccessors) {
				if (!visited.contains(successor.getStringState())) {
					visited.add(successor.getStringState());
					current.setChildrenNodes(successor);
					successor.setParentNode(current);
					stack.add(successor);
				} 
			}
			
			// if stack is not empty then we set current to stack.pop()
			if (!stack.isEmpty()) {
				if (maxQueue < stack.size()) {
					maxQueue = stack.size();
				}
				
				dequeue++;
				current = stack.pop();
				
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
