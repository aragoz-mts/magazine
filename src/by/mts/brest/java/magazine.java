package by.mts.brest.java;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


    public class magazine {

        public static void main(String[] args) throws IOException {
            String fin;
            String someString1;
            int pricet;
            int romt;
            int ramt;
            int screent;
            String colort;
            String namet;
            ArrayList<magazine_structure> sku = new ArrayList<>();

            try (FileReader reader = new FileReader("C:\\my\\command_list.txt")) {
                // читаем посимвольно
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Scanner in = new Scanner(System.in);    // Объявляем сканер строки
            while (true) {
                System.out.println("Enter Your Command 1;2;3;4;5");
                someString1 = in.nextLine();     // Ожидаем ввод СТРОКИ, пишем его в someString
                if (someString1.contains("stop")) {
                    break;
                } else if (someString1.contains("1")) {
                    while (true) {
                        System.out.print("Enter product name: ");
                        namet = in.nextLine();
                        System.out.print("Enter color produkt: ");
                        colort = in.nextLine();
                        System.out.print("Enter price of produkt: ");
                        pricet = in.nextInt();
                        System.out.print("Enter rom of produkt: ");
                        romt = in.nextInt();
                        System.out.print("Enter ram of produkt: ");
                        ramt = in.nextInt();
                        System.out.print("Enter inh of display: ");
                        screent = in.nextInt();
                        magazine_structure tovar = new magazine_structure(namet, colort, pricet, romt, ramt, screent);
                        sku.add(tovar);
                        in.nextLine();
                        System.out.println("Для прекращения ввода введите 'stop'");
                        fin = in.nextLine();
                        if (fin.contains("stop")) {break;}
                    }
                } else if (someString1.contains("2")) {
                    String magazine = "C:\\my\\magazine.txt";
                    new File(magazine).getParentFile().mkdirs();
                    FileWriter writer = new FileWriter(magazine);
                    writer.write(sku.toString());
                    writer.close();
                    System.out.println("Сохранено");
                } else if (someString1.contains("3")) {
                    sku.sort(Comparator.comparing(a -> a.price));
                    printmagazine_structure(sku);
                } else if (someString1.contains("4")) {
                    sku.sort(Comparator.comparing(a -> a.name));
                    printmagazine_structure(sku);
                } else if (someString1.contains("5")) {
                    sku.sort(Comparator.comparing(a -> a.screen));
                    printmagazine_structure(sku);
                }

            }

        }

        private static void printmagazine_structure(ArrayList<magazine_structure> Arraysku) {

            // классический способ вывода списка:
            int i;
            for (i = 0; i < Arraysku.size(); i++) {
                System.out.println("Название ТО: " + Arraysku.get(i).name);
                System.out.println("; цвет: " + Arraysku.get(i).color);
                System.out.println("; Оперативная память: " + Arraysku.get(i).rom);
                System.out.println("; Внутренняя память = " + Arraysku.get(i).ram);
                System.out.println("; Размер экрана = " + Arraysku.get(i).screen);
                System.out.println("; Цена = " + Arraysku.get(i).price);
                System.out.println("");
            }
            System.out.println("------------------------------------");
        }
        //            this.name = name;
        //            this.color = color;
        //            this.rom = rom;
        //            this.ram = ram;
        //            this.screen = screen;
        //            this.price = price;
    }


