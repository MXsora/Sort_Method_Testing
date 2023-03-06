public class Sortings {

    /**
     * Sorts an array using simple insertion.
     * @param data the array being used
     */

    public static void insertionSort (int[] data) {
        if(data == null) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            int j = i-1;
            while (j>=0 && data[j] > value)
            {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = value;
        }
    }

    /**
     * Sorts a linked list using simple insertion.
     * @param head the head of the list
     * @return the newly sorted list
     */

    public static Node insertionSort (Node head) {
        Node sorted = null;
        Node current = head;
        while (current != null) {
            int key = current.getData();
            sorted = insertInto(sorted, key);
            current = current.getLink();
        }
        return sorted;
    }

    /**
     * A helper method for inserting nodes in a list for the insertionSort.
     * @param list the list being used
     * @param value the value to be inserted into the list
     * @return the list with the new element properly sorted
     */

    private static Node insertInto(Node list, int value) {
        if (list == null) {
            return new Node(value, null);
        }

        Node prev = null;
        Node current = list;
        while (current != null && current.getData() < value) {
            prev = current;
            current = current.getLink();
        }
        Node insertedValue = new Node(value, current);
        if (prev == null) {
            return insertedValue;
        } else {
            prev.setLink(insertedValue);
            return list;
        }
    }

    /**
     * A container method for mergeSort to simplify the parameters check for null exceptions.
     * @param data the array being used
     */

    public static void mergeSort(int[] data) {
        if(data == null){
            return;
        }
        mergeSort(data, 0, data.length);
    }

    /**
     * Sorts an array by dividing and merging it back together.
     * @param data the array being used
     * @param start the index position to start
     * @param count the length of the array or the stopping position
     */

    public static void mergeSort(int[] data, int start, int count) {
        int mid;
        int rest;
        if (count > 1) {
            mid = count / 2;
            rest = count - mid;
            mergeSort(data, start, mid);
            mergeSort(data, start + mid, rest);
            merge(data, start, mid, rest);
        }
    }

    /**
     * merges two given arrays and sorts them.
     * @param data the array being used
     * @param first the starting index position
     * @param n1 the size of the first array
     * @param n2 the size of the second array
     */

    private static void merge(int[] data, int first, int n1, int n2) {
        int[] temp = new int[n1+n2];
        int copied  = 0;
        int copied1 = 0;
        int copied2 = 0;
        while (copied1 < n1 && copied2 < n2) {
            if (data[first + copied1] < data[first + n1 + copied2]) {
                temp[copied] = data[first + copied1];
                copied++;
                copied1++;
            }
            else {
                temp[copied] = data[first + n1 + copied2];
                copied++;
                copied2++;
            }
        }
        while (copied1 < n1) {
            temp[copied] = data[first + (copied1)];
            copied++;
            copied1++;
        }
        while (copied2 < n2) {
            temp[copied] = data[first + n1 + (copied2)];
            copied++;
            copied2++;
        }
        for (int i = 0; i < temp.length; i++) {
            data[first + i] = temp[i];
        }
    }

    /**
     * A container method that simplifies the parameters for mergeSort and checks for null exceptions.
     * @param head the start of the linked list to be sorted
     * @return the newly sorted list
     */

    public static Node mergeSort (Node head) {
        if(head == null) {
            return null;
        }
        Node tail = head;
        while (tail.getLink() != null) {
            tail = tail.getLink();
        }
        return mergeSort(head, tail);
    }

    /**
     * Sorts a linked list by dividing and merging.
     * @param first the head or start of the linked list
     * @param last the end of the linked list
     * @return the sorted linked list
     */

    public static Node mergeSort(Node first, Node last) {
        if (first != last) {
            Node mid = first;
            Node end = first.getLink();
            while (end != last) {
                mid = mid.getLink();
                end = end.getLink();
                if (end != last) {
                    end = end.getLink();
                }
            }
            Node left = mergeSort(first, mid);
            Node right = mergeSort(mid.getLink(), last);
            return merge(left, right);
        } else {
            return new Node(first.getData(), null);
        }
    }

    /**
     * Merges two given linked lists and sorts them.
     * @param left the first linked list
     * @param right the second linked list
     * @return the combined linked list
     */

    private static Node merge(Node left, Node right) {
        Node head = null;
        while (left != null && right != null) {
            if (left.getData() < right.getData()) {
                head = insertInto(head, left.getData());
                left = left.getLink();
            } else {
                head = insertInto(head, right.getData());
                right = right.getLink();
            }
        }

        while (left != null) {
            head = insertInto(head, left.getData());
            left = left.getLink();
        }
        while (right != null) {
            head = insertInto(head, right.getData());
            right = right.getLink();
        }
        return head;
    }

    /**
     * Sorts an array by creating a heap and then removing its root and adding them back into the original arry.
     * @param data the array being used
     */

    public static void heapSort (int[] data) {
        if(data == null) {
            return;
        }
        int[] heapArr = new int[data.length];
        for(int i = 0; i < data.length; i++) {
            add(heapArr, data[i], i);
        }
        for(int i = data.length-1; i >= 0; i--) {
            data[i] = removeRoot(heapArr);
        }
    }

    /**
     * Grabs the parent of a given index.
     * @param index the index to find the parent of
     * @return parent index
     */

    private static int getParent(int index) {
        return (index - 1)/2;
    }

    /**
     * Grabs the left child of a given index.
     * @param data the array being used
     * @param index the index to find the child of
     * @return left child index
     */

    private static int getLeftChild(int[] data, int index) {
        if((1 + (index * 2)) >= data.length) {
            return -1;
        }
        return 1 + (index * 2);
    }

    /**
     * Grabs the right child of a given index
     * @param data the array being used
     * @param index the index to find the child of
     * @return right child index
     */

    private static int getRightChild(int[] data, int index) {
        if((2 + (index * 2)) >= data.length) {
            return -1;
        }
        return 2 + (index * 2);
    }

    /**
     * Adds an element to an array and reheaps it up if necessary.
     * @param data the array being used
     * @param element the element to be added
     * @param index the index position to add it to
     */

    private static void add(int[] data, int element, int index) {
        data[index] = element;
        reheapUp(data, index);
    }

    /**
     * Swaps two index values
     * @param data the array being used
     * @param index1 first position to swap
     * @param index2 second position to swap
     */

    private static void swap(int[] data, int index1, int index2) {
        int index1DataCopy = data[index1];
        data[index1] = data[index2];
        data[index2] = index1DataCopy;
    }

    /**
     * Reheapifys downward used when removing.
     * @param data the array to reheapify
     * @param index the index that needs to be reheaped
     */

    private static void reheapDown(int[] data, int index) {
        int leftChild = getLeftChild(data, index);
        int rightChild = getRightChild(data, index);
        if(leftChild <= -1) {
            return;
        }
        if(rightChild <= -1 || data[leftChild] > data[rightChild]) {
            if(data[index] < data[leftChild]){
                swap(data, index, leftChild);
                reheapDown(data, leftChild);
            }
        }else{
            if(data[index] < data[rightChild]){
                swap(data, index, rightChild);
                reheapDown(data, rightChild);
            }
        }
    }

    /**
     * Reheapifys upward used when adding.
     * @param data the array to reheapify
     * @param index the index that needs to be reheaped
     */

    private static void reheapUp(int[] data, int index) {
        int parent = getParent(index);
        while(data[index] != data[parent] && data[index] > data[parent]) {
            swap(data, index, parent);
            index = parent;
            parent = getParent(parent);
        }
    }

    /**
     * Removes the root and reheapifys the array.
     * @param data the array to remove the root from.
     * @return returns the value of the removed root.
     */
    private static int removeRoot(int[] data) {
        int answer = data[0];
        data[0] = -1;
        reheapDown(data,0);
        return answer;
    }
}
