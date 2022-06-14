import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

    static int contador;

    public static void main(String a[])
    {
        initArray();
    }
    public static void bubble_srt( int a[], int n )
    {
        int i, j,t=0;

        for(i = 0; i < n; i++)
        {
            for(j = 1; j < (n-i); j++)
            {
                if(a[j-1] > a[j])
                {
                    /* Inicio del intercambio*/
                    t = a[j-1];
                    a[j-1]=a[j];
                    a[j]=t;
                    contador++;
                    /* Final del intercambio */
                }
            }
        }

    }

    public static void merge( int l[], int r[], int n1, int n2,  int arr[])
    {
        int i = 0, j = 0, k = 0;

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (l[i] < r[j])
                arr[k++] = l[i++];
            else
                arr[k++] = r[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr[k++] = l[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr[k++] = r[j++];

    }

    public static void print(int[] array)
    {
        //For que imprime el arreglo
        for(int i = 0; i < array.length; i++)
            System.out.print( array[i]+" ");
        System.out.println();
    }

    public static void initArray()
    {
        int i;
        int array[] = {46,40,55,49,39,95,91,52,40,30}; //Valores del arreglo de prueba

        //Dividir el arreglo
        int[] left_array = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right_array = Arrays.copyOfRange(array, array.length/2, array.length);

        /*
        int[] array = new int[5000]; //Inicializar el arreglo con el tamaño deseado
        for(i = 0; i <  array.length; i++) {
            array[i] = (int)(Math.random() * 10000); //Genera numeros random de 0-1000 para llenar el arreglo
            //System.out.print(ar1[i] + "  ");
        }
        */

        //Left Array
        System.out.println("Left values Before the sort:");
        print(left_array);

        //Right Array
        System.out.println("Right values Before the sort:");
        print(right_array);

        //Method to Bubble Sort
        // get the start time
        long start = System.nanoTime();

        // call the method
        bubble_srt(left_array, left_array.length);
        bubble_srt(right_array, right_array.length);

        int n1 = left_array.length;
        int n2 = right_array.length;
        int[] arr = new int[n1+n2];

        //merge both arrays
        merge(left_array,right_array, left_array.length, right_array.length, arr);

        // get the end time
        long end = System.nanoTime();

        // execution time
        long execution = end - start;
        System.out.println("Bubble Sort Time: " + execution + " nanoseconds");

        System.out.print("\nValues after the sort:\n");
        print(arr);

        System.out.println("\nIntercambios Totales: "+contador);
        System.out.println("PAUSE");

    }




}
