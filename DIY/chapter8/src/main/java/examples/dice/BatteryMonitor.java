package examples.dice;

public class BatteryMonitor {
    public void warnWhenBatteryPowerLow() {
        if (DeviceApi.getBatteryPercentage() < 10) {
            System.out.println("Warning - Batery low");
        }
    }
}
