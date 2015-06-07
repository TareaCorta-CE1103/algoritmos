package sort;
// file:    radixsort.java
// author:  Robert Keller
// purpose: illustrating a very fast sorting program for natural numbers only

class RadixSort{
    
    /**
      *  Calling radixsort constructor on array of floats sorts the array.
      *  Parameter N is the number of elements to be sorted.
      *  radixsort works using binary representation of numbers being sorted.
      * It first sorts on the least-significant bit, then the next least, 
      * and so on until there are no more bits which have 1 as a value.
      * On each pass, it counts the number of words with a 0 in the current
      * bit position.  It then copies the elements from the array into a
      * buffer so that all words with a 0 precede all with a one.  It then 
      * copies the buffer back to the array for the next pass.
     **/
    public RadixSort(int array[], int N){
        int buffer[]    = new int[N];	// place to put result of one pass
        boolean done = false;		// indicates whether sorting completed
        for(int shiftAmount=0; !done; shiftAmount++){// one pass consists of the following:
            int count=0;// count of number of 0 bits
            done=true;
            //first phase: determine number of words with 0 bit
            for(int i=0; i<N; i++ ){
                int shifted=(array[i] >> shiftAmount);// move bit to low-order
                if(shifted>0)// is there anything left?
                  done = false;
                if(shifted%2==0)
                  count++;// count this 0
            }
            if(done)
                break;
            //second phase: redistribute words with 0 vs. 1
            int lower=0,upper=count;// positions for redistribution
            for( int i=0; i<N; i++){
                int shifted=(array[i]>>shiftAmount);
                if(shifted%2==0)
                    buffer[lower++]=array[i];
                else
                    buffer[upper++]=array[i];
            }
            for(int i=0; i<N; i++)
                array[i]=buffer[i];
        }
    }
}   