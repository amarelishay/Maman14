/**
 *
 * maman 14 
 * Class Ex 14.
 * @author Elishay Amar ID 318840394
 * @2022
 */
import java.lang.Math;
public class Ex14
{

    /**
     * a static method that receives an array of integers , and two additional integers 
     * the method returns the minimum length between the integers in the array.  
     * If one or both of the integers in the array do not exist, the method returns Integer.MAX_VALUE.               
     *____The method's runtime complexity is O (n) because it only passes through an array with an unknown length (n) once.
     * ____The method has a space complexity of O (1) because it has a predetermined number of variables that do not change during operation
     * @param a represents the array  that method receive
     * @param x represents one of the integers that the method receive 
     * @param y represents one of the integers that the method receive 
     * @return the minimum length between the integers in the array  (or Integer.MAX_VALUE- if needed)  
     */
    public static int findMinDiff(int []a, int x , int y){
        int diff=a.length,i=0,placeX=a.length,placeY=a.length,placeX2=a.length,placeY2=a.length;//Set all the integers to a impossible value (the length of the array)
        while  (i<a.length)//The algorithm goes through the array
        {
            if (a[i]==x)//If the algorithm finds a number that equals x, it saves the number of places and calculates the difference between x and y places            {
            {
                placeX2=i; //When there are more than two differences in the array, the algorithm saves the index in a second integer
                if (Math.abs(i-placeY)<diff||placeX==a.length)//If the difference between place X and place Y is smaller *or* the placeX integer was not changed before, the placeX integer is updated to the place of the founded index
                {     
                    placeX=i;//updating the placeX integer                                            
                    diff=Math.abs(placeX-placeY);// updating diff integer
                }
                if (Math.abs(i-placeY2)<diff||placeX==a.length)/* If there are more than two places where the y location is relevant, then the
                algorithm select the best position with a smaller difference */
                {     
                    placeX=i;
                    placeY=placeY2;
                    diff=Math.abs(placeX-placeY);
                }
            }
            if (a[i]==y)//If the algorithm finds a number that equals y, it saves the number of places and calculates the difference between x and y places            {
            {   
                placeY2=i;//When there are more than two differences in the array, the algorithm saves the index in a second integer
                if (Math.abs(placeX-i)<diff|| placeY==a.length)//a condition that update the placeY integer to the place of the founded index if the diference between him and place x is smaller *or* if the placeY integer was not changed before 
                { 
                    placeY=i;//updating the placeY integer 
                    diff=Math.abs(placeX-placeY);// updating diff integer
                }
                if (Math.abs(i-placeX2)<diff||placeX==a.length)/* If there are more than two places where the x location is relevant, then the
                algorithm select the best position with a smaller difference */
                {     
                    placeY=i;
                    placeX=placeX2;
                    diff=Math.abs(placeX-placeY);
                }
            }
            i++;
        }
        if (placeX==a.length||placeY==a.length)//if the algorithm did not find x or y and did not change them
            return Integer.MAX_VALUE;

        return diff;
    }

