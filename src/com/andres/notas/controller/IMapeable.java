
package com.andres.notas.controller;

import java.awt.Component;
import java.awt.Window;
import java.lang.reflect.Field;

public interface IMapeable {
    
    default Component getComponentByName(String name, Window frame) {
        for (Field field : frame.getClass().getDeclaredFields()) { 
            field.setAccessible(true); 
            if (name.equals(field.getName())) { 
                try {
                    return (Component) field.get(frame); 
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                }
            }
        } 
        return null; 
    }
    
}
