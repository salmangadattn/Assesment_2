
public class SBI extends Bank{

        private double rateOfInterest = 7.3;

        public SBI(){
        }

        public SBI(String accountNumber, String name, AccountType accountType) {
            super(accountNumber, name, "SBI", accountType);
        }

        public String getDetails() {
                return "Bank{" +
                        "accountNumber='" + accountNumber + '\'' +
                        ", name='" + name + '\'' +
                        ", bankName= 'SBI'"+
                        ", accountType=" + accountType +
                        ", rateOfInterest="+rateOfInterest+"%"+
                        ", accountOpeningDate=" + accountOpeningDate +
                        ", balance=" + balance +
                        '}';
        }

}
