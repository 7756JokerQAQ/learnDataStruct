import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BST<Integer>bst=new BST<>();
//        int []nums={5,3,6,8,4,2};
//        for (int num:
//        nums){
//           bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println("无序");
//        bst.preOrderNR();
//        System.out.println("");
//        bst.inOrder();
//        System.out.println("");
//        bst.nextOrder();
//        System.out.println("");
//        System.out.println("=====");
//        bst.levelOrder();
        Random random=new Random();
        int n=1000;
        for(int i=0;i<n;i++){
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer>nums=new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
    }

}
