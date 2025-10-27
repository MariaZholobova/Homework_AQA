package org.example.lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Задание 2
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.*/

public class PhoneDirectory {
    private Map<String, List<String>> pd = new HashMap<>();

    public void add(String surname, String phone) {
        if (pd.containsKey(surname)) {
            pd.get(surname).add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            pd.put(surname, phones);
        }
    }

    public List<String> get(String surname) {
        return pd.get(surname);
    }
}
