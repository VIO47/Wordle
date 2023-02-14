package Server;

import Commons.Word;
import Server.Database.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
@EntityScan(basePackages = {"Commons", "Server"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(WordRepository repo) {
        try {
            Scanner scanner = new Scanner(new File("Wordle_words.txt"));
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                Word w = new Word(scanner.nextLine());
                repo.save(w);
            }
            System.out.println("Words were loaded!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldn't upload words");
        }
        return args -> {};
    }
}
