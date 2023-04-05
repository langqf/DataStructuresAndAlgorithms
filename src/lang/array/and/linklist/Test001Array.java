package lang.array.and.linklist;

public class Test001Array {
    public static void main(String[] args) {
        java.util.ArrayList<Integer> al = new java.util.ArrayList();
        al.add(1);
        al.add(2);
        System.out.println(al.get(0));
        System.out.println(al.get(1));
        System.out.println(al.size());
        System.out.println("============================分界线========================");
        ArrayList<Integer> myAl0 = new ArrayList<Integer>("myAl0",10);
        System.out.println(myAl0.getElement(0));
        ArrayList<Integer> myAl = new ArrayList<Integer>("myAl");
        System.out.println("isEmpty=" + myAl.isEmpty());
        for(int i  = 9; i > 0; i--){
            myAl.listAdd(i);
        }
        myAl.listAll();
        myAl.listInsert(3,11111);
        myAl.listAll();
        myAl.listDelete(3);
        myAl.listAll();
        System.out.println();
        System.out.println(myAl.getElement(4));
        System.out.println(myAl.locateList(8));
        System.out.println("isEmpty=" + myAl.isEmpty());
        myAl.clearList();
        myAl.listAll();
        myAl.destroyList();
        myAl.listAll();
    }

}
