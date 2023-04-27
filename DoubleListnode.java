package model;

/**
 *
 * @author Kasih_175314122
 *
 *
 */
public class DoubleListnode {

    private Song data;
    private DoubleListnode next, prev;

    public DoubleListnode() {
    }

    public DoubleListnode(Song data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public DoubleListnode getNext() {
        return next;
    }

    public void setNext(DoubleListnode next) {
        this.next = next;
    }

    public DoubleListnode getPrev() {
        return prev;
    }

    public void setPrev(DoubleListnode prev) {
        this.prev = prev;
    }

}
