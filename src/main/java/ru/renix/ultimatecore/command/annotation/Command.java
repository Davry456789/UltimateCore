package ru.renix.ultimatecore.command.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {
    String name(); // ручками пишем название команды
    String perm() default "piskaopkacmd"; // дефолтные права - пушка
    String desc() default "Cho kago?"; // описание для ленивых
    String usage() default "/command [sex]"; // пример использования
    String[] aliases() default {}; // алиасы команды
    boolean onlyPlayers() default false; // флаг для консоли
}
