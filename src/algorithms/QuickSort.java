package algorithms;

public class QuickSort {
	public static void sort(int[] a, int left, int right) {
		if(left < right) {
			int k = left;
			int j = right;
			int i = left + 1;
			int num = a[k];
			while(i <= j) {
				if(a[i] < num) {
					int temp = a[i];
					a[i++] = num;
					a[k++] = temp;
				} else if(a[i] > num) {
					int temp = a[j];
					a[j--] = a[i];
					a[i] = temp;
				} else {
					i++;
				}
			}
			sort(a, left, k-1);
			sort(a, k+1, right);
			
		}
		return;
	}
	public static void main(String[] args) {
		int[] a = new int[]{23, 5,10,1,42,12,57,89,23,56};
		sort(a, 0, a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
