import java.text.DecimalFormat;
import java.util.Random;

public class Test {

    static int[] data;
    static Node head;
    static int TOP = 12000000;
    static double startTime;

    private static Random rand = new Random();


    /**
     * fills an array and linked list with random integer values up to 12000000.
     * @param arrSize the size to instantiate the array.
     */

    public static void randomData(int arrSize) {
        head = null;
        data = new int[arrSize];
        for (int i = data.length-1; i >= 0; i--) {
            data[i] = rand.nextInt(TOP);
            if (head == null) {
                head = new Node(data[i], null);
            } else {
                head.addNodeAfter(data[i]);
            }
        }
    }

    /**
     * A simple method to calculate the time since the last appointed starting time.
     * @return a string of how many seconds between the call and start time
     */

    public static String calculateTime(){
        DecimalFormat df2 = new DecimalFormat("#.########");
        double result = (System.nanoTime() - startTime) / 1000000000;
        return df2.format(result);
    }

    /**
     * Tests all sorting algorithms by first calling random data and then analyzing its performance time for each
     * @param size the size of the arrays and lists that will be created for testing
     */

    public static void testSort(int size) {
        randomData(size);
        startTime = System.nanoTime();
        Sortings.insertionSort(data);
        System.out.println("Insertion sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        randomData(size);
        startTime = System.nanoTime();
        head = Sortings.insertionSort(head);
        System.out.println("Insertion sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        randomData(size);
        startTime = System.nanoTime();
        Sortings.mergeSort(data);
        System.out.println("Merge sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        randomData(size);
        startTime = System.nanoTime();
        head = Sortings.mergeSort(head);
        System.out.println("Merge sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        randomData(size);
        startTime = System.nanoTime();
        System.out.println("Heap sort of this array took " + calculateTime() + " seconds.");
        Sortings.heapSort(data);
        displayArray();
    }

    /**
     * Displays the array in the console up to only 200 values which are then cut down to 50
     */

    public static void displayArray() {
        int n = data.length;
        int k = 1;
        if (n > 200) {
            k = n/50;
        }

        for (int i = 0; i < n; i = i+k) {
            System.out.print("data[" + i + "]:     " + data[i] + "\n");
        }
        System.out.println();
    }

    /**
     * Displays the list to the console by calling toStringRecursive which limits it to 20 calls.
     */

    public static void displayList() {
        System.out.println(head.toStringRecurse());
        System.out.println();
    }

    public static void main( String[] args ) {
        System.out.println("Testing all algorithms with a size of 10");
        testSort(10);

        System.out.println("Testing all algorithms with a size of 1");
        testSort(1);

        System.out.println("Testing all algorithms with a size of 0");
        head = null;
        data = null;
        Sortings.insertionSort(data);
        Sortings.insertionSort(head);
        Sortings.mergeSort(data);
        Sortings.mergeSort(head);
        Sortings.heapSort(data);




        System.out.println("Testing all algorithms with a sorted array of 160000");
        data = new int[160000];
        int tempCounter = 160000;
        for(int i = 0; i < 160000; i++){
            data[i] = i;
            if (head == null) {
                head = new Node(data[i], null);
            } else {
                head.addNodeAfter(tempCounter);
            }
            tempCounter--;
        }
        startTime = System.nanoTime();
        Sortings.insertionSort(data);
        System.out.println("Insertion sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        startTime = System.nanoTime();
        head = Sortings.insertionSort(head);
        System.out.println("Insertion sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        startTime = System.nanoTime();
        Sortings.mergeSort(data);
        System.out.println("Merge sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        startTime = System.nanoTime();
        head = Sortings.mergeSort(head);
        System.out.println("Merge sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        startTime = System.nanoTime();
        System.out.println("Heap sort of this array took " + calculateTime() + " seconds.");
        Sortings.heapSort(data);
        displayArray();




        System.out.println("Testing all algorithms with a descending sorted array of 160000");
        data = new int[160000];
        tempCounter = 160000;
        for(int i = 0; i < 160000; i++){
            data[i] = tempCounter;
            if (head == null) {
                head = new Node(data[i], null);
            } else {
                head.addNodeAfter(i);
            }
            tempCounter--;
        }
        startTime = System.nanoTime();
        Sortings.insertionSort(data);
        System.out.println("Insertion sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        startTime = System.nanoTime();
        head = Sortings.insertionSort(head);
        System.out.println("Insertion sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        startTime = System.nanoTime();
        Sortings.mergeSort(data);
        System.out.println("Merge sort of this array took " + calculateTime() + " seconds.");
        displayArray();
        startTime = System.nanoTime();
        head = Sortings.mergeSort(head);
        System.out.println("Merge sort of this linked list took " + calculateTime() + " seconds.");
        displayList();
        startTime = System.nanoTime();
        System.out.println("Heap sort of this array took " + calculateTime() + " seconds.");
        Sortings.heapSort(data);
        displayArray();




        System.out.println("Testing all algorithms with a size of 20");
        testSort(20);

        System.out.println("Testing all algorithms with a size of 5000");
        testSort(5000);

        System.out.println("Testing all algorithms with a size of 10000");
        testSort(10000);

        System.out.println("Testing all algorithms with a size of 20000");
        testSort(20000);

        System.out.println("Testing all algorithms with a size of 40000");
        testSort(40000);

        System.out.println("Testing all algorithms with a size of 80000");
        testSort(80000);

        System.out.println("Testing all algorithms with a size of 160000");
        testSort(160000);

        System.out.println("Testing all algorithms with a size of 320000");
        testSort(320000);

        System.out.println("Testing all algorithms with a size of 640000");
        testSort(640000);

        System.out.println("Testing all algorithms with a size of 1280000");
        testSort(1280000);

        System.out.println("Testing all algorithms with a size of 2560000");
        testSort(2560000);

        System.out.println("Testing all algorithms with a size of 5120000");
        testSort(5120000);

        System.out.println("Testing all algorithms with a size of 10240000");
        testSort(10240000);
    }




    //console print out of phase 1 tests



//    Testing all algorithms with a size of 10
//    Insertion sort of this array took 0.01469706 seconds.
//    data[0]:     1425592
//    data[1]:     3328004
//    data[2]:     4263706
//    data[3]:     4398947
//    data[4]:     4855722
//    data[5]:     5184476
//    data[6]:     8082367
//    data[7]:     8641781
//    data[8]:     10728810
//    data[9]:     11433935
//
//    Insertion sort of this linked list took 0.00005077 seconds.
//    Node0:     1561346
//    Node1:     2508360
//    Node2:     3159695
//    Node3:     4180532
//    Node4:     5084174
//    Node5:     8600648
//    Node6:     9614484
//    Node7:     11034574
//    Node8:     11367259
//    Node9:     11774445
//            null in tail
//
//    Merge sort of this array took 0.00005158 seconds.
//    data[0]:     1782686
//    data[1]:     2340614
//    data[2]:     2723568
//    data[3]:     3778576
//    data[4]:     4513652
//    data[5]:     5815244
//    data[6]:     6346293
//    data[7]:     6491063
//    data[8]:     8449653
//    data[9]:     10453596
//
//    Merge sort of this linked list took 0.00004861 seconds.
//    Node0:     1323377
//    Node1:     3316714
//    Node2:     3492110
//    Node3:     4429954
//    Node4:     4554815
//    Node5:     7153646
//    Node6:     9065440
//    Node7:     9223432
//    Node8:     10087379
//    Node9:     11450665
//            null in tail
//
//    Heap sort of this array took 0.00002673 seconds.
//    data[0]:     773880
//    data[1]:     3900234
//    data[2]:     4489079
//    data[3]:     5676829
//    data[4]:     6943346
//    data[5]:     7518081
//    data[6]:     8978320
//    data[7]:     10653085
//    data[8]:     11118339
//    data[9]:     11464336
//
//    Testing all algorithms with a size of 1
//    Insertion sort of this array took 0.00003187 seconds.
//    data[0]:     6564155
//
//    Insertion sort of this linked list took 0.00002052 seconds.
//    Node0:     354042
//            null in tail
//
//    Merge sort of this array took 0.00001512 seconds.
//    data[0]:     10897734
//
//    Merge sort of this linked list took 0.0000162 seconds.
//    Node0:     5795255
//            null in tail
//
//    Heap sort of this array took 0.00001377 seconds.
//    data[0]:     10949143
//
//    Testing all algorithms with a size of 0
//
//    Process finished with exit code 0






    //comments on phase 2
    //I was surprised to not run into any StackOverflowErrors or OutOfMemoryErrors. Honestly the only thing
    //that stopped me from trying all algorithms on the largest size were how long they took. Below is a sample before
    //the insertionSort linked list begins to avalanche and it takes way too long to process.


//    Testing all algorithms with a size of 160000
//    Insertion sort of this array took 1.91881661 seconds.
//    data[0]:     103
//    data[3200]:     242885
//    data[6400]:     487093
//    data[9600]:     720302
//    data[12800]:     969884
//    data[16000]:     1202890
//    data[19200]:     1441155
//    data[22400]:     1673506
//    data[25600]:     1926432
//    data[28800]:     2165911
//    data[32000]:     2403196
//    data[35200]:     2637386
//    data[38400]:     2876607
//    data[41600]:     3116961
//    data[44800]:     3359853
//    data[48000]:     3603463
//    data[51200]:     3845715
//    data[54400]:     4081486
//    data[57600]:     4325979
//    data[60800]:     4567078
//    data[64000]:     4805035
//    data[67200]:     5038688
//    data[70400]:     5275937
//    data[73600]:     5522169
//    data[76800]:     5757837
//    data[80000]:     5993084
//    data[83200]:     6230705
//    data[86400]:     6478118
//    data[89600]:     6721725
//    data[92800]:     6957967
//    data[96000]:     7196220
//    data[99200]:     7439794
//    data[102400]:     7688423
//    data[105600]:     7924852
//    data[108800]:     8164672
//    data[112000]:     8407750
//    data[115200]:     8645200
//    data[118400]:     8878497
//    data[121600]:     9120337
//    data[124800]:     9361306
//    data[128000]:     9598128
//    data[131200]:     9842589
//    data[134400]:     10087444
//    data[137600]:     10331948
//    data[140800]:     10571794
//    data[144000]:     10810254
//    data[147200]:     11048104
//    data[150400]:     11282209
//    data[153600]:     11524530
//    data[156800]:     11764317
//
//    Insertion sort of this linked list took 98.3943748 seconds.
//    Node0:     27
//    Node1:     134
//    Node2:     161
//    Node3:     183
//    Node4:     267
//    Node5:     501
//    Node6:     702
//    Node7:     767
//    Node8:     793
//    Node9:     798
//    Node10:     910
//    Node11:     1012
//    Node12:     1088
//    Node13:     1296
//    Node14:     1321
//    Node15:     1349
//    Node16:     1467
//    Node17:     1549
//    Node18:     1558
//    Node19:     2221
//    Node20:     2232
//    Over 20 recursive calls, ending the loop.
//
//    Merge sort of this array took 0.02170223 seconds.
//    data[0]:     1
//    data[3200]:     240790
//    data[6400]:     480549
//    data[9600]:     722976
//    data[12800]:     960660
//    data[16000]:     1203657
//    data[19200]:     1444206
//    data[22400]:     1680288
//    data[25600]:     1916269
//    data[28800]:     2155677
//    data[32000]:     2398365
//    data[35200]:     2639029
//    data[38400]:     2880588
//    data[41600]:     3126251
//    data[44800]:     3369256
//    data[48000]:     3613226
//    data[51200]:     3850356
//    data[54400]:     4082849
//    data[57600]:     4328960
//    data[60800]:     4561751
//    data[64000]:     4794868
//    data[67200]:     5032493
//    data[70400]:     5263618
//    data[73600]:     5500780
//    data[76800]:     5742064
//    data[80000]:     5977068
//    data[83200]:     6220280
//    data[86400]:     6458010
//    data[89600]:     6697907
//    data[92800]:     6942430
//    data[96000]:     7187068
//    data[99200]:     7423133
//    data[102400]:     7662655
//    data[105600]:     7907184
//    data[108800]:     8145915
//    data[112000]:     8391597
//    data[115200]:     8632069
//    data[118400]:     8869845
//    data[121600]:     9109469
//    data[124800]:     9355121
//    data[128000]:     9597947
//    data[131200]:     9838349
//    data[134400]:     10080063
//    data[137600]:     10322403
//    data[140800]:     10564270
//    data[144000]:     10804634
//    data[147200]:     11039910
//    data[150400]:     11276924
//    data[153600]:     11514553
//    data[156800]:     11754450
//
//    Merge sort of this linked list took 44.31811185 seconds.
//    Node0:     134
//    Node1:     219
//    Node2:     317
//    Node3:     625
//    Node4:     639
//    Node5:     697
//    Node6:     701
//    Node7:     769
//    Node8:     801
//    Node9:     1051
//    Node10:     1058
//    Node11:     1069
//    Node12:     1199
//    Node13:     1241
//    Node14:     1247
//    Node15:     1742
//    Node16:     1811
//    Node17:     1821
//    Node18:     1821
//    Node19:     1835
//    Node20:     1872
//    Over 20 recursive calls, ending the loop.
//
//    Heap sort of this array took 0.00004402 seconds.
//    data[0]:     49
//    data[3200]:     234151
//    data[6400]:     477192
//    data[9600]:     716415
//    data[12800]:     963320
//    data[16000]:     1198984
//    data[19200]:     1435543
//    data[22400]:     1673592
//    data[25600]:     1912022
//    data[28800]:     2146570
//    data[32000]:     2383623
//    data[35200]:     2630835
//    data[38400]:     2868967
//    data[41600]:     3105596
//    data[44800]:     3347961
//    data[48000]:     3590656
//    data[51200]:     3830802
//    data[54400]:     4074210
//    data[57600]:     4305456
//    data[60800]:     4547885
//    data[64000]:     4793074
//    data[67200]:     5030143
//    data[70400]:     5266226
//    data[73600]:     5504437
//    data[76800]:     5739791
//    data[80000]:     5974766
//    data[83200]:     6211179
//    data[86400]:     6454147
//    data[89600]:     6697166
//    data[92800]:     6942909
//    data[96000]:     7192283
//    data[99200]:     7425678
//    data[102400]:     7661334
//    data[105600]:     7914371
//    data[108800]:     8160406
//    data[112000]:     8404961
//    data[115200]:     8645492
//    data[118400]:     8880193
//    data[121600]:     9129309
//    data[124800]:     9368539
//    data[128000]:     9607709
//    data[131200]:     9856372
//    data[134400]:     10095492
//    data[137600]:     10331266
//    data[140800]:     10574176
//    data[144000]:     10805425
//    data[147200]:     11044270
//    data[150400]:     11283614
//    data[153600]:     11521158
//    data[156800]:     11763215

}
