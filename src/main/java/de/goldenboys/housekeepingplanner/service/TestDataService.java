package de.goldenboys.housekeepingplanner.service;

import com.github.javafaker.Faker;
import de.goldenboys.housekeepingplanner.enums.Repitition;
import de.goldenboys.housekeepingplanner.model.Household;
import de.goldenboys.housekeepingplanner.model.Task;
import de.goldenboys.housekeepingplanner.model.User;
import de.goldenboys.housekeepingplanner.repository.HouseholdRepository;
import de.goldenboys.housekeepingplanner.repository.TaskRepository;
import de.goldenboys.housekeepingplanner.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TestDataService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final HouseholdRepository householdRepository;

    private List<User> users = new ArrayList<>();
    private List<Household> households = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public TestDataService(TaskRepository tr, UserRepository ur, HouseholdRepository hr) {
        this.taskRepository = tr;
        this.userRepository = ur;
        this.householdRepository = hr;
    }

    @PostConstruct
    public void createFakeData() {
        Faker faker = new Faker();
        createFakeUsers(faker, 10);
        createfakeHouseholds(faker, 10, users);
        createFakeTasks(faker, users);
    }

    private void createFakeUsers(Faker faker, int count) {
        for(int i = 0; i < count; i++) {
            User user = new User(faker.name().username(), UUID.randomUUID().toString(),
                    faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com");
            users.add(user);
            userRepository.save(user);
        }
    }

    private void createfakeHouseholds(Faker faker, int count, List<User> users) {
        for (int i = 0; i < count; i++){
            int startIndex = faker.random().nextInt(Math.min(8, users.size()-1));
            int numberOfUsers = faker.random().nextInt(users.size() - 1 - startIndex);
            List<User> householdUsers = users.subList(startIndex, startIndex + numberOfUsers);
            Household household = new Household(faker.funnyName().name(), householdUsers);
            households.add(household);
            householdRepository.save(household);
        }
    }

    private void createFakeTasks(Faker faker, List<User> users) {
        for(User user: users){
            for (int i = 0; i < 4; i++) {
                Task task = new Task(
                        faker.ancient().hero(),
                        faker.demographic().demonym(),
                        LocalDateTime.now(),
                        faker.random().nextInt(90),
                        randomRepitition(),
                        user);
                tasks.add(task);
                taskRepository.save(task);
            }
        }
    }

    private Repitition randomRepitition() {
        int repNum = ThreadLocalRandom.current().nextInt(4);
        switch (repNum) {
            case 0:
                return Repitition.DAILY;
            case 1:
                return Repitition.WEEKLY;
            case 2:
                return Repitition.EVERY_OTHER_DAY;
            default:
                return Repitition.TWO_TIMES_PER_WEEK;
        }
    }

    @PreDestroy
    public void deleteTestData() {
        taskRepository.deleteAll(tasks);
        householdRepository.deleteAll(households);
        userRepository.deleteAll(users);
        tasks = new ArrayList<>();
        households = new ArrayList<>();
        users = new ArrayList<>();
    }

}

