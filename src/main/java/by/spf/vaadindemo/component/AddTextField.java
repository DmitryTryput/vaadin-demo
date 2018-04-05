package by.spf.vaadindemo.component;


import com.vaadin.ui.TextField;

public class AddTextField extends TextField {

    public AddTextField(String placeholder, boolean enabled) {
        setEnabled(enabled);
        setWidth("100%");
        setPlaceholder(placeholder);
        setStyleName("v-textfield-category");
    }

    public void showError() {
        setStyleName("v-textfield-error");
    }

    public void hideError() {
        setStyleName("v-textfield-category");
    }
}
