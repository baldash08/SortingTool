package sorting;

import java.util.*;


public class SortingTool {

    private final static Scanner scanner = new Scanner(System.in);
    private final static List<Long> numbers = new ArrayList<>();
    private final static List<String> lines = new ArrayList<>();
    private final static List<String> words = new ArrayList<>();
    private final static List<String> list = new ArrayList<>();


    public static void sort(List<String> myList) {
        myList.forEach(s -> {if (!list.contains(s)) list.add(s);});
        list.sort(Comparator.comparing(s -> Collections.frequency(myList, s)));

        list.forEach(s -> System.out.printf("%s: %d time(s), %d%%%n", s, Collections.frequency(myList, s),
                Collections.frequency(myList, s) * 100 / myList.size()));
    }

    /**
     * sorting numbers
     */
    public static void sortingLong() {
        while (scanner.hasNext()) {
            String number = scanner.next();
            try {
                numbers.add(Long.valueOf(number));
            } catch (NumberFormatException e) {
                System.out.println("\"" + number + "\" is not a long. It will be skipped.");
            }

        }

        numbers.sort(Comparator.comparing(Long::longValue));
        String sortedNumbers = numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        System.out.printf("Total numbers: %d.%n", numbers.size());
        System.out.printf("Sorted data: %s%n", sortedNumbers);
    }

    /**
     * sorting lines
     */
    public static void sortingLines() {
        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        lines.sort(Comparator.comparing(String::length).reversed());

        System.out.printf("Total lines: %d.%n", lines.size());
        lines.forEach(System.out::println);
    }

    /**
     * sorting words
     */
    public static void sortingWord() {
        while (scanner.hasNext())
            words.add(scanner.next());

        words.sort(Comparator.comparing(String::valueOf));

        System.out.printf("Total words: %d.%n", words.size());
        System.out.print("Sorted data: ");
        words.forEach((n) -> System.out.print(n + " "));
    }

    /**
     * sorting words by count
     */
    public static void sortingWordByCount() {
        if (!words.isEmpty())
            words.clear();

        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }
        words.sort(Comparator.comparing(String::valueOf));
        System.out.printf("Total words: %d.%n", words.size());
        sort(words);
    }

    /**
     * sorting long values by count
     */
    public static void sortingLongByCount() {
        if (!numbers.isEmpty())
            numbers.clear();

        while (scanner.hasNext()) {
            String number = scanner.next();
            try {
                numbers.add(Long.valueOf(number));
            } catch (NumberFormatException e) {
                System.out.println("\"" + number + "\" is not a long. It will be skipped.");
            }
        }

        numbers.sort(Comparator.comparing(Long::longValue));
        System.out.printf("Total numbers: %d.%n", numbers.size());

        numbers.forEach(s -> {if (!list.contains(String.valueOf(s))) list.add(String.valueOf(s));});
        list.sort(Comparator.comparing(s -> Collections.frequency(numbers, Long.valueOf(s))));

        list.forEach(s -> System.out.printf("%s: %d time(s), %d%%%n", s, Collections.frequency(numbers, Long.valueOf(s)),
                Collections.frequency(numbers, Long.parseLong(s)) * 100 / numbers.size()));
    }

    /**
     * sorting lines by count
     */
    public static void sortingLineByCount() {
        if (!lines.isEmpty()) {
            lines.clear();
        }

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        lines.sort(Comparator.naturalOrder());
        System.out.printf("Total lines: %d.%n", lines.size());
        sort(lines);
    }

    public static void arguments(String arguments) {
        if (arguments.equals("-sortingType byCount -dataType word") || arguments.equals("-dataType word -sorting byCount")) {
            sortingWordByCount();
        } else if (arguments.equals("-sortingType byCount -dataType long") || arguments.equals("-dataType long -sorting byCount")) {
            sortingLongByCount();
        } else if (arguments.equals("-sortingType byCount -dataType line") || arguments.equals("-dataType line -sorting byCount")) {
            sortingLineByCount();
        } else if (arguments.equals("-sortingType natural -dataType long") || arguments.equals("-dataType long -sortingType natural")) {
            sortingLong();
        } else if (arguments.contains("-sortingType natural -dataType line") || arguments.contains("-dataType line -sortingType natural")) {
            sortingLines();
        } else if (arguments.contains("-sortingType natural -dataType word") || arguments.contains("-dataType word -sortingType natural")) {
            sortingWord();
        } else if (arguments.contains("-outputFile out.txt")) {
            System.out.println("No data type defined!");
        } else if (arguments.contains("long")) {
            sortingLong();
        } else if (!arguments.contains("long") && !arguments.contains("line") && !arguments.contains("word")){
            System.out.println("No data type defined!");
        } else if(!arguments.contains("byCount") && !arguments.contains("natural")) {
            System.out.println("No sorting type defined!");
        } else {
            System.out.println("It is not a valid parameter. It will be skipped.");
        }
    }

}
