package EX1;

public abstract class Audio extends Article {
    private String[] songs;

    public Audio(String[] songs, int code, int price) {
        super(code, price);
        this.songs = songs;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }


}
