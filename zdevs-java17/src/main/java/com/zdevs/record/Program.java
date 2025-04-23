package com.zdevs.record;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        Client ci = new Client(1,"cris", LocalDate.now(),true);

        ClientRecord cr = new ClientRecord(1,"cris", LocalDate.now(),true);
        ClientRecord cb = new ClientRecord(LocalDate.now());

        System.out.println(ci);
        System.out.println(cr.name());
        System.out.println(cb);

        String result = cb.toUpperCaseName();
        ClientRecord.toUpperCaseNameStatic();
    }
}
