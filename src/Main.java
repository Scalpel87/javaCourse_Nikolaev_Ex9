import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static TreeMap<Student, Integer> studentTreeMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        studentTreeMap.put(new Student("NSV", 20, "RKT", FavoriteSubject.INFORMATICS), 1);
        studentTreeMap.put(new Student("NII", 18, "LDH", FavoriteSubject.PHYSICS), 2);
        do {
            switch (menu()) {
                case 1: newStudent();
                        break;
                case 2: printAscending();//по возрастанию
                        break;
                case 3: printDescending();//по убыванию
                        break;
                case 4: deleteStudent();
                        break;
                case 5: exit();
                        break;
            }
        }
        while(true);
    }
    public static int menu() throws IOException {
        int select = 0;
        do {
            System.out.println("\nВведите цифру, соответствующую пункту меню:\n" +
                    "1. Ввести ученика.\n" +
                    "2. Вывести всех учеников по возрастанию.\n" +
                    "3. Вывести всех учеников по убыванию.\n" +
                    "4. Удалить ученика по индексу.\n" +
                    "5. Выйти из программы.\n");
            select = Integer.parseInt(reader.readLine());

        } while ((select < 1) && (select > 5));
        return select;
    }
    public static void newStudent() throws IOException {
        System.out.println("Введите \"Фамилию Имя Отчество\" ученика.");
        String fio = reader.readLine();
        int age;
        do {
            System.out.println("Введите возраст ученика.");
            age =  Integer.parseInt(reader.readLine());
        } while ((age < 1) && (age > 125));
        System.out.println("Введите группу ученика.");
        String group = reader.readLine();
        int subject;
        do {
            System.out.println("Введите номер любимого предмета ученика.\n" +
                    "1. Математика.\n" +
                    "2. Информатика.\n" +
                    "3. Физика.\n");
            subject =  Integer.parseInt(reader.readLine());
        } while ((subject < 1) && (subject > 3));
        switch (subject) {
            case 1: if (studentTreeMap.containsKey(new Student(fio, age, group, FavoriteSubject.MATHS))){
                        System.out.println("Такой студент уже есть");
                        break;
                    }
                    studentTreeMap.put(new Student(fio, age, group, FavoriteSubject.MATHS), (studentTreeMap.size() + 1));
                    break;
            case 2:
                if (studentTreeMap.containsKey(new Student(fio, age, group, FavoriteSubject.INFORMATICS))){
                    System.out.println("Такой студент уже есть");
                    break;
                }
                studentTreeMap.put(new Student(fio, age, group, FavoriteSubject.INFORMATICS), (studentTreeMap.size() + 1));
                break;
            case 3:
                if (studentTreeMap.containsKey(new Student(fio, age, group, FavoriteSubject.PHYSICS))){
                    System.out.println("Такой студент уже есть");
                    break;
                }
                studentTreeMap.put(new Student(fio, age, group, FavoriteSubject.PHYSICS), (studentTreeMap.size() + 1));
                break;
        }
    }
    public static void printAscending(){//по возрастанию
        for (Map.Entry<Student, Integer> e : studentTreeMap.entrySet()){
            System.out.println("Ученик №" + e.getValue() + " : " + e.getKey());
        }
    }
    public static void printDescending(){//по убыванию
        TreeMap<Student, Integer> tempStudentTreeMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Student, Integer> e : studentTreeMap.entrySet()){
            tempStudentTreeMap.put(e.getKey(), e.getValue());
        }
        for (Map.Entry<Student, Integer> e : tempStudentTreeMap.entrySet()){
            System.out.println("Ученик №" + e.getValue() + " : " + e.getKey());
        }
    }
    public static void deleteStudent() throws IOException {
        if (studentTreeMap.size() > 0){
            printAscending();
            int index;
            do {
                System.out.println("Введите индекс ученика от 1 до " + studentTreeMap.size());
                index = Integer.parseInt(reader.readLine());
            } while ((index < 1) && (index > studentTreeMap.size()));
            for (Map.Entry<Student, Integer> e : studentTreeMap.entrySet()){
                if (index == e.getValue()) {
                    studentTreeMap.remove(e.getKey());
                    break;
                }
            }
        } else System.out.println("Учеников еще нет в базе.");

    }
    public static void exit() throws IOException {
        reader.close();
        System.exit(0);
    }
}
