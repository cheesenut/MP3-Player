/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author USER
 */
public class DoubleLinkList {
     private  DoubleListnode head;
     private int size;

    public DoubleLinkList() {
        head = new DoubleListnode();
        head.setNext(head);
        head.setPrev(head);

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleListnode getHead() {
        return head;
    }

    public void setHead(DoubleListnode head) {
        this.head = head;
    } 
      
   
     public void addFirst(Song first) {
        addBefore(first, head.getNext());

    }

    public void addLast(Song Last) {
        addBefore(Last, head);
    }
     public DoubleListnode addBefore(Song  last, DoubleListnode bantu) {
        DoubleListnode baru = new DoubleListnode(last);
        baru.setNext(bantu);
        baru.setPrev(bantu.getPrev());
        bantu.setPrev(baru);
        baru.getPrev().setNext(baru);
        size++;
        return baru;

    }
      @Override
    public String toString() {// cetak elemen yang ada di list
        String isi = "";
        DoubleListnode pointer = head.getNext();
        while (pointer != head) {
            isi += pointer.getData().getArtist()+ " ";
            pointer = pointer.getNext();
        }
        return isi;
    }
    
    public boolean isEmpty() {
        if ((head.getNext() != null && head.getPrev() != null)) {
            return true;
        } else {
            return false;
        }

    }

   
    
    

}



