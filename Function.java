// package sort;

/**
 * Function
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Function {
    /**
     * Bubble Sort
     * 
     * @param data
     */
    public void bubbleSort(ArrayList<String> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size() - 1; j++) {
                if (data.get(j).compareTo(data.get(j + 1)) > 0) {
                    String temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set((j + 1), temp);
                }
            }
        }
    }

    /**
     * Selection Sort
     * 
     * @param data
     */
    public void selectionSort(ArrayList<String> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j).compareTo(data.get(min_index)) < 0) {
                    min_index = j;
                }
            }
            String temp = data.get(min_index);
            data.set(min_index, data.get(i));
            data.set(i, temp);
        }
    }

    /**
     * Insertion Sort
     * 
     * @param data
     */
    public void insertionSort(ArrayList<String> data) {
        String key;
        int j;
        for (int i = 1; i < data.size(); i++) {
            key = data.get(i);
            j = i - 1;
            while (j >= 0 && data.get(j).compareTo(key) > 0) {
                data.set((j + 1), data.get(j));
                j = j - 1;
            }
            data.set((j + 1), key);
        }
    }

    /**
     * Read File
     * 
     * @param file
     * @param data
     * @throws IOException
     */
    public void readFile(String file, ArrayList<String> data) throws IOException {
        file = "";
        Scanner inputFile = new Scanner(new File("data.txt"));
        while (inputFile.hasNext()) {
            file = inputFile.next();
            data.add(file);
        }
        inputFile.close();
        // for (String string : data) {
        // System.out.println(string);
        // }
    }

    /**
     * Input File
     * 
     * @param output
     * @param data
     * @throws IOException
     */
    public void outputFile(FileWriter output, ArrayList<String> data) throws IOException {
        for (String str : data) {
            output.write(str + System.lineSeparator());
        }
        output.close();
    }

    public static void main(String[] args) throws IOException {
        // data
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> data2 = new ArrayList<String>();
        ArrayList<String> data3 = new ArrayList<String>();
        Function func = new Function();
        String file = "";
        FileWriter bubble = new FileWriter("bubble.txt");
        FileWriter selection = new FileWriter("selection.txt");
        FileWriter insertion = new FileWriter("insertion.txt");

        // bubble sort
        func.readFile(file, data);
        long start = System.currentTimeMillis();
        func.bubbleSort(data);
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("Waktu yang dibutuhkan untuk Bubble sort = " + sec + " second");
        func.outputFile(bubble, data);
        // end of bubble sort

        // selection sort
        func.readFile(file, data2);
        start = System.currentTimeMillis();
        func.selectionSort(data2);
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Waktu yang dibutuhkan untuk Selection sort = " + sec + " second");
        func.outputFile(selection, data2);
        // end of selection sort

        // insertion sort
        func.readFile(file, data3);
        start = System.currentTimeMillis();
        func.insertionSort(data3);
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println("Waktu yang dibutuhkan untuk Insetion sort = " + sec + " second");
        func.outputFile(insertion, data3);
        // end of insertion sort
    }
}