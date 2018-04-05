package by.spf.vaadindemo.component.layout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class NavigationLayout extends VerticalLayout {

    public NavigationLayout(String labelText, String linkText, String viewName) {

        setWidth(100.0f, Unit.PERCENTAGE);
        setHeight(50.0f, Unit.PERCENTAGE);
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
        Label findLabel = new Label(labelText);
        findLabel.setStyleName("link-label");
        addComponent(findLabel);

        Button navigationLink = new Button(linkText);
        navigationLink.setStyleName("link");
        navigationLink.addClickListener(e -> getUI().getNavigator().navigateTo(viewName));
        addComponent(navigationLink);
    }
}
