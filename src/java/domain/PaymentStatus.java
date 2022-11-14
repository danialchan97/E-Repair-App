/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author user
 */
public class PaymentStatus {
    
    int paymentID;
    String paymentDetails;
    
    public PaymentStatus(int pid, String pd)
    {
        paymentID = pid;
        paymentDetails = pd;
    }
    
    public int getPaymentID()
    {
        return paymentID;
    }
    
    public String getDetails()
    {
        return paymentDetails;
    }
}
