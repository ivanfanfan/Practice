package com.ivan.a1.factory;

public class DefaultServiceLocator {
    public static ClientService clientService = new ClientService();

    public static AccountService accountService = new AccountService();
    public ClientService createClientServiceInstance(){
        return clientService;
    }

    public AccountService createAccountServiceInstance(){
        return accountService;
    }


}
