// https://leetcode.com/problems/gas-station/

public class GasStations{
	public int canCompleteCircuit(int[] gas, int[] cost) {

        int startingPoint = 0, totalgas = 0;
        int gasSum = 0, costSum=0;

        for(int i = 0; i < gas.length; i++){
            totalgas += gas[i] - cost[i];
            if(totalgas < 0){
                startingPoint = i+1;
                totalgas = 0;
            }
            gasSum += gas[i];
            costSum += cost[i];
        }

        return gasSum < costSum ? -1 : startingPoint;
    }
}