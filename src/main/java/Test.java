import java.util.ArrayList;
import java.util.List;

public class Test {

    /**
     * from 과 to를 받아서 더해주는 함수
     * @param from
     * @param to
     */
    @Deprecated
    public int calcAdd(int args[]) {
        int totalSum = 0;

        for (int i : args) {
            totalSum = totalSum + i;
        }

        List<String> list = new ArrayList();

        return totalSum;
    }

    public static void main(String[] args) {
        Test t = new Test();

        // 1~10까지 계산한다.
        System.out.println("결과는 = " + t.calcAdd(new int[]{1,2,3, 4, 5, 6, 7, 8, 9, 10}));

    }
}
