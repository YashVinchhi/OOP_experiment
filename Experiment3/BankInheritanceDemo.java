// BankInheritanceDemo.java
class Bank {
    public double GetInterestRate() {
        return 0.0;
    }
}

class ICICI extends Bank {
    @Override
    public double GetInterestRate() {
        return 7.5;
    }
}

class SBI extends Bank {
    @Override
    public double GetInterestRate() {
        return 6.8;
    }
}

class BOB extends Bank {
    @Override
    public double GetInterestRate() {
        return 7.0;
    }
}

public class BankInheritanceDemo {
    public static void main(String[] args) {
        Bank b1 = new ICICI();
        Bank b2 = new SBI();
        Bank b3 = new BOB();

        System.out.println("ICICI Interest Rate: " + b1.GetInterestRate() + "%");
        System.out.println("SBI Interest Rate: " + b2.GetInterestRate() + "%");
        System.out.println("BOB Interest Rate: " + b3.GetInterestRate() + "%");
    }
}
