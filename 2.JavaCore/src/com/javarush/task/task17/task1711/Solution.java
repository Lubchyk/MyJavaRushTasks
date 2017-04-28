package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CrUD Batch — multiple Creation, Updates, Deletion
Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/
public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        int sex = 2;
        int countName = 1;
        int countBD = 3;
        int id = 1;
        switch (args[0]) {
            case  "-c" :
                synchronized (allPeople) {
                    try {
                        for (int i = 0; i < args.length; i++) {
                            if (args[sex].equals("м")) {
                                allPeople.add(Person.createMale(args[countName], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[countBD])));
                                sex += 3;
                                countName += 3;
                                countBD += 3;
                            } else if (args[sex].equals("ж")) {
                                allPeople.add(Person.createFemale(args[countName], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[countBD])));
                                sex += 3;
                                countName += 3;
                                countBD += 3;
                            }
                            System.out.println(allPeople.size() - 1);
                        }
                    } catch ( Exception e ) { }
                }
//            for (int i = 0; i < allPeople.size(); i++) {
//                System.out.println(allPeople.get(i).getName() + " " + allPeople.get(i).getSex() + " " + simpleDateFormat.format(allPeople.get(i).getBirthDay()));
//            }
            case "-u" :
                synchronized (allPeople) {
                    sex++;
                    countName++;
                    countBD++;
                    try {
                        for (int i = 0; i < args.length; i++) {
                            if (args[sex].equals("м")) {
                                sex += 4;
                                allPeople.get(Integer.parseInt(args[id])).setName(args[countName]);
                                allPeople.get(Integer.parseInt(args[id])).setSex(Sex.MALE);
                                allPeople.get(Integer.parseInt(args[id])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[countBD]));
                                id += 4;
                                countName += 4;
                                countBD += 4;
                            } else if (args[sex].equals("ж")) {
                                sex += 4;
                                allPeople.get(Integer.parseInt(args[id])).setName(args[countName]);
                                allPeople.get(Integer.parseInt(args[id])).setSex(Sex.FEMALE);
                                allPeople.get(Integer.parseInt(args[id])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[countBD]));
                                id += 4;
                                countName += 4;
                                countBD += 4;
                            }
                        }
                    } catch ( Exception e ) { }
                }
//            for (int i = 0; i < allPeople.size(); i++) {
//                System.out.println(allPeople.get(i).getName() + " " + allPeople.get(i).getSex() + " " + simpleDateFormat.format(allPeople.get(i).getBirthDay()));
//            }
            case "-d" :
                synchronized (allPeople) {
                    try {
                        for (int i = 0; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[id])).setName(null);
                            allPeople.get(Integer.parseInt(args[id])).setSex(null);
                            allPeople.get(Integer.parseInt(args[id])).setBirthDay(null);
                            id++;
                        }
                    } catch ( Exception e ) {
                    }
                }
            case "-i" :
                synchronized (allPeople) {
                    try {
                        for (int i = 0; i < args.length; i++) {
                            String s = String.valueOf(allPeople.get(Integer.parseInt(args[id])).getSex());
                            if (s.equals("MALE")) s = "м";
                            else s = "ж";
                            System.out.println(allPeople.get(Integer.parseInt(args[id])).getName() + " " + s + " " + simpleDateFormat.format(allPeople.get(Integer.parseInt(args[id])).getBirthDay()));
                            id++;
                        }
                    } catch ( Exception e ) { }
                }
        }
    }
}
