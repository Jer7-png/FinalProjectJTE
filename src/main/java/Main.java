

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {



        File counter = new File("counter.txt");
        int count = 0;


        try (Scanner counterReader = new Scanner(counter)) {
            count = counterReader.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }

        ArrayList<Pankkitili> tilit = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Tilit.txt"))) {
            while (true) {
                try {
                    Pankkitili tili = (Pankkitili) ois.readObject();
                    tilit.add(tili);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("\n");
            System.out.println("Welcome to the banking application! (admin mode)");
            Scanner scanner = new Scanner(System.in);

            System.out.println("1. Tee uusi tili");
            System.out.println("2. Hallitse tiliä");
            System.out.println("3. Exit");

            // Lisäsin tarkituksen tänne ja myöhemmin, että inputtia ei voi laittaa väärin
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                continue;
            }
            String input = scanner.next();

            if (Integer.valueOf(input).equals(1)) {
                System.out.println("Tilin luonti");
                System.out.println("1. Luo tyhjä tili");
                System.out.println("2. Luo tili alkusaldolla");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input");
                    continue;
                }

                String luontiInput = scanner.next();

                if (Integer.valueOf(luontiInput).equals(1)) {
                    Pankkitili uusiTili = new Pankkitili(count++);

                    tilit.add(uusiTili);

                }
                else if (Integer.valueOf(luontiInput).equals(2)) {
                    System.out.println("Anna alkusaldo: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("invalid input");
                        continue;
                    }
                    String alkusaldo = scanner.next();

                    Pankkitili uusiTili = new Pankkitili(Double.parseDouble(alkusaldo), count++);

                    tilit.add(uusiTili);
                }
                try {
                    FileWriter fw = new FileWriter("counter.txt", false);
                    fw.write(String.valueOf(count));
                    fw.close();

                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }

            }
            else if (Integer.valueOf(input).equals(2)) {
                System.out.println("Hallitse tiliä");
                System.out.println("Valitse tili (id)");
                System.out.println("Olemassa olevat tilit: ");
                for (Pankkitili x: tilit) {
                    System.out.println("tili(id): " + x.getId());

                }

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input");
                    continue;
                }
                String valittuTiliId = scanner.next();

                Pankkitili valittuTili = null;

                for (Pankkitili x: tilit) {
                    if (x.getId() == Integer.parseInt(valittuTiliId)) {
                        valittuTili = x;
                    }
                }

                System.out.println("Saldo: " + valittuTili.getSaldo());
                System.out.println("1. Nosta");
                System.out.println("2. Talleta");
                System.out.println("3. Tapahtumahistoria");

                if (!scanner.hasNextInt()) {
                    System.out.println("invalid input");
                    continue;
                }

                String x = scanner.next();

                if (Integer.valueOf(x).equals(1)) {
                    System.out.println("Nostomäärä: ");

                    if (!scanner.hasNextDouble()) {
                        System.out.println("invalid input");
                        continue;
                    }
                    String maara = scanner.next();
                    valittuTili.nosto(Double.parseDouble(maara));
                }
                else if (Integer.valueOf(x).equals(2)) {
                    System.out.println("Talletusmäärä: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("invalid input");
                        continue;
                    }
                    String maara = scanner.next();
                    valittuTili.talleta(Double.parseDouble(maara));
                }
                else if (Integer.valueOf(x).equals(3)) {
                    System.out.println("Tapahtumahistoria: ");
                    for (String tapahtuma: valittuTili.getHistoria()) {
                        System.out.println(tapahtuma);
                    }
                }

            }
            else if (Integer.valueOf(input).equals(3)) {
                break;
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("Tilit.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Pankkitili x: tilit) {
            objectOutputStream.writeObject(x);
        }
        objectOutputStream.flush();
        objectOutputStream.close();



    }
}
