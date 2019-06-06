package com.serviexpress.serviexpress.vista.resources;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Elohim {
	
	public static void copiarPropiedadesNoNulas(Object objetoVirtual, Object claseObjetivo) {
	    BeanUtils.copyProperties(objetoVirtual, claseObjetivo, getNullPropertyNames(objetoVirtual));
	}

	public static String[] getPropiedadesNulas (Object objVirtual) {
	    final BeanWrapper src = new BeanWrapperImpl(objVirtual);
	    PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	
	public static String[] getNullPropertyNames(Object source) {
	    final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
	    return Stream.of(wrappedSource.getPropertyDescriptors())
	            .map(FeatureDescriptor::getName)
	            .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
	            .toArray(String[]::new);
	}
}
