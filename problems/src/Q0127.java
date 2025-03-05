import java.util.*;

public class Q0127 {
    public static void main(String[] args) {
        Q0127 obj = new Q0127();
        int ans =obj.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ans);
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        // do a bfs, starting from beginWord using queue, keep track of visited words, if not matched to endWord break
//        ArrayDeque<Object> queue = new ArrayDeque();
//        queue.addLast(beginWord);
//        queue.addLast(1);
//
//        Set<String> wordSet = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//
//        while(!queue.isEmpty()){
//            String word = (String)queue.removeFirst();
//            int count = (int) queue.removeFirst();
//
//            if(word.equals(endWord)){
//                return count;
//            }
//
//
//            // approach 2
//            char[] characters = word.toCharArray();
//            for(int i=0;i<word.length();i++){
//                for(int j='a';j<='z';j++) {
//                    char temp = characters[i];
//
//                    characters[i] = (char)j;
//                    String newWord = new String(characters); // multiply by length of word
//
//                    if(wordSet.contains(newWord) && !visited.contains(newWord)){
//                        queue.addLast(newWord);
//                        queue.addLast(count+1);
//                        visited.add(newWord);
//                    }
//
//                    characters[i] = temp;
//
//                }
//            }
//
//        }
//
//        return 0;
//    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // do a bfs, starting from beginWord using queue, keep track of visited words, if not matched to endWord break
        ArrayDeque<Object> queue = new ArrayDeque();
        queue.addLast(beginWord);
        queue.addLast(1);

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()){
            String word = (String)queue.removeFirst();
            int count = (int) queue.removeFirst();

            if(word.equals(endWord)){
                return count;
            }


            // approach 2
            char[] characters = word.toCharArray();
            for(int i=0;i<word.length();i++){
                for(int j='a';j<='z';j++) {
                    char temp = characters[i];

                    characters[i] = (char)j;
                    String newWord = new String(characters); // multiply by length of word

                    if(wordSet.contains(newWord) && !visited.contains(newWord)){
                        queue.addLast(newWord);
                        queue.addLast(count+1);
                        visited.add(newWord);
                    }

                    characters[i] = temp;

                }
            }

        }

        return 0;
    }


}
