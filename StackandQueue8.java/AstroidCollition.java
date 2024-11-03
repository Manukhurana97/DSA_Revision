import java.util.*;

public class AstroidCollition{
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid: asteroids){
            boolean isExploded = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() < -asteroid) // Pop smaller positive asteroid
                    stack.pop();
                else if(stack.peek()==-asteroid){ // Both asteroids are equal; they explode
                    stack.pop();
                    isExploded = true;
                    break;
                }else { // The current negative asteroid is smaller
                    isExploded = true;
                    break;
                }
            }
            if(!isExploded){
                stack.push(asteroid);
            }
        }
        int n = stack.size();
        int[] result = new int[n];
        while(!stack.isEmpty()){
            result[--n] = stack.pop();
        }

        return result;
    }
    
}

    public static void main(String[] args) {
        
    }
}