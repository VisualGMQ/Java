import java.util.*;

class collection {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            array.add(i);
        System.out.println(array.size());
        System.out.println(array.get(2));
        array.remove(1);
        System.out.println(array.size());
        System.out.println(array.get(0));
        System.out.println(array);

        LinkedList<Double> linklist = new LinkedList<Double>();
        linklist.add(3.131);
        linklist.add(4.123d);
        linklist.add(4213d);
        System.out.println(linklist.get(0));
        System.out.println(linklist.size());
        System.out.println(linklist);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("VisualGMQ", 170);
        map.put("LiXianFen", 182);
        map.put("CaiChuanXun", 175);
        System.out.println(map);

        Deque<Integer> deque = new LinkedList<Integer>();
        deque.push(3);
        deque.push(5);
        deque.push(19);
        System.out.println(deque);

        LinkedList ll = new LinkedList();
        ll.add((Float) 3.14f);
        ll.add((Integer) 5);
        ll.add((Boolean) false);
        System.out.println(ll);

        Iterator<Object> it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.toString());
            it.next();
        }
    }
};