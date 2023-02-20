package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> lst_a = new AListNoResizing<>();
        BuggyAList<Integer> lst_b = new BuggyAList<>();
        lst_a.addLast(4);lst_a.addLast(5);lst_a.addLast(6);
        lst_b.addLast(4);lst_b.addLast(5);lst_b.addLast(6);
        assertEquals(lst_a.removeLast(),lst_b.removeLast());
        assertEquals(lst_a.removeLast(),lst_b.removeLast());
        assertEquals(lst_a.removeLast(),lst_b.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                // int size = L.size();
                // System.out.println("size: " + size);
                assertEquals(L.size(),B.size());
            }
            else if (operationNumber ==2 ){
                // getLast
                int size_L = L.size(); int size_B = B.size();
                if (size_L==0 || size_B==0){
                    continue;
                }
//                int last = L.getLast();
//                System.out.println("last: " + last);
                assertEquals(L.getLast(),B.getLast());
            }
            else if (operationNumber == 3) {
                // remove last
                int size_L = L.size(); int size_B = B.size();
                if (size_L==0 || size_B==0){
                    continue;
                }
//                int last = L.getLast();
//                System.out.println("last: " + last);
                assertEquals(L.removeLast(),B.removeLast());
            }
        }
    }

}
