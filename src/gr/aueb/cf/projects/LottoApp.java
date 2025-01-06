package gr.aueb.cf.projects;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class LottoApp {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("C:/tmp/lotto.txt"));
             PrintStream ps = new PrintStream("C:/tmp/lottoOutput.txt", StandardCharsets.UTF_8)){

            final int LOTTO_SIZE = 6;
            int[] inputNumber = new int[49];
            int[] result = new int[LOTTO_SIZE];
            int num;
            int pivot = 0;
            int window;

            while ((num = in.nextInt()) != -1 && pivot <= 48) {
                inputNumber[pivot++] = num;
            }

            int[] numbers = Arrays.copyOfRange(inputNumber, 0, pivot);
            Arrays.sort(numbers);

            window = pivot - LOTTO_SIZE;
            for (int i = 0; i <= window; i++) {
                for (int j = i + 1; j <= window + 1; j++) {
                    for (int k = j + 1; k <= window + 2; k++) {
                        for (int l = k + 1; l <= window + 3; l++) {
                            for (int m = l + 1; m <= window + 4; m++) {
                                for (int n = m + 1; n <= window + 5; n++) {
                                    result[0] = numbers[i];
                                    result[1] = numbers[j];
                                    result[2] = numbers[k];
                                    result[3] = numbers[l];
                                    result[4] = numbers[m];
                                    result[5] = numbers[n];

                                    if (!isEven(result) && !isOdd(result) && !isContiguous(result)
                                            && !isSameEnding(result) && !isSameTen(result)) {
                                        ps.printf("%d %d %d %d %d %d\n", result[0], result[1], result[2],
                                                result[3], result[4], result[5]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEven(int[] arr) {
        int threshold = 4;
        int count = 0;

        for (int i : arr) {
            if (i % 2 == 0) {
                count++;
            }
        }
        return count >= threshold;
    }

    public static boolean isOdd(int[] arr) {
        int threshold = 4;
        int count = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }

        return count >= threshold;
    }

    public static boolean isContiguous(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i+1] - 1 && arr[i] == arr[i+2] - 2) {
                count++;
                break;
            }
        }
        return count >= 1;
    }

    public static boolean isSameEnding(int[] arr) {
        int[] arr2 = new int[10];
        boolean same = false;

        for (int num : arr) {
            arr2[num % 10]++;
        }

        for (int count : arr2) {
            if (count >= 3) {
                same = true;
                break;
            }
        }
        return same;
    }

    public static boolean isSameTen(int[] arr) {
        int[] arr2 = new int[10];
        boolean same = false;

        for (int num : arr) {
            arr2[num / 10]++;
        }

        for (int count : arr2) {
            if (count >= 3) {
                same = true;
                break;
            }
        }
        return same;
    }
}