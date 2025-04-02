package interfaces;

import java.util.Optional;

public interface Browser {
    void newTab();
    void showPage(String url);
    void backPage();
    void nextPage();
    void closeTab();
    void updatePage();
}
