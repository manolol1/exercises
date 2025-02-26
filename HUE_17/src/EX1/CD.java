package EX1;

import java.util.Arrays;

public class CD extends Audio {
    public CD(String[] tracks, int code, int price) {
        super(tracks, code, price);
    }

    @Override
    public String toString() {
        return String.format("{tracks: %s; %s}", Arrays.toString(this.getSongs()), super.toString());
    }

    @Override
    public boolean available() {
        return Math.random() < 0.6;
    }
}
