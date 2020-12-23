package id.banksampah;

import id.banksampah.core.UserManagement;

class MainApplication {

    public static void main(String[] args) {
        System.out.println("bismillah");

        UserManagement user = new UserManagement();
        user.connectToCustomer();
    }
}