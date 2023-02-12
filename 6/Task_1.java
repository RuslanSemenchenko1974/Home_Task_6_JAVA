/**
 Создать класс Ноутбук для магазина техники.

Добавить атрибуты класса с соответствующими типами.
Например,
- идентификатор
- производитель
- название модели
- RAM
- объем HD
- операционная система
- цена
- и т.д.
Добавить конструктор класса.
Добавить необходимые методы класса.
 */
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Task_1 {
public static void main(String[] args) throws Exception {
    System.out.print("\033\143");

BufferedReader br = new BufferedReader(new FileReader("ListOfLapTop.txt"));
String str;
HashSet <NoutBook> listOfLapTop = new HashSet<>();
while ((str = br.readLine()) != null) {
    ArrayList<String> myList = new ArrayList<String>(Arrays.asList(str.split(",")));
    NoutBook n1 = new NoutBook(Integer.parseInt(myList.get(0)), myList.get(1), myList.get(2), Integer.parseInt(myList.get(3)), Integer.parseInt(myList.get(4)), myList.get(5), Integer.parseInt(myList.get(6)), myList.get(7));
    listOfLapTop.add(n1);
    }
br.close(); 
    System.out.println("Добро пожаловать в каталог ноутбуков!");
    System.out.println("Выберите действие:"+"\n"+"1 - Печать всех товаров  "+"\n"+"2 - Поиск по каталогу  "+"\n"+"0 - Выход");
    
    int choice = InputNamber.InputN();
    switch (choice) {
        case 1:
        int j = 0;
        for (var item:listOfLapTop){
            j++;
            System.out.println(j+") "+item);
        }
        break;
        case 0:
        break;
        case 2:
        System.out.println("Введите цифру, соответствующую критерию поиска:"+"\n"+"1 - RAM "+"\n"+"2 - Объем HD "+"\n"+"3 - Операционная система "+"\n"+"4 - Цвет");
        int choice2 = InputNamber.InputN();
        seekLapTop(choice2, listOfLapTop);
        default:
        if (0>choice||choice>3) {System.out.println("Ошибка ввода!!!");}
        }
}
public static void seekLapTop(int n, HashSet <NoutBook> listOfLapTop){
    switch (n) {
        case 1:
        System.out.println("RAM в наличии :");
        Set <Integer> listOfRAM = new HashSet<>();
        for (var item:listOfLapTop){
            listOfRAM.add(item.ram);
        }
        int i=0;
        Map <Integer, Integer> MapOfRAM = new HashMap<>();
        for (var item:listOfRAM){
            i++;
            MapOfRAM.put(i, item);
        }
        
        System.out.println(MapOfRAM);
        Boolean check = true;
        int ram = 0;
        while (check) {
            System.out.print("Введите номер RAM: ");
            ram = InputNamber.InputN();
            if (MapOfRAM.containsKey(ram)) check = false;
            else { System.out.println("Введите корректные данные!");}
        }
        
        System.out.printf("Ноутбуки с RAM %d \n", MapOfRAM.get(ram));
        i = 0;
        for (var item:listOfLapTop){
            if (item.ram==MapOfRAM.get(ram)){
                i++;
                System.out.println(i+") "+item);}
        }
        break;

        case 2:
        System.out.println("HD в наличии :");
        Set <Integer> listOfHD = new HashSet<>();
        for (var item:listOfLapTop){
            listOfHD.add(item.hd);
        }
        i=0;
        Map <Integer, Integer> MapOfHD = new HashMap<>();
        for (var item:listOfHD){
            i++;
            MapOfHD.put(i, item);
        }
        System.out.println(MapOfHD);

        check = true;
        int hd = 0;
        while (check) {
            System.out.print("Введите номер HD: ");
            hd = InputNamber.InputN();
            if (MapOfHD.containsKey(hd)) check = false;
            else { System.out.println("Введите корректные данные!");}
        }

        System.out.printf("Ноутбуки с HD %d \n", MapOfHD.get(hd));
        i =0;
        for (var item:listOfLapTop){
            if (item.hd==MapOfHD.get(hd)){
                i++;
                System.out.println(i+") "+item);}
        }
        break;
        case 3:
        System.out.println("Операционные системы в наличии :");
        Set <String> listOfOS = new HashSet<>();
        for (var item:listOfLapTop){
            listOfOS.add(item.oS);
        }

        i=0;
        Map <Integer, String> MapOfOS = new HashMap<>();
        for (var item:listOfOS){
            i++;
            MapOfOS.put(i, item);
        }
        System.out.println(MapOfOS);

        check = true;
        int os = 0;
        while (check) {
            System.out.print("Введите номер OC: ");
            os = InputNamber.InputN();
            if (MapOfOS.containsKey(os)) check = false;
            else { System.out.println("Введите корректные данные!");}
        }

        System.out.printf("Ноутбуки с операционной системой %s\n", MapOfOS.get(os));
        i=0;
        for (var item:listOfLapTop){
            if (item.oS.equals(MapOfOS.get(os))){
                i++;
                System.out.println(i+") "+item);}
        }
        break;
        case 4:
        System.out.println("Цвет в наличии :");
        Set <String> listOfColor = new HashSet<>();
        for (var item:listOfLapTop){
            listOfColor.add(item.color);
        }

        i=0;
        Map <Integer, String> MapOfColor = new HashMap<>();
        for (var item:listOfColor){
            i++;
            MapOfColor.put(i, item);
        }
        System.out.println(MapOfColor);

        check = true;
        int col = 0;
        while (check) {
            System.out.print("Введите номер цвета: ");
            col = InputNamber.InputN();
            if (MapOfColor.containsKey(col)) check = false;
            else { System.out.println("Введите корректные данные!");}
        }
        System.out.printf("Ноутбуки с цвет %s \n", MapOfColor.get(col));
        i = 0;
        for (var item:listOfLapTop){
            if (item.color.equals(MapOfColor.get(col))){
                i++;
                System.out.println(i+") "+item);;}
        }
        break;
        default:
        if (0>n||n>4) {System.out.println("!!!Ошибка ввода!!!");}
    } 
}
}