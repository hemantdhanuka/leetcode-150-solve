import java.util.*;

public class Q0332 {
    public static void main(String[] args) {
        Q0332 obj = new Q0332();

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

    // approach-1
    // time complexity ->  ticketCount factorial
    // TLE
    //
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Edge>> graph = this.createGraph(tickets);

        String source = "JFK";
        ItinaryResult result = this.backTrack(source, 0,graph, tickets.size());
        result.getItinaries().addFirst(source);

        return result.getItinaries();

    }

    public ItinaryResult backTrack(String source, int pickedCount, Map<String, List<Edge>> graph, int totalTicketsCount){
        if(pickedCount == totalTicketsCount){
            return new ItinaryResult(true);
        }

        List<Edge> edges = graph.get(source);

        ItinaryResult result = new ItinaryResult(false);
        if(edges == null) {
            return result;
        }

        for(Edge edge: edges){
            if(edge.isVisited()){
                continue;
            }

            edge.setVisited(true);
            result = backTrack(edge.getDestination(), pickedCount+1, graph, totalTicketsCount);
            edge.setVisited(false);
            if(result.isPossible()){
                result.getItinaries().addFirst(edge.getDestination());
                break;
            }
        }
        return result;
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

    class ItinaryResult {
        boolean isPossible;
        LinkedList<String> itinaries;

        public ItinaryResult(boolean isPossible) {
            this.isPossible = isPossible;
            itinaries = new LinkedList<>();
        }

        public boolean isPossible() {
            return isPossible;
        }

        public LinkedList<String> getItinaries() {
            return itinaries;
        }
    }

}
