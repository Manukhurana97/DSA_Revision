
def graphColoringProblem(graph, m, n):
	colors = [0] * n
	return graphColoring(0, graph, colors, m, n)


def graphColoring(index, graph, colors, noOfColors, noOfNodes):
	if index == noOfNodes : return True

	for col in range(1, noOfColors+1):
		if checkGraphColorPossible(index, graph, colors, noOfColors, noOfNodes, col):
			color[ind] = col
			if graphColoring(index+1, graph, colot, noOfColors, noOfNodes):return True
			color[ind] = 0
	return False


def checkGraphColorPossible(index, graph, colors, noOfColors, noOfNodes, col ):
	for i in range(0, noOfNodes):
		if i != nodex and graph[i][index] and colors[i] == col: 
			return False

	return True