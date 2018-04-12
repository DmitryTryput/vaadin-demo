package by.spf.vaadindemo.view;

import by.spf.vaadindemo.component.layout.AddClassCategoryLayout;
import by.spf.vaadindemo.component.layout.NavigationLayout;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;

import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = AddClassCategoryView.VIEW_NAME)
public class AddClassCategoryView extends HorizontalLayout implements View {
    static final String VIEW_NAME = "addClassCategory";

    private NavigationLayout navigationLayout;

    @Autowired
    private AddClassCategoryLayout addClassCategoryLayout;


    @PostConstruct
    void init() {
        setView();
        setLayouts();
    }

    private void setView() {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
    }

    private void setLayouts() {
        addComponent(addClassCategoryLayout);
        addClassCategoryLayout.setSaveButton(this, addClassCategoryLayout, navigationLayout);
        navigationLayout = new NavigationLayout("Искомая категория сферы услуг отсутсвует?",
                "Создать категорию сферы услуг",
                "addDomainAndClassCategory");
        setExpandRatio(addClassCategoryLayout, 3.0f);
        addComponent(navigationLayout);
        setComponentAlignment(navigationLayout, Alignment.BOTTOM_CENTER);
        setExpandRatio(navigationLayout, 2.0f);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
