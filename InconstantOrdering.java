import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**

Problem
Link to problem : https://codingcompetitions.withgoogle.com/codejamio/round/00000000004360f2/00000000007772ed

We want to build a string with English alphabet uppercase letters in sorted order.
However, we want the order to be sometimes strictly increasing and sometimes strictly decreasing.

The first letter of the string must be A. After that, the string must contain one or more blocks of letters. 
The i-th block must contain exactly Li letters. Each letter in the i-th block must be later in the alphabet than 
its preceding letter in the string if i is odd and earlier in the alphabet than its preceding letter if i
is even. 

Notice that for the first letter of a block, its preceding letter exists, even though it is not in the block. 
Strings that follow all of these rules are called valid. There can be multiple valid strings, and we want to find the alphabetically first one.

For example, if there are 2
blocks of sizes L1=2 and L2=3, the string must have exactly 1+L1+L2=1+2+3=6 letters (the 1 is for the initial A).
The strings XYZYBA, AZYCBA and AYZYBB are not valid for this case because they violate the required starting letter condition, 
and the ordering conditions in the first and second block, respectively. 
The string AYZYBA is valid. The string ABDCBA is also valid and, moreover, it is the alphabetically first valid string.

Given the sizes of the blocks, output the valid string that comes first in alphabetical order in the list of all valid strings. It can be shown that, for all inputs within the given limits, at least one valid string exists.
Input

The first line of the input gives the number of test cases, T. T test cases follow. 
Each test case is described with two lines. The first line of a test case contains a single integer N, the number of blocks.
The second line contains N integers L1,L2,…,LN, the number of letters each block must have, in order.
Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1)
and y is the valid string that comes first in alphabetical order. It is guaranteed that at least one valid string exists. 
 */

public class InconstantOrdering {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			int l = sc.nextInt();
			int a[] = new int[l];
			StringBuilder sb = new StringBuilder("A");

			for (int j = 0; j < l; j++)
				a[j] = sc.nextInt();
			char prev = 'A';
			for (int j = 0; j < l; j++) {
				if (j % 2 != 1) {
					while (a[j] > 1) {
						prev++;
						sb.append(prev);
						a[j]--;
					}
					if (j < l - 1)
						prev = (char) Math.max(prev + 1, 'A' + a[j + 1]);
					else
						prev++;
					sb.append(prev);
				} else {
					while (a[j] > 0) {
						prev = (char) ('A' + a[j] - 1);
						sb.append(prev);
						a[j]--;
					}
				}
			}

			System.out.println("Case #" + i + ": " + sb.toString());
		}

		sc.close();

	}

}
