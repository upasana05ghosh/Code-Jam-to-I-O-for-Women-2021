import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**       
 **************************     Problem **********************************8
 Link to problem: https://codingcompetitions.withgoogle.com/codejamio/round/00000000004360f2/0000000000777098

 Aroha is a big animal lover, so she spends some free time taking care of many of her loved ones' pets. She likes to offer them treats, but wants to do that in an impartial way.

Aroha decided that it was logical for pets of the same size to get the same amount of treats and for larger pets to get strictly more treats than smaller ones. For example, if she has 4
pets with her of sizes 10,20,10, and 25, she could offer 2 treats to each pet of size 10, 3 treats to the pet of size 20, and 5 treats to the pet of size 25. 
This requires her to buy a total of 2+3+2+5=12 treats. 
However, she can offer treats to all 4 pets and comply with her own rules with a total of just 7 treats by offering 1 each to the pets of size 10, 
2 to the pet of size 20, and 3 to the pet of size 25.

Help Aroha plan her next pet day. Given the sizes of all pets that will accompany her, compute the minimum number of treats she needs to 
buy to be able to offer at least one treat to all pets while complying with her impartiality rules.

Input

The first line of the input gives the number of test cases, T. T test cases follow. 
Each test case consists of two lines.
The first line of a test case contains a single integer N, the number of pets in Aroha's next pet day.
The second line of a test case contains N integers S1,S2,…,SN, representing the sizes of each pet.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y
is the minimum number of treats she needs to buy to be able to offer at least one treat to all pets while complying with her impartiality rules.
Limits

Time limit: 10 seconds.
Memory limit: 1 GB.
1≤T≤100
.
1≤Si≤100, for all i.
 */

public class ImpartialOfferings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		int mycase = 1;
		while (t-- > 0) {
			int n = sc.nextInt();

			Map<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < n; i++) {
				int val = sc.nextInt();
				map.put(val, map.getOrDefault(val, 0) + 1);
			}

			int count = 1, res = 0;
			for (int key : map.keySet()) {
				res += (count++) * map.get(key);
			}

			System.out.println("Case #" + mycase + ": " + res);
			mycase++;
		}
		sc.close();

	}

}
