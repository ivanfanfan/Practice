package com.ivan.structual.proxy.dynamic;

public class TrainStation implements ISellTicket{
    @Override
    public void sell() {
        System.out.println("Train station sell tickets");
    }
}
