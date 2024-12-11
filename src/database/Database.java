package database;

import models.Announcement;
import models.Favorite;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {


    public static List<User> users = new ArrayList<User>();

    public static List<Favorite> favorites = new ArrayList<>();

    public static List<Announcement> announcements = new ArrayList<>();

}
