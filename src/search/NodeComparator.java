package search;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	public int compare(Node node1, Node node2) {

		if (node1.getTotalCost() < node2.getTotalCost()) {
			return -1;
		}
		if (node1.getTotalCost() > node2.getTotalCost()) {
			return 1;
		}

		return 0;

	}

}
