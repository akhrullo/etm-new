package uz.iDev.ui;

import uz.iDev.services.GenericServices;

public abstract class BaseUI < S extends GenericServices> {
    protected final S service;

    protected BaseUI(S service) {
        this.service = service;
    }

    public abstract void create();

    public abstract void block();

    public abstract void unblock();

    public abstract void get();

    public abstract void delete();

    public abstract void getList();
}
