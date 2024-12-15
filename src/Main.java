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

import java.util.ArrayList;
import java.util.List;
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
                    try {
                        while (true) {
                            System.out.println("""
                                    User methods:
                                    
                                    1.Add a new user,
                                    2.Get all users,
                                    3.Get user by id,
                                    4.Update user by id,
                                    5.Delete user by id,
                                    6.Back to the menu.
                                    """);
                            int chooseUser = new Scanner(System.in).nextInt();
                            switch (chooseUser) {
                                case 1 -> {
                                    System.out.println("Add a new user:");
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
                                    System.out.println("Get all users:");
                                    System.out.println(userService.getUsers());
                                }
                                case 3 -> {
                                    System.out.println("Get user by id:");
                                    System.out.print("Write user id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.println(userService.getUser(id));
                                }
                                case 4 -> {
                                    System.out.println("Update user id:");
                                    System.out.print("Write user id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.print("Update user name:");
                                    String username = new Scanner(System.in).nextLine();
                                    System.out.print("Update user password:");
                                    String password = new Scanner(System.in).nextLine();
                                    userService.updateUserById(id, username, password);
                                }
                                case 5 -> {
                                    System.out.println("Delete user by id:");
                                    System.out.print("Write user id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    userService.deleteUserById(id);

                                }
                                case 6 -> {
                                    throw new RuntimeException("Back to the menu.");
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        while (true) {
                            System.out.println("""
                                    Announcement methods:
                                    
                                    1.Add a new announcement,
                                    2.Get all announcement,
                                    3.Get announcement by id,
                                    4.Update announcement by id,
                                    5.Delete announcement by id,
                                    6.Back to the menu.
                                    """);
                            int chooseAnnouncement = new Scanner(System.in).nextInt();
                            switch (chooseAnnouncement) {
                                case 1 -> {
                                    System.out.println("Add a new announcement:");
                                    System.out.print("Enter announcement name: ");
                                    String announcementName = new Scanner(System.in).nextLine();
                                    System.out.print("Enter announcement description: ");
                                    String announcementDescription = new Scanner(System.in).nextLine();
                                    System.out.print("Enter announcement price: ");
                                    int announcementPrice = new Scanner(System.in).nextInt();
                                    System.out.println("Enter announcement owner: ");
                                    String announcementOwner = new Scanner(System.in).nextLine();
                                    System.out.println(announcementService.add(new Announcement(GeneratorId.getAnnouncementId(), announcementName, announcementDescription, announcementPrice, announcementOwner)));
                                }
                                case 2 -> {
                                    System.out.println("Get all announcements:");
                                    System.out.println(announcementService.getAllAnnouncements());
                                }
                                case 3 -> {
                                    System.out.println("Get announcement by id:");
                                    System.out.print("Write announcement id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.println(announcementService.getById(id));
                                }
                                case 4 -> {
                                    System.out.println("Update announcement by id:");
                                    System.out.print("Write announcement id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.print("Update announcement name: ");
                                    String announcementName = new Scanner(System.in).nextLine();
                                    System.out.print("Update announcement description: ");
                                    String announcementDescription = new Scanner(System.in).nextLine();
                                    System.out.print("Update announcement price: ");
                                    int announcementPrice = new Scanner(System.in).nextInt();
                                    System.out.print("Update announcement owner: ");
                                    String announcementOwner = new Scanner(System.in).nextLine();
                                    System.out.println(announcementService.updateByIdAnnouncement(id, new Announcement(GeneratorId.getAnnouncementId(), announcementName, announcementDescription, announcementPrice, announcementOwner)));
                                }
                                case 5 -> {
                                    System.out.println("Delete announcement by id:");
                                    System.out.print("Write announcement id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    announcementService.removeById(id);
                                }
                                case 6 -> {
                                    System.out.println("Back to the menu.");
                                    throw new RuntimeException("Back to the menu.");
                                }
                            }

                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        while (true) {
                            System.out.println("""
                                    Favorite methods:
                                    
                                    1.Add a new favorite,
                                    2.Get favorite by id,
                                    3.Get all favorite,
                                    4.Update favorite by id,
                                    5.Delete favorite by id,
                                    6.Get favorite by user id,
                                    7.Clear all favorites,
                                    8.Back to the menu.
                                    """);
                            int chooseAnnouncement = new Scanner(System.in).nextInt();
                            switch (chooseAnnouncement) {
                                case 1 -> {
                                    System.out.println("Add a new favorite");
                                    System.out.println(favoriteService.addFavorite(new Favorite(GeneratorId.getFavoriteId(),new User(GeneratorId.getUserId(),"Aitegin","aitegin.email.com","12345",Role.USER),new Announcement(GeneratorId.getAnnouncementId(),"Iphpne 12 pro","phone",450,"Elaman"))));
                                }
                                case 2 -> {
                                    System.out.println("Get favorite by id:");
                                    System.out.print("Write favorite id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.println(favoriteService.getFavoriteById(id));
                                }
                                case 3 -> {
                                    System.out.println("Get all favorites:");
                                    System.out.println(favoriteService.getAllFavorite());
                                }
                                case 4 -> {
                                    System.out.println("Update favorite by id:");
                                    System.out.print("Write favorite id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.println(favoriteService.updateFavorite(new Favorite(id, new User(2L), new Announcement(2L))));
                                }
                                case 5 -> {
                                    System.out.println("Delete favorite by id:");
                                    System.out.print("Write favorite id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    favoriteService.deleteFavorite(id);
                                }
                                case 6 -> {
                                    System.out.println("Get favorite by user id:");
                                    System.out.print("Write user id: ");
                                    Long id = new Scanner(System.in).nextLong();
                                    System.out.println(favoriteService.getFavoritesByUserId(id));

                                }
                                case 7 -> {
                                    System.out.println("Clear all favorites:");
                                    favoriteService.clearFavorites();
                                }
                                case 8 -> {
                                    System.out.println("Back to the menu.");
                                    throw new RuntimeException("Back to the menu.");
                                }
                            }
                        }
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}