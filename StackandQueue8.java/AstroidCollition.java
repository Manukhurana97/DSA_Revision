import java.util.*;

public class AstroidCollition{
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
       

        for(int i: asteroids){
            boolean isDistroyed = false;

            while(i < 0 && !stack.isEmpty() && stack.peek() > 0){
                int j = i*-1;
                if(stack.peek() == j){
                    stack.pop();
                    isDistroyed = true;
                }else if(stack.peek()>j) isDistroyed = true;
                else stack.pop();
                           
                
                if(!isDistroyed){
                    stack.push(i);
                }
                
            }
        }


        int[] result = new int[stack.size()];
        int j = stack.size();
        while(!stack.isEmpty()){
            result[--j] = stack.pop();
        }


        return result;
    
}

    public static void main(String[] args) {
        
    }
}