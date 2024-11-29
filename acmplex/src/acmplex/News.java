package acmplex;

public class News {
    private int news_id;
    private String title;
    private String content;
    private java.sql.Date announcement_date;
    private boolean is_public;

    // Constructor
    public News(String title, String content, java.sql.Date announcement_date, boolean is_public) {
        this.title = title;
        this.content = content;
        this.announcement_date = announcement_date;
        this.is_public = is_public;
    }

    // Getters and setters
    public int getNewsId() {
        return news_id;
    }

    public void setNewsId(int news_id) {
        this.news_id = news_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public java.sql.Date getAnnouncementDate() {
        return announcement_date;
    }

    public void setAnnouncementDate(java.sql.Date announcement_date) {
        this.announcement_date = announcement_date;
    }

    public boolean isPublic() {
        return is_public;
    }

    public void setPublic(boolean is_public) {
        this.is_public = is_public;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", announcement_date=" + announcement_date +
                ", is_public=" + is_public +
                '}';
    }
}
