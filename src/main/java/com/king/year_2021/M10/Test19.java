package com.king.year_2021.M10;

/**
 * @program: leetcode
 * @description: 211. ������������� - ���ݽṹ���
 * @author: King
 * @create: 2021-10-19 23:36
 */
public class Test19 {
    //�������һ�����ݽṹ��֧�� ����µ��� �� �����ַ����Ƿ����κ���ǰ��ӵ��ַ���ƥ�� ��
    //
    //ʵ�ִʵ��� WordDictionary ��
    //
    //WordDictionary() ��ʼ���ʵ����
    //void addWord(word) �� word ��ӵ����ݽṹ�У�֮����Զ�������ƥ��
    //bool search(word) ������ݽṹ�д����ַ�����word ƥ�䣬�򷵻� true �����򣬷���false ��
    // word �п��ܰ���һЩ '.' ��ÿ��. �����Ա�ʾ�κ�һ����ĸ��
    //
    //��Դ�����ۣ�LeetCode��
    //���ӣ�https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
    //����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������

    class WordDictionary {
        private Trie root;

        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int index, Trie node) {
            if (index == word.length()) {
                return node.isEnd();
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)) {
                int childIndex = ch - 'a';
                Trie child = node.getChildren()[childIndex];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            } else {
                for (int i = 0; i < 26; i++) {
                    Trie child = node.getChildren()[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public Trie[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }


}
