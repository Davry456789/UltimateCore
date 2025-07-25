package ru.renix.ultimatecore.command.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {
    String name(); 
    String perm() default "piskaopkacmd";
    String desc() default "Cho kago?"; 
    String usage() default "/command [sex]";
    String[] aliases() default {}; 
    boolean onlyPlayers() default false; 
}
