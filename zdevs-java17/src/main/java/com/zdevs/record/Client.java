package com.zdevs.record;

import java.time.LocalDate;

public class Client {

    private final int id;
    private final String name;
    private final LocalDate birthDay;
    private final boolean status;


    public Client(int id, String name, LocalDate birthDay, boolean status) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", status=" + status +
                '}';
    }
}
