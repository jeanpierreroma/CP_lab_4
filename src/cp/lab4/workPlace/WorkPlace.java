package cp.lab4.workPlace;

import cp.lab4.workPlace.mostCommonWord.MostCommonWord;
import cp.lab4.workPlace.sentencesOfQuotationMarks.SentencesOfQuotationMarks;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkPlace {
    private ArrayList<String> strings;
    private ArrayList<String> words;

    public ArrayList<String> getStrings() {
        return new ArrayList<>(strings);
    }

    public WorkPlace(String fileName, String fileForWords) {
        this.strings = new ArrayList<>();
        this.words = new ArrayList<>();

        try (FileReader reader = new FileReader(fileName)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                strings.add(scan.nextLine() + " ");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try (FileReader reader = new FileReader(fileForWords)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                words.add(" " + scan.nextLine() + " ");
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String GetFullText() {
        StringBuilder text = new StringBuilder();

        for (String string : strings) {
            text.append(string);
        }

        return text.toString();
    }

    public String GetFullTextWithoutSpaces() {
        String text = GetFullText();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if(i + 1 < text.length() && !(text.charAt(i) == ' ' && text.charAt(i + 1) == ' ')) {
                result.append(text.charAt(i));
            } else if(i + 1 == text.length()) {
                result.append(text.charAt(i));
            }
        }

        return result.toString();
    }

    public List<String> GetAllSentencesOfQuotationMarks() {
        return new SentencesOfQuotationMarks(GetFullTextWithoutSpaces()).GetAllSentencesOfQuotationMarks();
    }

    private List<String> GetAllSentencesOfQuotationMarks(String text) {
        return new SentencesOfQuotationMarks(text).GetAllSentencesOfQuotationMarks();
    }

    private String ChangeWordToWord(String str, String wordFind, String wordChange) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + wordFind.length()).equals(wordFind)) {
                res.append(wordChange);
            } else {
                res.append(str, i, i + wordFind.length());
            }
        }
        return res.toString();
    }
    public List<String> ReplaseWordsToWord() {
        MostCommonWord mostCommonWord = new MostCommonWord(GetFullTextWithoutSpaces());
        String word = mostCommonWord.GetMostCommonWord();
        System.out.println("Найчастіше слово у тексті: " + word);

        //Може винукнити помилка, не надто безпечно
        String sentence = GetAllSentencesOfQuotationMarks().get(0);

        for (int i = 0; i < words.size(); i++) {
            sentence = sentence.replace(words.get(i), " " + word + " ");
            sentence = sentence.replace(words.get(i), " " + word + " ");
        }
        for (int i = 0; i < words.size(); i++) {
            sentence = sentence.replace("\"" + words.get(i).stripLeading(), "\"" + word + " ");
            sentence = sentence.replace(words.get(i).stripTrailing() + "\"", " " + word + "\"");
        }

        return GetAllSentencesOfQuotationMarks(sentence);
    }
}
