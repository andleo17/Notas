
package com.andres.notas.controller;

import java.awt.Component;
import java.lang.reflect.Field;
import javax.swing.JFrame;

public interface IMapeable {
    
    default Component getComponentByName(String name, JFrame frame) {
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
