package service.serviceImpl;

import dao.FavoriteDao;
import dao.daoImpl.FavoriteDaoImpl;
import models.Favorite;
import service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {

    FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    public Favorite addFavorite(Favorite favorite) {
        return favoriteDao.addFavorite(favorite);
    }

    @Override
    public Favorite getFavoriteById(Long id) {
        return favoriteDao.getFavoriteById(id);
    }

    @Override
    public List<Favorite> getAllFavorite() {
        return favoriteDao.getAllFavorite();
    }

    @Override
    public Favorite updateFavorite(Favorite favorite) {
        return favoriteDao.updateFavorite(favorite);
    }

    @Override
    public void deleteFavorite(Long id) {
        favoriteDao.deleteFavorite(id);
    }

    @Override
    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoriteDao.getFavoritesByUserId(userId);
    }

    @Override
    public void clearFavorites() {
        favoriteDao.clearFavorites();
    }
}
