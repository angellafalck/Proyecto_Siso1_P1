import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

    static int contador=0;

    public static void main(String a[])
    {
        int i;
        int array[] = {12,9,4,99,120,1,3,10}; //Valores del arreglo de prueba

        //Dividir el arreglo
        int[] left_array = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right_array = Arrays.copyOfRange(array, array.length/2, array.length);

        /*int[] array = new int[5000]; //Inicializar el arreglo con el tamaño deseado
        for(i = 0; i <  array.length; i++) {
            array[i] = (int)(Math.random() * 10000); //Genera numeros random de 0-1000 para llenar el arreglo
            //System.out.print(ar1[i] + "  ");
        }
         */
        System.out.println("Values Before the sort:");

        //For que imprime el arreglo
        for(i = 0; i < left_array.length; i++)
            System.out.print( left_array[i]+" ");
        System.out.println();

        // get the start time
        long start = System.nanoTime();

        // call the method
        bubble_srt(left_array, left_array.length);

        // get the end time
        long end = System.nanoTime();

        // execution time
        long execution = end - start;
        System.out.println("Bubble Sort execution time: " + execution + " nanoseconds");

        System.out.print("\nValues after the sort:\n");

        for(i = 0; i <left_array.length; i++)
            System.out.print(left_array[i]+" ");
        System.out.println();
        System.out.println("\nIntercambios: "+contador);
        System.out.println("PAUSE");
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

    /*
    public static void bubble_srt2( int a[], int n )
    {
        int[] left_array = Arrays.copyOfRange(a, 0, a.length/2);
        int[] right_array = Arrays.copyOfRange(a, a.length/2, a.length);



    }
     */
}
