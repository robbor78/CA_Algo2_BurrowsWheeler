import sort.StringWrapper;


public class RadixQuickSort {
    
//    private static int cntRecurse=0;
//    private static int cntExch=0;
//    private static int cntCmp=0;
//    private static int cntCharAt=0;

    public static void sort(StringWrapper[] a) {
        sort(a, 0, a.length - 1, 0);
        
//        System.out.println("cntRecurse= "+cntRecurse);
//        System.out.println("cntExch= "+cntExch);
//        System.out.println("cntCmp= "+cntCmp);
//        System.out.println("cntCharAt= "+cntCharAt);
    }

    private static void sort(StringWrapper[] a, int lo, int hi, int d) {

        //cntRecurse++;
        
        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int gt = hi;

        int v = charAt(a[lo], d);

        int i = lo + 1;

        while (i <= gt) {
            int t = charAt(a[i], d);

            //cntCmp++;
            if (t < v) {
                exch(a, lt++, i++);
            } else if (t > v) {
                //cntCmp++;
                exch(a, i, gt--);
            } else {
                //cntCmp++;
                i++;
            }
        }

        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);

    }

    private static void exch(StringWrapper[] a, int i, int j) {
        //cntExch++;
        
        StringWrapper swp = a[i];
        a[i] = a[j];
        a[j] = swp;
    }

    private static int charAt(StringWrapper s, int d) {
        //cntCharAt++;
        
        if (d < s.length()) {
            return s.charAt(d);
        }
        return -1;
    }

}
