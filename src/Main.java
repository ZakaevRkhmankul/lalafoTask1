import database.GeneratorId;
import enums.Role;
import models.Announcement;
import models.Favorite;
import models.User;
import service.AnnouncementService;
import service.FavoriteService;
import service.UserService;
import service.serviceImpl.AnnouncementServiceImpl;
import service.serviceImpl.FavoriteServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        FavoriteService favoriteService = new FavoriteServiceImpl();
//
//
//        AnnouncementServiceImpl announcementService = new AnnouncementServiceImpl();
//
//        System.out.println(announcementService.add(new Announcement(GeneratorId.getAnnouncementId(), "Mersedes", "the best car", 8000, "Elaman")));
//        System.out.println(announcementService.getById(1L));
//
//        System.out.println(announcementService.getAllAnnouncements());
//
//        System.out.println(announcementService.updateByIdAnnouncement(1L, new Announcement(GeneratorId.getAnnouncementId(), "BMW", "the best car", 8000, "Elaman")));
//        System.out.println(announcementService.getById(1L));

        UserService userService = new UserServiceImpl();
        AnnouncementService announcementService = new AnnouncementServiceImpl();
        FavoriteService favoriteService = new FavoriteServiceImpl();
        while (true) {
            System.out.println("""
                    Choose options:
                    1.User methods
                    2.Announcement methods
                    3.Favorite methods
                    """);
            int choose = new Scanner(System.in).nextInt();
            switch (choose) {
                case 1 -> {
                    while (true) {
                        System.out.println("""
                                User methods:
                                
                                1.Add a new user,
                                2.Get all users,
                                3.Get user by id;
                                4.
                                """);
                        int chooseUser = new Scanner(System.in).nextInt();
                        switch (chooseUser) {
                            case 1 -> {
                                System.out.print("Enter username: ");
                                String username = new Scanner(System.in).nextLine();
                                System.out.print("Enter email: ");
                                String email = new Scanner(System.in).nextLine();
                                System.out.print("Enter password: ");
                                String password = new Scanner(System.in).nextLine();
                                System.out.print("Enter role: ");
                                String role = new Scanner(System.in).nextLine();
                                if (role.equals("admin")) {
                                    userService.addUser(new User(GeneratorId.getUserId(), username, email, password, Role.ADMIN));
                                } else if (role.equals("user")) {
                                    userService.addUser(new User(GeneratorId.getUserId(), username, email, password, Role.USER));
                                } else if (role.equals("vendor")) {
                                    userService.addUser(new User(GeneratorId.getUserId(), username, email, password, Role.VENDOR));
                                } else {
                                    System.out.println("incorect ");
                                }
                            }
                            case 2 -> {
                                System.out.println("Get all users");
                                System.out.println(userService.getUsers());
                            }
                            case 3 -> {
                                System.out.println("Write user id");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println(userService.getUser(id));
                            }
                        }
                    }
                }
            }
        }
    }
}