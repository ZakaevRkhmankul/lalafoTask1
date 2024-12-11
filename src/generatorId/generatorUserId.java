package generatorId;

public class generatorUserId {
    static Long userId;
    static Long announcementId;
    static Long favoriteId;


    public Long genUserId() {
        return ++userId;
    }
    public Long genAnnouncementId() {
        return ++announcementId;
    }
    public Long genFavoriteId() {
        return ++favoriteId;
    }
}
