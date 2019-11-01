
public class ElectricalOutletException extends Exception {

    private final ElectricalMachine machine;
    private final int incorrectOutlet;

    ElectricalOutletException(ElectricalMachine machine, int incorrectOutlet) {
        this.machine = machine;
        this.incorrectOutlet = incorrectOutlet;
    }

    @Override
    public String getMessage() {
        String format = "This machine can not be plugged into this outlet (%dv). This machine is %d volt.";
        return String.format(format, incorrectOutlet, machine.getVoltage());
    }

    @Override
    public String toString() {
        return "ElectricalOutletException: " + getMessage();
    }
}
