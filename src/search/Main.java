package search;

import java.util.Scanner;


/*
 * Created by Brandon Kessinger.
 */


public class Main {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		int[][] hardStartState = new int[][] { { 5, 6, 7 }, { 4, 0, 8 }, { 3, 2, 1 } };
		int[][] mediumStartState = new int[][] { { 2, 8, 1 }, { 0, 4, 3 }, { 7, 6, 5 } };
		int[][] easyStartState = new int[][] { { 1, 3, 4 }, { 8, 6, 2 }, { 7, 0, 5 } };

		String goal = "123804765";

		int[][] state = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		System.out.println("Enter the number for the corrisponding algorithm you would like to use: ");
		System.out.println("1 : BFS");
		System.out.println("2 : DFS");
		System.out.println("3 : UCS");
		System.out.println("4 : BestFS");
		System.out.println("5 : A*1");
		System.out.println("6 : A*2");

		int n = reader.nextInt();

		System.out.println("Enter the number for the corrisponding difficulty you would like to use: ");
		System.out.println("1 : Easy");
		System.out.println("2 : Medium");
		System.out.println("3 : Hard");

		int d = reader.nextInt();

		switch (d) {

		case 1:
			state = easyStartState;
			break;

		case 2:
			state = mediumStartState;
			break;

		case 3:
			state = hardStartState;
			break;
		}

		switch (n) {

		case 1:
			BFS bfs = new BFS(state, goal);
			bfs.search();
			break;

		case 2:
			DFS dfs = new DFS(state, goal);
			dfs.search();
			break;

		case 3:
			UCS ucs = new UCS(state, goal);
			ucs.search();
			break;

		case 4:
			BestFS bestfs = new BestFS(state, goal);
			bestfs.search();
			break;

		case 5:
			AStar astar1 = new AStar(state, goal);
			astar1.search(new H1());
			break;

		case 6:
			AStar astar2 = new AStar(state, goal);
			astar2.search(new H2());
			break;

		}
		
		reader.close();

	}
}
