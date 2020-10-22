package id.banksampah;

import id.banksampah.models.Customer;
import java.util.Arrays;

class UserManagement {
    
    public UserManagement() {

    }

    public void connectToCustomer() {
        Customer customer = new Customer();
        customer.setUserLevel("customer");
        customer.printUserLevel();

        System.out.println(Arrays.toString(customer.genUserId()));

        System.out.println(customer.checkParentClass());

        System.out.println(customer.checkSubClass(
            customer.checkParentClass(), customer.getClass()));    
    }
}