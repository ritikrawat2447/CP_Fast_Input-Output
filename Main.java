// @Author : Ritik Rawat

import java.util.*;
import java.math.*;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer> prime = new ArrayList<>();
	static int mod = 998244353 ;
	static ArrayList<Integer> arr;
	static ArrayList<Long> prefix;
	static ArrayList<Long> pre = new ArrayList<>();

	static int dr[] = {0, 1, 0, -1};
	static int dc[] = { -1, 0, 1, 0};
	static String direction = "LDRU";

	static long preFix[] = new long[(int)1e6 + 1];

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine().trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
		public int[] nextIntArr() throws IOException {
			String[] str = br.readLine().split("\\s+");
			int[] inp = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				inp[i] = Integer.parseInt(str[i]);
			}
			return inp;
		}
	}
	static class FastWriter {
		private final BufferedWriter bw;
		public FastWriter() {
			this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}
		public void print(Object object) throws IOException {
			bw.append("" + object);
		}
		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}
		public void close() throws IOException {
			bw.close();
		}
	}
	public static class Pair {
		int a ;
		int d;
		Pair( int a, int d) {
			this.a = a;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			FastWriter out = new FastWriter();

			int testcases = in.nextInt();
			while ( testcases-- > 0 ) {
				int ans1 = 0, ans2 = 0, ans3 = 0, ans4 = 0 ;
				long ans5 = 0;
				String ans = "NO";

				int n = in.nextInt();
				int k = in.nextInt();
				int arr[] = in.nextIntArr();

				// for ( int i = 0; i < n; i += 2 ) {
				// 	if ( i < k && i != arr[i] ) ans1++;
				// 	if ( i > k && arr[i] != (i + 1) ) ans1++;
				// 	if ( i == k && arr[i] == k ) ans1++;
				// }

				HashSet<Integer> hs = new HashSet<>();
				for ( int i : arr ) { hs.add(i); if ( i == k ) ans2++; }
				for (int i = 0; i < k; i++) {
					if (!hs.contains(i)) ans1++;
				}
				ans1 = Math.max(ans2, ans1);
				out.println(ans1);

			}


			out.close();

		} catch (Exception e) {
			return;
		}




		// Collections.sort(arr, new Comparator<Pair>() {
		// 		@Override public int compare(Pair o1, Pair o2) {
		// 			if (o1.second < o2.second ) { // change (>) for desending order
		// 				return -1;
		// 			} else if (o1.second == o2.second ) {
		// 				return 0;
		// 			} else {
		// 				return 1;
		// 			}
		// 		}
		// 	});

		// Collections.sort(arr, (list1, list2) -> {
		//     // Compare the first elements of each list
		//     return list1.get(0).compareTo(list2.get(0));
		// });

	}

	private static int type1(String s) {
		char ch[] = s.toCharArray();
		int l = 1 , r = s.length() - 2;
		return 0;
	}

	private static void addEle( ArrayList<Integer> arr , HashMap<Integer, Integer> hm ) {
		for ( int i : arr ) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
	}

	private static void removeEle( ArrayList<Integer> arr , HashMap<Integer, Integer> hm ) {
		for ( int i : arr ) {
			hm.put(i, hm.get(i) - 1);
			if ( hm.get(i) == 0 ) hm.remove(i);
		}
	}

	private static int satisfy(int x , int i , int n) {
		int left = i + 1;
		int right = n - i;
		int op = x / right;
		int rem = x % right;
		if (rem % left != 0 ) return -1;
		return op + ( rem / left );
	}
	private static int f(int wt[] ) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for ( int i : wt ) {
			pq.add(i);
		}
		while ( !pq.isEmpty() ) {
			if ( pq.size() == 1 ) return pq.remove();
			int x = pq.remove();
			int y = pq.remove();
			if ( x == y ) continue;
			else if ( x < y ) pq.add(x);
			else pq.add(y);
		}
		return 0;
	}



	public static void swap ( int l , int r , ArrayList<Integer> a ) {
		int t = a.get(l) ;
		a.add(l, a.get(r) );
		a.add(r, t);
	}

	public static void fib( int a , int b , int n) {
		int x = Math.floorMod(a, mod);
		int y = Math.floorMod(b, mod);
		arr = new ArrayList<>();
		arr.add(a);
		arr.add(b);
		for ( int i = 2; i <= n; ++i ) {
			int cur = Math.floorMod((y - x), mod);
			x = y;
			y = cur;
			arr.add(y);
		}
	}

	public static long countSetBits(long n) {
		long count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	public static long pow( long k , long n ) {
		long ans = 1;
		while ( n > 0 ) {
			if ( n % 2 == 1 ) {
				ans = (ans * k) % mod;
				n--;
			} else {
				k = (k * k) % mod;
				n /= 2;
			}
		}
		return ans % mod;
	}

	public static long fact(long n ) {
		long ans = 0;
		for (int i = 1; i < n; ++i) {
			ans += (long)i;
		}
		return ans;
	}


	public static String sortString(String inputString) {
		char tempArray[] = inputString.toCharArray();
		Arrays.sort(tempArray);
		return new String(tempArray);
	}

	private static void reverse( ArrayList<Long> arr , int i, int j ) {
		while ( i <= j ) {
			swap( arr, i, j);
			i++; j--;
		}
	}

	private static void swap( ArrayList<Long> arr , int i, int j ) {
		long temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

	private static boolean isPrime(long n ) {
		if ( n <= 1 ) return false;

		for ( int i = 2; i * i <= n; i++) {
			if ( n % i == 0 ) {
				return false ;
			}
		}
		return true;
	}

	private static boolean[] sieve() {
		int n = 100000;
		boolean sieve[] = new boolean[n + 1];
		Arrays.fill(sieve, true);
		for ( int i = 2; i * i <= n; i++) {
			for ( int j = i * i; j <= n; j += i) {
				sieve[j] = false;
			}
		}
		return sieve;
	}

	private static ArrayList<Integer> generatePrimes(int n ) {
		boolean sieve[] = sieve();
		for ( int i = 2; i <= n; i++) {
			if ( sieve[i] == true ) {
				prime.add(i);
			}
		}
		return prime;
	}

	private static void segmentedSieve( int l  , int r ) {
		int n = (int) Math.sqrt(r);
		ArrayList<Integer> pr = generatePrimes(n);
		int dummy[] = new int[r - l + 1];
		Arrays.fill(dummy, 1);

		for ( int p : pr ) {

			int firstMultiple = (l / p) * p;
			if ( firstMultiple < l ) firstMultiple += p;
			for ( int j = Math.max(firstMultiple, p * p); j <= r; j += p) {
				dummy[j - l] = 0;
			}
		}

		for ( int i = l; i <= r; i++) {
			if ( dummy[i - l] == 1 ) {
				System.out.println(i);
			}
		}
	}

	private static int[] primeFactors() {
		int n = (int) 1e9;
		int prime[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prime[i] = i;
		}
		for (int i = 2; i * i <= n; i++) {
			if ( prime[i] == i ) {
				for (int j = i * i; j <= n; j += i) {
					if ( prime[j] == j ) {
						prime[j] = i;
					}
				}
			}
		}
		return prime;
	}

	private static void primeFactors(HashSet<Integer> hs , int n ) {
		for ( int i = 2; i * i <= n; ++i ) {
			if ( n % i == 0 ) {
				int c = 0;
				while ( n % i == 0 ) {
					c++;
					n /= i;
				}
				while ( c-- > 0) hs.add(i);
			}
		}
		if ( n > 1 ) hs.add(n);
	}

	private static boolean isPalindrome(String s ) {
		int i = 0, j = s.length() - 1;
		while ( i <= j ) {
			if ( s.charAt(i) != s.charAt(j) ) {
				return false;
			}
			i++; j--;
		}
		return true;
	}

	private static long power( long a , long b ) {
		long ans = 1;
		while ( b > 0 ) {
			if ( (b & 1) != 0 ) {
				ans = binMultiply(ans, a);
			}
			a = binMultiply(a, a );
			b >>= 1;
		}
		return ans;
	}

	private static long binMultiply(long a , long b ) {
		long ans = 0;
		while ( b > 0 ) {
			if ( (b & 1) != 0 ) {
				ans = (ans + a % mod ); // if  m is given in ques than use ans = ans+a % m ;
			}
			a = (a + a) % mod; // if m is given in ques than use a = (a+a)%m;
			b >>= 1;
		}
		return ans;
	}

	private static long GCD ( long a , long b ) {
		if ( b == 0) return a;
		return GCD( b , a % b);
	}

	private static int binarySearch(int l , int r , int[] arr , int find ) {
		int mid = l + (r - l) / 2;
		if ( arr[mid] == find ) {
			return mid;
		} else if ( arr[mid] > find ) {
			return binarySearch(l, mid - 1, arr, find);
		}

		return binarySearch(mid + 1, r, arr, find);
	}

	private static int upper_bound(ArrayList<Integer> arr , int element ) {
		int l = 0 ;
		int h = arr.size() - 1;
		int mid = 0;
		while ( h - l > 1 ) {
			mid = (h + l) / 2;
			if ( arr.get(mid) <=  element ) {
				l = mid + 1;
			} else {
				h = mid ;
			}
		}
		if ( arr.get(l) > element ) return l;
		if ( arr.get(h) > element ) return h;
		return -1;
	}

	private static int lower_bound( long arr[] , long element ) {
		int l = 0 ;
		int h = arr.length - 1;
		int mid = 0;
		while ( h - l > 1 ) {
			mid = (h - l) / 2;
			if ( arr[mid] < element ) {
				l = mid + 1;
			} else {
				h = mid ;
			}
		}
		if ( arr[l] >= element ) return l;
		if ( arr[h] >= element ) return h;
		return -1;
	}

//////////////////////////////////////////// #### CODE FOR FAST READER WRITTER ### /////////////////////////////////////////////



//////////////////////////////////////// #### END FOR FAST READER WRITTER ### //////////////////////////////////////////////////


}

class DisjointSet {
	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();

	public DisjointSet(int n ) {
		for ( int i = 0; i <= n; ++i ) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}
	public int findUPar(int node ) {
		if ( node == parent.get(node) ) return node;
		int ulp = findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	public void unionBySize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if ( ulp_u == ulp_v ) return ;
		if ( size.get(ulp_u) < size.get(ulp_v) ) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u) );
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u) );
		}
	}
	public void unionByRank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if ( ulp_u == ulp_v ) return ;
		if ( rank.get(ulp_u) < rank.get(ulp_v) ) {
			parent.set(ulp_u, ulp_v);
		} else if ( rank.get(ulp_v) < rank.get(ulp_u) ) {
			parent.set(ulp_v, ulp_u);
		} else {
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU + 1);
		}
	}
}

