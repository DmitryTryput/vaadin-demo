package by.spf.vaadindemo.mapping;

import lombok.Getter;

@Getter
public class DomainCategoryMapper {
    private String name;
    private ClassCategoryMapper classCategory;

    public DomainCategoryMapper(String name, String classCategoryName) {
        this.name = name;
        classCategory = new ClassCategoryMapper(classCategoryName);
    }
}
