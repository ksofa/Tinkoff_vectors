# Tinkoff_vectors
Использую паттерн Command 
https://refactoring.guru/ru/design-patterns/command

Был заменен switch на паттерн Command. 







Пользователь может ввести следующие команды:

1) ```create $название $x $y $z```
    - Создать вектор

2) ```read```
    - Вывести все векторы

3) ```range $название```
    - Вывести длину вектора

4) ```angle $вектор1 $вектор2```
    - Найти угол между векторами

5) ```product $типПроизведения $вектор1 $вектор2```
    - ```$типПроизведения``` может быть dot (скалярное) и cross (векторное). Вывести результат соответствующего произведения

6) ```exit```
    - завершить программу
    - 
7) ```save $имяФайла```
   - Сохранить коллекцию векторов в файл 

8) ```load $имяФайла```
   - Прочитать коллекцию векторов из файла
