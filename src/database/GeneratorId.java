package database;

public class GeneratorId {
   public static Long userId = 0L;
   public static Long announcementId = 0L;
   public static Long favoriteId = 0L;


    public static Long getUserId() {
        return ++userId;
    }
    public static Long getAnnouncementId() {
        return ++announcementId;
    }
    public static Long getFavoriteId() {
        return ++favoriteId;
    }
}
