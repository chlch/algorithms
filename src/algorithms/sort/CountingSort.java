package algorithms.sort;
/*
* 计数排序
*
 */
public class CountingSort {
    public static int[] countingSort(int[] a) {
        int count[] = new int[a.length + 1];  // 统计记录出现过数字个数的数组 范围比a中最大值大1
        int res[] = new int[a.length]; // 结果数组

        for (int i=0; i<a.length; i++) {
            count[a[i]]+=1;
        }
        for (int i=1; i<count.length; i++) {
            count[i] = count[i] + count[i-1];  // 每一个当前数保存之前的和
        }
        for (int i=0; i<a.length; i++) {
            int k = a[i];
            res[count[k] - 1] = k ;
            count[k]--;        // 重复的数从后往前添加
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = countingSort(new int[]{0,3,3,3,4});
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
