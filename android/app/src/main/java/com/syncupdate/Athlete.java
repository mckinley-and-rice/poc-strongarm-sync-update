package com.syncupdate;

public class Athlete {
    int id;
    String externalId;
    String firstName;
    String lastName;
    String settings;
    int settingsId;
    int warehouseId;
    int groupId;

    public void setId(int id) {
        this.id = id;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public void setSettingsId(int settingsId) {
        this.settingsId = settingsId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSettings() {
        return settings;
    }

    public int getSettingsId() {
        return settingsId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public int getGroupId() {
        return groupId;
    }
}
