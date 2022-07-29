import java.util.ArrayList;
import java.util.HashMap;

public class minimizeCost {

    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<ArrayList<String>> conn = new ArrayList<ArrayList<String>>();
        conn.add(new ArrayList<String>(){add("A"); add("B"); add("1")});
        conn.add(new ArrayList<String>(){add("B"); add("C"); add("4")});
        conn.add(new ArrayList<String>(){add("B"); add("D"); add("6")});
        conn.add(new ArrayList<String>(){add("D"); add("E"); add("5")});
        conn.add(new ArrayList<String>(){add("C"); add("E"); add("1")});
        ArrayList<ArrayList<String>> ans = minimizeCost(conn);

        for (ArrayList<String> c : ans)
        {
            System.out.println(c.get(0) + " " + c.get(1) + " " + c.get(2));
        }

    }

    static HashMap<String, String> parent = new HashMap<>();

    static public void union(String x, String y) {
        String px = find(x);
        String py = find(y);

        if (px != py) {
            parent.put(px, py);
        }
    }

    static public String find(String x) {
        if (!parent.containsKey(x) || parent.get(x) == x) {
            parent.put(x, x);
            return x;
        }
        parent.put(x, find(parent.get(x)));
        return parent.get(x);
    }

    public static List<List<String>> minimizeCost(List<List<String>> connections) {
        if (connections.size() == 0 || connections.get(0).size() == 0) {
            return new ArrayList<List<String>>();
        }

        Collections.sort(connections,
                (city1, city2) -> (Integer.parseInt(city1.get(2)) - Integer.parseInt(city2.get(2))));
        HashSet<String> included = new HashSet<>();
        // Integer.parseInt(s)

        // int res = 0;
        List<List<String>> ans = new ArrayList<List<String>>();

        for (List<String> c : connections) {
            String city1 = c.get(0), city2 = c.get(1);
            if (find(city1) != find(city2)) {
                included.add(city1);
                included.add(city2);
                ans.add(c);
                union(city1, city2);
            }
        }

        String end = find(connections.get(0).get(0));

        for (String city : included)
        {
            if (end != find(city)) {
                return new ArrayList<List<String>>();
            }
        }

        Collections.sort(ans, (conn1, conn2) -> (
            (conn1.get(0).compareTo(conn2.get(0)) != 0)
            (conn1.get(0).compareTo(conn2.get(0)))
            : (conn1.get(1).compareTo(conn2.get(1)))));

        return ans;
    }

}
