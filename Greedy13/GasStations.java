// https://leetcode.com/problems/gas-station/

public class GasStations{
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, totalCost = 0, totalGas = 0, startingPoint = 0;

        int total = 0;
        for(int i=0; i<n; i++){
            total += gas[i] - cost[i];
            
            if(total<0){
                startingPoint = i+1;
                total = 0;
            }

            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(startingPoint == n) return -1;
        return totalGas < totalCost ? -1 : startingPoint;
    }
}