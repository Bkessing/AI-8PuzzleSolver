package search;

import java.util.ArrayList;

/*
 * SuccessorFunction takes a node and returns and array list of all possible states that can be reached from the node's state.
 */

public class SuccessorFunction {

	public ArrayList<Node> getSuccessors(Node node) {
		int[][] state = node.getState();
		ArrayList<Node> successors = new ArrayList<Node>();
		int x = 0;
		int y = 0;

		// for look the finds the element 0 in the 2d array.
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				if (state[i][j] == 0) {
					y = i;
					x = j;
				}
			}
		}
		
		// each of these cases checks to see if swapping the 0 element with an element around it would cause an out of bounds exception
		//if it would not cause an exception we created a new node with the swapped elements 
		// we set the path cost, in this case it is the element that is being moved
		// we set the action (up,down,left,right)
		// we set the path cost by using the parents path cost
		// we then add the new node to the array list

		if (y != 0) {
			Node newNode = new Node((this.swap(state, x, y, x, y - 1)));
			newNode.setDepth(node.getDepth() + 1);
			newNode.setPathCost(state[y - 1][x]);
			newNode.setAction("Down");
			newNode.setTotalCost(node.getTotalCost() + newNode.getPathCost());
			successors.add(newNode);
		}
		if (y != 2) {
			Node newNode = new Node((this.swap(state, x, y, x, y + 1)));
			newNode.setDepth(node.getDepth() + 1);
			newNode.setPathCost(state[y + 1][x]);
			newNode.setAction("Up");
			newNode.setTotalCost(node.getTotalCost() + newNode.getPathCost());
			successors.add(newNode);
		}
		if (x != 2) {
			Node newNode = new Node((this.swap(state, x, y, x + 1, y)));
			newNode.setDepth(node.getDepth() + 1);
			newNode.setPathCost(state[y][x + 1]);
			newNode.setAction("Left");
			newNode.setTotalCost(node.getTotalCost() + newNode.getPathCost());
			successors.add(newNode);
		}
		if (x != 0) {
			Node newNode = new Node((this.swap(state, x, y, x - 1, y)));
			newNode.setDepth(node.getDepth() + 1);
			newNode.setPathCost(state[y][x - 1]);
			newNode.setAction("Right");
			newNode.setTotalCost(node.getTotalCost() + newNode.getPathCost());
			successors.add(newNode);
		}

		return successors;

	}

	// helper functions that takes the zero element held at y,x and swap it with the requested element held at y1,x1
	private int[][] swap(int[][] state, int x1, int y1, int x2, int y2) {
		int[][] newState = new int[3][3];
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				newState[i][j] = state[i][j];
			}
		}
		int hold = newState[y1][x1];
		newState[y1][x1] = newState[y2][x2];
		newState[y2][x2] = hold;
		return newState;

	}

}
