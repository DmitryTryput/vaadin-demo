package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.AddTextField;
import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.SaveButton;
import by.spf.vaadindemo.mapping.DomainCategoryMapper;
import by.spf.vaadindemo.util.RestClientServiceProvider;
import com.vaadin.data.HasValue;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.AbstractOrderedLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;


@UIScope
@SpringComponent
public class AddDomainAndClassCategoryLayout extends AddClassCategoryLayout {

    @Autowired
    private RestClientServiceProvider restClientServiceProvider;

    private AddTextField domainCategoryTextField;
    private AddTextField classCategoryTextField;
    private SaveButton saveButton;
    private ErrorLabel domainErrorLabel;
    private ErrorLabel classErrorLabel;

    @PostConstruct
    public void init() {
        setDomainField();
        setClassField();
    }

    private void setDomainField() {
        new CustomLabel("Категория сферы услуг", getFieldsLayout());
        domainCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        domainCategoryTextField.addValueChangeListener(this::valueChange);
        getFieldsLayout().addComponent(domainCategoryTextField);
        domainErrorLabel = new ErrorLabel(getFieldsLayout());
    }

    private void setClassField() {
        new CustomLabel("Категория вида услуг", getFieldsLayout());
        classCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        getFieldsLayout().addComponent(classCategoryTextField);
        classCategoryTextField.addValueChangeListener(this::valueChange);
        classErrorLabel = new ErrorLabel(getFieldsLayout());
    }



    public void setSaveButton(AbstractOrderedLayout root, NavigationLayout navigation) {
        saveButton = new SaveButton(true);
        saveButton.addClickListener(e -> {
            ResponseEntity response = restClientServiceProvider.saveDomainCategoryWithClassCategory(new DomainCategoryMapper(
                domainCategoryTextField.getValue(),
                classCategoryTextField.getValue()));
            if (response.getStatusCode() == HttpStatus.CREATED) {
                SavedLayout savedLayout = new SavedLayout(domainCategoryTextField.getValue(), classCategoryTextField.getValue());
                root.replaceComponent(this, savedLayout);
                navigation.hideNavigation();;
            } else {
                domainCategoryTextField.showError();
                domainErrorLabel.showError();
                classCategoryTextField.showError();
                classErrorLabel.showError();
            }
        });
        getButtonLayout().addComponent(saveButton);
    }

    private void valueChange(HasValue.ValueChangeEvent<String> e) {
        domainCategoryTextField.hideError();
        classCategoryTextField.hideError();
        domainErrorLabel.hideError();
        classErrorLabel.hideError();
    }
}
