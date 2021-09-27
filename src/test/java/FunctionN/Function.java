package FunctionN;
import java.util.LinkedList;
import java.util.List;


public class Function {

        public static void main(String[] args) {
            int border = 1000;
            int rndIndex;
            List<Integer> nums = new LinkedList<>();
            for (int i = 1; i <= border; i++) {
                nums.add(i);
            }
            for (int i = 0; i < 1000; i++) {
                rndIndex = (int)(Math.random()*nums.size());
                System.out.println(nums.get(rndIndex));
                nums.remove(rndIndex);
            }
        }
}
