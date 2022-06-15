import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;



class MyClass extends Thread{

    int arr[]=new int[10000];

    //Para poder mandar el arreglo como parametro
    public MyClass(int arr[]) {
        this.arr=arr;

    }
    //Override el metodo run para poder inicializar ambos threads
    @Override
    public void run(){
        bubbleSort bb= new bubbleSort(); //Se crea una instancia de la clase para poder llamar las funciones
        try {
            bb.initArrays(arr); //Se llama a la función que se quiere ejecutar al inicializar el thread
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


public class bubbleSort {

    static int contador;

    public static void main(String a[]) throws IOException, InterruptedException {


        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("file.txt"));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }
        int [] array = new int [10000];
        int j = 0;
        while(scanner.hasNextInt()){
            array[j++] = scanner.nextInt();
        }

         //Dividir el arreglo
        int[] left_array = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right_array = Arrays.copyOfRange(array, array.length/2, array.length);


        // get the start time
        long start = System.nanoTime();

        //start threads
        MyClass myclass = new MyClass(left_array);
        myclass.start();
        MyClass myclass1 = new MyClass(right_array);
        myclass1.start();

        //join threads
        myclass.join();
        myclass1.join();

        // call the method
        int [] arr1= myclass.arr;
        int [] arr2= myclass1.arr;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr = new int[n1+n2];

        //merge both arrays
        merge(arr1,arr2, n1, n2, arr);

        // get the end time
        long end = System.nanoTime();

        // execution time
        long execution = end - start;
        System.out.println();
        System.out.println("Time with Threads: " + execution + " nanoseconds");

        System.out.print("\nValues after the sort:\n");
        print(arr);

        //System.out.println("\nIntercambios Totales: "+contador);


    }

    public static int[] bubble_srt( int a[], int n )
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
        return a;

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

    public static int[] initArrays(int arr[]) throws IOException {
        return arr = bubble_srt(arr, arr.length);
    }
    /*
    public static void initArray() throws IOException {
        int i;

        Scanner scanner = new Scanner(new File("file.txt"));
        int [] array = new int [10000];
        int j = 0;
        while(scanner.hasNextInt()){
            array[j++] = scanner.nextInt();
        }


        //Dividir el arreglo
        int[] left_array = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right_array = Arrays.copyOfRange(array, array.length/2, array.length);

        //Array
        System.out.println("Values Before the sort:");
        print(array);
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
        int [] arr1= bubble_srt(left_array, left_array.length);
        int [] arr2= bubble_srt(right_array, right_array.length);
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr = new int[n1+n2];

        //merge both arrays
        merge(arr1,arr2, n1, n2, arr);

        // get the end time
        long end = System.nanoTime();

        // execution time
        long execution = end - start;
        System.out.println();
        System.out.println("Bubble Sort Time: " + execution + " nanoseconds");

        System.out.print("\nValues after the sort:\n");
        print(arr);

        System.out.println("\nIntercambios Totales: "+contador);
        System.out.println("PAUSE");

    }

     */

}
