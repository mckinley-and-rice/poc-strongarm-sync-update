package com.syncupdate;

import io.realm.RealmObject;

public class Athelete extends RealmObject {
    private String name;
    private int id;
    private int client_id;
    private int warehouse_id;

    public void setName(String name){ this.name = name; }
    public String getName(){ return this.name; }

    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    public void setClientId(int id){ this.client_id = id; }
    public int getClientId(){ return this.client_id; }

    public void setWarehouseId(int id){ this.warehouse_id = id; }
    public int getWarehouseId(){ return this.warehouse_id; }
}
