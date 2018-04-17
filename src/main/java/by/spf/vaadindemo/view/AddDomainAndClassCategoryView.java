package by.spf.vaadindemo.view;

import by.spf.vaadindemo.component.layout.AddDomainAndClassCategoryLayout;
import by.spf.vaadindemo.component.layout.NavigationLayout;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = AddDomainAndClassCategoryView.VIEW_NAME)
public class AddDomainAndClassCategoryView extends GridLayout implements View {
    static final String VIEW_NAME = "addDomainAndClassCategory";

    private NavigationLayout navigationLayout;

    @Autowired
    private AddDomainAndClassCategoryLayout addDomainAndClassCategoryLayout;

    @PostConstruct
    void init() {
        setView();
        setLayouts();
    }

    private void setView() {
        setColumns(5);
        setRows(4);
        setDefaultComponentAlignment(Alignment.TOP_LEFT);
        setWidth(100.0f, Unit.PERCENTAGE);
        setHeight(80.0f, Unit.PERCENTAGE);
    }

    private void setLayouts() {
        addComponent(addDomainAndClassCategoryLayout,0,0,2,3);
        addComponent(navigationLayout,3,0);
        setComponentAlignment(navigationLayout, Alignment.BOTTOM_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
