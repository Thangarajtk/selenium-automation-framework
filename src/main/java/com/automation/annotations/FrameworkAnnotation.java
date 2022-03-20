package com.automation.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.automation.enums.CategoryType;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and
 * category details to the extent report.
 *
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 *
 * @author Administrator
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

    String[] author();

    CategoryType[] category();
}
