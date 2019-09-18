package com.example.lukasz_2.kurierai.PerformanceInterface;

import com.example.lukasz_2.kurierai.base.BaseFragment;
import com.example.lukasz_2.kurierai.fragments.Fragment_type_managment;

public  class FactoryInterafce {

    public FactoryInterafce () { }

    public ElementInterface createElementInterface(BaseFragment fragment, String name, String description, byte[] bytes){
        ElementInterface.BuliderElementInterface bild = new ElementInterface.BuliderElementInterface(fragment);
        bild.setName(name);
        bild.setDecryption(description);
        bild.setImage(bytes);
        return bild.bulid();
    }
}
