package bms.programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTemplate2 {
    public int solution(String word, String[] pages) {
        int answer = 0;
        Map<String, Integer> idxPageLinkMap = new HashMap<>(pages.length);
        float[] basicScore = new float[pages.length];
        float[] linkScore = new float[pages.length];
        word = word.toLowerCase() + " ";
        for (int i = 0; i < pages.length; i++) {
            int linkStartIdx = pages[i].indexOf("https://");
            String linkBeginString = pages[i].substring(linkStartIdx);
            String link = linkBeginString.substring(0, linkBeginString.indexOf("\"/>"));
            idxPageLinkMap.put(link, i);
            String body = pages[i].substring(pages[i].indexOf("<body>"), pages[i].lastIndexOf("</body>")).toLowerCase();
            pages[i] = body;
            int count = 0;
            int idx = body.indexOf(word);
            while (idx > 0) {
                count++;
                idx = body.indexOf(word, idx + 1);
            }
            basicScore[i] = count;
            idx = body.indexOf("<a ");
            count = 0;
            while (idx > 0) {
                count++;
                idx = body.indexOf("<a ", idx + 1);
            }
            if (count > 0) {
                linkScore[i] = basicScore[i] * 1.0f / count;
            } else {
                linkScore[i] = 0;
            }

        }
        float maxScore = 0;
        for (int i = 0; i < pages.length; i++) {
            for (String link : idxPageLinkMap.keySet()) {
                if (pages[i].contains(link)) {
                    basicScore[idxPageLinkMap.get(link)] += linkScore[i];
                }

            }
        }
        for (int i = 0; i < basicScore.length; i++) {
            if (maxScore < basicScore[i]) {
                maxScore = basicScore[i];
                answer = i;
            }
        }

        return answer;
    }

    @Test
    public void testCase() {

        String word = "word";
        String[] pages = new String[]{};
        solution(word, pages);


    }
}
