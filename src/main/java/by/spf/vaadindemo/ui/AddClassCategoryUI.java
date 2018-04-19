package by.spf.vaadindemo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.UI;

@Theme("my")
@SpringUI(path = "/sfp")
@SpringViewDisplay
public class AddClassCategoryUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
            getUI().getNavigator().navigateTo("domainCategories");
    }
}
