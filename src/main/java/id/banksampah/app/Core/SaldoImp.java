/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Deposit;
import id.banksampah.app.model.Withdraw;

/**
 *
 * @author Asus
 */
public interface SaldoImp {
    public boolean insertDeposit(Deposit deposit);
    public Boolean insertWithdraw(Withdraw withdraw);
}
