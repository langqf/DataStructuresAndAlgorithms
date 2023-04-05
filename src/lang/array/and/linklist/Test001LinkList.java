package lang.array.and.linklist;

import java.util.LinkedList;

public class Test001LinkList {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList();
        ll.add("c");
        ll.add("b");
        ll.add("a");
        for(int i = 0; i < ll.size(); i++){
            System.out.println(ll.get(i));
        }
        ll.get(3);
        System.out.println("============分割线=============");
        LinkList<String> lls = new LinkList<>("lls");
        lls.listAdd("b");
        lls.listAdd("e");
        lls.listAdd("j");
        lls.listAdd("3");
        lls.listAll();
        System.out.println(lls.getElement(0));
        System.out.println(lls.getElement(3));
        System.out.println(lls.getElement(1));
        System.out.println(lls.getElement(2));
        System.out.println(lls.getElement(-999));
        System.out.println(lls.getElement(999));
        System.out.println("============分割线=============");
        System.out.println("j所在位置：" + lls.locateList("j"));
        System.out.println("b所在位置：" + lls.locateList("b"));
        System.out.println("3所在位置：" + lls.locateList("3"));
        System.out.println(lls.locateList(null));
        System.out.println(lls.locateList("x"));
        System.out.println("============分割线=============");
        lls.listAll();
        lls.listInsert(3, "33");
        System.out.println("last is " + lls.getLast());
        lls.listAll();
        lls.listInsert(5, "44");
        System.out.println("last is " + lls.getLast());
        lls.listAll();
        lls.listInsert(0,"00");
        System.out.println("last is " + lls.getLast());
        lls.listAll();
        lls.listInsert(2,"aa");
        System.out.println("last is " + lls.getLast());
        lls.listAll();
        System.out.println("last is " + lls.getLast());

        lls.listDelete(lls.listSize() -1);
        lls.listAll();
        System.out.println("last is " + lls.getLast());
        lls.listDelete(0);
        lls.listAll();
        System.out.println("last is " + lls.getLast());
        lls.listDelete(1);
        lls.listAll();
        System.out.println("last is " + lls.getLast());
        lls.listInsert(5, "44");
        lls.listAll();
        System.out.println("last is " + lls.getLast());
        lls.listAdd("000000000");
        lls.listAll();
        System.out.println("last is " + lls.getLast());
//        lls.listAdd(-2,"-2");
        lls.listInsert(9,"99999");
    }
}
