package topic16;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] a ={1,3,4,100,5,6,7};
        mergeSortUp2Down(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public  static  void mergeSortUp2Down(int[] a,int start,int end){
        if (a==null ||start>=end){
            return;
        }
        int mid=(end+start)/2;
        mergeSortUp2Down(a,start,mid);
        mergeSortUp2Down(a,mid+1,end);
        merge(a,start,mid,end);

    }
    public static  void merge(int[] a,int start,int mid, int end){
        int[] tmp =new int[end-start+1];
        int k=0;
        int i=start;
        int j=mid+1;
        while (i<=mid&&j<=end){
            if (a[i]<=a[j]){
                tmp[k++]=a[i++];
            } else {
                tmp[k++]=a[j++];
            }
        }
        while (i<=mid){
            tmp[k++]=a[i++];
        }
        while (j<=end){
            tmp[k++]=a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[start+l]=tmp[l];
        }
        tmp = null;
    }

    public static void mergeGroups(int[] a, int len, int gap){
        int i;
        int twoLen = 2*gap;
        for ( i = 0; i+2*gap-1 <len ; i+=(2*gap)) {
            merge(a, i, i+gap-1, i+2*gap-1);
            
        }
        // 若 i+gap-1 < len-1，则剩余一个子数组没有配对。
        // 将该子数组合并到已排序的数组中。
        if ( i+gap-1 < len-1)
            merge(a, i, i + gap - 1, len - 1);
    }

    public static void mergeSortDown2Up(int[] a) {
        if (a==null)
            return ;

        for(int n = 1; n < a.length; n*=2)
            mergeGroups(a, a.length, n);
    }
}
