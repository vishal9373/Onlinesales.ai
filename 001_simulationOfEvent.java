import java.util.*;

class EventSimulator 
{
     List<String> outcomes;
     List<Double> probabilities;

     EventSimulator(Map<String, Double> map) 
    {
        outcomes = new ArrayList<>(map.keySet());
        probabilities = calculate(map);
    }

    String simulateEvent() 
    {
        Random random = new Random();
        Double randomValue = random.nextDouble();
        for (int i = 0; i < probabilities.size(); i++) 
        {
            if (randomValue < probabilities.get(i)) 
            {
                return outcomes.get(i);
            }
        }

        return "";
    }

    List<Double> calculate(Map<String, Double> map) 
    {
        List<Double> probabilities = new ArrayList<>();
        Double cumulativeProbability = 0.0;

        for (Double probability : map.values()) 
        {
            cumulativeProbability += probability;
            probabilities.add(cumulativeProbability / 100.00); 
        }

        return probabilities;
    }
}

class Solution 
{
    public static void main(String[] args) 
    {

        Map<String, Double> map = new HashMap<>();
        map.put("Head", 35.00);
        map.put("Tail", 65.00);


        EventSimulator eventSimulator = new EventSimulator(map);

        int iNum = 1000, iHeadCnt = 0, iTailCnt = 0;

        for (int olc = 0; olc < iNum; olc++) 
        {
            String outcome = eventSimulator.simulateEvent();
            if (outcome.equals("Head")) 
            {
                iHeadCnt++;
            } 
            else if (outcome.equals("Tail")) 
            {
                iTailCnt++;
            }
        }

        System.out.println("Head Count: " + iHeadCnt);
        System.out.println("Tail Count: " + iTailCnt);
    }
}
