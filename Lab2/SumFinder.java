import java.util.Arrays;

public class SumFinder{

	//public int[] 

	public int[] sorter(int[] list){ //sorts ordered array of numbers into an array
		for(int i = 0; i < list.length; i++){
			for(int j = i+1; j < list.length; j++){
				if (list[j] < list[i]){
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		return list;
	}

	public int[] twoElements(int[] list, int num){ //returns the index of two numbers that adds to the target number
		int[] res = new int[2];
		for(int i = 0; i < list.length; i++){ //goes through the sorted array
			for(int j = i+1; j < list.length; j++){
				if ((list[i] <= num) && (list[j] <= num)){ //limit of search is lower than the number searching for
					if ((list[i] != list[j]) && (list[i] + list[j] == num)){ //if both numbers adds to target number and aren't equal to each other
						res[0] = i; 
						res[1] = j;
					}
				}
			}
		}
		return res; //returns the resulting array
	}

	public void sumInList(int[] list, int num){ //prints indices of two numbers that equals to the target or prints -1
		int[] orderList = sorter(list);
		int[] sumList = twoElements(orderList, num);
		int zero = sumList[0];
		int one = sumList[1];
		if(orderList[zero] + orderList[one] == num){
			System.out.println(Arrays.toString(sumList));
		} else{
			System.out.println(-1);
		}
	}


	
	public static void main(String args[]){

		SumFinder finder = new SumFinder(); //class of itself created

		int[] list = {2, 7, 1, 6, 5, 3, 5, 4}; //unordered array

		finder.sumInList(list, 7); //finds two numbers that adds to second input
	}
}