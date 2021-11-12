package com.koi.springmvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = FieldMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//Example: @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public @interface FieldMatch {
    String message() default "The fields must match";
    String first();
    String second();

    Class<?>[] group() default {};
    Class<? extends Payload>[] payload() default {};

}