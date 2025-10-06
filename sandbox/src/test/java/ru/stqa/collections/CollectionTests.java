package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        //вызван конструктор массива и сразу указаны элементы
        //var array = new String[]{"a","b","c"};
        var array = new String[3];
        //Проверка кол-ва элементов в массиве
        Assertions.assertEquals(3, array.length);
        //проверка, что в элементе с индексом 0 находится "а"
        Assertions.assertEquals("a", array[0]);
        //поменять значение в массиве
        array[0]="d";
        //проверка, что в элементе с индексом 0 находится "а"
        Assertions.assertEquals("d", array[0]);

    }

    @Test
    void listTests() {
        //в скобках указано объекты какого типа будут храниться в списке
        //var list = new ArrayList<String>();

        //проинициализировать список при создании
//        var list = List.of("a","b","c");
//        //список имеет размер 3
//        Assertions.assertEquals(3, list.size());

        //список по дефолту имеет размер 0
//        Assertions.assertEquals(0, list.size());

        //добавить элемент в список
//        list.add("a");
//        list.add("b");
//        list.add("c");

        //в конструктор списка передать предзаполненный элементами список
        var list = new ArrayList<>(List.of("a","b","c"));
        //в треугольных скобках можно не указывать тип String, т.к. и так ясно,
        // что делаем копию списка строк

        //проверить,что список содержит добавленные элементы
        //в списках индексация тоже начинается с 0
        Assertions.assertEquals("a", list.get(0));

        //установить в элемент 0 значение "d"
        list.set(0,"d");
        //проверить, что в элемент с индексом 0 вместо "а" теперь записан "d"
        Assertions.assertEquals("d", list.get(0));
    }
}
