import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Bank> userBankDetails = new ArrayList<>(20);

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("*********  Welcome to bank Portal ***********");

            System.out.println("Choose Service \n 1.Open account \n 2.UserDetails \n 3.AllUserDetails \n 4.Exit");
            int serviceId = sc.nextInt();

            if (serviceId == 1) {
                System.out.println("Choose bank to open an account ");
                System.out.println(" 1.SBI \n 2.ICICI \n 3.BOI \n Choose(1-3)");
                int bankId = sc.nextInt();

                sc.nextLine();

                System.out.println("Please provide user name");
                String userName = sc.nextLine();

                System.out.println("Please provide acccount number");
                String acNumber = sc.nextLine();

                System.out.println("Choose Account type");
                System.out.println("1.CURRENT, 2.SAVINGS");
                int accountTypeId = sc.nextInt();

                AccountType accounType;
                if (accountTypeId == 1) {
                    accounType = AccountType.CURRENT;
                } else
                    accounType = AccountType.SAVINGS;

                switch (bankId) {
                    case 1:
                        SBI newSBIAccount = new SBI(acNumber, userName, accounType);
                        userBankDetails.add(newSBIAccount);
                        System.out.println(newSBIAccount.getDetails());
                        break;
                    case 2:
                        ICICI newICICIAccount = new ICICI(acNumber, userName, accounType);
                        userBankDetails.add(newICICIAccount);
                        System.out.println(newICICIAccount.getDetails());
                        break;
                    case 3:
                        BOI newBOIAccount = new BOI(acNumber, userName, accounType);
                        userBankDetails.add(newBOIAccount);
                        System.out.println(newBOIAccount.getDetails());
                        break;
                    default:
                        System.out.println("Provide valid details");

                }
            } else if (serviceId == 2) {
                System.out.println("*** choose account services ****");
                System.out.println(" 1.Deposit \n 2. Withdraw \n 3.details \n Choose(1-3)");

                int utilityId = sc.nextInt();

                sc.nextLine();

                System.out.println("Enter account number");
                String accNumber = sc.nextLine();

                Bank userBank = new Bank();
                boolean found = true;
                for (Bank bank : userBankDetails) {
                    System.out.println(bank.accountNumber);
                    System.out.println(accNumber);
                    if (bank.accountNumber.equals(accNumber)) {
                        System.out.println("yes acccount exists");
                        userBank = bank;
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println("No account exists with given account number");
                    continue;
                }


                switch (utilityId) {
                    case 1:
                        System.out.println("Enter amount:");
                        double depositAmount = sc.nextDouble();
                        userBank.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("Enter amount:");
                        double withdrawAmount = sc.nextDouble();
                        userBank.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println(userBank.getDetails());
                        break;
                    default:
                        System.out.println("Enter valid service number");
                }
            } else if (serviceId == 3) {

                for (Bank bank : userBankDetails) {
                    System.out.println(bank.getDetails());
                }

            } else if (serviceId == 4) {
                break;
            } else {
                System.out.println("Enter valid input");
                continue;
            }
        } while (userBankDetails.size() <= 20);

    }
}