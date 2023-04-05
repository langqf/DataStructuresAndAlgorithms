package lang.array.and.linklist;

public interface MyList<T> {

    void listAdd(T t);

    void listInsert(int i, T e);

    void listDelete(int i);

    Boolean isEmpty();

    int listLength();

    int locateList(T e);

    T getElement(int i);

    void listAll();

}
