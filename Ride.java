import static java.lang.Math.abs;

class Ride {

    private final int startRow, startCol, finishRow, finishCol;
    private final int earliest;
    private final int latest, latestStart;
    private final int range;
    private final int rideId;

    public Ride(int startRow, int startCol, int finishRow, int finishCol, int earliest, int latest, int rideId) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.finishRow = finishRow;
        this.finishCol = finishCol;
        this.earliest = earliest;
        this.latest = latest;
        this.rideId = rideId;

        range = (abs(startRow - finishRow) + abs(startCol - finishCol));
        latestStart = latest - range;
    }

    public int getRideId() {
        return rideId;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getFinishRow() {
        return finishRow;
    }

    public int getFinishCol() {
        return finishCol;
    }

    public int getEarliest() {
        return earliest;
    }

    public int getLatest() {
        return latest;
    }

    public int getLatestStart() {
        return latestStart;
    }

    public int getRange() {
        return range;
    }
}
