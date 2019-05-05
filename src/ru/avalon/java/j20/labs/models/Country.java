package ru.avalon.java.j20.labs.models;

import java.text.ParseException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Модель представления о стране.
 */
public class Country {
    /**
     * Код страны.
     */
    private final String code;
    /**
     * Название страны.
     */
    private final String name;

    /**
     * Основное конструктор класса.
     *
     * @param code код страны
     * @param name название страны
     */
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Возвращает код страны.
     *
     * @return строковый код страны
     */
    public String getCode() {
        return code;
    }

    /**
     * Возвращает название страны.
     *
     * @return название страны
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Country)) {
            return false;
        }
        Country eqCountry = (Country)obj;
        return getCode().equals(eqCountry.getCode()) && getName().equals(eqCountry.getName());
    }
    /*
     * TODO(Студент): для класса Country переопределить методы equals и hashCode
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.code);
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Возвращает экземпляр страны созданный из переданного
     * текста в формате 'Код:Название'.
     *
     * @param text тектс в формате 'Код:Название'
     * @return новый экземпляр типа {@Link Country}.
     * @throws ParseException в случае, если переданная строка
     * имеет неверный формат.
     */
    public static Country valueOf(String text) throws ParseException {
        
        Pattern pattern = Pattern.compile("([a-zA-Z]{2}):([a-zA-Zа-яА-Я\\s\\(\\)\\-\\,\\']{1,})");
        Matcher matcher = pattern.matcher(text);
        //Хоть результат корректен, к сожалению, matcher.matches() не удалось использовать, т.к. всегда возврощает false.
        //Проверка (countryCode+":"+countryName == text) также не работает, возможно, из-за разницы кодировок.
        if (matcher.find()){
            String countryCode = matcher.group(1);
            String countryName = matcher.group(2);
            return new Country(countryCode, countryName);            
        } else {
            throw new ParseException("Incorrect format of string", 0);
        }
        
        /*
         * TODO(Студент): Реализовать метод valueOf класса Country
         */
    }
}
