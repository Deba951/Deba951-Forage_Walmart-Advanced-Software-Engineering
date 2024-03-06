package Task_1;

import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap{
    private List<Integer> heap;
    private int childrenFactor;

    public PowerOfTwoMaxHeap(int childrenFactor){
        this.heap = new ArrayList<>();
        this.childrenFactor = childrenFactor;
    }

    public void insert(int value){
        heap.add(value);
        bubbleUp(heap.size() - 1);
    }

    public int popMax(){
        
        if (isEmpty())
            throw new IllegalStateException("Heap is empty");
        
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        
        if (!isEmpty()){
            heap.set(0, last);
            trickleDown(0);
        }
        
        return max;
    }

    private void bubbleUp(int index){
        while (index > 0){
            int parentIndex = (index - 1) / childrenFactor;

            if (heap.get(index) <= heap.get(parentIndex))
                break;
            
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void trickleDown(int index){
        while (true){
            int maxChildIndex = getMaxChildIndex(index);

            if (maxChildIndex == -1 || heap.get(index) >= heap.get(maxChildIndex))
                break;
            
            swap(index, maxChildIndex);
            index = maxChildIndex;
        }
    }

    private int getMaxChildIndex(int index){
        int start = index * childrenFactor + 1;
        
        if (start >= heap.size())
            return -1;
        
        int maxIndex = start;
        int end = Math.min(start + childrenFactor, heap.size());
        for (int i=start+1; i<end; i++){
         
            if (heap.get(i) > heap.get(maxIndex))
                maxIndex = i;
        }
        return maxIndex;
    }

    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private boolean isEmpty(){
        return heap.isEmpty();
    }

    public void print(){
        for (int i=0; i<heap.size(); i++){
            System.out.print(heap.get(i));
            System.out.print(',');
        }
        System.out.println();
    }
    public static void main(String[] args){
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2);
        heap.insert(100);
        heap.insert(50);
        heap.insert(200);
        heap.insert(105);
        heap.insert(205);
        // System.out.println("Max: " + heap.popMax());
        // System.out.println("Max: " + heap.popMax());         
        heap.print();
        int maxItem = heap. popMax () ;
        System.out.println("Max item: " + maxItem);
    }
}