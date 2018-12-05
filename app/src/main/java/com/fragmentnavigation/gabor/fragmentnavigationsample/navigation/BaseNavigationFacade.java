package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;


import android.os.Bundle;
import android.support.annotation.AnimRes;

import java.lang.reflect.Type;


public abstract class BaseNavigationFacade<T extends BaseActivity> {

    protected T activity;
    protected BaseNavigationStrategy<T> fragmentNavigationStrategy;


    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param requestCode   - request code to send back when fragment closes
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, int requestCode);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, Bundle bundle);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @param requestCode   - request code to send back when fragment closes
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, Bundle bundle, int requestCode);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param enterAnimId   - your fragment`s enter animation
     * @param exitAnimId    - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, @AnimRes int enterAnimId, @AnimRes int exitAnimId);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param bundle        - bundle to send to the fragment
     * @param enterAnimId   - your fragment`s enter animation
     * @param exitAnimId    - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass    - your fragment instance or Class to navigate
     * @param param            - param to send to the fragment
     * @param enterAnimationID - your fragment`s enter animation
     * @param exitAnimationID  - previous fragment`s exit animation
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, Object param, @AnimRes int enterAnimationID, @AnimRes int exitAnimationID);

    /**
     * With this method you can navigate to other Fragment
     *
     * @param fragmentClass - your fragment instance or Class to navigate
     * @param param         - param to send to the fragment
     * @return true if the navigation was success.
     **/
    public abstract boolean navigateTo(Type fragmentClass, Object param);
}
