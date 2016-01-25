package com.gmail.ivanytskyy.vitaliy.annotation;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LessonIntervalFormatValidator.class})
public @interface LessonIntervalFormat {
	String message() default "The input data must be entered in 'HH.mm' format!";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}