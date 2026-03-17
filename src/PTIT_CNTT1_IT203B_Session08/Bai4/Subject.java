package PTIT_CNTT1_IT203B_Session08.Bai4;

public interface Subject {
    //Tạo interface Subject với các phương thức attach(Observer o), detach(Observer o), notifyObservers().

    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}
