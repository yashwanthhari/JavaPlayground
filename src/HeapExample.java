import java.util.ArrayList;
import java.util.List;

public class HeapExample {
    public static void main(String[] args){
        Heap heap = new Heap();
        int[] mock = {1, 2, 6, 11, -1, 15};
        for(int i: mock){
            heap.insert(i);
            System.out.println("done 1 insertion");
        }
        System.out.println("The heap");
        heap.printHeap();
        heap.delete(1);
        heap.printHeap();
    }

    static class Heap{
        List<Integer> heap;
        int last;

        public Heap(){
            heap = new ArrayList<>();
            heap.add(0);
            last = 0;
        }

        public void insert(int x){
            this.heap.add(++last, x);
            System.out.println("After adding new element");
            printHeap();
            this.swim(last);
        }

        public int getParent(int i){
            return i/2;
        }

        public int getLeft(int i){
            return 2*i;
        }

        public int getRight(int i){
            return 2*i + 1;
        }

        public void swim(int i){
            if (i <= 1)
                return;
            int parent = getParent(i);
            if(heap.get(parent) < heap.get(i)){
                swap(parent, i);
                System.out.println("After swapping");
                printHeap();
                swim(parent);
            }
        }

        public void swap(int i, int j){
            int t = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, t);
        }

        public void sink(int i){
            // TODO:
        }

        public List<Integer> getHeap(){
            return this.heap;
        }

        public void printHeap(){
            for(int i: heap){
                System.out.println(i);
            }
        }

        public void delete(int i){
            int li = getLeft(i);
            int ri = getRight(i);
            int left = (li <= last)? heap.get(li): Integer.MIN_VALUE;
            int right = (ri <= last)? heap.get(ri): Integer.MIN_VALUE;
            if(left >= right && left != Integer.MIN_VALUE) {
                heap.set(i, left);
                delete(li);
            } else if(right > left) {
                heap.set(i, right);
                delete(ri);
            } else {
                heap.remove(i);
            }
        }
    }
}
