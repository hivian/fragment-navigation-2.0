package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.util.Log;

import java.lang.reflect.Type;

/**
 * Base navigation strategy
 */

abstract class BaseNavigationStrategy<T extends BaseActivity> {
    private static final String TAG = StandardNavigationStrategy.class.getSimpleName();

    BaseFragment sourceFragment;
    BaseFragment currentFragment;
    int fragmentContainerId;
    boolean isRequestCode;

    BaseNavigationStrategy(int fragmentContainerId) {
        this.fragmentContainerId = fragmentContainerId;
    }

    private BaseFragment getBaseFragmentFromType(Type fragmentClass) {
        BaseFragment baseFragment = null;
        if (fragmentClass instanceof BaseFragment) {
            baseFragment = (BaseFragment) fragmentClass;
        } else {
            try {
                Class<? extends BaseFragment> baseFragmentClass = (Class<BaseFragment>) fragmentClass;
                baseFragment = baseFragmentClass.newInstance();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return baseFragment;
    }

    private boolean isSameFragment(BaseFragment currentFragment, BaseFragment targetFragment) {
        return targetFragment.getClass().isInstance(currentFragment);
    }

    boolean navigateTo(T context, Type fragmentClass, Object param, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return navigationExecutor(context, fragmentClass, null, param, 0, enterAnimId, exitAnimId);
    }

    boolean navigateTo(T context, Type fragmentClass, Bundle bundle, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        return navigationExecutor(context, fragmentClass, bundle, null, 0, enterAnimId, exitAnimId);
    }

    boolean navigateTo(T context, Type fragmentClass, Bundle bundle, int requestCode) {
        isRequestCode = true;

        return navigationExecutor(context, fragmentClass, bundle, null, requestCode, 0, 0);
    }

    private boolean navigationExecutor(T context, Type fragmentClass, Bundle bundle, Object param, int requestCode, @AnimRes int enterAnimId, @AnimRes int exitAnimId) {
        sourceFragment = (BaseFragment) context.getSupportFragmentManager().findFragmentById(fragmentContainerId);
        currentFragment = sourceFragment;

        BaseFragment targetFragment = getBaseFragmentFromType(fragmentClass);

        if (targetFragment != null && !isSameFragment(currentFragment, targetFragment)) {
            transaction(context, bundle, param, targetFragment, requestCode, enterAnimId, exitAnimId);
            return true;
        }
        return false;
    }

    abstract void transaction(T context, Bundle bundle, Object mParam, BaseFragment baseFragmentClass, int requestCode, int enterAnimId, int exitAnimId);
}
