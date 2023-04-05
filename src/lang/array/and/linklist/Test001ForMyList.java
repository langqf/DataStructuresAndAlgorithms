package lang.array.and.linklist;

public class Test001ForMyList {

    public static void main(String[] args) {
        // la 7、5、3、11    lb 2、6、3   la U lb =7、5、3、11、 2、 6
        /*MyList<Integer> la = new ArrayList<>("la");
        la.listAdd(7);
        la.listAdd(5);
        la.listAdd(3);
        la.listAdd(11);
        la.listAll();
        MyList<Integer> lb = new ArrayList<>("lb");
        lb.listAdd(2);
        lb.listAdd(6);
        lb.listAdd(3);
        lb.listAll();
        union(la, lb);
        la.listAll();
        lb.listAll();*/

        /*System.out.println("=====================分割线==================");
        MyList<Integer> lla = new LinkList<>("lla");
        lla.listAdd(7);
        lla.listAdd(5);
        lla.listAdd(3);
        lla.listAdd(11);
        lla.listAll();
        MyList<Integer> llb = new LinkList<>("llb");
        llb.listAdd(2);
        llb.listAdd(6);
        llb.listAdd(3);
        llb.listAll();
        union(lla, llb);
        lla.listAll();
        llb.listAll();*/

        /*System.out.println("=====================分割线==================");
        MyList<String> lla = new LinkList<>("lla");
        lla.listAdd("7");
        lla.listAdd("5");
        lla.listAdd("3");
        lla.listAdd("11");
        lla.listAll();
        MyList<String> llb = new LinkList<>("llb");
        llb.listAdd("2");
        llb.listAdd("6");
        llb.listAdd("3");
        llb.listAdd(new String("5"));
        llb.listAll();
        union(lla, llb);
        lla.listAll();
        llb.listAll();*/
        /*System.out.println("=====================分割线：有序链表合并  数组实现 ==================");
        MyList<Integer> lla = new ArrayList("lla");
        lla.listAdd(1);
        lla.listAdd(7);
        lla.listAdd(8);
        lla.listAll();
        MyList<Integer> llb = new ArrayList("llb");
        llb.listAdd(2);
        llb.listAdd(4);
        llb.listAdd(6);
        llb.listAdd(8);
        llb.listAdd(10);
        llb.listAdd(11);
        llb.listAll();
//        unionOrderLinklist2(lla, llb);
//        unionOrderLinklist2(llb, lla);
        LinkList<Integer> llc = new LinkList("llc");
//        unionOrderLinklist3(lla, llb, llc);
        lla.listAll();
        llb.listAll();
        llc.listAll();*/

        System.out.println("=====================分割线：有序链表合并  链表实现 ==================");
        LinkList<Integer> lla = new LinkList("lla");
        lla.listAdd(1);
        lla.listAdd(7);
        lla.listAdd(8);
        lla.listAll();
        LinkList<Integer> llb = new LinkList("llb");
        llb.listAdd(2);
        llb.listAdd(4);
        llb.listAdd(6);
        llb.listAdd(8);
        llb.listAdd(10);
        llb.listAdd(11);
        llb.listAll();
        LinkList<Integer> llc = new LinkList("llc");
        unionOrderLinklist4(lla, llb, llc);
        lla.listAll();
        llb.listAll();
        llc.listAll();

    }


    public static void union(MyList la, MyList lb) {
        int lb_len = lb.listLength();
        for (int i = 0; i < lb_len; i++) {
            Object element = lb.getElement(i);
            int pos = la.locateList(element);
            if (pos == -1) {
                la.listAdd(element);
            }
        }
    }

    // 非递减有序链表合并1 时间复杂度O(a*b*b)  太复杂
    public static void unionOrderLinklist1(LinkList<Integer> la, LinkList<Integer> lb) {
        int la_len = la.listLength();
        for (int i = 0; i < la_len; i++) {
            Integer ea = la.getElement(i);
            boolean max = true;
            int lb_len = lb.listLength();
            for (int j = 0; j < lb_len; j++) {
                Integer eb = lb.getElement(j);
                if (ea <= eb) {
                    max = false;
                    lb.listInsert(j, ea);
                    break;
                }
            }
            if (max) {
                lb.listAdd(ea);
            }
        }
    }

    // 非递减有序链表合并2  找到之后记下来，下次从记下来的位置找，不用重写从头开始，时间复杂度O(a+b*b)
    public static void unionOrderLinklist2(LinkList<Integer> la, LinkList<Integer> lb) {
        int la_len = la.listLength();
        int currentIndex = 0;
        for (int i = 0; i < la_len; i++) {
            Integer ea = la.getElement(i);
            int lb_len = lb.listLength();
            if (currentIndex >= lb_len) {
                lb.listAdd(ea);
            } else {
                boolean max = true;
                for (int j = currentIndex; j < lb_len; j++) {
                    Integer eb = lb.getElement(j);
                    if (ea <= eb) {
                        max = false;
                        lb.listInsert(j, ea);
                        currentIndex = j + 1;
                        break;
                    }
                }
                if (max) {
                    lb.listAdd(ea);
                    currentIndex = lb.listLength();
                }
            }
        }
    }

    // 非递减有序链表合并3 数组方式实现  两两比较，将较小的添加到第三个集合中，时间复杂度是O(a+b)，空间复杂度O(a+b)
    public static MyList<Integer> unionOrderLinklist3(MyList<Integer> la, MyList<Integer> lb, MyList<Integer> lc) {
        int la_len = la.listLength();
        int lb_len = lb.listLength();
        int i = 0, j = 0;
        while(i < la_len && j < lb_len){
            int ea = la.getElement(i);// 用链表时间复杂度O(a)
            int eb = lb.getElement(j);// 用链表时间复杂度O(b)
            if(ea <= eb){
                lc.listAdd(ea);
                i++;
            }else{
                lc.listAdd(eb);
                j++;
            }
        }
        if(i <= la_len){
            for(int x = i ; x < la_len; x++){
                lc.listAdd(la.getElement(x));
            }

        }
        if(j <= lb_len){
            for(int x = j ; x < lb_len; x++){
                lc.listAdd(lb.getElement(x));
            }
        }
        return lc;
    }

    // 非递减有序链表合并3 链表方式实现  两两比较，不断改变引用内容，时间复杂度是O(a+b)，不需要额外空间，但是lc的size不能更新
    public static MyList<Integer> unionOrderLinklist4(LinkList<Integer> la, LinkList<Integer> lb, LinkList<Integer> lc) {
        LinkList.Node<Integer> headA = la.getHead();
        LinkList.Node<Integer> headB = lb.getHead();
        LinkList.Node<Integer> headC = lc.getHead();
        LinkList.Node<Integer> p1 = headA.getNext();
        LinkList.Node<Integer> p2 = headB.getNext();
        LinkList.Node<Integer> p3 = headC;
        while(p1 != null && p2 != null){
            if(p1.getE() <= p2.getE()){
                p3.setNext(p1);
                p3 = p1;
                p1 = p1.getNext();
            }else{
                p3.setNext(p2);
                p3 = p2;
                p2 = p2.getNext();
            }
        }
        if(p1 != null){
            p3.setNext(p1);
        }
        if(p2 != null){
            p3.setNext(p2);
        }
        return lc;
    }

}
