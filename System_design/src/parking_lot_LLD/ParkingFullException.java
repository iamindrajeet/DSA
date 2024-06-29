package parking_lot_LLD;

public class ParkingFullException extends Exception {
	public ParkingFullException(String message) {
		super(message);
	}
}