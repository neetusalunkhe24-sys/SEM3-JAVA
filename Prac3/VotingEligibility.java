package javaprac_3;

class NotEligibleToVoteException
extends Exception{
    
    public
NotEligibleToVoteException(String message){
    super(message);
}
}

class Voter{
    
    public void checkEligibility (int age)
throws NotEligibleToVoteException {
        if (age < 18) {
            throw new
NotEligibleToVoteException("You are not eligible to vote."); }
        else{
            System.out.println("You are eligible to vote.");
        }
    }
}

public class VotingEligibility{
    public static void main(String[] args)
    {
        Voter voter = new Voter();
        
        try{
            voter.checkEligibility(20);
            voter.checkEligibility(16);
        }catch
(NotEligibleToVoteException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}