    /**
     * A static method that takes two parameters: a two-dimensional "mat" array that is sorted-rotational, and a number (num) for searching. 
     * If the value num is found In the mat array, 
     *When the value of the num is found in the mat array, the method returns true. Otherwise, it returns false    
     *____The method has a runtime complexity of O (log n) since the method goes through a sorted array whose length is unknown in advance (n) less than once 
     *( the method doesn't enter a search in a row or line with a largest value smaller than num because that would be pointless).. 
     * ____The method has a space complexity of O (1) because it has a predetermined number of variables that do not change during operation
     * @param mat represents the array that method receives
     * @param num represents  the integer that the method seeks within the array.
     * @return true if the num value is found In the mat array. 
     */
    public static boolean search (int [][] mat,int num){
        int i=0;
        while (i<=mat.length-2)// A loop that goes through the columns of the array  
        {  
            int testnum=mat[mat.length-1][i];
            if (mat[mat.length-1][i]<num)/* This condition checks whether the column is relevant by looking at the last number.
            If it is less than num, the column isn't relevant and it is skipped by the algorithm */
                i+=2;
            else {                        
                int j =1;

                while (j<mat.length)// The loop goes through the rows of the array  
                {
                    if (mat[j][i]==num)//Check if the specific index matches to num
                    {
                        return true;
                    }              
                    if ((mat[j][i]>=num||j==1)&&(j==mat.length-1||mat[j+1][i]>=num))/* The algorithm checks if the values in the line and the line after it are within the range of num.
                    If not, the line is skipped.*/
                    {
                        if (j==1&&mat[j-1][i]==num)//compare the first num in the column  to num
                        {
                            return true; 
                        }
                        if (mat[j][i+1]==num) //compare the right down corner of the square  to num
                        {
                            return true;   
                        }
                        if (mat[j-1][i+1]==num)//compare the right up corner of the square  to num
                        {
                            return true;   
                        }
                    } 

                    j++;
                }
                if (mat.length%2==1&&i==mat.length-3)// If the length of the line is odd, the algorithm goes to the line before the last to check both 
                    i++;
                else
                    i+=2;   
            }
        }
        return false;
    }

    private static boolean  equalSplit (int [] array ,int i,int searched,int lenleft,int lenright)
    {
        if (array .length%2==0)//check if the array  length is even
        { 
            if (i==array .length)// if the algorithm  passed over all the array 
                return (searched==0);// Check if the difference between the two groups is zero (that means both groups are equal)
            if (lenright<array .length/2)//if the 'right' group is smaller then the the array /2
                if(lenleft<array .length/2)// if the 'left' group is also smaller then the array /2
                    return  equalSplit(array ,i+1,searched-array [i],lenright,lenleft+1)||equalSplit (array ,i+1,searched+array [i],lenright+1,lenleft);/*Each time the array/2 is bigger than both groups, the algorithm calls
                the recursion with updated
                values to compare each run between the two groups in each situation until both groups have equal values and lengths.*/
                else if (lenright<array .length/2)//if just the 'right' group is smaller than the array /2 the algorithm will call the recursion with updated values (i++, lenright++)
                    return equalSplit (array ,i+1,searched+array [i],lenright+1,lenleft);
                else //if just the 'left' group is smaller than the array /2 the algorithm will call the recursion with updated values (i++, lenleft ++)
                    return equalSplit(array ,i+1,searched-array [i],lenright,lenleft+1);

        }

        return false;//if the algorithm finally dont find two equals group with the same length / the array length is not even return false    
    }

    /**
     * A Boolean recursive static method that gets an array of integers arr. The method returns true if it is possible to divide all the array members into two different groups of equal size so 
     *that the sum of the members in the two groups is equal. If this is not possible, the method
     *Return false
     *@param arr represents the array  that the method receive 
     *@return true if it is possible to divide all the array members into two different groups of equal size so 
     *that the sum of the members in the two groups is equal.
     */
    public static boolean equalSplit (int [] arr){
        return equalSplit (arr,0,0,0,0);// call a over loading for the method

    }

    /**
     * A recursive Boolean static method, which accepts an integer as a parameter and returns true 
     * if the number is a special number and false otherwise.
     * @param n represents the integer that the method receive 
     * @return true if the number is a special
     */
    public static boolean isSpecial(int n){
        if (n<=0) return false;//check if the number is positive
        if (n%2==0) return false;//check if the number is even
        return isSpecial(2,n);//call a over loading to the method with 'divcount' as a counter for the divition and indexplace as a var to save the updated place of the index 
    }

    private static boolean isSpecial(int divcount, int indexplace){
        if (indexplace%divcount==0)//if divcount can be divisible by indexplace with no remainder thats mean that the number isnt special 
            return false;

        if (divcount>indexplace)//if divcount became bigger then the index place thats means that the number is special 
            return true;

        else
            return isSpecial(divcount+1,indexplace-(indexplace/divcount));//calling the recursion with updated values 
    }
}

