package cp.lab4.workPlace.mostCommonWord;

import java.util.HashMap;
import java.util.Map;

public class MostCommonWord {
    private final String text;

    public MostCommonWord(String text) {
        this.text = text;
    }

    public String GetMostCommonWord() {
        HashMap<String, Integer> wordsMap = new HashMap<>(MakeTableOfAllWords());

        String word = "";
        int tmp = 0;
        for(String s : wordsMap.keySet()) {
            if(tmp < wordsMap.get(s)) {
                tmp = wordsMap.get(s);
                word = s;
            }
        }

        return word;
    }

    private Map<String, Integer> MakeTableOfAllWords() {
        String[] text = DeleteAllSignsFromText().split(" ");

        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String s : text) {
            if (wordsMap.containsKey(s)) {
                wordsMap.replace(s, wordsMap.get(s) + 1);
            } else if (!s.equals("\u0000")){
                wordsMap.put(s, 1);
            }
        }

        return wordsMap;
    }

    private String DeleteAllSignsFromText() {
        String text = this.text;
        char[] signs = {',', '.', '!', '?', '"', '\''};
        for (char sign : signs) {
            text = DeleteSignFromText(sign, text);
        }
        return text;
    }

    private String DeleteSignFromText(char sign, String text) {
        return text.replace(sign, Character.MIN_VALUE);
    }
}
