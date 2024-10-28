import java.util.*;

class Item{
	int weight;
	int profit;

	Item(int profit, int weight){
		this.weight = weight;
		this.profit = profit;
	}
}

// allowed to add fractional weights
public class FractionalKnapSack{
	static double fractionalKnapsack(int W, Item arr[], int n) {

		if(n == 0) return 0;

		PriorityQueue<Item> queue = new PriorityQueue<>((b, a) -> Double.compare((double) a.profit / a.weight, (double)b.profit / b.weight));

		double profit = 0;

		for(Item i: arr) queue.add(i);

		while(!queue.isEmpty() || W>0){
			var current = queue.poll();

			if(current.weight > W){
				profit += ((double)current.profit / current.weight) * W;
				break;
			}

			profit+=current.profit;
			W -= current.weight;
		}
		return profit;
	}

	public static void main(String[] args) {
		Item[] arr = {new Item(100, 20), new Item(60, 10), new Item(100, 50), new Item(200, 50)};
		System.out.println(fractionalKnapsack(90, arr, arr.length));

		Item arr1[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
		System.out.println(fractionalKnapsack(50, arr1, arr1.length));
	}
}