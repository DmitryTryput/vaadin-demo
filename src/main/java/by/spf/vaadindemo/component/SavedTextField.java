package by.spf.vaadindemo.component;

import com.vaadin.ui.TextField;

public class SavedTextField extends TextField {

    public SavedTextField(String savedText) {
        setWidth("100%");
        setStyleName("v-textfield-category");
        setValue(savedText);
        setReadOnly(true);
    }
}
