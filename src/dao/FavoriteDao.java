package dao;

import models.Announcement;
import models.Favorite;

import java.util.List;

public interface FavoriteDao {
    String addFavorite(Long userId,Long announcementId);

    String deleteFavorite(Long userId,Long announcementId);

    String updateFavorite(Favorite favorite);

    List<Favorite> getAllFavoriteByUserId(Long userId);

}
