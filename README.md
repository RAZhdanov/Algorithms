# Algorithms

Task 1.java: https://github.com/RAZhdanov/Algorithms/blob/main/Task1.java
Написать функцию принимающюю на вход String[]
Исходный массив менять нельзя

Требуется найти группы строк содержащие одинаковый набор символов и вывести на консоль в виде:
набор символов(в любом порядке) = индексы строк в исходном массиве через запятую(в любом порядке)
Если у строки нет парной с ней строки с одинаковым набором символов - то печать её не надо.


пример  (форматирование может быть любое):
подаём на вход:  {"qwe","wqe","qwee","a","a"};

вывод на консоль:
a 3, 4
eqw 0, 1 

набор символов QQ и Q - разный

PS: подумайте над тем как можно распараллелить эту задачу, не учитывая вывод на консоль
