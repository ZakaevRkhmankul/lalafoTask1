package dao.daoImpl;

import dao.AnnoumcementDao;
import database.Database;
import models.Announcement;

import java.util.List;

import static database.Database.announcements;

public class AnnouncementDaoImpl implements AnnoumcementDao {
    @Override
    public String add(Announcement announcement) {
        announcements.add(announcement);
        return "successfully added";
    }

    @Override
    public Announcement getById(Long id) {
        for (Announcement announcement : Database.announcements) {
            if (announcement.getId().equals(id)) {
                return announcement;
            }
        }
        return null;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcements;
    }

    @Override
    public String updateByIdAnnouncement(Long id, Announcement announcement) {
        for (Announcement announcement1 : announcements) {
            if (announcement1.getId().equals(id)) {
                announcement1.setName(announcement.getName());
            }
        }
        return "Successfully updated";
    }

    @Override
    public void removeById(Long id) {
        for (int i = 0; i < announcements.size(); i++) {
            if (announcements.get(i).getId().equals(id)) {
                announcements.remove(i);
                System.out.println(" ийгилуктуу очурулду: ");
                break;
            }
        }
        System.out.println(" табылган жок");
    }

}

