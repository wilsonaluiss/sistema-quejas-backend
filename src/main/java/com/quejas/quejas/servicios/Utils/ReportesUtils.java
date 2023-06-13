/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quejas.quejas.servicios.Utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Wilson
 */
public class ReportesUtils {
    
    
    /**
     * Metodo que genera las clausulas where de un query en base a un objeto
     * (object), las genera a un query base (baseQuery) y crea el query con el
     * administrador de entidades (entityManager).
     *
     * @author crramosl
     *
     * @param entityManager es el administrador de entidades utilizado para
     * crear el query.
     * @param baseQuery es el query base (antes de where) para la creación del
     * query.
     * @param object es la instancia del objeto que tiene la estructura de la
     * consulta.
     *
     */
    public static Query createCompiledQuery(final EntityManager entityManager, final String baseQuery, final Object object, final Class type) {
        final Method[] allMethods = object.getClass().getDeclaredMethods();
        final Query q = entityManager.createNativeQuery(createQuery(baseQuery, object), type);

        for (Method method : allMethods) {
            try {
                final Column column = method.getDeclaredAnnotation(Column.class);
                if (column != null) {
                    final Object value = method.invoke(object);
                    if (column.forceAdd() || (value != null && !value.equals("") && !value.equals(0) && !value.equals(0.0) && !value.equals(0.0f))) {
                        q.setParameter(method.getName(), value);
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ReportesUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return q;
    }
    
    private static <T> String createQuery(final String baseQuery, final T object) {
        final StringBuilder query = new StringBuilder(baseQuery);
        final Method[] allMethods = object.getClass().getDeclaredMethods();
        boolean isFirst = true;

        for (final Method method : allMethods) {
            try {
                final Column column = method.getDeclaredAnnotation(Column.class);
                if (column != null) {
                    final Object value = method.invoke(object);

                    if (value != null && !value.equals("") && !value.equals(0) && !value.equals(0.0) && !value.equals(0.0f)) {
                        query.append(isFirst ? " where " : " and ")
                                .append(column.table())
                                .append(".")
                                .append(column.name())
                                .append(" ")
                                .append(column.operator())
                                .append(" :")
                                .append(method.getName());
                        isFirst = false;
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ReportesUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return query.toString();
    }

    @Target(value = {ElementType.METHOD, ElementType.FIELD})
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface Column {

        public String name() default "";

        public String table() default "";

        public String operator() default "=";
        
        public boolean isFirst() default false;

        public boolean forceAdd() default false;
    }
    
}
