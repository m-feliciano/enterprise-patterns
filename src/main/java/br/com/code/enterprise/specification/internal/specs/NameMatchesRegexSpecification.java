package br.com.code.enterprise.specification.internal.specs;

import br.com.code.enterprise.specification.internal.AbstractSpecification;
import br.com.code.enterprise.specification.internal.interfaces.HasName;

import java.util.regex.Pattern;

public class NameMatchesRegexSpecification<T extends HasName> extends AbstractSpecification<T> {

    private final Pattern pattern;

    public NameMatchesRegexSpecification(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return candidate.getName() != null
               && pattern.matcher(candidate.getName()).matches();
    }
}
