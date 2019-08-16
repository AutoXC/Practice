class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = 0, n2 = 0;
        int[] temp = new int[m];
        for(int i = 0;i<m;i++){
            temp[i]=nums1[i];
        }
        for(int i = 0;i<m+n;i++){
            if(n2>n-1||(n1<m&&temp[n1]<nums2[n2])){
                nums1[i]=temp[n1];
                n1++;
            }else{
                nums1[i]=nums2[n2];
                n2++;
            }
        }
    }
}