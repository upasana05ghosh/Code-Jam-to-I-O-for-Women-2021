import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**



Problem
Link to problem: https://codingcompetitions.withgoogle.com/codejamio/round/00000000004360f2/0000000000777c68

Izabella and Olga are playing a game alternating turns.
Izabella plays first. The game starts with all game pieces arranged in a single row.
The pieces come in two colors: indigo and orange. During Izabella's turns, she must choose and remove an indigo piece that is either the leftmost or rightmost piece remaining. 
During Olga's turns, she must choose and remove an orange piece that is either the leftmost or rightmost piece remaining.
If at any point one of the players does not have a legal move (possibly because there are no pieces remaining), that player loses the game, and the other player is awarded 1
point plus 1 additional point for each piece that remains on the board.

We use an uppercase letter I to represent indigo pieces and an uppercase letter O to represent orange pieces.
Suppose, for example, that they play with the following starting board: IOIOOOII.

On her first turn, Izabella can choose to remove either the leftmost or rightmost pieces, as both are indigo. 
Suppose she chooses the leftmost. Then, the board would become OIOOOII.
Then, Olga would have no choice but to remove the new leftmost piece, as the rightmost piece is not orange, leaving IOOOII.
Izabella can choose again, and this time she chooses the rightmost piece, leaving IOOOI for Olga's turn.
At this point, Olga has no valid move, so Izabella won. Since there are 5 pieces remaining, Izabella wins 1+5=6 points in total.

Each player plays optimally trying to win and to maximize their own score. A player that cannot guarantee a win plays to minimize the opponent's score.

Given the starting board, can you find out who wins and what is their score?
Input

The first line of the input gives the number of test cases, T. T lines follow.
Each line represents a test case and contains a string B representing the status of the board. The i-th character in B is I if the i

-th piece from the left is indigo and O if it is orange.
Output

For each test case, output one line containing Case #x: y z, where x is the test case number (starting from 1),
y is the initial of the winner (I for Izabella or O for Olga), and z

is the score the winner gets.
Limits



*/
public class IrrefutableOutcome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			String s = sc.next();
			char turn = 'I';
			int m = s.length();
			int start = 0, end = m - 1;

			while (start <= end) {
				if (s.charAt(start) == turn && s.charAt(end) == turn) {
					int k = start + 1, j = end - 1;
					int countS = 0, countE = 0;
					while ((k < m && j >= 0) && (countS == countE)) {
						if (s.charAt(k++) == turn)
							countS++;
						if (s.charAt(j--) == turn)
							countE++;
					}
					if (countS >= countE)
						start++;
					else
						end--;
				} else if (s.charAt(start) == turn) {
					start++;
				} else if (s.charAt(end) == turn) {
					end--;
				} else {
					break;
				}
				turn = (turn == 'I' ? 'O' : 'I');
			}

			char win = turn == 'I' ? 'O' : 'I';

			int val = end - start + 2;
			System.out.println("Case #" + i + ": " + win + " " + val);
		}

		sc.close();

	}

}
