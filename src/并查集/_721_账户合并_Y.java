package 并查集;

import java.util.*;

public class _721_账户合并_Y {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 初始化两个HashMap，保存一个email对应的用户以及对应的索引
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }
        // 建立并查集并初始化，同一用户的email合并
        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex,nextIndex);
            }
        }
        // 将每个集合的email汇总到Map中
        Map<Integer, List<String>> indexToEmail = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmail.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmail.put(index, account);
        }
        // 构造返回结果
        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmail.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            res.add(list);
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}

