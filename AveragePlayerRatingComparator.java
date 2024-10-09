import java.util.Comparator;

public class AveragePlayerRatingComparator implements Comparator<ChessGame> {

    @Override
    public int compare(ChessGame game1, ChessGame game2) {
        return Double.compare(game1.getAveragePlayerRating(), game2.getAveragePlayerRating());
    }
}
