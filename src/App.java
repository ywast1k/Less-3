import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        
        String next = scanner.nextLine();

        String[] split = next.split(" ");
            if (split.length != 6) {
                throw new IOException("Не хватает данных для сохранения!");
            }
        String surname = split[0];
        String name = split[1];
        String patronymic = split[2];
        String birthDate = split[3];
            if(split[3].length() !=10){
                throw new IOException("Неверный формат даты рождения");
            }
                
        String phoneNumber = split[4];
        String gender = split[5];
            if (!gender.equals("f") && !gender.equals("m")) {
                throw new IllegalArgumentException("Пол должен быть 'f' или 'm'");
            }

        
        String fn = surname + ".txt";
         try (FileWriter fw = new FileWriter(fn, StandardCharsets.UTF_8, true)) {
            fw.write("Фамилия: " + surname);
            fw.write(" Имя: " + name );
            fw.write(" Отчество: " + patronymic);
            fw.write(" Дата рождения: " + birthDate);
            fw.write(" Номер телефона: " + phoneNumber);
            fw.write(" Пол: " + gender + "\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}