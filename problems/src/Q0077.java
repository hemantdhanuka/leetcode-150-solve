import java.util.*;

public class Q0077 {
    public static void main(String[] args) {
        Q0077 obj = new Q0077();
        List<List<Integer>> ans = obj.combine(3,2);

        System.out.println(ans);
    }


//    approach-1
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> ansList = new ArrayList<>();
//        List<Integer> pickedElements = new ArrayList<>();
//
//        generate(1,0,pickedElements, ansList, n, k);
//
//        return ansList;
//    }
//
//    public void generate(int elementNo, int pickedCount, List<Integer> pickedElements, List<List<Integer>> ansList, int n, int k){
//        if(pickedCount == k) {
//            List copyList = this.copy(pickedElements);
//            ansList.add(copyList);
//            return;
//
//        }
//
//        if(elementNo > n){
//            return;
//        }
//
//        pickedElements.add(elementNo);
//        generate(elementNo+1, pickedCount+1, pickedElements, ansList, n,k );
//
//        pickedElements.remove(pickedElements.size()-1);
//        generate(elementNo+1, pickedCount, pickedElements, ansList, n, k);
//
//    }


    // approach-2
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> ansList = new ArrayList<>();
//        List<Integer> pickedElements = new ArrayList<>();
//
//        generate2(0,pickedElements, n, k, ansList);
//        return ansList;
//
//    }
//
//    public void generate2(int lastPicked, List<Integer> pickedList, int n, int remainingToPick, List<List<Integer>> ansList){
//        if(remainingToPick==0){
//            List<Integer> copyList = new ArrayList<>(pickedList);
//            ansList.add(copyList);
//            return;
//        }
//
//        for(int i=lastPicked+1;i<=n;i++){
//            pickedList.add(i);
//            generate2(i, pickedList, n, remainingToPick-1,ansList );
//            pickedList.remove(pickedList.size()-1);
//        }
//
//    }
//


    // approach 3:- (iterative)
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> ansList = new LinkedList<>();
//        LinkedList<LinkedList<Integer>> queueList = new LinkedList<>();
//
//        for(int i=1; i<=n;i++){
//            LinkedList<Integer> list = new LinkedList<>();
//            list.add(i);
//            queueList.add(list);
//        }
//
//        while(queueList.size() !=0){
//            LinkedList<Integer> list = queueList.removeFirst();
//
//            if(list.size() == k){
//                ansList.add(list);
//                continue;
//            }
//
//            int lastElement = list.getLast();
//            for(int i=lastElement+1;i<=n;i++){
//                LinkedList<Integer> clone = new LinkedList(list);
//                clone.addLast(i);
//                queueList.addLast(clone);
//            }
//        }
//
//        return ansList;
//    }
//
//
//
//    public List<Integer> copy(List<Integer> list){
//        List copyList = new ArrayList();
//        for(int item: list){
//            copyList.add(item);
//        }
//
//        return copyList;
//    }


    // approach 4 without passing
    public List<List<Integer>> combine(int n, int k) {
        return recursive(1, k, n);
    }

    public List<List<Integer>> recursive(int start,int remaining,  int n){
        List<List<Integer>> ansList = new ArrayList<>();
        if(remaining == 0){
            ansList.add(new ArrayList<>());
            return ansList;
        }



        for(int i=start;i<=n;i++){
          List<List<Integer>> result =  recursive(i+1, remaining-1, n);
          for(List<Integer> obj: result){
              obj.add(i);
              ansList.add(obj);
          }
        }

        return ansList;
    }

}
