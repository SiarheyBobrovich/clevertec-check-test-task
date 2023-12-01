### Стек:

    Java 21

## Build

    javac -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java

## Run

    java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 balanceDebitCard=63.01

## Описание

Консольное приложение, реализующее функционал формирования чека в магазине запускается с помощью консольной команды:

    java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx

    id					    - идентификатор товара (целое)
    quantity 				- количество товара (целое)
    discountCard=xxxx 		- номер дисконтной карты (4-значное число)
    balanceDebitCard=xxxx 	- баланс на дебетовой карте возможные варианты (любое целое или цисло с плавающей точкой)

#### ВАЖНО!

    Id могут повторяться: 1-3 2-5 1-1 тоже, что и 1-4 2-5
    В  наборе параметров должна быть минимум одна такая связка "id-quantity"
    Обязательно нужно передать баланс дебитовой карты

Пример:

    java ̺ -jar clevertec-check.jar ̺3-1 ̺ 2-5 ̺ 5-1 ̺ discountCard=1111 ̺ balanceDebitCard=100

# Команды для запуска:

- java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 balanceDebitCard=63.01
- java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java 1-4 10-2 14-43 discountCard=3333 balanceDebitCard=61.71
- java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java 20-20 1-10 discountCard=9999 balanceDebitCard=346.55
- java -cp src .\src\main\java\ru\clevertec\check\CheckRunner.java 5-2 7-1 12-14 balanceDebitCard=155.66

# Команды для запуска с ошибками:

- java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 balanceDebitCard=63
- java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111
- java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 discountCard=1111 balanceDebitCard=0
- java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java discountCard=1111 balanceDebitCard=1000

## OUTPUT файл:

    result.csv в корне проекта

## Таблица 1. Список доступных продуктов

| id | description                    | price, $ | quantity in stock | wholesale goods |
|----|--------------------------------|----------|-------------------|-----------------|
| 1  | Milk                           | 1,07     | 10                | +               |
| 2  | cream 400g                     | 2,71     | 20                | +               |
| 3  | Yogurt 400g                    | 2,10     | 7                 | +               |
| 4  | Packed potatoes 1kg            | 1,47     | 30                | -               |
| 5  | Packed cabbage 1kg             | 1,19     | 15                | -               |
| 6  | Packed tomatoes 350g           | 1,60     | 50                | -               |
| 7  | Packed apples 1kg              | 2,78     | 18                | -               |
| 8  | Packed oranges 1kg             | 3,20     | 12                | -               |
| 9  | Packed bananas 1kg             | 1,10     | 25                | +               |
| 10 | Packed beef fillet 1kg         | 12,8     | 7                 | -               |
| 11 | Packed pork fillet 1kg         | 8,52     | 14                | -               |
| 12 | Packed chicken breasts 1kgSour | 10,75    | 18                | -               |
| 13 | Baguette 360g                  | 1,30     | 10                | +               |
| 14 | Drinking water 1,5l            | 0,80     | 100               | -               |
| 15 | Olive oil 500ml                | 5,30     | 16                | -               |
| 16 | Sunflower oil 1l               | 1,20     | 12                | -               |
| 17 | Chocolate Ritter sport 100g    | 1,10     | 50                | +               |
| 18 | Paulaner 0,5l                  | 1,10     | 100               | -               |
| 19 | Whiskey Jim Beam 1l            | 13,99    | 30                | -               |
| 20 | Whiskey Jack Daniels 1l        | 17,19    | 20                | -               |

## Таблица 2. Список карт

| id | discountcard | discount amount, % |
|----|--------------|--------------------|
| 1  | 1111         | 3                  |
| 2  | 2222         | 3                  |
| 3  | 3333         | 4                  |
| 4  | 4444         | 5                  |

Любая другая дисконтная карта с вашим номером предоставляет 2% скидки
