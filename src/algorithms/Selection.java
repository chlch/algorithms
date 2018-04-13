package algorithms;

public class Selection {
	public static void sort(int[] a) {
		int n = a.length;
		for(int i=0; i<n; i++) {
			int min = i;
			for(int j=i; j<n; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			int swap = a[i];
			a[i] = a[min];
			a[min] = swap;
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{5,4,3,6,8,3,2,94,22,12};
		sort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
