package Loop;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Loop {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// rt means runtime
		int rt = 0;
		int n = 15;
		int i;
		int j;
		long start = System.nanoTime();
		for (i = 0; i < n; ++i) {
			for(j = 0;j < n * n; ++j)
			++rt;}

		long finish = System.nanoTime();
		
		NumberFormat format = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + format.format((finish - start)/1000000d) + " milliseconds");
	}

}
