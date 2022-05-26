import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Allignment {
    private String first;
    private String second;
    public Allignment(String first, String second) throws IOException {
        validateInputs(first);
        validateInputs(second);
        this.first = first;
        this.second = second;
    }

    private void validateInputs(String sequence) throws IOException {
        for (int i = 0; i < sequence.length(); i++){
            if(sequence.charAt(i) != 'g' &&
                    sequence.charAt(i) != 'G' &&
                    sequence.charAt(i) != 'a' &&
                    sequence.charAt(i) != 'A' &&
                    sequence.charAt(i) != 'c' &&
                    sequence.charAt(i) != 'C' &&
                    sequence.charAt(i) != 't' &&
                    sequence.charAt(i) != 'T'){
                throw new IOException("Invalid sequence");
            }
        }
    }

    public void local(int gap){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
        {
            arr[i][0] = 0;
        }
        for (int i = 0; i <= second.length(); i++)
        {
            arr[0][i] = 0;
        }
        arr = constructTable(arr, gap);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + "      ");
            }
            System.out.println();
        }

        int maxValue = arr[0][0];
        int maxI = 0;
        int maxY = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxI = i;
                    maxY = j;
                }
            }
        }
        int i = maxI;
        int j = maxY;
        String firstAns = "";
        String secondAns = "";
        while (arr[i][j] != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        System.out.println(firstAns);
        System.out.println(secondAns);
    }
    public void global(int gap){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
        {
            arr[i][0] = i * gap;
        }
        for (int i = 0; i <= second.length(); i++)
        {
            arr[0][i] = i * gap;
        }
        arr = constructTable(arr, gap);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        int i = first.length();
        int j = second.length();
        String firstAns = "";
        String secondAns = "";
        while (i != 0 && j != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        while(i != 0){
            firstAns += first.charAt(i - 1);
            secondAns += "-";
            i--;
        }
        while (j != 0){
            firstAns += "-";
            secondAns += second.charAt(j - 1);
            j--;
        }
        System.out.println(firstAns);
        System.out.println(secondAns);

    }
    public void semiGlobal(int gap){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
        {
            arr[i][0] = i * gap;
        }
        for (int i = 0; i <= second.length(); i++)
        {
            arr[0][i] = i * gap;
        }
        arr = constructTable(arr, gap);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        int i = first.length();
        int j = second.length();
        String firstAns = "";
        String secondAns = "";
        while (i != 0 && j != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        System.out.println(firstAns);
        System.out.println(secondAns);
    }


    public void local(int gap1, int gap2){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++)
        {
            arr[i][0] = 0;
        }
        for (int i = 0; i <= second.length(); i++)
        {
            arr[0][i] = 0;
        }
        arr = constructTable(arr, gap1, gap2);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + "      ");
            }
            System.out.println();
        }

        int maxValue = arr[0][0];
        int maxI = 0;
        int maxY = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxI = i;
                    maxY = j;
                }
            }
        }
        int i = maxI;
        int j = maxY;
        String firstAns = "";
        String secondAns = "";
        while (arr[i][j] != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        System.out.println(firstAns);
        System.out.println(secondAns);
    }


    public void semiGlobal(int gap1, int gap2){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        arr[0][0] = 0;
        arr[1][0] = gap1;
        arr[0][1] = gap1;
        for (int i = 2; i <= first.length(); i++)
        {
            arr[i][0] = i * gap2 + gap1;
        }
        for (int i = 2; i <= second.length(); i++)
        {
            arr[0][i] = i * gap2 + gap1;
        }
        arr = constructTable(arr, gap1, gap2);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        int i = first.length();
        int j = second.length();
        String firstAns = "";
        String secondAns = "";
        while (i != 0 && j != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        System.out.println(firstAns);
        System.out.println(secondAns);
    }

    public void global(int gap1, int gap2){
        int arr[][] = new int[first.length() + 1][second.length() + 1];
        arr[0][0] = 0;
        arr[1][0] = gap1;
        arr[0][1] = gap1;
        for (int i = 2; i <= first.length(); i++)
        {
            arr[i][0] = i * gap2 + gap1;
        }
        for (int i = 2; i <= second.length(); i++)
        {
            arr[0][i] = i * gap2 + gap1;
        }
        arr = constructTable(arr, gap1, gap2);
        for (int[] x : arr)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        int i = first.length();
        int j = second.length();
        String firstAns = "";
        String secondAns = "";
        while (i != 0 && j != 0){
            if(first.charAt(i - 1) == second.charAt(j - 1)){
                firstAns += first.charAt(i - 1);
                secondAns += second.charAt(j - 1);
                i--; j--;
            }
            else if (arr[i - 1][j] < arr[i][j - 1]){
                firstAns += "-";
                secondAns += second.charAt(j - 1);
                j--;
            }
            else {
                firstAns += first.charAt(i - 1);
                secondAns += "-";
                i--;
            }
        }
        while(i != 0){
            firstAns += first.charAt(i - 1);
            secondAns += "-";
            i--;
        }
        while (j != 0){
            firstAns += "-";
            secondAns += second.charAt(j - 1);
            j--;
        }
        System.out.println(firstAns);
        System.out.println(secondAns);
    }

    private int[][] constructTable(int[][] arr, int gap){
        for (int i = 1; i <= first.length(); i++)
        {
            for (int j = 1; j <= second.length(); j++)
            {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                else {
                    arr[i][j] = Math.max(Math.max(arr[i - 1][j - 1] - 1 , arr[i - 1][j] + gap), arr[i][j - 1] + gap );
                }
            }
        }
        return arr;
    }
    private int[][] constructTable(int[][] arr, int gap1, int gap2){
        boolean vertical[] = new boolean[arr[0].length - 1];
        for (int i = 1; i <= first.length(); i++)
        {
            boolean horizontal = false;
            for (int j = 1; j <= second.length(); j++)
            {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                else if((arr[i - 1][j - 1] - 1) >= arr[i - 1][j] + penalty(vertical[j-1], gap1, gap2) &&
                        (arr[i - 1][j - 1] - 1) >= arr[i][j - 1] + penalty(horizontal, gap1, gap2)){
                    arr[i][j] = arr[i - 1][j - 1] - 1;
                    horizontal = false;
                }
                else if(arr[i - 1][j] + penalty(vertical[j-1], gap1, gap2) > (arr[i - 1][j - 1] - 1) &&
                        arr[i - 1][j] + penalty(vertical[j-1], gap1, gap2) >= arr[i][j - 1] + penalty(horizontal, gap1, gap2)){
                    arr[i][j] = arr[i - 1][j] + penalty(vertical[j-1], gap1, gap2);
                    vertical[j-1] = true;
                    horizontal = false;
                }
                else {
                    arr[i][j] = arr[i][j - 1] + penalty(horizontal, gap1, gap2);
                    horizontal = true;
                }
            }
        }
        return arr;
    }
    private int penalty(boolean b, int gap1, int gap2){
        if(b){
            return gap2;
        }
        return gap1;
    }
}
