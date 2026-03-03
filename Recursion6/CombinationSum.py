# https://leetcode.com/problems/combination-sum/

def CombinationSumTaking1Times(arr, k, ind, result):
	if ind == len(arr):
		if k == 0:
			print(result)
		return

	
	result.append(arr[ind]) # taking 
	CombinationSumTaking1Times(arr, k - arr[ind], ind + 1, result)
	result.pop(-1) # not taking
	CombinationSumTaking1Times(arr, k, ind + 1, result)

def CombinationSumTakingNTimes(arr, k, ind, result):
	if ind >= len(arr):
		if k == 0:
			print(result)
		return

	if k >= 0:
		result.append(arr[ind]) # taking 
		CombinationSumTakingNTimes(arr, k - arr[ind], ind, result)
		result.pop(-1) # not taking
	CombinationSumTakingNTimes(arr, k, ind + 1, result)


def CombinationSum(arr, k):
	# CombinationSumTaking1Times(arr, k, 0, [])
	CombinationSumTakingNTimes(arr, k, 0, [])

arr = [2,3,6,7]
CombinationSum(arr, 7)




# public List<List<Integer>> combinationSum(int[] candidates, int target) {
#         List<List<Integer>> result = new ArrayList<>();
#         recursion(0, candidates, target, new ArrayList<>(), result);
#         return result;
#     }

#     private void recursion(int i, int[] arr, int target, List<Integer> list, List<List<Integer>> result) {
#         if(target == 0) {
#             result.add(new ArrayList(list));
#             return;
#         }
#         if(i == arr.length || target < 0) {
#             return;
#         }

#         if(target >= arr[i]) {
#             list.add(arr[i]);
#             recursion(i, arr, target - arr[i], list, result);
#             list.remove(list.size() - 1);
#         }
#         recursion(i+1, arr, target, list, result);
#     }
# }