package cp.lab4;

import cp.lab4.printManager.PrintManager;
import cp.lab4.workPlace.WorkPlace;

public class Main {
    public static void main(String[] args) {
        WorkPlace workPlace = new WorkPlace("Text.txt", "Words.txt");

        System.out.println("Вхідні дані");
        PrintManager.PrintListData(workPlace.getStrings());
        System.out.println("///////////////////////////////////////////////////////////////\n");

        System.out.println("Вхідні дані без зайвих пробілів");
        PrintManager.PrinStringData(workPlace.GetFullTextWithoutSpaces());
        System.out.println("///////////////////////////////////////////////////////////////\n");

        System.out.println("Усі речення в лапках по рівнях");
        PrintManager.PrintListData(workPlace.GetAllSentencesOfQuotationMarks());
        System.out.println("///////////////////////////////////////////////////////////////\n");

        System.out.println("Усі речення в лапках по рівнях, слова з таблиці замінені на найчастіше слово у тексті");
        PrintManager.PrintListData(workPlace.ReplaseWordsToWord());
        System.out.println("///////////////////////////////////////////////////////////////\n");

    }
}

//Окремий клас для визначення найчастішого слова