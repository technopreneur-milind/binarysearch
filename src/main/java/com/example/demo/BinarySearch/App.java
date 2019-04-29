package com.example.demo.BinarySearch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App app = new App();
        int[] input = {1,5,3,21,4,23,28};
        System.out.println(app.execute(input, 22));
    }

	private int execute(int[] input, int seachFor) {
		sort(input);
		return search(input,0, input.length,seachFor);
	}
	
	private int search(int[] input, int low, int high,int seachFor) {
		if(high >=1)
		{
			int mid = (high +low -1) /2;
			if(input[mid] == seachFor)
				return mid;
			else if(input[mid] > seachFor)
				return search(input, low, mid-1, seachFor);
			else if(mid <=high)
				return search(input, mid+1, high-1, seachFor);
			
		}
		return -1;
	}

	private void sort(int[] input) {
		 mergeSort(0,input.length,input);
	}
	
	private void mergeSort(int low, int high,int[] input) {
		if(low < high && input != null && input.length > 1)
		{
			int mid = (low + high )/2;
			mergeSort(low,mid,input);
			mergeSort(mid+1,input.length,input);
			merge(low,mid,input.length, input);
		}
	}

	private void merge(int low, int mid, int length, int[] input) {
		//int sizeOfSecond = length - mid;
		int i =0, j = mid, index = 0;
		int[] copiedData = input.clone();
		while(i< mid && j< length)
		{
			if(input[i] < input[j])
				input[index++] = copiedData[i++];
			else
				input[index++] = copiedData[j++];
		}
		while( i< mid)
			input[index++] = copiedData[i++];
		while(j<length)
			input[index++] = copiedData[j++];
		
	}
}
