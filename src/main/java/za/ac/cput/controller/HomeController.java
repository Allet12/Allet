package za.ac.cput.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        try {
            // Read the HTML file
            Resource resource = new ClassPathResource("index.html");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Load the content of the HTML file
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading HTML file";
        }
    }
}
