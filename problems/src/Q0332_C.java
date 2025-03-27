import java.util.*;

public class Q0332_C {
    public static void main(String[] args) {
        Q0332_C obj = new Q0332_C();

        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")

        );

        System.out.println(obj.findItinerary(tickets));
    }

    // same as approach-2, but used priority queue instead of sorted list.
    // time complexity O(V+E) => O(tickets)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = this.createGraph(tickets);
        String source = "JFK";
        List<String> results = new ArrayList<>();
        this.backTrack(source,graph, results);

        // reverse results
        Collections.reverse(results);

        return results;
    }

    public void backTrack(String source, Map<String, Queue<String>> graph, List<String> results){
        Queue<String> edges = graph.getOrDefault(source, new PriorityQueue<>());
        // instead can be used priority queue
        while(!edges.isEmpty()){
            String edge = edges.remove();
            backTrack(edge, graph,results);
        }

        results.add(source);

    }
    public Map<String, Queue<String>> createGraph(List<List<String>> tickets){
        Map<String, Queue<String>> graph = new HashMap<>();

        for(List<String> ticket: tickets){
            String source = ticket.get(0);
            String dest = ticket.get(1);

            Queue<String> edges = graph.get(source);
            if(edges == null){
                edges = new PriorityQueue<>(String::compareTo);
            }

            edges.add(dest);
            graph.put(source, edges);
        }

        return graph;
    }
}
