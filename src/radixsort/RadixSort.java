package radixsort;

public class RadixSort {
	
	public static void sort(IPADRRESS[] array)  {
		IPADRRESS maxItem=findMaxNumber(array);
		long max=maxItem.getIpFrom();
		for (int exp=1; max/exp>0; exp*=10) {
			sort(array,exp);
		}
	}
	/*
	public static long findMaxNumber(IPADRRESS[] array) {
		long max=array[0].getIpFrom();
		for (int i=1;i<array.length;i++) {
			if (array[i].getIpFrom()>max) {
				max=array[i].getIpFrom();
			}
		} 
		return max;
	} */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IPADRRESS findMaxNumber(Comparable[] array) {
		Comparable max=array[0];
		for (int i=1;i<array.length;i++) {
			if (array[i].compareTo(max)>0) {
				max=array[i];
			}
		} IPADRRESS result=(IPADRRESS) max;
		return result;
	}
	
	
	private static void sort(IPADRRESS[] array,int exp)  {
		IPADRRESS[] helping=new IPADRRESS[array.length];
		int [] frequency= {0,0,0,0,0,0,0,0,0,0};
		
		for (int i=0;i<array.length;i++) {
			long helpingDigit=(array[i].getIpFrom()/exp) % 10;
			int digit=(int)helpingDigit;
			frequency[digit]++;
		}
		for (int i=1;i<10;i++) {
			frequency[i]+=frequency[i-1];
		}
		for (int i=array.length-1;i>=0;i--) {
			long helpingDigit=(array[i].getIpFrom()/exp) % 10;
			int digit=(int)helpingDigit;
			helping[frequency[digit]-1]=array[i];
			frequency[digit]--;
		}
		for (int i=0;i<array.length;i++) {
			array[i]=helping[i];
		}
	}
	
}
