package sorting;

import java.util.*;

public class Main {
    public static void main(final String[] args) {
        String arguments = Arrays.toString(args)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        SortingTool.arguments(arguments);

    }
}
