package merge_sort;

import utils.SortingUtils;

import java.util.Arrays;

public class MergeSort
{
    private static int[] aux;

    public static void main(String[] args)
    {
        int[] test = {4, -1, 20, -3, -333, 55, 777, 10};
        //test = SortingUtils.genArray(1000000, 1, 1000000);
        mergeSort(test);
        //System.out.println(Arrays.toString(test));
        System.out.println("Inversions? " + SortingUtils.hasInversions(test));
    }

    public static void mergeSort(int[] array)
    {
        //precondition
        if (array.length <= 1)
        {
            //already sorted!
            return;
        }

        //make space in our aux array
        aux = new int[array.length];

        mergeSort(array, 0, array.length - 1);
    }

    //recursive mergeSort() method
    private static void mergeSort(int[] array, int low, int high)
    {
        //base case (one element)
        if (high - low == 0)
        {
            return;
        }

        //split and recurse
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        //then merge
        merge(array, low, high);
    }

    private static void merge(int[] array, int low, int high)
    {
        //declare variables we'll need
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;
        int count =  high - low + 1;

        //loop over our sub-arrays and merge elements to the aux array
        for (int i = 0; i < count; i++)
        {
            //check whether we have exhausted a sub array
            if (left > mid)
            {
                aux[low + i] = array[right++];
            }
            else if (right > high)
            {
                aux[low + i] = array[left++];
            }
            //check which element is smaller
            else if (array[left] < array[right])
            {
                aux[low + i] = array[left++];
            }
            else
            {
                aux[low + i] = array[right++];
            }
        }

        //move elements from aux back to the array
        for (int i = 0; i < count; i++)
        {
            array[low + i] = aux[low + i];
        }
    }
}













