package PTIT_CNTT1_IT203B_Session08.Bai5;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

    void attach(Observer observer);

    void notifyObserver();
}
