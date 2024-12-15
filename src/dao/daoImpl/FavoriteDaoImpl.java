package dao.daoImpl;

import dao.FavoriteDao;
import database.Database;
import models.Announcement;
import models.Favorite;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FavoriteDaoImpl implements FavoriteDao {
    @Override
    public Favorite addFavorite(Favorite favorite) {
        try {
            Database.favorites.add(favorite);
            return favorite;
        } catch (Exception e) {
            System.out.println("Выходит ошибка при добавлении в избранное: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Favorite getFavoriteById(Long id) {
        try {
            return Database.favorites.stream()
                    .filter(favorite -> favorite.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("Ошибка при выводе избранного по ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Favorite> getAllFavorite() {
        try {
            return new ArrayList<>(Database.favorites);
        } catch (Exception e) {
            System.out.println("Ошибка при выводе всех избранных из базы: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Favorite updateFavorite(Favorite favorite) {
        try {
            Optional<Favorite> existingFavorite = Database.favorites.stream()
                    .filter(favorite1 -> favorite1.getId().equals(favorite.getId()))
                    .findFirst();

            if (existingFavorite.isPresent()) {
                Database.favorites.remove(existingFavorite.get());
                Database.favorites.add(favorite);
                return favorite;
            } else {
                throw new IllegalArgumentException(favorite.getId() + "айдисинде favorite табыглан жок.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void deleteFavorite(Long id) {
        try {
            boolean removed = Database.favorites.removeIf(favorite -> favorite.getId().equals(id));
            System.out.println("Иглиликтуу очурулду");
            if (!removed) {
                throw new IllegalArgumentException( id + "айдисинде favorite табылган жок");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Favorite> getFavoritesByUserId(Long userId) {
        try {
            return Database.favorites.stream()
                    .filter(favorite -> favorite.getUser().equals(userId))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении метода" + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void clearFavorites() {
        try {
            Database.favorites.clear();
            System.out.println("Баардык favorite'тер очурулду.");
        } catch (Exception e) {
            System.out.println("Возникла ошибка при очистке списка Избранных: " + e.getMessage());
        }
    }

}

