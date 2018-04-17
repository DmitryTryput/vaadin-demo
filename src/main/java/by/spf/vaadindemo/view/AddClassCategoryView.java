package by.spf.vaadindemo.view;

import by.spf.vaadindemo.component.layout.AddClassCategoryLayout;
import by.spf.vaadindemo.component.layout.AddDomainAndClassCategoryLayout;
import by.spf.vaadindemo.component.layout.NavigationLayout;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = AddClassCategoryView.VIEW_NAME)
public class AddClassCategoryView extends HorizontalLayout implements View {
    static final String VIEW_NAME = "addClassCategory";

    private NavigationLayout addClassCategoryNavigationLayout;
    private NavigationLayout addDomainAndClassCategoryNavigationLayout;

    @Autowired
    private AddClassCategoryLayout addClassCategoryLayout;

    @Autowired
    private AddDomainAndClassCategoryLayout addDomainAndClassCategoryLayout;


    @PostConstruct
    void init() {
        setView();
        setLayouts();
        setNavigation();
    }

    private void setView() {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.TOP_CENTER);
    }

    private void setLayouts() {
        addComponent(addClassCategoryLayout);
        addClassCategoryLayout.setSaveButton(this, addClassCategoryLayout, addClassCategoryNavigationLayout);
        setExpandRatio(addClassCategoryLayout, 6.0f);

    }

    private void setNavigation() {
        addClassCategoryNavigationLayout = new NavigationLayout(
                "Искомая категория сферы услуг отсутствует?",
                "Создать категорию сферы услуг",
                (Button.ClickListener) event -> {
                    this.replaceComponent(addClassCategoryLayout, addDomainAndClassCategoryLayout);
                    this.replaceComponent(addClassCategoryNavigationLayout, addDomainAndClassCategoryNavigationLayout);
                });
        addComponent(addClassCategoryNavigationLayout);
        setExpandRatio(addClassCategoryNavigationLayout, 4.0f);
        addDomainAndClassCategoryNavigationLayout = new NavigationLayout(
                "Передумали создавать категорию сферы услуг?",
                "Выбрать существующую категорию сферы услуг",
                (Button.ClickListener) event -> {
                    this.replaceComponent(addDomainAndClassCategoryLayout, addClassCategoryLayout);
                    this.replaceComponent(addDomainAndClassCategoryNavigationLayout, addClassCategoryNavigationLayout);
                });
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }


}
