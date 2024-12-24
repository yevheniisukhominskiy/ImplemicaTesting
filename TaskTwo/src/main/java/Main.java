import java.util.*;

public class Main {
    // Dijkstra's algorithm
    public static int[] findShortestPaths(int numberOfCities, List<List<int[]>> cityGraph, int startCityIndex) {
        int[] shortestPaths = new int[numberOfCities];

        // Initialize all distances as infinite
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        // Distance to starting city = 0
        shortestPaths[startCityIndex] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.offer(new int[]{startCityIndex, 0});

        while (!priorityQueue.isEmpty()) {
            // Retrieve the city with the minimum cost
            int[] currentCity = priorityQueue.poll();
            int currentCityIndex = currentCity[0];
            int currentDistance = currentCity[1];

            // If we reach the target city, return the cost
            if (currentDistance > shortestPaths[currentCityIndex]) {
                continue;
            }

            for (int[] neighbor : cityGraph.get(currentCityIndex)) {
                int neighborIndex = neighbor[0];
                int edgeCost = neighbor[1];

                int newDistance = currentDistance + edgeCost;
                // If we found a cheaper way
                if (newDistance < shortestPaths[neighborIndex]) {
                    shortestPaths[neighborIndex] = newDistance;
                    priorityQueue.offer(new int[]{neighborIndex, newDistance});
                }
            }
        }
        // If the path is not found, return -1
        return shortestPaths;
    }

    public static void main(String[] args) {
        // Reading input data
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        // Reading data for each test
        for (int t = 0; t < numberOfTests; t++) {
            if (t > 0) {
                scanner.nextLine();
            }

            int numberOfCities = Integer.parseInt(scanner.nextLine());
            Map<String, Integer> cityNameToIndex = new HashMap<>();
            List<String> cityNames = new ArrayList<>();
            List<List<int[]>> cityGraph = new ArrayList<>(numberOfCities);

            for (int i = 0; i < numberOfCities; i++) {
                String cityName = scanner.nextLine();
                cityNameToIndex.put(cityName, i);
                cityNames.add(cityName);
                cityGraph.add(new ArrayList<>());

                int numberOfNeighbors = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < numberOfNeighbors; j++) {
                    String[] connectionData = scanner.nextLine().split(" ");
                    int neighborIndex = Integer.parseInt(connectionData[0]) - 1;
                    int cost = Integer.parseInt(connectionData[1]);
                    cityGraph.get(i).add(new int[]{neighborIndex, cost});
                }
            }

            int numberOfQueries = Integer.parseInt(scanner.nextLine());
            // Process requests to find the shortest path
            for (int q = 0; q < numberOfQueries; q++) {
                String[] query = scanner.nextLine().split(" ");
                String startCity = query[0];
                String destinationCity = query[1];

                int startCityIndex = cityNameToIndex.get(startCity);
                int destinationCityIndex = cityNameToIndex.get(destinationCity);

                int[] shortestDistances = findShortestPaths(numberOfCities, cityGraph, startCityIndex);

                System.out.println(shortestDistances[destinationCityIndex]);
            }
        }
    }
}
