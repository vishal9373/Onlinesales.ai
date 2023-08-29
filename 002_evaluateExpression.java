import java.util.concurrent.*;

class Solution 
{
     public static final int  maxRequests= 50;
     public static final int delay = 1000 / maxRequests;
    
    public static void main(String[] args) 
    {
        BlockingQueue<String> expressionQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(maxRequests);
        
        // Add expressions to the queue (in a separate thread or from input)
        expressionQueue.add("2 * 4 * 4");
        expressionQueue.add("5 / (7 - 5)");
        expressionQueue.add("sqrt(5^2 - 4^2)");
        expressionQueue.add("sqrt(-3^2 - 4^2)");
        expressionQueue.add("end");
        
        while (true) 
        {
            String expression;
            try 
            {
                expression = expressionQueue.take();
                if (expression.equals("end")) 
                {
                    break;
                }
            } 
            catch (InterruptedException e) 
            {
                Thread.currentThread().interrupt();
                break;
            }

            executorService.submit(() -> 
            {
                // Evaluate expression using the Web API and print the result
                double result = evaluateExpression(expression);
                System.out.println(expression + " => " + result);
                try 
                {
                    Thread.sleep(delay); // Rate limiting
                } 
                catch (InterruptedException e) 
                {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        executorService.shutdown();
    }
    
    public static double evaluateExpression(String expression) 
    {
        /* 
         code should be Implemented here to send expression to the Web API for evaluation and return the result
         This can involve using HTTP requests or appropriate API calls
        */ 
        return 0.0; // Placeholder for demonstration
    }
}

/*
Process To run the code:
 command:    javac 002_evaluateExpression.java
 command:    java Solution

*/
