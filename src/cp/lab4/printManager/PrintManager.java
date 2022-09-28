package cp.lab4.printManager;

import java.util.List;

public class PrintManager {
    public static void PrinStringData(String text) {
        System.out.println(text);
    }
    public static void PrintListData(List<String> text) {
        for (String s : text) {
            System.out.println(s);
        }
    }
}
