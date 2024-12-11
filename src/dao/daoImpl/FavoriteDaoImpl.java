package dao.daoImpl;

import dao.FavoriteDao;
import database.Database;
import models.Announcement;
import models.Favorite;
import models.User;

import java.util.*;

public class FavoriteDaoImpl implements FavoriteDao {
    private Map<Long, Set<Long>> favorite = new HashMap<>();

    @Override
    public String addFavorite(Long userId, Long announcementId) {
        try {
            favorite.putIfAbsent(userId, new HashSet<>());
            favorite.get(userId).add(announcementId);
            for (Long id : favorite.get(userId)) {
                if (id != userId) {
                    throw new RuntimeException("Айдиси " + userId + " болгон колдонуучу жок!");
                }
                return "Избранныйга бир бир элемент кошулду!";
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public String deleteFavorite(Long userId, Long announcementId) {
        if (favorite.containsKey(userId)) {
            favorite.get(userId).remove(announcementId);
            if (favorite.get(userId).isEmpty()) {
                favorite.remove(userId);
            }
        }
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
