package fr.cesi.toulouse.cda23.demospring0224.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiStats {

    @AfterReturning("execution(public * fr.cesi.toulouse.cda23.demospring0224.controllers.*Controller.*(..))")
    public void statCount() {
        System.out.println("Count stats API .....");
    }
}
