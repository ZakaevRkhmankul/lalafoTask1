package dao;

import models.Announcement;
import models.Favorite;

import java.util.List;

public interface FavoriteDao {
    Favorite addFavorite(Favorite favorite);

    Favorite getFavoriteById(Long id);

    List<Favorite> getAllFavorite();

    Favorite updateFavorite(Favorite favorite);

    void deleteFavorite(Long id);

    List<Favorite> getFavoritesByUserId(Long userId);

    void clearFavorites();

}
