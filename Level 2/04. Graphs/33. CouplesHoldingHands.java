class Solution {
    // first method O(n)
    private Map<Integer, Integer> map;

    public int minSwapsCouples(int[] row) {
        map = new HashMap<>();

        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }
        int swap = 0;
        for (int i = 0; i < row.length; i += 2) {
            int first = row[i];
            int second = first ^ 1;
            if (second != row[i + 1]) {
                swap(row, i + 1, map.get(second));
                swap++;
            }
        }
        return swap;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        map.put(arr[i], i);
        map.put(arr[j], j);
    }

    // second method union find

    class UnionFind {
        int[] par;
        int count;

        UnionFind(int n) {
            par = new int[n];
            for (int i = 0; i < par.length; i++) {
                par[i] = i;
            }
            count = n;
        }

        void union(int u, int v) {
            int p1 = find(u);
            int p2 = find(v);

            if (p1 != p2) {
                par[p2] = p1;
                count--;
            }
        }

        int find(int u) {
            if (u == par[u]) {
                return u;
            }
            return par[u] = find(par[u]);
        }
    }

    public int minSwapsCouples1(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < row.length; i += 2) {
            int a = row[2 * i];
            int b = row[2 * i + 1];
            uf.union(a / 2, b / 2);
        }

        return n - uf.count;
    }
}