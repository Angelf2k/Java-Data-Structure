import java.util.*;
import java.io.*;

public class dataStructure{

    public int[] selectionSort(int[] arrayNum){
        //surfing between the array
        int i, j, minValue, minIndex, temp=0;
        int arraySize = arrayNum.length;
        for (i = 0; i < arraySize-1; i++){
            minValue = arrayNum[i];
            minIndex = i;
            for(j = i + 1; j < arraySize; j++){
                if (arrayNum[j] < minValue){
                    minValue = arrayNum[j];
                    minIndex=j;
                }
            }
            if(minValue < arrayNum[i]){
                temp = arrayNum[i];
                arrayNum[i] = arrayNum[minIndex];
                arrayNum[minIndex] = temp;
            }
        }
        return arrayNum;
    }
    //Merge Sort
    public int[] mergeSort(int arrayNum[]){
        return  arrayNum;
    }

    public static void main(String[] args) {
        //print Unsorted Array;
        int[] myNumbers  = {10,34,2,56,7,67,88,42};
        System.out.println("Example Array:"+ Arrays.toString(myNumbers));
        System.out.println("Selection Sort");
        // calling function selection Sort
        dataStructure arrayObj = new dataStructure(); // for Main.java file
        arrayObj.selectionSort(myNumbers);

        //print sorted array
        int[] arrayResult = arrayObj.selectionSort(myNumbers);
        for (int i: arrayResult){
            System.out.print(i);
            System.out.print(", ");
        }
    }
}