/**
 *
 * @author Jesús Israel
 */
package com.klasnic.pos.model.data;

import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;

public abstract class BeanUtils {

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws BeansException {
        return org.springframework.beans.BeanUtils.getPropertyDescriptors(clazz);
    }
}
