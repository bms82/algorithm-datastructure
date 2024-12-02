package bms.algorithm.must;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * LeetCode #30 Substring of Concatenation of All Words
 */
public class SubstringofConcat {

    public List<Integer> findSubstring(String s, String[] words) {
        int totalWordsLen = 0;
        Map<Integer, String> wordsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            boolean containsWord = false;
            int baseIdx = 0;
            int wordIdx = s.indexOf(words[i], baseIdx);
            while (wordIdx  > -1) {
                wordsMap.put(wordIdx, words[i]);
                wordIdx = s.indexOf(words[i], baseIdx);
                baseIdx = wordIdx + 1;
                containsWord = true;
            }
            totalWordsLen += words[i].length();
            if (!containsWord) {
                return new ArrayList<>();
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int idx = 0; idx < s.length() - totalWordsLen + 1; idx++) {
            List<String> wordsList = new ArrayList<>(List.of(words));
            String rangeString = s.substring(idx, idx + totalWordsLen);
            int minIdx = Integer.MAX_VALUE;
            for (Map.Entry<Integer, String> wordIdxEntry : wordsMap.entrySet()) {
                if (wordIdxEntry.getKey() < idx || (wordIdxEntry.getKey() + wordIdxEntry.getValue().length()) > idx + totalWordsLen) continue;
                if (rangeString.contains(wordIdxEntry.getValue())) {
                    rangeString = rangeString.replaceFirst(wordIdxEntry.getValue(), "");
                    wordsList.remove(wordIdxEntry.getValue());
                    if (wordIdxEntry.getKey() < minIdx)
                        minIdx = wordIdxEntry.getKey();
                }
            }
            if (rangeString.isEmpty() && wordsList.isEmpty()) {
                resultList.add(minIdx);
                idx = minIdx;
            }
        }
        return resultList;
    }

    @Test
    public void checkCase() {

        String s1 = "aaaaaaaaaaaaaa";

        String[] words1 = new String[]{"aa","aa"};

        List<Integer> idxes = new ArrayList<>();
        idxes.add(0);
        idxes.add(1);
        idxes.add(2);
        idxes.add(3);
        idxes.add(4);
        idxes.add(5);
        idxes.add(6);
        idxes.add(7);
        idxes.add(8);
        idxes.add(9);
        idxes.add(10);
        assertIterableEquals(findSubstring(s1, words1), idxes);

        String s2 = "ababaab";
        String[] words2 = new String[]{"ab","ba", "ba"};

        idxes = new ArrayList<>();
        //idxes.add(0);
        idxes.add(1);
        assertIterableEquals(findSubstring(s2, words2), idxes);
        String s3 = "barfoothefoobarman";
        String[] words3 = new String[]{"foo","bar"};

        idxes = new ArrayList<>();
        idxes.add(0);
        idxes.add(9);
        assertIterableEquals(findSubstring(s3, words3), idxes);
        String s4 = "wordgoodgoodgoodbestword";
        String[] words4 = new String[]{"word","good","best","word"};

        idxes = new ArrayList<>();
        assertIterableEquals(findSubstring(s4, words4), idxes);

        String s5 = "abababab";
        String[] words5 = new String[]{"ab", "ba"};

        idxes = new ArrayList<>();
        assertIterableEquals(findSubstring(s5, words5), idxes);
        String s6 = "abaababbaba";
        String[] words6 = new String[]{"ba","ab","ab"};

        idxes = new ArrayList<>();
        assertIterableEquals(findSubstring(s6, words6), idxes);
    }

}
