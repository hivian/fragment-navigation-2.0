package com.fragmentnavigation.gabor.fragmentnavigationsample.navigation;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;


class StandardNavigationStrategy<T extends BaseActivity> extends BaseNavigationStrategy<T> {

    StandardNavigationStrategy(int fragmentContainerID) {
        super(fragmentContainerID);
    }

    @Override
    void transaction(T context, Bundle bundle, Object mParam, BaseFragment baseFragmentClass, int requestCode, int enterAnimId, int exitAnimId) {
        currentFragment = baseFragmentClass;

        if (mParam != null) {
            currentFragment.setParam(mParam);
        }

        if (bundle != null) {
            currentFragment.setArguments(bundle);
        }

        if (isRequestCode) {
            currentFragment.setTargetFragment(sourceFragment, requestCode);
        }

        FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction();

        if (enterAnimId > 0 && exitAnimId > 0) {
            transaction.setCustomAnimations(enterAnimId, exitAnimId);
        }

        transaction.replace(fragmentContainerId, currentFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
