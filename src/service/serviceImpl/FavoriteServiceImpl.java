package service.serviceImpl;

import dao.FavoriteDao;
import dao.daoImpl.FavoriteDaoImpl;
import models.Favorite;
import service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    FavoriteDao favoriteDao = new FavoriteDaoImpl();
    @Override
    public String addFavorite(Long userId, Long announcementId) {
        return favoriteDao.addFavorite(userId, announcementId);
    }

    @Override
    public String deleteFavorite(Long userId, Long announcementId) {
        return "";
    }

    @Override
    public String updateFavorite(Favorite favorite) {
        return "";
    }

    @Override
    public List<Favorite> getAllFavoriteByUserId(Long userId) {
        return List.of();
    }
}
