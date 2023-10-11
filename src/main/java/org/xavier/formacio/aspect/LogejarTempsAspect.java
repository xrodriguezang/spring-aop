package org.xavier.formacio.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Aspect
@Slf4j
public class LogejarTempsAspect {

    private Map<Object, Object> cache = new HashMap<>();

    @Around("@annotation(org.xavier.formacio.anotacio.Cacheig)")
    public Object cachejarValor (ProceedingJoinPoint joinPoint) throws Throwable {
        Object valorEntrada = joinPoint.getArgs()[0];// Suposem que té un valor.

        if (cache.containsKey(valorEntrada)) {
            return cache.get(valorEntrada);
        }

        Object valorSortida = joinPoint.proceed();

        cache.put(valorEntrada, valorSortida);

        return valorSortida;
    }

    @Before("@annotation(org.xavier.formacio.anotacio.Cacheig)")
    public void imprimeixAbans() {
        /*String ddd = null;   -- Ojo que atura!!!
        if (ddd.equals("fff"));*/
        log.info("ABans");
    }

    @After("@annotation(org.xavier.formacio.anotacio.Cacheig)")
    public void imprimeixDespres() {
        log.info("Despres");
    }

}
