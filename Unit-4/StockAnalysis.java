import java.util.ArrayList;

public class StockAnalysis {

    // Method to calculate average stock price
    public static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum / prices.length;
    }

    // Method to find maximum stock price
    public static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // Method to count occurrences of a specific price
    public static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == target) {
                count++;
            }
        }
        return count;
    }

    // Method to compute cumulative sum using ArrayList
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulative = new ArrayList<>();
        float sum = 0;

        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
            cumulative.add(sum);
        }

        return cumulative;
    }

    // Main method (Test execution)
    public static void main(String[] args) {

        // Array of stock prices (10 days)
        float[] stockPrices = {10.5f, 11.0f, 10.5f, 12.3f, 13.0f, 12.3f, 11.5f, 10.5f, 14.0f, 13.5f};

        // ArrayList of stock prices
        ArrayList<Float> priceList = new ArrayList<>();
        for (float price : stockPrices) {
            priceList.add(price);
        }

        // Calling methods
        float average = calculateAveragePrice(stockPrices);
        float maxPrice = findMaximumPrice(stockPrices);
        int occurrences = countOccurrences(stockPrices, 10.5f);
        ArrayList<Float> cumulativeSum = computeCumulativeSum(priceList);

        // Output results
        System.out.println("Average Stock Price: " + average);
        System.out.println("Maximum Stock Price: " + maxPrice);
        System.out.println("Occurrences of 10.5: " + occurrences);
        System.out.println("Cumulative Sum: " + cumulativeSum);
    }
}