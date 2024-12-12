package service.serviceImpl;

import dao.daoImpl.AnnouncementDaoImpl;
import models.Announcement;
import service.AnnouncementService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    AnnouncementDaoImpl announcementDao = new AnnouncementDaoImpl();
    @Override
    public String add(Announcement announcement) {
        return announcementDao.add(announcement);
    }

    @Override
    public Announcement getById(Long id) {
        return announcementDao.getById(id);
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementDao.getAllAnnouncements();
    }

    @Override
    public String updateByIdAnnouncement(Long id, Announcement announcement) {
        return announcementDao.updateByIdAnnouncement(id, announcement);
    }

    @Override
    public void removeById(Long id) {
        announcementDao.removeById(id);
    }
}
