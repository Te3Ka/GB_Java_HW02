import java.util.Arrays;

public class Exercise02 {
    /*
    Дополнительные задания
    Дана json-строка (можно сохранить в файл и читать из файла)
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
    {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Написать метод(ы), который распарсит json и,
    используя StringBuilder, создаст строки вида:
    Студент [фамилия] получил [оценка] по предмету [предмет].
    Пример вывода:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
    */
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder(
                "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, " +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        stringBuilder.deleteCharAt(0).deleteCharAt(stringBuilder.length() - 1); // Удаляем символы [ и ]
        String string = stringBuilder.toString()
                .replace("{", "")
                .replace("}", "");
        String[] strings = string.split(",");

        String result = "";
        for (int i = 0; i < strings.length; i += 3) {
            result = "Студент ";
            String[] surname = strings[i].split(":");
            result += surname[1].replace("\"", "");
            result += " получил ";
            String[] grade = strings[i + 1].split(":");
            result += grade[1].replace("\"", "");
            result += " по предмету ";
            String[] lesson = strings[i + 2].split(":");
            result += lesson[1].replace("\"", "");
            result += ".";

            System.out.println(result);
        }

    }
}
