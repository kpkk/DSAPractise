package design_patterns.factory;

import javax.sound.sampled.UnsupportedAudioFileException;

public class CardFactory {

    public Card createCard(String paymentMode){
        if(paymentMode.equals("credit")){
            return new CreditCard();
        }
        else if(paymentMode.equals("debit")){
            return new DebitCard();
        }
        else
            throw  new UnsupportedOperationException("payment mode not supported");
    }
}
