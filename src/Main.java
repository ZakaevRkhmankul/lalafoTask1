import database.GeneratorId;
import enums.Role;
import models.Favorite;
import models.User;
import service.FavoriteService;
import service.UserService;
import service.serviceImpl.FavoriteServiceImpl;
import service.serviceImpl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        FavoriteService favoriteService = new FavoriteServiceImpl();

        System.out.println(favoriteService.addFavorite(GeneratorId.getUserId(), GeneratorId.getAnnouncementId()));

    }
}