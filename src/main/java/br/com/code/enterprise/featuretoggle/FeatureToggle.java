package br.com.code.enterprise.featuretoggle;

public interface FeatureToggle {

    boolean isEnabled(String featureName);

    boolean isEnabled(String featureName, Context context);
}
