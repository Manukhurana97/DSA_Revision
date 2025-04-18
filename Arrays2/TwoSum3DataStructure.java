// https://leetcode.com/problems/two-sum-iii-data-structure-design/description/

import java.util.*;

public class TwoSum3DataStructure {
	int sum = 0;
	Set<Integer> set = new HashSet<>();
	
	public void add(int number){
		
		set.add(number);
	}

	public boolean find(int value){
		for(var i : set) {
			if(set.contains(value - i)) return true;
			if(value - i == i) return true;
		}

		return false;
	}

	public static void main(String[] args) {
		TwoSum3DataStructure obj = new TwoSum3DataStructure();
		obj.add(1);
		obj.add(3);
		obj.add(5);
		System.out.println(obj.find(4));
		System.out.println(obj.find(7));
	}
}