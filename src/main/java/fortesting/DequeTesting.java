package fortesting;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Augie
 * Date: 4/8/13
 * Time: 9:22 AM
 * <p/>
 * Modification:
 * ----------------------------
 */


public class DequeTesting {
    @Test
    public void myProjectTest() {
        Deque dequelist = new ArrayDeque();
        dequelist.add("equity");
        dequelist.addFirst("Derivative");
        dequelist.addLast("commondities");
        System.out.println(dequelist);
    }

    public String deque() {
        Deque dequelist = new ArrayDeque();
        dequelist.add("equity");
        dequelist.addFirst("Derivative");
        dequelist.addLast("commondities");
        return dequelist.toString();
    }

    public String[] dequeStringArray() {
        Deque<String> dequelist = new ArrayDeque();
        dequelist.add("equity");
        dequelist.addFirst("Derivative");
        dequelist.addLast("commondities");
        Iterator<String> iter = dequelist.iterator();
        String[] tmp = new String[dequelist.size()];
        int i = 0;
        while (iter.hasNext()) {
            tmp[i] = iter.next();
            i++;
        }
        return tmp;
    }
}
