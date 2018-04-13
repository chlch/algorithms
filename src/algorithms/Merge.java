package algorithms;

public class Merge {
	public static void sort(int[] a, int[] b, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(a, b, left, mid);
			sort(a, b, mid+1, right);
			merge(a, b, left, mid, right);
		}
		return;
	}
	public static void merge(int[] a, int[] b, int left, int mid, int right) {
		int i = left;
		int j = mid+1;
		for(int p = 0; p<a.length; p++) {
			b[p] = a[p];
		}
		
 		for(int k = left; k<=right; k++) {
 			if(i > mid) {
 				a[k] = b[j++];
 			} else if (j > right) {
 				a[k] = b[i++];
 			} else if (b[i] > b[j]) {
 				a[k] = b[j++];
 			} else {
 				a[k] = b[i++];
 			}
 		} 
		
		return;
	}
	public static void main(String[] args) {
		int[] a = new int[]{9,3,4,6,2,12,463,32,21,14};
		int[] b= new int[a.length];
		sort(a,b,0,a.length-1);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
