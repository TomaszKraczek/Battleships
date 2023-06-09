package org.battleship.ship;

public enum SquareStatus {
    EMPTY("🟦"), SHIP("🟩"), HIT("🟥"), MISSED("🟫"), SUNK("🟪"), DISABLED("🟨");

    private final String status;

    SquareStatus(String status)
    {

        this.status = status;
    }
    public String getFieldStatusSymbol()
    {
        return status;
    }
}
