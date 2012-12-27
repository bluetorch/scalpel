package com.bluetorch.lib.scalpel;

import java.util.Map;

public class Fragment {
    private String _html;
    private FragmentType _type;
    private Map<String,String> _attributes;
    
    public Fragment(String html, FragmentType type) {
        _html = html;
        _type = type;
    }
    
    public Fragment(Map<String,String> attributes) {
        _attributes = attributes;
        _type = FragmentType.ATTRIBUTE;
    }

    public String getHtml() {
        return _html;
    }

    public void setHtml(String html) {
        this._html = html;
    }

    public FragmentType getType() {
        return _type;
    }

    public void setType(FragmentType type) {
        this._type = type;
    }

    public Map<String,String> getAttributes() {
        return _attributes;
    }

    public void setAttributes(Map<String,String> attributes) {
        this._attributes = attributes;
    }
}
