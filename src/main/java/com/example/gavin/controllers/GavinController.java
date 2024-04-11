package com.example.gavin.controllers;

import com.example.gavin.InMemoryAppender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class GavinController {
    String[] names = {
            "Ava Johnson", "Liam Smith", "Sophia Williams", "Noah Brown", "Isabella Jones",
            "Elijah Davis", "Mia Miller", "Oliver Wilson", "Charlotte Taylor", "Lucas Anderson",
            "Amelia Martinez", "Mason Thomas", "Harper Jackson", "Ethan White", "Evelyn Harris",
            "Logan Thompson", "Abigail Garcia", "Benjamin Lee", "Emily Rodriguez", "Alexander Lewis",
            "Elizabeth Perez", "Henry Hall", "Evelyn Clark", "Jackson Walker", "Victoria Hernandez",
            "Samuel King", "Scarlett Scott", "Daniel Martinez", "Madison Young", "William Adams",
            "Luna Lopez", "Michael Moore", "Grace Green", "Aiden Martin", "Lily Mitchell",
            "Sebastian Hill", "Avery Nelson", "James Baker", "Zoey Wright", "Gabriel Ramirez",
            "Riley Cooper", "Mateo Flores", "Layla Rivera", "Jackson Harris", "Nora Sanchez",
            "Wyatt Carter", "Chloe Thompson", "David Turner", "Penelope Howard", "Julian Stewart",
            "Aria Price", "Joseph Ross", "Hailey Flores", "Levi Edwards", "Aubrey Morris",
            "Joshua Stewart", "Camila Coleman", "Christopher Perry", "Nora Simmons", "Dylan Bailey",
            "Sofia Hughes", "Caleb Murphy", "Ellie Washington", "Isaac Nelson", "Addison Diaz",
            "Samuel Watson", "Stella Peterson", "Nathan Powell", "Zoey Watson", "Andrew Barnes",
            "Hannah Foster", "Jonathan Bennett", "Bella Cooper", "Adrian Gonzales", "Paisley Butler",
            "Lincoln Rivera", "Lillian Roberts", "Ezra Turner", "Naomi Long", "Isaac Allen",
            "Ariana Ross", "Colton Morris", "Eva Perry", "Isaiah Cox", "Savannah Coleman",
            "Jeremiah Griffin", "Clara Evans", "Christian Mitchell", "Ellie Torres", "Josiah Reed",
            "Vivian Price", "Cameron Reed", "Madelyn Russell", "Anthony Murphy", "Peyton Foster",
            "Thomas Bailey", "Eleanor James", "Asher Jenkins", "Gabriella Bell", "Charles Ward",
            "Aurora Ramirez", "Jordan Sanchez", "Addison Butler", "Adrian Campbell", "Hazel Martinez",
            "Leo Simmons", "Naomi Parker", "Connor Watson", "Nora Hill", "Eli Graham", "Zoey Adams",
            "Hunter Green", "Adeline Bryant", "Aaron Ross", "Skylar Watson", "Jonathan Hayes",
            "Lucy Cox", "Xavier Diaz", "Kylie Bennett", "Levi Turner", "Paisley Powell",
            "Wyatt Campbell", "Audrey Carter", "Nicholas Gray", "Reagan Hughes", "John Fisher",
            "Caroline Sanders", "Dominic Evans", "Violet Howard", "Asher Coleman", "Elena Watson",
            "Nathaniel Phillips", "Hazel Torres", "Ryder Russell", "Quinn Garcia", "Eliana Long",
            "Miles Jenkins", "Scarlett Reed", "Vincent Patterson", "Clara Butler", "Tristan Griffin",
            "Adalyn Adams", "Maxwell Wood", "Ariana Price", "Owen Bell", "Clara Mitchell",
            "Evan Ramirez", "Alana Russell", "Daniel Bennett", "Skylar Cox", "Aiden Torres",
            "Gemma Howard", "Gabriel Peterson", "Kinsley Parker", "Cameron Gonzalez", "Isabelle Ward",
            "Grayson Young", "Naomi Allen", "Isaac Hayes", "Sophie Jenkins", "Ryder Hughes",
            "Luna Brooks", "Colton Fisher", "Savannah Coleman", "Jordan Gray", "Elena Hayes",
            "Lincoln Rivera", "Ivy Butler", "Carter Cox", "Eva Perry", "Jayden Bell", "Scarlett Scott",
            "Dominic Evans", "Piper Murphy", "Leo Simmons", "Lila Ward", "Oliver Jenkins", "Stella Peterson",
            "Max Bryant", "Reagan Hughes", "Logan Thompson", "Alana Russell", "Elijah Davis", "Quinn Garcia",
            "Lucas Anderson", "Audrey Carter", "Caleb Murphy", "Isabelle Ward", "Jaxon Flores", "Adalyn Adams",
            "Grayson Young", "Ariana Price", "Christian Mitchell", "Naomi Allen", "Carter Cox", "Elena Hayes",
            "Gabriel Peterson", "Lila Ward", "Oliver Jenkins", "Stella Peterson"
    };
    @GetMapping("/")
    public String main(Model model) {
        Random random = new Random();
        model.addAttribute("gavin","Gavin Henderson's All time underaged hit list (in 10s)");
        List<String> l = new ArrayList<>();
        for (int i=0;i<10;i++) {
            l.add(names[random.nextInt(names.length-1)]);
        }

        model.addAttribute("names",l);
        return "index";
    }
    @GetMapping("/logs")
    public String showLogs(Model model) {
        List<String> logs = new ArrayList<>(InMemoryAppender.getLogQueue());
        model.addAttribute("logs", logs);
        System.out.println(logs);
        return "logView";
    }
    @GetMapping("/lucas")
    public String lucas() {
        return "lucas";
    }
}
