package org.xavier.formacio.anotacio;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
// @Target({ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})  // type-> classe, method -> Mètode, paràmeter -> Variable
@Target(ElementType.METHOD)
public @interface LogeigTemps {
    int maxTiempo() default 2000;
}