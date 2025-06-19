package br.com.code.enterprise.featuretoggle;

public interface ToggleRepository {

    boolean getToggleState(String featureName);

    boolean getToggleState(String featureName, Context context);

    void setToggleState(String featureName, boolean enabled);
}
