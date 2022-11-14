/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import da.DeviceDA;
import da.RepairDA;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Device {
    
    String deviceID;
    String deviceModel;
    String deviceBrand;
    String devicePasscode;
    
    
    
    public Device() {
        deviceID = "";
        deviceModel = "";
        deviceBrand = "";
        devicePasscode = "";
    }
    
    public Device(String deviceID, String deviceModel, String deviceBrand, String devicePasscode) {
        this.deviceID = deviceID;
        this.deviceModel = deviceModel;
        this.deviceBrand = deviceBrand;
        this.devicePasscode = devicePasscode;
    }
    

    public String getDeviceID() {
        return deviceID;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public String getDevicePasscode() {
        return devicePasscode;
    }
    
    public String selectDeviceID(int repairID) throws SQLException
    {
        return RepairDA.selectDeviceID(repairID);
    }
    
    public int checkDevice(String deviceID) throws SQLException
    {
        return DeviceDA.checkDevice(deviceID);
    }
    
    public Device createDevice(String id, String model, String brand, String pass,String custID) throws SQLException{
        return DeviceDA.createDevice(id,model,brand,pass,custID);
    }
    
    public ArrayList<Device> getCustomerDevice(String custID) throws SQLException {
        return DeviceDA.getCustomerDevice(custID);
    }
    
    public Device selectAllDeviceID(int repairID) throws SQLException
    {
        return DeviceDA.selectAllDeviceID(repairID);
    }



    
    
}
