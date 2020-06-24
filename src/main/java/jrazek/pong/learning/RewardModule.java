package jrazek.pong.learning;
public class RewardModule implements jrazek.pong.templates.RewardModule {
    @Override
    public float reward(String[] args) {
        try{
            if(args.length > 1) {
                int x1 = Integer.parseInt(args[0]);
                int x2 = Integer.parseInt(args[1]);
                //tests
                return Math.abs(x1 - x2);
            }
        }catch(NumberFormatException e){
            return -1;
        }
        return -1;
    }
}
