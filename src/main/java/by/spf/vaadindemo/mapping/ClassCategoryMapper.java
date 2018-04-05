package by.spf.vaadindemo.mapping;

import lombok.Getter;

@Getter
public class ClassCategoryMapper {
    private String name;

    public ClassCategoryMapper(String name) {
        this.name = name;
    }
}
