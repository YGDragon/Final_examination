package counter;

import java.io.*;

public class IdCounter implements AutoCloseable {

    private int id;
    public String fileName = "final_id.txt";

    public IdCounter() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            id = Integer.parseInt(buffer.readLine());
        } catch (IOException e) {
            System.out.println("файл счетчика отсутствует -> " +
                    "создан новый файл счетчика -> " +
                    "ID-номер выставлен по умолчанию");
            id = 1;
        }
    }

    public int getId() {
        return id;
    }

    public void add() {
        id++;
    }

    @Override
    public void close() throws Exception {
    }
}