import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialTest {
    @Test
    void testConstructor() {
        Wallet wallet = new Wallet("Saya");

        Assertions.assertEquals("Saya", wallet.getOwner());
    }

    @Test
    void testGetOwner() {
        Wallet wallet = new Wallet("Saya");

        Assertions.assertEquals("Saya", wallet.getOwner());
    }

    @Test
    void testSetOwner() {
        Wallet wallet = new Wallet("Saya");
        wallet.setOwner("Anda");

        Assertions.assertEquals("Anda", wallet.getOwner());
    }

    @Test
    void testAddOneMoney() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(1000);

        Assertions.assertEquals(1, wallet.getMoneys().get(1000));
    }

    @Test
    void testAddThreeMoneys() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(10000);

        Assertions.assertEquals(1, wallet.getMoneys().get(1000));
        Assertions.assertEquals(1, wallet.getMoneys().get(2000));
        Assertions.assertEquals(1, wallet.getMoneys().get(10000));
    }

    @Test
    void testAddWrongMoneys() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(3000);
        wallet.addMoney(6000);
        wallet.addMoney(70000);

        Assertions.assertNull(wallet.getMoneys().get(3000));
        Assertions.assertNull(wallet.getMoneys().get(6000));
        Assertions.assertNull(wallet.getMoneys().get(70000));
    }

    @Test
    void testTakeMoneys() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(10000);
        wallet.takeMoneys(1000);
        wallet.takeMoneys(2000);
        wallet.takeMoneys(10000);

        Assertions.assertEquals(0, wallet.getMoneys().get(1000));
        Assertions.assertEquals(0, wallet.getMoneys().get(2000));
        Assertions.assertEquals(0, wallet.getMoneys().get(10000));
    }

    @Test
    void testAddOneCoin() {
        Wallet wallet = new Wallet("Saya");
        wallet.addCoin(100);

        Assertions.assertEquals(1, wallet.getCoins().get(100));
    }

    @Test
    void testAddThreeCoins() {
        Wallet wallet = new Wallet("Saya");
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(200);

        Assertions.assertEquals(1, wallet.getCoins().get(1000));
        Assertions.assertEquals(1, wallet.getCoins().get(500));
        Assertions.assertEquals(1, wallet.getCoins().get(200));
    }

    @Test
    void testAddWrongCoins() {
        Wallet wallet = new Wallet("Saya");
        wallet.addCoin(300);
        wallet.addCoin(600);
        wallet.addCoin(7000);

        Assertions.assertNull(wallet.getCoins().get(300));
        Assertions.assertNull(wallet.getCoins().get(600));
        Assertions.assertNull(wallet.getCoins().get(7000));
    }

    @Test
    void testTakeCoins() {
        Wallet wallet = new Wallet("Saya");
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(200);
        wallet.takeCoins(1000);
        wallet.takeCoins(500);
        wallet.takeCoins(200);

        Assertions.assertEquals(0, wallet.getCoins().get(1000));
        Assertions.assertEquals(0, wallet.getCoins().get(500));
        Assertions.assertEquals(0, wallet.getCoins().get(200));
    }

    @Test
    void testAddOneCard() {
        Wallet wallet = new Wallet("Saya");
        String card = "BCA";
        boolean isCardAvailable = false;
        wallet.addCard(card);

        for (int i = 0; i < wallet.getCards().size(); i++) {
            if (wallet.getCards().get(i).equals(card)) {
                isCardAvailable = true;
                break;
            }
        }

        Assertions.assertTrue(isCardAvailable);
    }

    @Test
    void testAddThreeCards() {
        Wallet wallet = new Wallet("Saya");
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        boolean isCard1Available = false;
        boolean isCard2Available = false;
        boolean isCard3Available = false;
        wallet.addCard(card1);
        wallet.addCard(card2);
        wallet.addCard(card3);

        for (int i = 0; i < wallet.getCards().size(); i++) {
            if (wallet.getCards().get(i).equals(card1)) {
                isCard1Available = true;
            }
            if (wallet.getCards().get(i).equals(card2)) {
                isCard2Available = true;
            }
            if (wallet.getCards().get(i).equals(card3)) {
                isCard3Available = true;
            }
        }

        Assertions.assertTrue(isCard1Available);
        Assertions.assertTrue(isCard2Available);
        Assertions.assertTrue(isCard3Available);
    }

    @Test
    void testSizeCards() {
        Wallet wallet = new Wallet("Saya");
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        wallet.addCard(card1);
        wallet.addCard(card2);
        wallet.addCard(card3);

        Assertions.assertEquals(3, wallet.getCards().size());
    }

    @Test
    void testTakeCards() {
        Wallet wallet = new Wallet("Saya");
        String card1 = "BCA";
        String card2 = "Mandiri";
        String card3 = "BNI";
        boolean isCard1Available = false;
        boolean isCard2Available = false;
        boolean isCard3Available = false;
        wallet.addCard(card1);
        wallet.addCard(card2);
        wallet.addCard(card3);
        wallet.takeCard(card1);
        wallet.takeCard(card2);
        wallet.takeCard(card3);

        for (int i = 0; i < wallet.getCards().size(); i++) {
            if (wallet.getCards().get(i).equals(card1)) {
                isCard1Available = true;
            }
            if (wallet.getCards().get(i).equals(card2)) {
                isCard2Available = true;
            }
            if (wallet.getCards().get(i).equals(card3)) {
                isCard3Available = true;
            }
        }

        Assertions.assertFalse(isCard1Available);
        Assertions.assertFalse(isCard2Available);
        Assertions.assertFalse(isCard3Available);
    }

    @Test
    void testCalculateCoins() {
        Wallet wallet = new Wallet("Saya");
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(200);
        wallet.addCoin(100);
        wallet.addCoin(200);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        wallet.addCoin(100);

        Assertions.assertEquals(3600, wallet.calculateCoins());
    }

    @Test
    void testCalculateMoneys() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(1000);
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(50000);
        wallet.addMoney(50000);
        wallet.addMoney(100000);
        wallet.addMoney(50000);

        Assertions.assertEquals(272000, wallet.calculateMoneys());
    }

    @Test
    void testMoneyAvailable() {
        Wallet wallet = new Wallet("Saya");
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(1000);
        wallet.addMoney(1000);
        wallet.addMoney(2000);
        wallet.addMoney(50000);
        wallet.addMoney(50000);
        wallet.addMoney(100000);
        wallet.addMoney(50000);
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(200);
        wallet.addCoin(100);
        wallet.addCoin(200);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        wallet.addCoin(100);

        Assertions.assertEquals(275600, wallet.getMoneyAvailable());
    }
}
