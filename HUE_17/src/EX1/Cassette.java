package EX1;

public class Cassette extends Audio {
    private int length;

    public Cassette(String[] songs, int length, int code, int price) {
        super(songs, code, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean available() {
        return false; // cassettes are no longer available.
    }
}
