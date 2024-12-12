package dao;

import models.Announcement;

import java.util.List;

public interface AnnoumcementDao {
    String add(Announcement announcement );

    Announcement getById(Long id);

    List<Announcement> getAllAnnouncements();

    String updateByIdAnnouncement(Long id ,Announcement announcement);

    void removeById(Long id);

}
