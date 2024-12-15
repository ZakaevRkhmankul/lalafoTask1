package service;

import models.Favorite;

import java.util.List;

public interface FavoriteService {

    Favorite addFavorite(Favorite favorite);

    Favorite getFavoriteById(Long id);

    List<Favorite> getAllFavorite();

    Favorite updateFavorite(Favorite favorite);

    void deleteFavorite(Long id);

    List<Favorite> getFavoritesByUserId(Long userId);

    void clearFavorites();

}
