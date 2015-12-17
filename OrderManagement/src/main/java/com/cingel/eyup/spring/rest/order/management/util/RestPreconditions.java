package com.cingel.eyup.spring.rest.order.management.util;

public class RestPreconditions {

	public static <T> T checkFound(final T resource) throws Exception{
		if(resource == null){
			throw new Exception();
		}
		return resource;
	}
}
