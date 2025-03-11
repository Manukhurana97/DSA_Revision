import java.util.*;


class Work{
	int endTime;
	int serverId;

	Work(int endTime, int serverId){
		this.endTime = endTime;
		this.serverId = serverId;
	}
}
public class Loadbalancing{

	public static List<Integer> loadBalancing(int k, int[] arival, int[] load){

		int currentTime = 0, lastServerUsed = -1;
		PriorityQueue<Work> workInProgressQueue = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
		
		boolean[] serverAvailabelList = new boolean[k];
		Arrays.fill(serverAvailabelList, true);

		Map<Integer, Integer> workDoneByServer = new HashMap<>();

		for(int i=0; i<arival.length; i++){

			currentTime = arival[i];

			while(!workInProgressQueue.isEmpty() && workInProgressQueue.peek().endTime <= currentTime+1){
				Work workDone = workInProgressQueue.poll();
				serverAvailabelList[workDone.serverId] = true;
			}
						
			for(int j=0; j<k; j++){ 
				int serverId = (j+lastServerUsed+1)%k;
				
				if(serverAvailabelList[serverId]){
					lastServerUsed = serverId;
					workDoneByServer.put(serverId, workDoneByServer.getOrDefault(serverId, 0)+load[i]);
					workInProgressQueue.add(new Work(currentTime + load[i], serverId));
					serverAvailabelList[serverId] = false;
					break;
				}
			}

		}



		List<Integer> result = new ArrayList<>(workDoneByServer.values());
		Collections.sort(result);

		return result;
	}



	public static void main(String[] args) {
		int[] arrival = {1,2,12,5,6,30, 32};
		int[] load = {15, 10, 10, 10, 10, 15, 10};
		System.out.println(loadBalancing(3, arrival, load));
	}
}