package round;

public class robin
{
	static void waitTime(int processes[], int arrival[], int n,
				int bt[], int wt[], int quantum)
	{

		int rem_bt[] = new int[n];
		for (int i = 0 ; i < n ; i++)
			rem_bt[i] = bt[i];
	
		int t = 0; 
		while(true)
		{
			boolean done = true;
	
			for (int i = 0 ; i < n; i++)
			{
				if (rem_bt[i] > 0)
				{
					done = false; // 
	
					if (rem_bt[i] > quantum)
					{
						t += quantum;

						rem_bt[i] -= quantum;
					}

					else
					{
						t = t + rem_bt[i];
	
						wt[i] = t - bt[i];
	
						rem_bt[i] = 0;
					}
				}
			}
	
			if (done == true)
			break;
		}
	}
	static void turnAroundTime(int processes[], int arrival[], int n,
							int bt[], int wt[], int tat[])
	{
		for (int i = 0; i < n ; i++)
			tat[i] = bt[i] + wt[i] - arrival[i];
	}

	static void avgTime(int processes[], int arrival[], int n, int bt[],
										int quantum)
	{
		int wt[] = new int[n], tat[] = new int[n];
		int total_wt = 0, total_tat = n;
	
		waitTime(processes, arrival, n, bt, wt, quantum);

		turnAroundTime(processes, arrival, n, bt, wt, tat);
		
	
		System.out.println("Processes " + " Arrival time " + " Burst time " +
					" Waiting time " + " Turnaround time");
	
		for (int i=0; i<n; i++)
		{
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i]-1;
			System.out.println(" " + (i+1) + "\t\t" + arrival[i] + "\t\t" + bt[i] +"\t" +
							wt[i] +"\t\t " + tat[i]);
		}
	
		System.out.println("Average waiting time = " +
						(float)total_wt / (float)n);
		System.out.println("Average turnaround time = " +
						(float)total_tat / (float)n);
	}

	public static void main(String[] args)
	{
		int processes[] = {1, 2, 3, 4};
		int n = processes.length;
		
		int arrival[] = {0, 1, 2, 3};
	
		int burst_time[] = {8, 4, 9, 5};
		
	
		int quantum = 4;
		avgTime(processes, arrival, n, burst_time, quantum);
	}
}
