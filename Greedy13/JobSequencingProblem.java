import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class JobSequencingProblem{

	public int[] JobScheduling(Job arr[]){
		int sum = 0;
		int count = 0;

	    Arrays.sort(arr, (a, b) -> b.profit == a.profit ? a.deadline == b.deadline ? a.id - b.id : a.deadline - b.deadline : b.profit - a.profit);


		int maxDeadline = 0;
		for(Job job: arr) maxDeadline = Math.max(maxDeadline, job.deadline);

		boolean[] visited = new boolean[maxDeadline+1];

		for(var job: arr){
			for (int ind = job.deadline; ind > 0; ind--) {
				if(!visited[ind]){
					visited[ind] = true;
					sum+=job.profit;
					count+=1;
					break;
				}	
			}
		}

		return new int[]{count, sum};

	}

	public static void main(String[] args) {
		JobSequencingProblem jobSequencingProblem = new JobSequencingProblem();

		// Job[] jobs = new Job[8];
		// jobs[0] = new Job(6, 2, 80);
		// jobs[1] = new Job(3, 6, 70);
		// jobs[2] = new Job(4, 6, 65);
		// jobs[3] = new Job(2, 5, 60);
		// jobs[4] = new Job(5, 4, 25);
		// jobs[5] = new Job(8, 2, 22);
		// jobs[6] = new Job(1, 4, 20);
		// jobs[7] = new Job(7, 2, 10);

		Job[] jobs = new Job[5];
		jobs[0] = new Job(1,2,100);
		jobs[1] = new Job(2,1,19);
		jobs[2] = new Job(3,2,27);
		jobs[3] = new Job(4,1,25);
		jobs[4] = new Job(5,1,15);

		var result = jobSequencingProblem.JobScheduling(jobs);
		for (Integer x : result)
            System.out.print(x + " ");

	}
}