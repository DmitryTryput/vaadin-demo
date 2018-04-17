package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.AddTextField;
import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.SaveButton;
import by.spf.vaadindemo.domain.DomainCategory;
import by.spf.vaadindemo.util.RestClientServiceProvider;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


@UIScope
@SpringComponent
public class AddClassCategoryLayout extends CustomVerticalLayout {




    @Autowired
    private RestClientServiceProvider restClientServiceProvider;
    private ComboBox<DomainCategory> domainCategoryComboBox;
    private AddTextField classCategoryTextField;
    private SaveButton saveButton;
    private ErrorLabel errorLabel;

    @PostConstruct
    public void init() {
        setDomainComboBox();
        setClassCategoryField();
        setSaveButton();
    }


    private void setDomainComboBox() {
        new CustomLabel("Категория сферы услуг", getFieldsLayout());
        domainCategoryComboBox = new ComboBox<>();
        domainCategoryComboBox.addStyleName("v-combobox");
        domainCategoryComboBox.setItems(restClientServiceProvider.getDomainCategories());
        domainCategoryComboBox.setTextInputAllowed(false);
        domainCategoryComboBox.setWidth("100%");
        domainCategoryComboBox.setPlaceholder("Выбрать категорию сферы услуг");
        domainCategoryComboBox.setItemCaptionGenerator(DomainCategory::getName);
        domainCategoryComboBox.setEmptySelectionAllowed(false);
        domainCategoryComboBox.addValueChangeListener(event -> classCategoryTextField.setEnabled(true));
        getFieldsLayout().addComponent(domainCategoryComboBox);
        new ErrorLabel( getFieldsLayout());
    }

    private void setClassCategoryField() {
        new CustomLabel("Категория вида услуг", getFieldsLayout());
        classCategoryTextField = new AddTextField("Укажите категорию вида услуг", false);
        classCategoryTextField.addValueChangeListener(e -> {
           if (!classCategoryTextField.isEmpty()) {
               saveButton.setButtonEnable();
           } else {
               saveButton.setButtonDisable();
            }
        });
        getFieldsLayout().addComponent(classCategoryTextField);
        errorLabel = new ErrorLabel( getFieldsLayout());
    }

    public void setSaveButton() {
        saveButton = new SaveButton(false);
        saveButton.addClickListener(e -> {

        });
        getButtonLayout().addComponent(saveButton);
    }
}
