
package javaapplication14;

import java.io.IOException;
import java.util.Scanner;



public class JavaApplication14 {

    public static int[][] last = new int[64][64];
    
    static void bend(int size){
        int i, j;
        
        // Ширина 
        int width = last[0][0] / (size * size * 4);
        
        // 
        for ( i=0; i < size; i++ ){
            for ( j=0; j < size; j++ ){
                int fl = ( i+ j ) % 2 * 2 - 1;   
                last[ 2 * size-i-1 ][ j ]= last[ i ][ j ] + fl*( width * 4 - 1 );
                last[ i ][ 2 * size-j-1 ]= last[ i ][ j ] + fl*( width * 2 -1 );
                last[ 2 * size-i-1 ][ 2*size-j-1 ]= last[ i ][ j ] + fl*( width * 2 );
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        //Сканер для ввода с клавиатуры
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int k = in.nextInt();
        
        
        int i, j, size;
        
        //Записываем максимальный элемент в массив под индекс 0:0
        last[0][0]= (int) Math.pow(4, k);
        
        // Складываем передевая размер поля 
        for (size= 1; size < Math.pow (2,k); size*= 2){ 
            bend (size);
        }
        for (i=0; i < size; i++) {
            for (j= 0; j < size; j++) {
                
                System.out.print((last[0][0] - last[i][j] + 1));
                System.out.print(" ");
            }
            System.out.println();
        }
        
    }
    
}
