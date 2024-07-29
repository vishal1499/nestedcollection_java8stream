import java.util.ArrayList;
import java.util.List;

public class FindContinuousSubArrayHavingSum23 {
    /*
    10,5,10,3,5,9,10

    find continuous sub array and sum is 23
    E.g. 5,10,3,5
     */
    public static void main(String[] args) {

        int[] arr = {10, 5, 10, 3, 5, 9, 10};
        List list = new ArrayList();
        int index =0;
        int sum = 0;
        for (int i = 0; i < arr.length;) {
            if (sum > 23 ) {
                sum = 0;
                i = ++index;
                list = new ArrayList();
            } else if (sum < 23 ) {
                sum+=arr[i];
                list.add(arr[i++]);
            } else if (sum == 23) {
                System.out.println(list);
                break;
            }
        }
    }
}
