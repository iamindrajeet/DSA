package parking_lot_LLD;

public interface Parking {

	public Ticket park(Vehicle vehicle) throws ParkingFullException;

	public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}