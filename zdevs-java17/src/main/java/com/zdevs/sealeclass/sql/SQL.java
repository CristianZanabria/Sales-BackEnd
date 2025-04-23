package com.zdevs.sealeclass.sql;

public abstract sealed class SQL  permits SQLServer,MySQL{
    public abstract void connection();

    public abstract void disConnection();
}
