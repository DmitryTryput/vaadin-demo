package by.spf.vaadindemo.component;


import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;

public class ErrorLabel extends Label {

    public ErrorLabel( AbstractOrderedLayout layout) {
        super();
        setValue("");
        setStyleName("error-message");
        layout.addComponent(this);
        layout.setComponentAlignment(this, Alignment.TOP_RIGHT);

    }

    public void showError() {
        setValue("Данная категория уже существует");

    }

    public void hideError() {
        setValue("");
    }
}
