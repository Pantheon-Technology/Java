import java.util.HashMap;

public class UnionFind {
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, Integer> rank;

    public UnionFind(int[] nums) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        for (int num : nums) {
            parent.put(num, num);
            rank.put(num, 0);
        }
    }

    public int find(int num) {
        if (!parent.containsKey(num)) {
            return -1;
        }

        if (num != parent.get(num)) {
            parent.put(num, find(parent.get(num)));
        }

        return parent.get(num);
    }

    public boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);

        if (root1 == -1 || root2 == -1) {
            return false;
        }

        if (root1 == root2) {
            return true;
        }

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else if (rank.get(root1) < rank.get(root2)) {
            parent.put(root1, root2);
        } else {
            parent.put(root2, root1);
            rank.put(root1, rank.get(root1) + 1);
        }

        return true;
    }
}
int[] nums = {1, 2, 3, 4, 5};
UnionFind uf = new UnionFind(nums);
System.out.println(uf.find(1)); // prints 1
System.out.println(uf.find(2)); // prints 2

uf.union(1, 2);

System.out.println(uf.find(1)); // prints 1
System.out.println(uf.find(2)); // prints 1