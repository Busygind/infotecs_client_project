# Тестовый проект на стажировку в компанию "infotecs"
------------------------------------------------------------
### Задание 1:
Реализовать клиент для работы с FTP сервером, на котором расположен файл с информацией о студентах кафедры в виде JSON подобной структуры:
```json
{
   "students": [
      {
         "id": 1,
         "name": "Student1"
      },
      {
         "id": 2,
         "name": "Student2"
      },
      {
         "id": 3,
         "name": "Student3"
      }
   ]
}
```
Клиент должен быть разработан в виде консольного приложения, принимающего на вход логин, пароль пользователя и IP-адрес FTP-сервера, после чего выводит меню, в котором доступны на выбор следующие действия:
1.	Получение списка студентов по имени
2.	Получение информации о студенте по id
3.	Добавление студента (id генерируется автоматически)
4.	Удаление студента по id
5.	Завершение работы

Целевая платформа: **Linux**

### Задание 2:
Для разработанной системы:
1.	Составить список необходимых проверок для системы
2.	Изучить фреймворк TestNG
3.	В отдельном проекте разработать автотесты на основании списка из **п.1** с использованием фреймворка из **п.2**
4.	Объединить полученные тесты в test-suite и добиться их запуска.

Требования к присылаемым решениям:
* Тестовое задание должно быть выполнено с использованием **Java SE 8**. Для сборки не должны скачиваться внешние библиотеки, не входящие в состав JDK.
* Клиент должен уметь работать с FTP-сервером в двух режимах: активном и пассивном
* Список студентов при выводе должен быть отсортирован по алфавиту
* id студента уникален

Результат предоставить в виде архива с исходными кодами и/или ссылкой на репозиторий github, где должен быть размещен(ы) проект(ы).
В архиве также должны находиться:
1.	исполняемый jar-файл клиента
2.	инструкция по сборке проекта
3.	инструкция по работе с приложением
4.	исполняемый jar-файл автотестов
5.	инструкция по запуску тестов и кратким обоснованием тестов.

-----------------------
### Комментарии к выполненному проекту:
* В работе было запрещено использование библиотек, не входящих в состав JDK. 
Исходя из этого и документации стандартного набора JDK, я принял решение не использовать 
библиотеку sun.net с некоторым функционалом для работы с протоколом ftp. Это влечет
возможные трудности с работой в активном режиме, но я посчитал условие отсутствия 
библиотек более строгим.
* Test-suite и сама система были объединены в один проект, но без труда могут быть 
сепарированы. Это было сделано для удобства тестирования и сборки проекта. Единственный
минус - **TestNG** импортирован на весь проект, а не на только тестовую часть.
* Список необходимых по моему мнению тестов представлен [здесь](https://github.com/Busygind/infotecs_client_project/blob/main/src/test/test_list.txt).
* Парсинг JSON выполнялся также вручную, поэтому его работа не была доведена до 
идеала (посчитал это изобретением велосипеда), да и в целом, думаю, проект направлен не на парсинг.

### Инструкция по сборке проекта: 
1. Клонировать репозиторий в директорию на диске
2. В терминале перейти в директорию main/java/ и скомпилировать java-классы (для удобства в директорию out): 

` javac -classpath . App.java commands/*.java entities/*.java utils/*.java -d ../../../out`
3. Перейти в директорию out/ и объединить классы в исполняемый jar-файл:

`jar cvfe client.jar App *.class */*.class`
4. Проверить работоспособность jar-файла:

`java -jar client.jar`

### Инструкция по работе с приложением:
1. Запустите jar-файл в терминале (см. выше)
2. В меню приветствия следуйте указаниям и введите данные сервера, с которым будет
производиться работа
3. При успешном подключении данные из файла с данными будут импортированы в программу,
и вам выведется подсказка с доступными командами и их аргументами
4. После каждой команды измененные данные будут сохраняться на сервере

### Инструкция по запуску тестов
Первый вариант:
1. Запустить весь проект с помощью среды разработки и импортировать зависимость testNG (версия 7.6.1)
2. Редактировать конфигурацию запуска как TestNG suite и указать путь до конфигурационного файла _system_test_suite.xml_
3. Запустить test-suite

Второй вариант:
