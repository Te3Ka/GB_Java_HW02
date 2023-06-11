import java.util.Arrays;

public class HomeWork02 {
    /*
    Задание
    Дана строка sql-запроса "select * from students where ".
    Сформируйте часть WHERE этого запроса, используя StringBuilder.
    Данные для фильтрации приведены ниже в виде json-строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    */
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("select * from students where ");
        StringBuilder stringBuilder = new StringBuilder(
                "{\"name\":\"Ivanov\"," +
                " \"country\":\"Russia\"," +
                " \"city\":\"Moscow\"," +
                " \"age\":\"null\"}");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).deleteCharAt(0);
        String[] strings = stringBuilder
                .toString()
                .replace(":", ", ")
                .split(", ");
        for (int i = 0; i < strings.length; i += 2) {
            if (strings[i + 1].equals("\"null\"")) {
                string.deleteCharAt(string.length() - 1)
                        .deleteCharAt(string.length() - 1);
            } else {
                string.append(strings[i])
                        .append(" = ")
                        .append(strings[i + 1])
                        .append(", ");
            }
        }
        System.out.println(string);
    }
}
