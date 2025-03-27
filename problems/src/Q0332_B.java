import java.util.*;

public class Q0332_B {
    public static void main(String[] args) {
        Q0332_B obj = new Q0332_B();

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

    // approach-2
    // time complexity O(V+E) => O(tickets)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Edge>> graph = this.createGraph(tickets);
        String source = "JFK";
        List<String> results = new ArrayList<>();
        this.backTrack(source,graph, results);

        // reverse results
        Collections.reverse(results);

        return results;
    }

    public void backTrack(String source, Map<String, List<Edge>> graph, List<String> results){
        List<Edge> edges = graph.getOrDefault(source, new ArrayList<>());
        // instead can be used priority queue
        for(Edge edge: edges){
            if(!edge.isVisited()){
                edge.setVisited(true);
                backTrack(edge.getDestination(), graph,results);
            }
        }

        results.add(source);

    }
    public Map<String, List<Edge>> createGraph(List<List<String>> tickets){
        Map<String, List<Edge>> graph = new HashMap<>();

        for(List<String> ticket: tickets){
            String source = ticket.get(0);
            String dest = ticket.get(1);

            List<Edge> edges = graph.get(source);
            if(edges == null){
                edges = new ArrayList<>();
            }
            Edge edge = new Edge(dest);
            edges.add(edge);

            graph.put(source, edges);
        }

        for( List<Edge> edges : graph.values()){
            Collections.sort(edges);
        }

        return graph;
    }


    class Edge implements Comparable<Edge> {
        String destination;
        boolean isVisited;

        public Edge(String destination) {
            this.destination = destination;
            this.isVisited = false;
        }

        public String getDestination() {
            return destination;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        @Override
        public int compareTo(Edge o) {
            return this.getDestination().compareTo(o.getDestination());
        }
    }

}
