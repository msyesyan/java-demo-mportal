package com.bstar.mportal.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


@SuppressWarnings("unchecked")
public abstract class EntryDaoSupport<T> extends HibernateDaoSupport {
	
	protected Class<? extends T> entityClass;
	
	public EntryDaoSupport() {
		Class<?> genericClazz = findGenericSuperclass(this.getClass());
		if(genericClazz != null) {
			ParameterizedType parameterizedType = (ParameterizedType) genericClazz.getGenericSuperclass();
			this.entityClass = getActualTypeArguments(parameterizedType, 0);
		}
	}
	
	private static <T> Class<T> getActualTypeArguments(ParameterizedType parameterizedType, int index) {
		Type type = parameterizedType.getActualTypeArguments()[index];
		if(type instanceof ParameterizedType) {
			type = ((ParameterizedType) type).getRawType();
		}
		
		return (Class<T>) type;
	}
	
	private static Class<?> findGenericSuperclass(Class<?> clazz) {
		Class<?> currentClass = clazz;

		while (currentClass != null) {
			if (currentClass.getGenericSuperclass() instanceof ParameterizedType) {
				return currentClass;
			}
			
			currentClass = currentClass.getSuperclass();
		}
		
		return null;
	}
	
	public void save(T entry) {
		currentSession().save(entry);
	}
	
	public void delete(T entry) {
		currentSession().delete(entry);
	}

	public T get(Integer id) {
		return (T) currentSession().get(this.entityClass, id);
	}
	
	public List<T> findAll() {
		return currentSession().createCriteria(this.entityClass).list();
	}

	public void update(T entry) {
		currentSession().update(entry);
	}
}