class SegmentTree {

	int seg[];
	SegmentTree(int n ) {
		seg = new int[4 * n + 1];
	}

	public void  build( int ind , int low , int high , int arr[] , boolean orr ) {
		if ( low == high ) {
			seg[ind] = arr[low];
			return;
		}
		int mid = (low + high) / 2;
		build( 2 * ind + 1, low, mid, arr , !orr );
		build( 2 * ind + 2, mid + 1, high, arr , !orr );
		if ( orr ) {
			seg[ind] = (seg[2 * ind + 1] | seg[2 * ind + 2]);
		} else {
			seg[ind] = ( seg[2 * ind + 1] ^ seg[2 * ind + 2] );
		}
	}

	public int query( int ind, int low, int high, int l, int r ,  boolean or ) {

		// no overlap
		if ( r < low || l > high ) {
			return Integer.MAX_VALUE;
		}
		// complete overlap
		if ( l <= low && high <= r ) {
			return seg[ind];
		}
		// partial overlap
		int mid = (low + high) / 2;
		int left = query(2 * ind + 1, low, mid, l, r , ! or );
		int right = query(2 * ind + 2, mid + 1, high, l, r , ! or );
		if ( or ) {
			return seg[ind] = seg[2 * ind + 1] | seg[2 * ind + 2];
		}
		return seg[ind] = seg[2 * ind + 1] ^ seg[2 * ind + 2];
	}

	public void update(int ind, int low, int high, int i, int val, boolean or ) {
		if ( low == high ) {
			seg[ind] = val;
			return;
		}
		int mid = (low + high) / 2;
		if ( i <= mid ) update(2 * ind + 1, low, mid, i, val , ! or );
		else update(2 * ind + 2, mid + 1, high, i, val , ! or );
		if ( or ) {
			seg[ind] = (seg[2 * ind + 1] | seg[2 * ind + 2]);
		} else {
			seg[ind] = ( seg[2 * ind + 1] ^ seg[2 * ind + 2] );
		}
	}
	public void printArray() {
		for ( int i : seg ) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}

