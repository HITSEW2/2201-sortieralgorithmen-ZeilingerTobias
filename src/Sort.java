import java.util.Scanner;

public class Sort {
    public static void insertionsorter(String[] quickfriends) {
        for (int i = 1; i < quickfriends.length; i++) {
            String value = quickfriends[i];

            int j = i - 1;
            while (j >= 0 && quickfriends[j].compareTo(value) > 0) {
                quickfriends[j + 1] = quickfriends[j];
                j--;
            }
            quickfriends[j + 1] = value;
        }
    }

    public static void bubblesorter(String[] bubblefriends) {
        for (int i = 0; i < bubblefriends.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < bubblefriends.length; j++) {
                if (bubblefriends[j].compareTo(bubblefriends[min]) < 0) {
                    min = j;
                }
            }
            String temp = bubblefriends[i];
            bubblefriends[i] = bubblefriends[min];
            bubblefriends[min] = temp;
        }
    }
    private static int binarysearch(String search, String[] quickfriends) {
        int left = 0;
        int right = quickfriends.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int compare = quickfriends[middle].toLowerCase().compareTo(search.toLowerCase().trim());
            //trim = vernachlässigt leere Charakter (Leerzeichen)

            if (compare == 0) {
                return middle;
            }
            else if (compare < 0) {
                left = middle + 1;
            }
            else {
                right = middle - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String search;

        String[] quickfriends = {"Wolfgang", "Max", "Volkswagen", "Dennis", "Ebner", "Russel", "Gerhard", "Hilde",
                "Inter", "Sabine", "Xandi", "Linda", "Bello", "Oberndorfer", "Pecht", "Yvonne", "Friedrich",
                "Jan", "Tobias", "Unejs", "Charlie", "Arnel", "Kendrick", "Quanty", "Zeilinger"};

        String[] insertionfriends = {"Wolfgang", "Max", "Volkswagen", "Dennis", "Ebner", "Russel", "Gerhard", "Hilde",
                "Inter", "Sabine", "Xandi", "Linda", "Bello", "Oberndorfer", "Pecht", "Yvonne", "Friedrich",
                "Jan", "Tobias", "Unejs", "Charlie", "Arnel", "Kendrick", "Quanty", "Zeilinger"};

        bubblesorter(quickfriends);
        for (String quickfriend : quickfriends) {
            System.out.print(quickfriend + ", ");
        }
        insertionsorter(insertionfriends);
        System.out.println("\n");
        for (String insertionfriend : insertionfriends) {
            System.out.print(insertionfriend + ", ");
        }

        System.out.println("\nWelchen Namen suchst du?");
        search = sc.nextLine();
        int place = binarysearch(search, quickfriends);

        if (place != -1) {
            System.out.println(search + " wurde an dem Platz " + (place + 1) + " gefunden.");
        }
        else {
            System.out.println(search + " wurde nicht gefunden!");
        }
    }
}