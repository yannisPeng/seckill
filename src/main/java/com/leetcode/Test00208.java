package com.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Description: 实现 Trie (前缀树)
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * @author 10014994
 * @since 2021/4/12
 */
public class Test00208 {

    class TrieC {

        private List<String> words;
        /** Initialize your data structure here. */
        public TrieC() {
            words = new ArrayList<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            words.add(word);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (words.contains(word)) {
                return true;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for (String word: words) {
                if (word.startsWith(prefix)) {
                    return true;
                }
            }
            return false;
        }
    }

    class Trie {

        /**
         * 字段
         */
        String dict;

        /**
         * 下个节点
         */
        Trie nextNode;

        /** Initialize your data structure here. */
        public Trie() {
            new Trie();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            String[] split = word.split("");

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            return false;
        }
    }

    public static void main(String[] args) {

    }

}
