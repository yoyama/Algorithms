package sort.youy.jp;

import java.util.Random;


public class QuickSort<T extends Comparable<T>> {
	public void sort(T[] ar) {
		shuffle(ar);
		sort(ar, 0, ar.length-1);
	}
	
	private void sort(T[] ar, int lo, int hi) {
		if(lo >= hi)
			return;
		int vidx = partition(ar, lo, hi);
		sort(ar, 0, vidx-1);
		sort(ar, vidx+1, hi);
		
	}
	
	private int partition(T[]ar, int lo, int hi) {
		T v = ar[lo];
		int i = lo;
		int j = hi+1;
		while(true) {
			while(ar[++i].compareTo(v) <= 0) {
				if(i >= hi)
					break;
			}
			while(ar[--j].compareTo(v) >= 0) {
				if(j <= lo)
					break;
			}
			if(i >= j)
				break;
			T tmp = ar[i];
			ar[i] = ar[j];
			ar[j] = tmp;
		}
		ar[lo] = ar[j];
		ar[j] = v;
		//System.out.printf("lo:%d hi:%d j:%d\n", lo, hi, j);
		//print(ar);
		return j;
	}
	
	public void print(T[] values) {
		for(T i: values) {
			System.out.printf("%s ", i);
		}
		System.out.println("");
	}
	
	public void shuffle(T[] ar) {
		int hi = ar.length-1;
		Random rnd = new Random();
		while(hi > 0) {
			int idx = rnd.nextInt(hi);
			T tmp = ar[idx];
			ar[idx] = ar[hi];
			ar[hi] = tmp;
			hi--;
		}
	}

	public static void main(String[] args) {
		Integer[] values = {1,2,3,4,5,6,7,8,9,10};
		QuickSort<Integer> isort = new QuickSort<>();
		isort.shuffle(values);
		isort.print(values);
		isort.sort(values);
		isort.print(values);

	}


}
