package com.bluetorch.lib.scalpel;

public class Replacement {
    private String _selector;
    private Fragment _fragment;
    
    public Replacement(String selector, Fragment fragment) {
        _selector = selector;
        _fragment = fragment;
    }

    public String getSelector() {
        return _selector;
    }

    public void setSelector(String selector) {
        this._selector = selector;
    }

    public Fragment getFragment() {
        return _fragment;
    }

    public void setFragment(Fragment fragment) {
        this._fragment = fragment;
    }

    public FragmentType getType() {
        return _fragment.getType();
    }

}
