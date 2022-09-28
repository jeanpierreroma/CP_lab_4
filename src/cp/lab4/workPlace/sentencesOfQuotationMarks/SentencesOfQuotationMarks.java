package cp.lab4.workPlace.sentencesOfQuotationMarks;

import java.util.ArrayList;
import java.util.List;

public class SentencesOfQuotationMarks {
    private String text;

    public SentencesOfQuotationMarks(String text) {
        this.text = text;
    }

    private int GetCountOfQuotationMarks() {
        int res = 0;

        int index = GetQuotationMarksIndexFromBegin(0);
        while (index >= 0) {
            index = GetQuotationMarksIndexFromBegin(index + 1);
            res++;
        }

        return res;
    }

    private int GetQuotationMarksIndexFromBegin(int start) {
        int res = -1;
        String text = this.text;

        for (int i = start; i < text.length(); i++) {
            if(text.charAt(i) == '"') {
                res = i;
                break;
            }
        }

        return res;
    }

    private int GetQuotationMarksIndexFromEnd(int start) {
        int res = -1;
        String text = this.text;

        for (int i = start; i >= 0; i--) {
            if(text.charAt(i) == '"') {
                res = i;
                break;
            }
        }

        return res;
    }
    public List<String> GetAllSentencesOfQuotationMarks() {
        String text = this.text;
        ArrayList<String> arrayList = new ArrayList<>();

        int countQuotationMarks = GetCountOfQuotationMarks();
        if(countQuotationMarks > 0 && countQuotationMarks % 2 ==0) {
            //Я хочу мати два індекса: початок стрічки та кінець стрічки
            int begin = -1;
            int end = text.length();
            for (; countQuotationMarks > 0; countQuotationMarks -= 2) {
                begin = GetQuotationMarksIndexFromBegin(begin + 1);
                end = GetQuotationMarksIndexFromEnd(end - 1);
                arrayList.add(text.substring(begin, end + 1));
            }

        } else {
            System.out.println("В тексті немає лапок або їх кількість непарна!");
        }

        return arrayList;
    }
}
