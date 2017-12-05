import java.util.concurrent.ThreadLocalRandom;
/**
* <h1>ArrayTools</h1>
* The ArrayTools Library has a number of methods for manipulating arrays.
* <p>
*
* @author  Charles Cunningham
* @version 1.0
* @since   2017-11-17
*/
public class ArrayTools {
    
        
    /**
    * This is the main method which tests each of the following methods.
    * @param args Unused.
    */
	public static void main(String args[]){
        
        double[] arr = {1.0002,22323,1221,2.444,3.4};
        double[] arr2 = {2,2,2,2};
        
        System.out.println("\n\n\n");
        System.out.print("ArrayTools Library Test");
        System.out.println("\n\n");
        
        //printArray
        System.out.println("printArray():");
        System.out.println("This method should print '1.0002,22323,1221,2.444,3.4'.");
        System.out.print("Output: ");
        printArray(arr);
        System.out.println("\n");
        
        //reverseArray
        System.out.println("reverseArray():");
        System.out.println("This method should output '3.4,2.444,1221,22323,1.0002'.");
        System.out.print("Output: ");
        printArray(reverseArray(arr));
        System.out.println("\n");
        
        //maxArray
        System.out.println("maxArray():");
        System.out.println("This method should output '22323'.");
        System.out.print("Output: ");
        System.out.println(maxArray(arr));
        System.out.println("\n");
        
        //minArray
        System.out.println("minArray():");
        System.out.println("This method should output '1.0002'.");
        System.out.print("Output: ");
        System.out.println(minArray(arr));
        System.out.println("\n");
        
        //equalArrays
        System.out.println("equalArrays():");
        System.out.println("This method should output false.");
        System.out.print("Output: ");
        System.out.println(equalArrays(arr,arr2));
        System.out.println("\n");
        
        //meanArray
        System.out.println("meanArray():");
        System.out.println("This method should output '4710.16884'.");
        System.out.print("Output: ");
        System.out.println(meanArray(arr));
        System.out.println("\n");
        
        //scaleArray
        System.out.println("scaleArray():");
        System.out.println("This method should output '2.0004,44646,2442,4.88800,6.8'.");
        System.out.print("Output: ");
        printArray(scaleArray(arr,2));
        System.out.println("\n");
        
        //badShuffleArray
        System.out.println("badShuffleArray():");
        System.out.println("This method should shuffle '1.0002,22323,1221,2.444,3.4'.");
        System.out.print("Output: ");
        printArray(badShuffleArray(arr));
        System.out.println("\n");
        
        //shuffleArray
        System.out.println("shuffleArray():");
        System.out.println("This method should shuffle '1.0002,22323,1221,2.444,3.4'.");
        System.out.print("Output: ");
        printArray(shuffleArray(arr));
        System.out.println("\n");
        
        //addArrays
        System.out.println("addArrays():");
        System.out.println("This method should perform a weighted average of two arrays and should print '1.60008,8930.4,489.6,2.1776,1.36'.");
        System.out.print("Output: ");
        printArray(addArrays(arr,arr2,0.4,0.6));
        System.out.println("\n");
        
        //copyArray
        System.out.println("copyArray():");
        System.out.println("This method should output '22323,1221'.");
        System.out.print("Output: ");
        printArray(copyArray(arr,1,3));
        System.out.println("\n");
        
        //cutArray
        System.out.println("cutArray():");
        System.out.println("This method should output '1.0002,2.444,3.4'.");
        System.out.print("Output: ");
        printArray(cutArray(arr,1,3));
        System.out.println("\n");
        
        //swapArray
        System.out.println("swapArray():");
        System.out.println("This method should output '1.0002,1221,22323,2.444,3.4'.");
        System.out.print("Output: ");
        swapArray(arr,1,2);
        printArray(arr);
        System.out.println("\n\n\n");
        
        
        System.out.println("End of test.");
        
	}
    
    
    /**
    * This method prints all the values in the input array.
    * @param a[] Double array to be operated on.
    */
    public static void printArray(double a[]){
		int N=a.length;
		for(int i=0;i<N-1;i++){
			System.out.print(a[i]);
			System.out.print(",");
		}
		System.out.print(a[N-1]);
	}
    
    
    /**
    * This method reverses the order of the input array.
    * @param a[] Double array to be operated on.
    * @return Reversed array.
    */
	public static double[] reverseArray(double a[]){
		int N=a.length;
		double[] b = new double[N];
		for(int i=0;i<N;i++){
			b[i]=a[N-1-i];
		}
		return b;
	}
    
    
    /**
    * This method returns the maximum value in the input array.
    * @param a[] Double array to be operated on.
    * @return Maximum value.
    */
	public static double maxArray(double a[]){
		int N=a.length;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0;i<N;i++){
            if(a[i]>max) {max = a[i];}}
		return max;
	}
    
	
    /**
    * This method returns the minimum value in the input array.
    * @param a[] Double array to be operated on.
    * @return Minimum value.
    */
    public static double minArray(double a[]){
		int N=a.length;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0;i<N;i++){
            if(a[i]<min) {min = a[i];}}
		return min;
	}
    
	
    /**
    * This method returns true if the two input arrays are equal, false if not.
    * @param a[] Double array to be compared with array b.
    * @param b[] Double array to be compared with array a.
    * @return True or false.
    */
    public static boolean equalArrays(double a[], double b[]){
		int Na=a.length;
        int Nb=b.length;
        if(Na==Nb){
            for(int i=0;i<Na;i++){
                if(a[i]==b[i]){;}
                else return false;
            }
            return true;
        }
        else return false;
	}
    
    
    /**
    * This method returns the average of all the values in the input array.
    * @param a[] Double array to be operated on.
    * @return Average value.
    */
    public static double meanArray(double a[]){
		int N=a.length;
        double sum=0.0;
        for(int i=0;i<N;i++){
            sum+=a[i];
        }
        double average = sum/N;
        return average;
	}
    
    
    /**
    * This method scales all the values in the input array with the input scalar.
    * @param a[] Double array to be operated on.
    * @param scalar The scalar value.
    * @return Scaled array.
    */
	public static double[] scaleArray(double a[], double scalar){
		int N=a.length;
        double[] b=new double[N];
        for(int i=0;i<N;i++){
            b[i]=(a[i]*scalar);
        }
        return b;
	}
    
    
    /**
    * This method is an inefficient way to shuffle all the values in the input array randomly.
    * @param a[] Double array to be operated on.
    * @return Shuffled array.
    */
	public static double[] badShuffleArray(double a[]){
		int N=a.length;
        double[] b=new double[N];
        double unSet=Math.random();
        while(0==0){
            boolean broke=true;
            for(int i=0;i<N;i++){
                if(a[i]==unSet){
                    broke=false;
                }
            }
            if(broke) break;
        }
        for(int i=0;i<N;i++){
            b[i]=unSet;
        }
        int index=N;
        int place=0;
        for(int i=0;i<N;i++){
            while(b[place]!=unSet){
                place=ThreadLocalRandom.current().nextInt(0, N);
            }
            b[place]=a[i];
        }
        return b;
	}
    
    
    /**
    * This method is a better way to shuffle all the values in the input array randomly.
    * @param a[] Double array to be operated on.
    * @return Shuffled array.
    */
    public static double[] shuffleArray(double[] a){
        int N=a.length;
        double[] ar=new double[N];
        for(int i=0;i<N;i++){
            ar[i]=a[i];
        }
        for (int i = N - 1; i > 0; i--){
            int index = ThreadLocalRandom.current().nextInt(i + 1);
            double p = ar[index];
            ar[index] = ar[i];
            ar[i] = p;
        }
        return ar;
    }

	
    /**
    * This method adds two methods in a weighted manner.
    * @param a[] First double array to be added
    * @param b[] Second double array to be added
    * @param wA The weight of a[] in the addition (wA+wB must equal 1).
    * @param wB The weight of b[] in the addition (wA+wB must equal 1).
    * @return One array that is the weighted combination of a[] and b[].
    */
    public static double[] addArrays(double a[], double b[], double wA, double wB){
		int Na=a.length;
        int Nb=b.length;
        int N=Math.max(Na,Nb);
        double[] smaller = new double[N];
        double[] c = new double[N];
        for(int i=0;i<N;i++){
            smaller[i]=0.0;  
        }
        if(Na<Nb){
            for(int i=0;i<Na;i++){
                smaller[i]=a[i];
            }
            for(int i=0;i<N;i++){
                c[i]=b[i]*wB+smaller[i]*wA;
            }
        }
        else{
            for(int i=0;i<Nb;i++){
                smaller[i]=b[i];
            }
            for(int i=0;i<N;i++){
                c[i]=a[i]*wA+smaller[i]*wB;
            }
        }
        return c;
	}
	
	
    /**
    * This method returns the selected portion of an array.
    * @param a[] Double array to be operated on.
    * @param start The beginning of the section to be kept, inclusive (so a start of 1 would include position 1 in the selection of terms to be kept).
    * @param end The end of the section to be kept (so an end of 2 would exclude the term at position 2 in the selection of terms to be kept).
    * @return An array that contains only the terms in the original array that are in the selection defined by start and end
    */
    public static double[] copyArray(double a[], int start, int end){
		double[] b = new double[end-start];
		for(int i=start;i<end;i++){
			b[i-start]=a[i];
		}
		return b;
	}
    
    
    /**
    * This method cuts out all terms but the selected portion of an array; it cuts out the selected portion.
    * @param a[] Double array to be operated on.
    * @param start The beginning of the section to be cut out, inclusive (so a start of 1 would include position 1 in the selection of terms to be cut out).
    * @param end The end of the section to be kept (so an end of 2 would exclude the term at position 2 in the selection of terms to be cut out).
    * @return An array that contains all the terms in the original array except for those in the selection defined by start and end.
    */
	public static double[] cutArray(double a[], int start, int end){
		int N=a.length;
		double[] b1 = new double[start];
		double[] b2 = new double[N-end];
		double[] b = new double[start+N-end];
		for(int i=0;i<start;i++){
			b1[i]=a[i];
		}
		for(int i=end;i<N;i++){
			b2[i-end]=a[i];
		}
		for(int i=0;i<b.length;i++){
            if(i<start){
                b[i]=b1[i];
            }
            else{
                b[i]=b2[i-start];
            }
        }
		return b;
	}
    
    
    /**
    * This method swaps the two positions in the array.
    * @param a[] Double array to be operated on.
    * @param p1 The first term (to be swapped with the second term).
    * @param p2 The second term (to be swapped with the first term).
    */
    private static void swapArray(double[] a, int p1, int p2) {
        int N=a.length;
        for(int i=0;i<N;i++){
            double hold = a[p1];
            a[p1]=a[p2];
            a[p2]=hold;
        }
    }
    
    //End of class
}