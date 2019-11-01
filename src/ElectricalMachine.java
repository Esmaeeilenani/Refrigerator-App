
public abstract class ElectricalMachine {

    private int voltage;

    public final int getVoltage() {
        return voltage;
    }

    public final void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public final void plug(int volt) throws ElectricalOutletException {
        if (voltage != volt) {
            throw new ElectricalOutletException(this, volt);
        }
    }
}
