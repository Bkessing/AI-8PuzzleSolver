package search;

import java.util.Comparator;

public class NodeComparatorUsingH implements Comparator<Node> {

	public int compare(Node node1, Node node2) {

		if (node1.getH() < node2.getH()) {
			return -1;
		}
		if (node1.getH() > node2.getH()) {
			return 1;
		}

		return 0;

	}

}
