/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payme;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.param.ChargeCreateParams;
import com.stripe.model.Charge;


/**
 *
 * @author MSI
 */
public class payy {
     

    public payy() {
        Stripe.apiKey = "sk_test_51N0nVDDXXNlJHCatFF4DTWc739qNPcC0m2tMDQWq6cSHerf9PTUM0DThWXA484ZABTxe7YwLIk0ExnpdArE2Wvr000Mg65WKM1";
    }
   public void processPaymen( int amount) {
        try {
            // create payment charge
            ChargeCreateParams chargeCreateParams1 = ChargeCreateParams.builder()
                    //.setAmount(Integer.parseInt(amount) * 100)
                 .setAmount(amount *100L)
                    .setCurrency("USD")
                    .setSource("tok_visa") // replace with your test card token
                    .setDescription("Test Payment")
                    .build();

                     Charge charge1 = Charge.create(chargeCreateParams1);

            // update payment status label
             System.out.println("Success! Here is your starter subscription price id: " + charge1.getId());

        } catch (StripeException e) {
            System.out.println(e.getMessage());        }
    }

  
    
}
