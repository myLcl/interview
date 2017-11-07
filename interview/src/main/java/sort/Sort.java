package sort;

/**
 * Created by conglin.liu on 2017/11/7.
 */
public class Sort {

    public static void main(String[] args) {
        sort2();
    }

    /**
     * 冒泡
     * 相邻两个元素比, 每次选择一个大的, 放在最右边
     */
    public static  void  sort1() {
        int[] array = {8, 4, 10 , 2};
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i +1; j < array.length; j++) {
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i = 0 ; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 选择
     * 第一个元素和剩下的所有元素比, 每次选择一个大的, 放在左边
     */
    public static void sort2() {
        int[] array = {8, 4, 10 , 2};
        for (int i = 0; i < array.length; i++) {
            for (int j = i +1; j < array.length; j++) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0 ; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
