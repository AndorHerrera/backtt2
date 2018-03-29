package com.klasnic.pos.model.data;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;

public final class ExampleFilter {

	private static List<String> getNestedProperties(String masterProperty, List<String> validProperties) {
		List<String> nestedProperties = new ArrayList<String>();
		for(String validProperty : validProperties) {
			if(validProperty.startsWith(masterProperty)) {
				String nestedProperty = validProperty.replaceFirst(masterProperty + ".", "");
				nestedProperties.add(nestedProperty);
			}
		}
		return nestedProperties;
	}

	private static void initToNull(PersistentObject item, List<String> validProperties) {
		BeanWrapper bean = new BeanWrapperImpl(item);
		PropertyDescriptor[] properties = bean.getPropertyDescriptors();

		for (PropertyDescriptor property : properties) {
			String propertyName = property.getName();
			Class<?> propertyType = property.getPropertyType();

			if (!validProperties.contains(propertyName) && bean.isWritableProperty(propertyName)) {
				if (BeanUtils.isSimpleProperty(propertyType)) {
					bean.setPropertyValue(property.getName(), null);
				} else {
					if (PersistentObject.class.isAssignableFrom(propertyType)) {
						PersistentObject nestedProperty = (PersistentObject) bean.getPropertyValue(propertyName);
						if (nestedProperty != null) {
							initToNull(nestedProperty, getNestedProperties(propertyName, validProperties));
						}
					}
				}
			}
		}
	}

	private static GenericPropertyMatcher createFilterMatcher(String matchMode) {
		return ExampleMatcher.GenericPropertyMatchers.contains();
	}

	public static <PO extends PersistentObject> Example<PO> createExample(RequestInfo<PO> requestInfo) {
		List<String> validProperties = new ArrayList<String>();
		ExampleMatcher matcher = ExampleMatcher.matching();
		matcher = matcher.withIgnoreCase();
		matcher = matcher.withIgnorePaths("id");
		
		for (FilterRequest filterRequest : requestInfo.getFilters()) {
			GenericPropertyMatcher filterMatcher = createFilterMatcher(filterRequest.getMatchMode());
			matcher = matcher.withMatcher(filterRequest.getProperty(), filterMatcher);
			validProperties.add(filterRequest.getProperty());
		}

		initToNull(requestInfo.getFilterValues(), validProperties);

		return Example.of(requestInfo.getFilterValues(), matcher);
	}
}
