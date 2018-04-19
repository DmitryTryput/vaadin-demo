package by.spf.vaadindemo.component.layout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;



public class NavigationLayout extends VerticalLayout {

    private Label findLabel;
    private Button navigationLink;

    public NavigationLayout(String labelText, String linkText, Button.ClickListener clickListener) {

        setMargin(false);
        setSpacing(false);
        setHeight(40.0f, Unit.PERCENTAGE);
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        VerticalLayout fields = new VerticalLayout();
        fields.setHeight(20.0f, Unit.PERCENTAGE);
        findLabel = new Label(labelText);
        findLabel.setStyleName("link-label");
        fields.addComponent(findLabel);

        navigationLink = new Button(linkText);
        navigationLink.setStyleName("link");
        navigationLink.addClickListener(clickListener);
        fields.addComponent(navigationLink);
        addComponent(fields);
    }


    public void hideNavigation() {
        findLabel.setValue("");
        navigationLink.setCaption("");
        navigationLink.setEnabled(false);
    }
}
