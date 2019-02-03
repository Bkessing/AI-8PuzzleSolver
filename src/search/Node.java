package search;

import java.util.ArrayList;

/*
 * Node class holding all information needed for algorithms and logistics 
 */

public class Node {
	private int[][] state;
	private Node parentNode;
	private ArrayList<Node> childrenNodes = new ArrayList<Node>();
	private String action;
	private int depth;
	private int pathCost;
	private int totalCost;
	private String stringState;
	private int h;

	public Node(int[][] state) {
		this.state = state;
		this.depth = 0;
		this.pathCost = 0;
		this.totalCost = 0;
		this.toStateString();

	}

	public int[][] getState() {
		return state;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}

	public ArrayList<Node> getChildrenNodes() {
		return childrenNodes;
	}

	public void setChildrenNodes(Node child) {
		childrenNodes.add(child);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getPathCost() {
		return pathCost;
	}

	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}


	public String getStringState() {
		return stringState;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	private void toStateString() {
		stringState = "";
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				stringState = stringState + state[i][j];
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringState == null) ? 0 : stringState.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (stringState == null) {
			if (other.stringState != null)
				return false;
		} else if (!stringState.equals(other.stringState))
			return false;
		return true;
	}
	
	

}
