package DFS和BFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * BFS
 */
public class _127_单词接龙_Y {
    /**
     * 单向BFS
     */
    // 保存wordList中所有单词
    static Set<String> wordSet1;
    // 保存已遍历过的单词
    static Set<String> visited1;
    // 队列，进行广度优先搜索
    static Queue<String> queue;

    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 单词列表为空或长度为空或不包含结束单词，均无法转接，返回0
        if (wordList.size() == 0 || !wordList.contains(endWord)) return 0;
        wordSet1 = new HashSet<>(wordList);
        wordSet1.remove(beginWord);

        // 广度优先遍历，visited表示是否遍历过
        queue = new LinkedList<>();
        queue.offer(beginWord);
        visited1 = new HashSet<>();
        visited1.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String curWord = queue.poll();
                if (changeOneLetter1(curWord, endWord)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    /**
     * 修改一个字符是否等于endWord
     */
    private static boolean changeOneLetter1(String curWord, String endWord) {
        char[] curArray = curWord.toCharArray();
        for (int i = 0; i < curArray.length; i++) {
            char cur = curArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == cur) continue;
                curArray[i] = j;
                String nextWord = String.valueOf(curArray);
                if (wordSet1.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited1.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited1.add(nextWord);
                    }
                }
            }
            // 恢复之前的字符
            curArray[i] = cur;
        }
        return false;
    }

    /**
     * 双向BFS
     */
    // 单词集合
    Set<String> wordSet;
    // 从起点开始遍历过的单词
    Set<String> beginVisited;
    // 从终点开始遍历过的单词
    Set<String> endVisited;
    // 所有遍历过的单词
    Set<String> visited;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;

        visited = new HashSet<>();
        // 在双向过程中交替使用，代替队列
        beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先从元素少的集合开始遍历，考虑的情况少一些
            if (beginVisited.size() > endVisited.size()) {
                Set<String> tmp = beginVisited;
                beginVisited = endVisited;
                endVisited = tmp;
            }
            // 开始遍历集合中的元素
            Set<String> nextLevelVisited = new HashSet<>();
            for (String curWord : beginVisited) {
                if (changeOneLetter(curWord, nextLevelVisited)) {
                    return step + 1;
                }
            }
            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }

    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     * @param curWord
     * @param nextLevelVisited
     * @return
     */
    private boolean changeOneLetter(String curWord, Set<String> nextLevelVisited) {
        char[] curArray = curWord.toCharArray();
        for (int i = 0; i < curArray.length; i++) {
            char cur = curArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == cur) continue;
                curArray[i] = j;
                String nextWord = String.valueOf(curArray);
                if (wordSet.contains(nextWord)) {
                    // 当前单词落在了endVisited里，返回true
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        nextLevelVisited.add(nextWord);
                    }
                }
            }
            curArray[i] = cur;
        }
        return false;
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        String[] word = {"hot", "dog"};
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            wordList.add(word[i]);
        }
        System.out.println(new _127_单词接龙_Y().ladderLength(beginWord, endWord, wordList));
    }
}
