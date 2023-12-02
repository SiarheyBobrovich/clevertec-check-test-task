## Описание:

Консольное приложение для печати чека в CSV-файл и консоль.<br/>
Аргументы:

- id                    - идентификатор товара (см. Таблицу 1)
- quantity              - количество товара
- discountCard=xxxx     - название и номер дисконтной карты (см. Таблицу 2)
- balanceDebitCard=xxxx - баланс на дебетовой карте
- pathToFile            - путь и название с расширением файла с продуктами
- saveToFile            - путь и название с расширением файла для сохранения чека

## Файлы:

Файлы для заполнения бд находятся:

    Продукты из файла: если передан pathToFile, иначе: ./src/main/resources/products.csv
    Дисконтные карты из файла: ./src/main/resources/discountCards.csv

Файл, который создаёт приложение:

    saveToFile, если передано, иначе: ./result.csv

### Стек:

    Java 21

### Build

    javac -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java

### Run:

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 balanceDebitCard=63.01 pathToFile=./src/main/resources/products.csv saveToFile=./result_file.csv

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 20-10 10-2 14-43 discountCard=1111 balanceDebitCard=225.98 pathToFile=./src/main/resources/products.csv saveToFile=./result_file.csv

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=3333 balanceDebitCard=62.41 pathToFile=./src/main/resources/products.csv saveToFile=./result_file.csv

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 20-20 1-10 discountCard=9999 balanceDebitCard=346.55 pathToFile=./src/main/resources/products.csv saveToFile=./result_file.csv

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 5-2 7-1 12-14 balanceDebitCard=155.66 pathToFile=./src/main/resources/products.csv saveToFile=./result_file.csv

## Ошибки:

Не достаточно средств (NOT ENOUGH MONEY):

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 balanceDebitCard=63 pathToFile=./src/main/resources/products.csv saveToFile=./error_file.csv

Не передан баланс карты (BAD REQUEST):

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 1-4 10-2 14-43 discountCard=1111 pathToFile=./src/main/resources/products.csv saveToFile=./error_file.csv

Не достаточно средств (NOT ENOUGH MONEY):

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java 1-1 discountCard=1111 balanceDebitCard=0 pathToFile=./src/main/resources/products.csv saveToFile=./error_file.csv

Не передано ни одного продукта (BAD REQUEST):

    java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java discountCard=1111 balanceDebitCard=1000 pathToFile=./src/main/resources/products.csv saveToFile=./error_file.csv

## Таблица 1. Список доступных goods

| id | description                    | price, $ | quantity in stock | wholesale goods |
|----|--------------------------------|----------|-------------------|-----------------|
| 1  | Milk                           | 1,07     | 1,07              | +               |
| 2  | cream 400g                     | 2,71     | 2,71              | +               |
| 3  | Yogurt 400g                    | 2,10     | 2,10              | +               |
| 4  | Packed potatoes 1kg            | 1,47     | 1,47              | -               |
| 5  | Packed cabbage 1kg             | 1,19     | 1,19              | -               |
| 6  | Packed tomatoes 350g           | 1,60     | 1,60              | -               |
| 7  | Packed apples 1kg              | 2,78     | 2,78              | -               |
| 8  | Packed oranges 1kg             | 3,20     | 3,20              | -               |
| 9  | Packed bananas 1kg             | 1,10     | 1,10              | +               |
| 10 | Packed beef fillet 1kg         | 12,8     | 12,8              | -               |
| 11 | Packed pork fillet 1kg         | 8,52     | 8,52              | -               |
| 12 | Packed chicken breasts 1kgSour | 10,75    | 10,75             | -               |
| 13 | Baguette 360g                  | 1,30     | 1,30              | +               |
| 14 | Drinking water 1,5l            | 0,80     | 0,80              | -               |
| 15 | Olive oil 500ml                | 5,30     | 5,30              | -               |
| 16 | Sunflower oil 1l               | 1,20     | 1,20              | -               |
| 17 | Chocolate Ritter sport 100g    | 1,10     | 1,10              | +               |
| 18 | Paulaner 0,5l                  | 1,10     | 1,10              | -               |
| 19 | Whiskey Jim Beam 1l            | 13,99    | 13,99             | -               |
| 20 | Whiskey Jack Daniels 1l        | 17,19    | 17,19             | -               |

## Таблица 2. Список карт

| id | discountcard | discount amount, % |
|----|--------------|--------------------|
| 1  | 1111         | 3                  |
| 2  | 2222         | 3                  |
| 3  | 3333         | 4                  |
| 4  | 4444         | 5                  |

Любая другая дисконтная карта с вашим номером предоставляет 2% скидки
